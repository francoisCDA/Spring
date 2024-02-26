package org.example.exo_webflux_agregation.controller;

import lombok.RequiredArgsConstructor;
import org.example.exo_webflux_agregation.service.NewsService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
@RequestMapping("/api/news")
@RequiredArgsConstructor
public class NewsAPI {

    private final NewsService newsService;

    @GetMapping(value = "flux", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> getInfoFlux() {

        return Flux.just("grève ", "manifestation ", "charge de CRS ").delayElements(Duration.ofSeconds(2));
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> getInfo() {

        return newsService.getFlux();
    }

    @PostMapping
    public ResponseEntity<String> postWeather(@RequestParam String news) {

        newsService.sendNews(news);
        return ResponseEntity.ok("dernière info " + news);

    }
}
