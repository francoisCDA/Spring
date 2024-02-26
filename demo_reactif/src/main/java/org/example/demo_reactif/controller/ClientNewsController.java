package org.example.demo_reactif.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
@RequestMapping("clientnews")
public class ClientNewsController {

    private WebClient webClient;

    public ClientNewsController(){
        webClient = WebClient.builder().baseUrl("http://localhost:8080").build();
    }

    @GetMapping
    public Flux<String> get(){
       return this.webClient.get().uri("/news").retrieve().bodyToFlux(String.class).delayElements(Duration.ofSeconds(2));
    }

    @GetMapping
    @RequestMapping("zip")
    public Flux<String> getZip(){
        Flux<String> flux1 = this.webClient.get().uri("/news").retrieve().bodyToFlux(String.class);

        Flux<String> flux2 = this.webClient.get().uri("/news2").retrieve().bodyToFlux(String.class);


        return Flux.zip(flux1,flux2).map(t -> t.getT1() +t.getT2());
    }

}
