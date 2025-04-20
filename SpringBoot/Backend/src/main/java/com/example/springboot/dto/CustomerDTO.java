package com.example.springboot.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class CustomerDTO {
    private int id;
    private String name;
    private String address;
    private double salary;
}