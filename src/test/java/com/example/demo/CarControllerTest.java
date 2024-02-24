package com.example.demo;


import com.example.demo.controller.CarController;
import com.example.demo.domain.car.Car;
import com.example.demo.domain.car.RequestCarDTO;
import com.example.demo.service.CarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CarControllerTest {

    private Validator validator;

    @Mock
    private CarService carService;

    @InjectMocks
    private CarController carController;


    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testCreateCar() {
        // Given
        RequestCarDTO requestCarDTO = new RequestCarDTO("Toyota", "Corolla", "Compact",110023.11);
        Car createdCar = new Car(requestCarDTO);
        when(carService.createCar(any(RequestCarDTO.class))).thenReturn(createdCar);

        // When
        ResponseEntity<Car> responseEntity = carController.createCar(requestCarDTO);

        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(createdCar, Objects.requireNonNull(responseEntity.getBody()));

        assertEquals(11002.11,createdCar.getPrice());
    }
}
