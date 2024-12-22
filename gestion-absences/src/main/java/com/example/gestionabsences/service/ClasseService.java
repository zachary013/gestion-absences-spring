package com.example.gestionabsences.service;

import com.example.gestionabsences.entity.Classe;

import java.util.List;

public interface ClasseService {
    List<Classe> getAllClasses();
    List<Classe> getClassesByNiveau(Integer niveau);
    Classe getClasseById(Long id);

    Classe saveClasse(Classe classe);
    Classe updateClasse(Long id, Classe classe);
    void deleteClasse(Long id);
}
