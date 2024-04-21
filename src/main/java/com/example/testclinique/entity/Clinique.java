package com.example.testclinique.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Clinique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idclinique;

    private String nomClinique;

    private String adresse ;
    private  int telephone ;

    @ManyToMany
    private Set<Medecin> medecins;




}
