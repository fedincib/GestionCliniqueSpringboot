package com.example.testclinique.serviceimpl;

import com.example.testclinique.Repository.CliniqueRepo;
import com.example.testclinique.Repository.MedRepo;
import com.example.testclinique.Repository.PatientRepo;
import com.example.testclinique.Repository.RendezVousRepo;
import com.example.testclinique.entity.*;
import com.example.testclinique.serviceinter.Testinter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.util.List;


@Slf4j
public class TestServ implements Testinter {

    CliniqueRepo cliniqueRepo;

    PatientRepo patientRepo;

    MedRepo medRepo;

    RendezVousRepo rendezVousRepo;
    @Override
    public Clinique addClinique(Clinique clinique) {
        return cliniqueRepo.save(clinique);
    }

    @Override
    public Medecin addMedecinAndAssignToClinique(Medecin medecin, Long cliniqueId) {

        Clinique clinique=retrieveClinique(cliniqueId);
        medecin.getCliniques().add(clinique);

        return medRepo.save(medecin);
    }

    @Override
    public Patient addPatient(Patient patient) {
        return patientRepo.save(patient);
    }

    @Override
    public void addRDVAndAssignMedAndPatient(RendezVous rdv, Long idMedecin, Long idPatient) {

        Patient patient=retrievePatient(idPatient);
        Medecin medecin=retrieveMedecin(idMedecin);
        rdv.setMedecin(medecin);
        rdv.setPatient(patient);



    }

    @Override
    public List<RendezVous> getRendezVousByCliniqueAndSpecialite(Long idClinique, Specialite specialite) {
        return rendezVousRepo.findByCliniqueIdcliniqueAndMedecinSpecialite(idClinique,specialite);
    }

    @Override
    public int getNbrRendezVousMedecin(Long idMedecin) {
        return rendezVousRepo.countByMedecinIdMed(idMedecin);}

    @Override
    public Clinique retrieveClinique(long cliniqueid) {
        return cliniqueRepo.findById( cliniqueid).orElse(null);
    }

    @Override
    public Medecin retrieveMedecin(long idMedecin) {
        return medRepo.findById(idMedecin).orElse(null);
    }

    @Override
    public Patient retrievePatient(long idPatient) {
        return patientRepo.findById(idPatient).orElse(null);
    }

    @Scheduled(fixedRate = 30000)
    public void retrieveRendezVous() {
        LocalDateTime now = LocalDateTime.now();
        List<RendezVous> rendezVousList = rendezVousRepo.findByDateRDVGreaterThan(now);
        for (RendezVous rendezVous : rendezVousList) {
            log.info(rendezVous.toString());
        }
    }
}
