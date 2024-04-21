package com.example.testclinique.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPat;
    private  String nomPat;

    private int telephone;

    private LocalDateTime dateNais;

    @JsonIgnore
    @OneToMany( mappedBy = "patient")
    private Set<RendezVous> rdvs;

}
