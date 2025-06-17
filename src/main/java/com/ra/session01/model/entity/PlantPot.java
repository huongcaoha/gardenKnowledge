package com.ra.session01.model.entity;

import com.ra.session01.model.constants.PlantPotType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PlantPot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name ;

    @Enumerated(EnumType.STRING)
    private PlantPotType type ;

    private double price;

    private String image;

    @Column(columnDefinition = "TEXT")
    private String description;

    private double productivity ;
}
