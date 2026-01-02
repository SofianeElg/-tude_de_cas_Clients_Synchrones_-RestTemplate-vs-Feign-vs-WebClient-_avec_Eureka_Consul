package com.example.service_client.controller;

import com.example.service_client.client.CarFeignClient;
import com.example.service_client.dto.Car;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final RestTemplate restTemplate;
    private final CarFeignClient feignClient;
    private final WebClient.Builder webClientBuilder;

    public ClientController(RestTemplate restTemplate,
                            CarFeignClient feignClient,
                            WebClient.Builder webClientBuilder) {
        this.restTemplate = restTemplate;
        this.feignClient = feignClient;
        this.webClientBuilder = webClientBuilder;
    }

    // RESTTEMPLATE
    @GetMapping("/{id}/car/rest")
    public Car getCarRest(@PathVariable Long id) {
        return restTemplate.getForObject(
                "http://SERVICE-VOITURE/api/cars/byClient/" + id,
                Car.class
        );
    }

    // FEIGN
    @GetMapping("/{id}/car/feign")
    public Car getCarFeign(@PathVariable Long id) {
        return feignClient.getCarByClient(id);
    }

    // WEBCLIENT (sync)
    @GetMapping("/{id}/car/webclient")
    public Car getCarWebClient(@PathVariable Long id) {
        return webClientBuilder.build()
                .get()
                .uri("http://SERVICE-VOITURE/api/cars/byClient/" + id)
                .retrieve()
                .bodyToMono(Car.class)
                .block();
    }
}

