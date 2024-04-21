package com.example.testclinique.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class RendezVous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long idRDV;

    private LocalDateTime dateRDV;

    private String remarque;

    @JsonIgnore
    @ManyToOne
    private Patient patient;

    @JsonIgnore
    @ManyToOne
    private  Medecin medecin;



}
