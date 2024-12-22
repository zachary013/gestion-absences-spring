package com.example.gestionabsences.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class ClasseDTO {
    private Long id;
    @NotBlank(message = "Le nom de la classe est obligatoire.")
    private String nom;

    @NotNull(message = "Le niveau est obligatoire.")
    @Min(value = 1, message = "Le niveau doit être supérieur ou égal à 1.")
    @Max(value = 6, message = "Le niveau doit être inférieur ou égal à 6.")
    private Integer niveau;
    private List<Long> etudiants;
}
