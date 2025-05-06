package lk.ijse.gdse66.SpringBoot.service.impl;

import lk.ijse.gdse66.SpringBoot.dto.CustomerDTO;
import lk.ijse.gdse66.SpringBoot.dto.ItemDTO;
import lk.ijse.gdse66.SpringBoot.entity.Customer;
import lk.ijse.gdse66.SpringBoot.entity.Item;
import lk.ijse.gdse66.SpringBoot.repository.ItemRepository;
import lk.ijse.gdse66.SpringBoot.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public ItemDTO add(ItemDTO dto) {
        Item item = modelMapper.map(dto, Item.class);
        Item addedData = itemRepository.save(item);
        return modelMapper.map(addedData, ItemDTO.class);
    }

    @Override
    public List<ItemDTO> getAll() {
        List<Item> items = itemRepository.findAll();
        return items.stream()
                .map(item -> modelMapper.map(item, ItemDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ItemDTO getById(Integer id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found with ID: " + id));
        return modelMapper.map(item, ItemDTO.class);
    }
}