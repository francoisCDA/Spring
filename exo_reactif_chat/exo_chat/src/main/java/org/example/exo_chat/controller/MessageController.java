package org.example.exo_chat.controller;


import org.example.exo_chat.entity.Message;
import org.example.exo_chat.service.MessageService;
import org.example.exo_chat.service.MessageServiceObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/chat")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private MessageServiceObj messageServiceObj;

    @PostMapping("/post")
    public ResponseEntity<String> addMessage(@RequestBody Message message) {
        messageService.post(message);
        messageServiceObj.post(message);
        return ResponseEntity.ok(message.toString());
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> subscribeChat() { return messageService.getFLux();}

    @GetMapping(value = "obj",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Message> subscribeChatObj() { return messageServiceObj.getFLuxObj();}

}
