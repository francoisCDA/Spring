package org.example.exo_chat.service;

import org.example.exo_chat.entity.Message;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Service
public class MessageService {

    private final Sinks.Many<String> sink;

    public MessageService() {
        this.sink = Sinks.many().multicast().onBackpressureBuffer();
    }

    public void post(Message message) {
        sink.tryEmitNext(message.toString());
    }


    public Flux<String> getFLux() {
        return sink.asFlux();
    }
}
