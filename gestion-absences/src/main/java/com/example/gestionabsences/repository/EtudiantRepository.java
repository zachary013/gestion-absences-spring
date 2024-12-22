package com.example.gestionabsences.repository;

import com.example.gestionabsences.entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

    Optional<Etudiant> findByNumeroInscription(String numeroInscription);
    List<Etudiant> findByNom(String nom);
    List<Etudiant> findByPrenom(String prenom);
    List<Etudiant> findByClasseNiveau(Integer niveau);
}
