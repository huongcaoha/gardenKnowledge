package com.ra.session01.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    @Column(name = "username",length = 100 ,unique = true,nullable = false)
    private String username ;

    @Column(name = "email",nullable = false , unique = true )
    private String email;

    @Column(name = "fullName",nullable = false)
    private String fullName ;

    @Column(name = "password",nullable = false)
    private String password;

    private String avatar;

    @ManyToOne(fetch = FetchType.EAGER)
    private Classs classs ;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "roleId")
    private Role role;

    @Column(name = "phone",nullable = false,unique = true)
    private String phone ;

    @Column(name = "address")
    private String address ;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Builder.Default
    private Date created_at = new Date();

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date updated_at ;

    @Builder.Default
    private boolean is_deleted = false ;

    @Builder.Default
    private double coin = 1000 ;
}
