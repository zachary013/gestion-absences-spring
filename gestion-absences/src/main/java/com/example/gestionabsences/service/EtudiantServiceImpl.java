package com.example.gestionabsences.service;

import com.example.gestionabsences.entity.Classe;
import com.example.gestionabsences.entity.Etudiant;
import com.example.gestionabsences.repository.ClasseRepository;
import com.example.gestionabsences.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EtudiantServiceImpl implements EtudiantService {
    private final EtudiantRepository etudiantRepository;
    private final ClasseRepository classeRepository;

    @Autowired
    public EtudiantServiceImpl(EtudiantRepository etudiantRepository, ClasseRepository classeRepository) {
        this.etudiantRepository = etudiantRepository;
        this.classeRepository = classeRepository;
    }

    @Override
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public List<Etudiant> getEtudiantsByClasseId(Long classeId) {
        return etudiantRepository.findByClasseId(classeId);
    }

    @Override
    public Etudiant getEtudiantById(Long id) {
        return etudiantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Étudiant non trouvé avec l'id : " + id));
    }

    @Override
    @Transactional
    public Etudiant saveEtudiant(Etudiant etudiant, Long classeId) {
        Classe classe = classeRepository.findById(classeId)
                .orElseThrow(() -> new RuntimeException("Classe non trouvée avec l'id : " + classeId));
        etudiant.setClasse(classe);
        return etudiantRepository.save(etudiant);
    }

    @Override
    @Transactional
    public Etudiant updateEtudiant(Long id, Etudiant etudiantDetails) {
        Etudiant etudiant = getEtudiantById(id);
        etudiant.setNom(etudiantDetails.getNom());
        etudiant.setPrenom(etudiantDetails.getPrenom());
        etudiant.setDateNaissance(etudiantDetails.getDateNaissance());
        return etudiantRepository.save(etudiant);
    }

    @Override
    @Transactional
    public void deleteEtudiant(Long id) {
        etudiantRepository.deleteById(id);
    }
}
