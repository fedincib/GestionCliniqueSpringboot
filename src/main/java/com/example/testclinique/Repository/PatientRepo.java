package com.example.testclinique.Repository;

import com.example.testclinique.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PatientRepo extends JpaRepository<Patient, Long> {
}
