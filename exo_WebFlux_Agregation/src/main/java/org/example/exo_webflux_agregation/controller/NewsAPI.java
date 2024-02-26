package org.example.exo_webflux_agregation.controller;

import lombok.RequiredArgsConstructor;
import org.example.exo_webflux_agregation.service.NewsService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
@RequestMapping("/api/news")
@RequiredArgsConstructor
public class NewsAPI {

    private final NewsService newsService;

    @GetMapping(value = "flux", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> getWeatherFlux() {

        return Flux.just("grève ", "manifestation ", "charge de CRS ").delayElements(Duration.ofSeconds(2));
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> getWeather() {

        return Flux.just("grève ", "manifestation ", "charge de CRS ").delayElements(Duration.ofSeconds(2));
    }

}
