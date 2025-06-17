package com.ra.session01.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    @ManyToOne
    @JoinColumn(name = "questionId")
    private Question question ;

    @ManyToOne
    @JoinColumn(name = "subjectId")
    private Subject subject ;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Answer> answers ;
}
