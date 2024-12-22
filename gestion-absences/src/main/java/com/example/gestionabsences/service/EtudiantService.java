package com.example.gestionabsences.service;

import com.example.gestionabsences.entity.Etudiant;

import java.util.List;

public interface EtudiantService {
    List<Etudiant> getAllEtudiants();
    List<Etudiant> getEtudiantsByClasseId(Long classeId);

    Etudiant getEtudiantById(Long id);

    Etudiant saveEtudiant(Etudiant student, Long classeId);
    Etudiant updateEtudiant(Long id, Etudiant student);
    void deleteEtudiant(Long id);
}
