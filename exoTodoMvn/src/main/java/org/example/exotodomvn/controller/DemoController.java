package org.example.exotodomvn.controller;


import lombok.RequiredArgsConstructor;
import org.example.exotodomvn.entity.Lapin;
import org.example.exotodomvn.service.LapinService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class DemoController {

    private final LapinService lapinService;

    @GetMapping("demo/lapin/add")
    public String getPageA(Model model) {

        model.addAttribute("lapin",new Lapin());

        return "demopages/pagea";
    }

    @PostMapping("/demo/lapin/add")
    public String submitLapin(@ModelAttribute("lapin") Lapin lapin ) {
       // Lapin newLapin = Lapin.builder().id(UUID.randomUUID()).name(lapin.getName()).breed(lapin.getBreed()).build();
       // lapin.setId(UUID.randomUUID());
       // lapinService.addLapin(lapin);
        lapinService.addLapin(lapin.getName(),lapin.getBreed());
        return "redirect:/demo/lapins";

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
