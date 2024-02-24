package com.example.demo.controller;


import com.example.demo.domain.car.Car;
import com.example.demo.domain.car.RequestCarDTO;
import com.example.demo.service.CarService;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/store")
public class CarController {


    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("/cars")
public ResponseEntity<Car> createCar( @RequestBody @Valid RequestCarDTO data) {
    Car createdStock = carService.createCar(data);
    return ResponseEntity.ok(createdStock);
}
}
