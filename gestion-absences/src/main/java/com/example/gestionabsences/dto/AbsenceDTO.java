package com.example.gestionabsences.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class AbsenceDTO {
    private Long id;
    private LocalDate date;
    private String raison;
    private boolean justifiee;
    private Long etudiantId;
}
