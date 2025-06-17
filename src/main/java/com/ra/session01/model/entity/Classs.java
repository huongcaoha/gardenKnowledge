package com.ra.session01.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Classs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    @Column(unique = true , nullable = false)
    private String className ;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "class_subject",joinColumns = @JoinColumn(name = "classId"),
    inverseJoinColumns = @JoinColumn(name = "subject_id"))
    Set<Subject> subjects ;
}
