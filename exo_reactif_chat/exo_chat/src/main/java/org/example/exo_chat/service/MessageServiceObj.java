package org.example.exo_chat.service;

import org.example.exo_chat.entity.Message;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Service
public class MessageServiceObj {

    private final Sinks.Many<Message> sink;

    public MessageServiceObj() {
        this.sink = Sinks.many().multicast().onBackpressureBuffer();
    }

    public void post(Message message) {
        sink.tryEmitNext(message);
    }

    public Flux<Message> getFLuxObj() {
        return sink.asFlux();
    }
}
