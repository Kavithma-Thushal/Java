package com.example.springboot.service;

import com.example.springboot.dto.CustomerDTO;
import com.example.springboot.entity.Customer;

public interface CustomerService {
    Customer saveCustomer(CustomerDTO customerDTO);
}