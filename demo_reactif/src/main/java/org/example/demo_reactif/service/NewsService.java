package org.example.demo_reactif.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Service
public class NewsService {

    // Un sink multicast qui pemet de pousser des éléments vers plusieurs subscriber
    private final Sinks.Many<String> sink;

    public NewsService() {
        sink = Sinks.many().multicast().onBackpressureBuffer();
    }

    public void sendNews(String news) {
        sink.tryEmitNext(news);
    }


    public Flux<String> getFlux() {
        return sink.asFlux();
    }

}
