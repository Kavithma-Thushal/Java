package lk.ijse.gdse66.SpringBoot.controller;

import jakarta.validation.Valid;
import lk.ijse.gdse66.SpringBoot.dto.ItemDTO;
import lk.ijse.gdse66.SpringBoot.service.ItemService;
import lk.ijse.gdse66.SpringBoot.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping
    public ResponseUtil add(@Valid @RequestBody ItemDTO dto) {
        ItemDTO data = itemService.add(dto);
        return new ResponseUtil("Item added successfully!", data);
    }

    @GetMapping
    public ResponseUtil getAll() {
        List<ItemDTO> data = itemService.getAll();
        return new ResponseUtil("Get all items successfully!", data);
    }

    @GetMapping("/{id}")
    public ResponseUtil getById(@PathVariable Integer id) {
        ItemDTO data = itemService.getById(id);
        return new ResponseUtil("Item fetched successfully!", data);
    }
}