package com.example.testclinique.Repository;

import com.example.testclinique.entity.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MedRepo extends JpaRepository <Medecin, Long> {
}
