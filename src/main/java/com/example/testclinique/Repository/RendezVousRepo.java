package com.example.testclinique.Repository;

import com.example.testclinique.entity.RendezVous;
import com.example.testclinique.entity.Specialite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;




@Repository
public interface RendezVousRepo extends JpaRepository<RendezVousRepo, Long> {


    List<RendezVous> findByCliniqueIdcliniqueAndMedecinSpecialite(Long idClinique, Specialite specialite);


    int countByMedecinIdMed(Long idMedecin);


    List<RendezVous> findByDateRDVGreaterThan(LocalDateTime dateRDV);



}
