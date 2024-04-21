package com.example.testclinique.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Medecin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMed;
    private String nomMed ;

    @Enumerated(EnumType.STRING)
    private Specialite specialite;

    private int telephone;

    private int prixConsultation;

    @JsonIgnore

    @OneToMany( mappedBy = "medecin")
    private Set<RendezVous> rdvs;


    @JsonIgnore
    @ManyToMany(mappedBy = "medecins")
    private Set<Clinique> cliniques;


}
