package org.example.exotodomvn.service;

import org.example.exotodomvn.entity.Lapin;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class LapinService {

    private final Map<UUID, Lapin> lapins;

    public LapinService() {
        this.lapins = new HashMap<>();

        Lapin lapinA = Lapin.builder().id(UUID.randomUUID()).name("Bugs Bunny").breed("angora").build();
        Lapin lapinB = Lapin.builder().id(UUID.randomUUID()).name("Roger Rabbit").breed("bélier").build();
        Lapin lapinC = Lapin.builder().id(UUID.randomUUID()).name("Lapun trois").breed("de laboratoire").build();

        lapins.put(lapinA.getId(),lapinA);
        lapins.put(lapinB.getId(),lapinB);
        lapins.put(lapinC.getId(),lapinC);
    }

    public List<Lapin> getLapins() {
        return lapins.values().stream().toList();
    }

    public Lapin getLapinById(UUID id) {
        return lapins.get(id);
    }



}
