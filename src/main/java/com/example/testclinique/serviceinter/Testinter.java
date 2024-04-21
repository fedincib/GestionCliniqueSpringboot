package com.example.testclinique.serviceinter;

import com.example.testclinique.entity.*;

import java.util.List;

public interface Testinter {

    Clinique addClinique (Clinique clinique);
    Medecin addMedecinAndAssignToClinique (Medecin medecin, Long cliniqueId);

    Patient addPatient(Patient patient);

    void addRDVAndAssignMedAndPatient(RendezVous rdv, Long idMedecin, Long idPatient);

    List<RendezVous> getRendezVousByCliniqueAndSpecialite(Long idClinique, Specialite specialite);

      int getNbrRendezVousMedecin(Long idMedecin)       ;

    Clinique retrieveClinique(long cliniqueid);

    Medecin retrieveMedecin(long idMedecin);

    Patient retrievePatient(long idPatient );

    void retrieveRendezVous();



}
