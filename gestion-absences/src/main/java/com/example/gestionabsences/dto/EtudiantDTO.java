package com.example.gestionabsences.dto;

import lombok.Data;

@Data
public class EtudiantDTO {
    private Long id;
    private String nom;
    private String prenom;
    private Long classeId;
}
