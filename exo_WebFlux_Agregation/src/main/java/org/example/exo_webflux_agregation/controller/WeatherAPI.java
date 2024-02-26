package org.example.exo_webflux_agregation.controller;

import lombok.RequiredArgsConstructor;
import org.example.exo_webflux_agregation.service.WeatherService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
@RequestMapping("/api/weather")
@RequiredArgsConstructor
public class WeatherAPI {

    private final WeatherService weatherService;

    @GetMapping(value = "flux", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> getWeatherFlux() {

        return Flux.just("pluie ", "soleil ", "pluie ", "neige").delayElements(Duration.ofSeconds(1));
    }

    @GetMapping( MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> getWeather() {

        return weatherService.getFlux();
    }

    @PostMapping
    public ResponseEntity<String> postWeather(@RequestParam String weather) {

        weatherService.update(weather);
        return ResponseEntity.ok("info buletin météo " + weather);

    }


}
