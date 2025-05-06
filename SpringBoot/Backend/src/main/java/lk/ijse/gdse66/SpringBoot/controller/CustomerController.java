package lk.ijse.gdse66.SpringBoot.controller;

import jakarta.validation.Valid;
import lk.ijse.gdse66.SpringBoot.dto.CustomerDTO;
import lk.ijse.gdse66.SpringBoot.service.CustomerService;
import lk.ijse.gdse66.SpringBoot.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseUtil save(@Valid @RequestBody CustomerDTO dto) {
        CustomerDTO data = customerService.save(dto);
        return new ResponseUtil("Customer saved successfully!", data);
    }

    @GetMapping
    public ResponseUtil getAll() {
        List<CustomerDTO> data = customerService.getAll();
        return new ResponseUtil("Get all customers successfully!", data);
    }

    @GetMapping("/{id}")
    public ResponseUtil getById(@PathVariable Integer id) {
        CustomerDTO data = customerService.getById(id);
        return new ResponseUtil("Customer fetched successfully!", data);
    }
}