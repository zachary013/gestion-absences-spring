package com.example.gestionabsences.service;

import com.example.gestionabsences.entity.Classe;

import java.util.List;

public interface ClasseService {
    List<Classe> getAllClasses();
    Classe getClasseById(Long id);
    List<Classe> getClassesByNiveau(Integer niveau);
    List<Classe> getClassesByNom(String nom);
    Classe saveClasse(Classe classe);
    Classe updateClasse(Long id, Classe classe);
    void deleteClasse(Long id);
}
