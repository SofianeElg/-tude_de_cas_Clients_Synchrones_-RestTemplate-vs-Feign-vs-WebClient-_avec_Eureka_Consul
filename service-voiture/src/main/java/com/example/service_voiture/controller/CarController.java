package com.example.service_voiture.controller;

import com.example.service_voiture.dto.Car;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/cars")
public class CarController {

    @GetMapping("/byClient/{clientId}")
    public Car getCarByClient(@PathVariable Long clientId) throws InterruptedException {

        Thread.sleep(20);

        return new Car(10L, "Toyota", "Yaris", clientId);
    }
}

