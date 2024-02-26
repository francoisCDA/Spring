package org.example.exo_webflux_agregation.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
@RequestMapping("/api/weather")
public class WeatherAPI {

    @GetMapping(value = "flux", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> getWeatherFlux() {

        return Flux.just("pluie ", "soleil ", "pluie ", "neige").delayElements(Duration.ofSeconds(1));
    }

    @GetMapping( MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> getWeather() {

        return Flux.just("pluie ", "soleil ", "pluie ", "neige").delayElements(Duration.ofSeconds(1));
    }

}
