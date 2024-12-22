package com.example.gestionabsences.service;

import com.example.gestionabsences.entity.Absence;

import java.time.LocalDate;
import java.util.List;

public interface AbsenceService {
    List<Absence> getAllAbsences();
    Absence getAbsenceById(Long id);
    List<Absence> getAbsencesByEtudiantId(Long studentId);

    List<Absence> getAbsencesByDateRange(LocalDate dateDebut, LocalDate dateFin);
    List<Absence> getAbsencesByJustifiee(boolean justifiee);

    Absence saveAbsence(Absence absence, Long etudiantId);
    Absence updateAbsence(Long id, Absence absence);
    void deleteAbsence(Long id);
}
