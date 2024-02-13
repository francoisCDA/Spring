package org.example.exotodomvn.controller;


import lombok.RequiredArgsConstructor;
import org.example.exotodomvn.entity.Lapin;
import org.example.exotodomvn.service.LapinService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class DemoController {

    private final LapinService lapinService;

    @GetMapping("demo/pagea")
    public String getPageA() {
        return "demopages/pagea";
    }

    @GetMapping("demo/lapins")
    public String getPageB(Model model) {

        List<Lapin> lapins = lapinService.getLapins();
        Lapin lapin = lapins.get(0);

        model.addAttribute("lapin", lapin);
        model.addAttribute("lapins",lapins);

        return "demopages/pageb";
    }

    @GetMapping("demo/details/{idLapin}")
    public String getDetailsLapin(@PathVariable("idLapin") UUID id, Model model ) {

        Lapin lapin = lapinService.getLapinById(id);
        model.addAttribute("lapin",lapin);

        return "demopages/pagec";
    }




}
