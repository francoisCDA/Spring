package org.example.exo_chat.service;

import org.example.exo_chat.dao.MessageDAO;
import org.example.exo_chat.entity.Message;
import org.example.exo_chat.repository.MessageRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

@Service
public class MessageServiceObj {

    private final Sinks.Many<Message> sink;

    private final MessageDAO  messageDAO;

    private final MessageRepository messageRepository;

    public MessageServiceObj(MessageDAO messageDAO, MessageRepository messageRepository) {
        this.messageDAO = messageDAO;
        this.messageRepository = messageRepository;

        this.sink = Sinks.many().multicast().onBackpressureBuffer();
    }

    public void post(Message message) {
        messageRepository.save(message).then().subscribe();

        //System.out.println(messageMono);
       // messageDAO.add(message);
      //  sink.tryEmitNext(message);
    }

    public Flux<Message> getFLuxObj() {
       // Flux<Message> retour =  messageDAO.getConversation();
       Flux<Message> retour = messageRepository.findAll();
        return retour;
        //return sink.asFlux();
    }

}
