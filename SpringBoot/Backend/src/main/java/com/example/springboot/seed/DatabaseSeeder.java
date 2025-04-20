package com.example.springboot.seed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private final CustomerSeeder customerSeeder;

    @Autowired
    public DatabaseSeeder(CustomerSeeder customerSeeder) {
        this.customerSeeder = customerSeeder;
    }

    @Override
    public void run(String... args) throws Exception {
//        customerSeeder.seed();
    }
}
