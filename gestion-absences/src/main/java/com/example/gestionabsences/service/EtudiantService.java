package com.example.gestionabsences.service;

import com.example.gestionabsences.entity.Etudiant;

import java.util.List;

public interface EtudiantService {
    List<Etudiant> getAllEtudiants();
    Etudiant getEtudiantById(Long id);
    Etudiant getEtudiantByNumeroInscription(String numeroInscription);
    Etudiant saveEtudiant(Etudiant student, Long classeId);
    Etudiant updateEtudiant(Long id, Etudiant student);
    void deleteEtudiant(Long id);
    List<Etudiant> getEtudiantsByClasseId(Long classeId);
}
