package com.example.springboot.service.impl;

import com.example.springboot.dto.CustomerDTO;
import com.example.springboot.entity.Customer;
import com.example.springboot.repository.CustomerRepository;
import com.example.springboot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setAddress(customerDTO.getAddress());
        customer.setSalary(customerDTO.getSalary());

        return customerRepository.save(customer);
    }
}