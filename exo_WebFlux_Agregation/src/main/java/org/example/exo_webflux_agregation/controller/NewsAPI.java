package org.example.exo_webflux_agregation.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
@RequestMapping("/api/news")
public class NewsAPI {

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> getWeather() {

        return Flux.just("grève ", "manifestation ", "charge de CRS ").delayElements(Duration.ofSeconds(2));
    }

}
