package com.example.weather_api.controller;


import com.example.weather_api.entity.WeatherForecast;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Random;

@RequestMapping("weather")
@RestController
public class WeatherAPIController {

    private final Random random;

    public WeatherAPIController() {
        random = new Random();
    }

    @GetMapping("{city}")
    public Flux<WeatherForecast> get(String city) {
        return Flux.just(WeatherForecast.builder().city(city).temperature(random.nextDouble(20)).build(),WeatherForecast.builder().city(city).temperature(random.nextDouble(20)).build());
    }
}
