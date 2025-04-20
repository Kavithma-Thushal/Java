package com.example.springboot.seed;

import com.example.springboot.entity.Customer;
import com.example.springboot.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerSeeder {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerSeeder(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void seed() {
        customerRepository.save(new Customer(0, "Kavithma", "Galle", 90000));
        customerRepository.save(new Customer(0, "Kamal", "Matara", 45000));
        customerRepository.save(new Customer(0, "Nimal", "Colombo", 120000));
        customerRepository.save(new Customer(0, "Kumar", "Jaffna", 56000));
        customerRepository.save(new Customer(0, "Nisal", "Kandy", 78000));
    }
}