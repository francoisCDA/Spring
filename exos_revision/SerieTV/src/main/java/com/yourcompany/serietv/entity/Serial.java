package com.yourcompany.serietv.entity;

import com.yourcompany.serietv.enumerate.SerialKind;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Serial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    @Column(name="serial_kind")
    private SerialKind serialKind;

    private boolean isFinished;

    private int season;



}
