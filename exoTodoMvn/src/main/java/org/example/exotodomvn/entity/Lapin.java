package org.example.exotodomvn.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
public class Lapin {

    private UUID id;
    private String name;
    private String breed;

}
