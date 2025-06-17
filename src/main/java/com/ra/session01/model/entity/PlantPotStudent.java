package com.ra.session01.model.entity;

import com.ra.session01.model.constants.StatusPlantPot;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "plantPotStudents")
public class PlantPotStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @ManyToOne
    @JoinColumn(name = "plantPotId")
    private PlantPot plantPot ;

    @ManyToOne
    @JoinColumn(name = "seedId")
    private Seed seed ;

    private LocalDateTime harvestTime ;
    private boolean isWatering ;
    private int numberWateringRemaining ;

    private LocalDateTime nextTimeWatering ;

    @Enumerated(EnumType.STRING)
    private StatusPlantPot status;
}
