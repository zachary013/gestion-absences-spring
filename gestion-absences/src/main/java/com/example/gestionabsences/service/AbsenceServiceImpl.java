package com.example.gestionabsences.service;

import com.example.gestionabsences.entity.Absence;
import com.example.gestionabsences.entity.Etudiant;
import com.example.gestionabsences.repository.AbsenceRepository;
import com.example.gestionabsences.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class AbsenceServiceImpl implements AbsenceService {
    private final AbsenceRepository absenceRepository;
    private final EtudiantRepository etudiantRepository;

    @Autowired
    public AbsenceServiceImpl(AbsenceRepository absenceRepository, EtudiantRepository etudiantRepository) {
        this.absenceRepository = absenceRepository;
        this.etudiantRepository = etudiantRepository;
    }

    @Override
    public List<Absence> getAllAbsences() {
        return absenceRepository.findAll();
    }

    @Override
    public Absence getAbsenceById(Long id) {
        return absenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Absence non trouvée avec l'id : " + id));
    }

    @Override
    public List<Absence> getAbsencesByEtudiantId(Long etudiantId) {
        return absenceRepository.findByEtudiantId(etudiantId);
    }

    @Override
    public List<Absence> getAbsencesByDateRange(LocalDate dateDebut, LocalDate dateFin) {
        return absenceRepository.findByDateBetween(dateDebut, dateFin);
    }

    @Override
    public List<Absence> getAbsencesByJustifiee(boolean justifiee) {
        return absenceRepository.findByJustifiee(justifiee);
    }

    @Override
    @Transactional
    public Absence saveAbsence(Absence absence, Long etudiantId) {
        Etudiant etudiant = etudiantRepository.findById(etudiantId)
                .orElseThrow(() -> new RuntimeException("Étudiant non trouvé avec l'id : " + etudiantId));
        absence.setEtudiant(etudiant);
        return absenceRepository.save(absence);
    }

    @Override
    @Transactional
    public Absence updateAbsence(Long id, Absence absenceDetails) {
        Absence absence = getAbsenceById(id);
        absence.setDate(absenceDetails.getDate());
        absence.setJustifiee(absenceDetails.isJustifiee());
        absence.setRaison(absenceDetails.getRaison());
        return absenceRepository.save(absence);
    }

    @Override
    @Transactional
    public void deleteAbsence(Long id) {
        absenceRepository.deleteById(id);
    }
}
