package lk.ijse.gdse66.SpringBoot.service;

import lk.ijse.gdse66.SpringBoot.dto.OrderDTO;

public interface OrderService {

    OrderDTO placeOrder(OrderDTO dto);
}