package com.example.springboot.service;

import com.example.springboot.dto.CustomerDTO;

public interface CustomerService {
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
}