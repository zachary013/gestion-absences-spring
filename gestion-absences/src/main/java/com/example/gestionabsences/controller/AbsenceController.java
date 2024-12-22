package com.example.gestionabsences.controller;

import com.example.gestionabsences.entity.Absence;
import com.example.gestionabsences.service.AbsenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/absences")
public class AbsenceController {

    private final AbsenceService absenceService;

    @Autowired
    public AbsenceController(AbsenceService absenceService) {
        this.absenceService = absenceService;
    }

    @GetMapping
    public ResponseEntity<List<Absence>> getAllAbsences() {
        return ResponseEntity.ok(absenceService.getAllAbsences());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Absence> getAbsenceById(@PathVariable Long id) {
        return ResponseEntity.ok(absenceService.getAbsenceById(id));
    }

    @GetMapping("/etudiant/{etudiantId}")
    public ResponseEntity<List<Absence>> getAbsencesByEtudiantId(@PathVariable Long etudiantId) {
        return ResponseEntity.ok(absenceService.getAbsencesByEtudiantId(etudiantId));
    }

    @GetMapping("/date-range")
    public ResponseEntity<List<Absence>> getAbsencesByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateDebut,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateFin) {
        return ResponseEntity.ok(absenceService.getAbsencesByDateRange(dateDebut, dateFin));
    }

    @GetMapping("/justifiee")
    public ResponseEntity<List<Absence>> getAbsencesByJustifiee(@RequestParam boolean justifiee) {
        return ResponseEntity.ok(absenceService.getAbsencesByJustifiee(justifiee));
    }

    @PostMapping
    public ResponseEntity<Absence> createAbsence(@RequestBody Absence absence, @RequestParam Long etudiantId) {
        return new ResponseEntity<>(absenceService.saveAbsence(absence, etudiantId), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Absence> updateAbsence(@PathVariable Long id, @RequestBody Absence absence) {
        return ResponseEntity.ok(absenceService.updateAbsence(id, absence));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAbsence(@PathVariable Long id) {
        absenceService.deleteAbsence(id);
        return ResponseEntity.noContent().build();
    }


}
