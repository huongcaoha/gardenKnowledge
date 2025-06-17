package com.ra.session01.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "seeds")
public class Seed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false )
    private String seedName;

    @Column(nullable = false )
    private double price ;

    @Column(nullable = false )
    private double harvestMoney ;

    @Column(nullable = false )
    @Min(1)
    private int harvestTime ;

    @Column(nullable = false)
    private String image ;

    @ManyToOne(fetch = FetchType.EAGER)
    private Subject subject ;

    private int numberWatering;

    @Column(columnDefinition = "TEXT")
    private String description ;


}
