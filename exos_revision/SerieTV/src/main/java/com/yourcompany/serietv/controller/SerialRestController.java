package com.yourcompany.serietv.controller;

import com.yourcompany.serietv.entity.Serial;
import com.yourcompany.serietv.entity.Subscription;
import com.yourcompany.serietv.service.MailService;
import com.yourcompany.serietv.service.SerialService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/serials/api")
@RequiredArgsConstructor
public class SerialRestController {

    private final SerialService serialService;
    private final MailService mailService;

    @GetMapping
    public List<Serial> get(@RequestParam(name="search",required = false) String search){
        if (search== null) return serialService.findAll();
        return serialService.search(search);
    }

    @PostMapping
    public Serial saveSerial(@RequestBody Serial serial) {
        return serialService.saveSerial(serial);
    }

    @PutMapping
    public Serial putSerial(@RequestBody Serial serial){
        return serialService.putSerial(serial);
    }

    @PostMapping("/{seasonId}")
    public void newSeason(@PathVariable Long seasonId) {
        serialService.newSeason(seasonId);
    }

    @PostMapping("/subscribe")
    public void subscribe(@Valid @RequestBody Subscription subscription, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            mailService.subscribe(subscription);
        }
    }

    @DeleteMapping("/subscribe")
    public void unSubscribe(@RequestParam String email) {
        mailService.unSubscribe(email);
    }






}
