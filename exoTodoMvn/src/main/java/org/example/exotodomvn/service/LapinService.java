package org.example.exotodomvn.service;

import org.example.exotodomvn.entity.Lapin;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class LapinService {

    private final Map<UUID, Lapin> lapins;

    public LapinService() {
        this.lapins = new HashMap<>();

        Lapin lapinA = Lapin.builder().id(UUID.randomUUID()).name("Bugs Bunny").breed("angora").build();
        Lapin lapinB = Lapin.builder().id(UUID.randomUUID()).name("Roger Rabbit").breed("bélier").build();
        Lapin lapinC = Lapin.builder().id(UUID.randomUUID()).name("Lapin trois").breed("de laboratoire").build();
        Lapin lapinD = Lapin.builder().id(UUID.randomUUID()).name("Billy").breed("Vulpis").build();
        Lapin lapinE = Lapin.builder().id(UUID.randomUUID()).name("Steeve").breed("Géant des Flandres").build();

        lapins.put(lapinA.getId(),lapinA);
        lapins.put(lapinB.getId(),lapinB);
        lapins.put(lapinC.getId(),lapinC);
        lapins.put(lapinD.getId(),lapinD);
        lapins.put(lapinE.getId(),lapinE);
    }

    public List<Lapin> getLapins() {
        return lapins.values().stream().toList();
    }

    public Lapin getLapinById(UUID id) {
        return lapins.get(id);
    }

    private void addLapin(Lapin lapin) {
        lapins.put(lapin.getId(),lapin);
    }

    public boolean addLapin(String name, String breed) {
        if (!name.isBlank() && !name.isEmpty() && !breed.isBlank() && !breed.isEmpty()) {
            addLapin(Lapin.builder().id(UUID.randomUUID()).name(name).breed(breed).build());
            return true;
        }
        return false;
    }


    public Lapin getLapinByName(String name) {

        return lapins.values().stream().filter( lapin -> lapin.getName().equals(name)).findFirst().orElse(null);

    }
}
