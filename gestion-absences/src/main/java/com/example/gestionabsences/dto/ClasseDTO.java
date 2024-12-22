package com.example.gestionabsences.dto;

import lombok.Data;

import java.util.List;

@Data
public class ClasseDTO {
    private Long id;
    private String nom;
    private Integer niveau;
    private List<Long> etudiants;
}
