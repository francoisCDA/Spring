package org.example.exo_chat.controller;


import org.example.exo_chat.entity.Message;
import org.example.exo_chat.service.MessageService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/chat")
public class MessageController {

    private MessageService messageService;

    @PostMapping("/post")
    public ResponseEntity<String> addMessage(@RequestBody Message message) {
        messageService.post(message);
        return ResponseEntity.ok(message.toString());
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> subscribeChat() { return messageService.getFLux();}


}
