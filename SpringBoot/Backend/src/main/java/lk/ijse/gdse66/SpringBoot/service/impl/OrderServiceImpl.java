package lk.ijse.gdse66.SpringBoot.service.impl;

import lk.ijse.gdse66.SpringBoot.dto.OrderDTO;
import lk.ijse.gdse66.SpringBoot.dto.OrderDetailDTO;
import lk.ijse.gdse66.SpringBoot.entity.Customer;
import lk.ijse.gdse66.SpringBoot.entity.Item;
import lk.ijse.gdse66.SpringBoot.entity.Order;
import lk.ijse.gdse66.SpringBoot.entity.OrderDetail;
import lk.ijse.gdse66.SpringBoot.repository.CustomerRepository;
import lk.ijse.gdse66.SpringBoot.repository.ItemRepository;
import lk.ijse.gdse66.SpringBoot.repository.OrderRepository;
import lk.ijse.gdse66.SpringBoot.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public OrderDTO placeOrder(OrderDTO dto) {

        Customer customer = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found!"));

        Order order = new Order();
        order.setCustomer(customer);
        order.setDate(dto.getDate());

        List<OrderDetail> orderDetailList = new ArrayList<>();

        for (OrderDetailDTO items : dto.getOrderDetails()) {
            Item item = itemRepository.findById(items.getItemId())
                    .orElseThrow(() -> new RuntimeException("Item not found!"));

            if (item.getQuantity() < items.getQuantity()) {
                throw new RuntimeException("Insufficient stock for item: " + item.getDescription());
            }
            item.setQuantity(item.getQuantity() - items.getQuantity());
            itemRepository.save(item);

            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setItem(item);
            orderDetail.setQuantity(items.getQuantity());
            orderDetail.setUnitPrice(items.getUnitPrice());
            orderDetail.setTotal(items.getTotal());
            orderDetail.setOrder(order);

            orderDetailList.add(orderDetail);
        }

        order.setOrderDetails(orderDetailList);

        Order placedOrder = orderRepository.save(order);

        OrderDTO placedOrderDTO = new OrderDTO();
        placedOrderDTO.setId(placedOrder.getId());
        placedOrderDTO.setCustomerId(customer.getId());
        placedOrderDTO.setDate(placedOrder.getDate());

        List<OrderDetailDTO> orderDetailDTOList = new ArrayList<>();
        for (OrderDetail itemDetail : placedOrder.getOrderDetails()) {
            OrderDetailDTO itemDetailDTO = modelMapper.map(itemDetail, OrderDetailDTO.class);
            itemDetailDTO.setItemId(itemDetail.getItem().getId());
            itemDetailDTO.setOrderId(placedOrder.getId());
            orderDetailDTOList.add(itemDetailDTO);
        }

        placedOrderDTO.setOrderDetails(orderDetailDTOList);

        return placedOrderDTO;
    }
}