package org.example.demo_reactif.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
@RequestMapping("/reactives")
public class ReactiveController {

    @GetMapping
    public Mono<String> get() {
        return Mono.just("reactive get");
    }

    @GetMapping(value = "/flux", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> getFlux() {
        return Flux.just("toto", "tata", "titi").delayElements(Duration.ofSeconds(2));
    }

}
