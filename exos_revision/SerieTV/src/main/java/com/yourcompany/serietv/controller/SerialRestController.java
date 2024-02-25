package com.yourcompany.serietv.controller;

import com.yourcompany.serietv.entity.Serial;
import com.yourcompany.serietv.repository.SerialRepository;
import com.yourcompany.serietv.service.SerialService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/serials/api")
@RequiredArgsConstructor
public class SerialRestController {

    private final SerialService serialService;

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




}
