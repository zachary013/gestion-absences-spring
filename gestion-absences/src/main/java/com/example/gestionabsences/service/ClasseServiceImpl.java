package com.example.gestionabsences.service;

import com.example.gestionabsences.entity.Classe;
import com.example.gestionabsences.repository.ClasseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClasseServiceImpl implements ClasseService {
    private final ClasseRepository classeRepository;

    @Autowired
    public ClasseServiceImpl(ClasseRepository classeRepository) {
        this.classeRepository = classeRepository;
    }

    @Override
    public List<Classe> getAllClasses() {
        return classeRepository.findAll();
    }

    @Override
    public List<Classe> getClassesByNiveau(Integer niveau) {
        return classeRepository.findByNiveau(niveau);
    }

    @Override
    public Classe getClasseById(Long id) {
        return classeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Classe non trouvée avec l'id : " + id));
    }

    @Override
    @Transactional
    public Classe saveClasse(Classe classe) {
        return classeRepository.save(classe);
    }

    @Override
    @Transactional
    public Classe updateClasse(Long id, Classe classeDetails) {
        Classe classe = getClasseById(id);
        classe.setNom(classeDetails.getNom());
        classe.setNiveau(classeDetails.getNiveau());
        return classeRepository.save(classe);
    }

    @Override
    @Transactional
    public void deleteClasse(Long id) {
        classeRepository.deleteById(id);
    }
}
