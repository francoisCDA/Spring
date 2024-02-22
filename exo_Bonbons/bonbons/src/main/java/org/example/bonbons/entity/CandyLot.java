package org.example.bonbons.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CandyLot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "candy_id")
    private Candy candy;

    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "candy_order_id")
    private CandyOrder candyOrder;

}
