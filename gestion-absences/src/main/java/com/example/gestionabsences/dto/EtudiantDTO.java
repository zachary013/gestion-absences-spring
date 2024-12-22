package com.example.gestionabsences.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class EtudiantDTO {
    private Long id;
    @NotBlank(message = "Le nom est obligatoire.")
    private String nom;

    @NotBlank(message = "Le prénom est obligatoire.")
    private String prenom;

    @Past(message = "La date de naissance doit être dans le passé.")
    private Date dateNaissance;

    @NotNull(message = "La classe ID est obligatoire.")
    private Long classeId;
    // ID de la classe associée
    private List<Long> absences; // Liste des IDs des absences
}
