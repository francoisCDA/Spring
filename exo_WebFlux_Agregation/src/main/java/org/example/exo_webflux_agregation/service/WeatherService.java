package org.example.exo_webflux_agregation.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Service
public class WeatherService {

    private final Sinks.Many<String> sink;

    public WeatherService() {
        sink = Sinks.many().multicast().onBackpressureBuffer();
    }

    public void update(String weather) {
        sink.tryEmitNext(weather);
    }

    public Flux<String> getFlux() {
        return sink.asFlux();
    }

}
