package com.example.gestionabsences.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.time.LocalDate;

@Data
public class AbsenceDTO {
    private Long id;

    @NotNull(message = "La date de l'absence est obligatoire.")
    @PastOrPresent(message = "La date de l'absence ne peut pas être dans le futur.")
    private LocalDate date;

    @NotBlank(message = "La raison de l'absence est obligatoire.")
    @Size(max = 255, message = "La raison ne peut pas dépasser 255 caractères.")
    private String raison;

    private boolean justifiee;

    @NotNull(message = "L'identifiant de l'étudiant est obligatoire.")
    private Long etudiantId;
}
