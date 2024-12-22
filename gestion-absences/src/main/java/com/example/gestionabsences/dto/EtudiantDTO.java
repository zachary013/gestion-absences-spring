package com.example.gestionabsences.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class EtudiantDTO {
    private Long id;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private Long classeId; // ID de la classe associée
    private List<Long> absences; // Liste des IDs des absences
}
