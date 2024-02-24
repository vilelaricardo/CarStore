package com.example.demo.service;


import com.example.demo.domain.car.Car;
import com.example.demo.domain.car.RequestCarDTO;
import org.springframework.stereotype.Service;

@Service
public class CarService {


    public Car createCar(RequestCarDTO data) {
        Car newCar = new Car(data);

        return newCar;
    }
}
