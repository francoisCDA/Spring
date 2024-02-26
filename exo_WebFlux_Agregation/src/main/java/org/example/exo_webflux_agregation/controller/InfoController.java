package org.example.exo_webflux_agregation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
@RestController
public class InfoController {

    private WebClient webClient;


    public InfoController() {
        webClient = WebClient.builder().baseUrl("http://localhost:8080").build();
     }

    @GetMapping
    public Flux<Object> getFlux() {

        Flux<String> fluxNews = webClient.get().uri("/api/news").retrieve().bodyToFlux(String.class);
        Flux<String> fluxWeather = webClient.get().uri("/api/weather").retrieve().bodyToFlux(String.class);

       return Flux.merge(fluxNews,fluxWeather);

    }


}
