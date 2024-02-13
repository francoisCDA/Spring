package org.example.exotodomvn.controller;

import lombok.RequiredArgsConstructor;
import org.example.exotodomvn.entity.Lapin;
import org.example.exotodomvn.service.LapinService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("demo/api/v2")
@RequiredArgsConstructor
public class DemoRestController {

    private final LapinService lapinService;

    @GetMapping
    public List<Lapin> getAllLapins(){
        return lapinService.getLapins();
    }




}
