package com.example.demo.domain.car;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    private String model;
    private String brand;
    private String category;
    private double price;


public Car (RequestCarDTO requestCarDTO){

    this.model = requestCarDTO.model();
    this.brand = requestCarDTO.brand();
    this.category = requestCarDTO.category();
    this.price = requestCarDTO.price();
}
}
