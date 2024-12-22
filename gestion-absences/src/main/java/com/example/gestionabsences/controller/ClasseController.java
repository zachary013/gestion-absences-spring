package com.example.gestionabsences.controller;

import com.example.gestionabsences.entity.Classe;
import com.example.gestionabsences.service.ClasseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classes")
public class ClasseController {

    private final ClasseService classeService;

    @Autowired
    public ClasseController(ClasseService classeService) {
        this.classeService = classeService;
    }

    @GetMapping
    public ResponseEntity<List<Classe>> getAllClasses() {
        return ResponseEntity.ok(classeService.getAllClasses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Classe> getClasseById(@PathVariable Long id) {
        return ResponseEntity.ok(classeService.getClasseById(id));
    }

    @GetMapping("/niveau/{niveau}")
    public ResponseEntity<List<Classe>> getClassesByNiveau(@PathVariable Integer niveau) {
        return ResponseEntity.ok(classeService.getClassesByNiveau(niveau));
    }

//    @GetMapping("/nom")
//    public ResponseEntity<List<Classe>> getClassesByNom(@RequestParam String nom) {
//        return ResponseEntity.ok(classeService.getClassesByNom(nom));
//    }

    @PostMapping
    public ResponseEntity<Classe> createClasse(@RequestBody Classe classe) {
        return new ResponseEntity<>(classeService.saveClasse(classe), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Classe> updateClasse(@PathVariable Long id, @RequestBody Classe classe) {
        return ResponseEntity.ok(classeService.updateClasse(id, classe));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClasse(@PathVariable Long id) {
        classeService.deleteClasse(id);
        return ResponseEntity.noContent().build();
    }
}
