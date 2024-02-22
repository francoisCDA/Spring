package org.example.bonbons.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class CandyOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(mappedBy = "candyOrder", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CandyLot> candyLots = new ArrayList<>();

}
