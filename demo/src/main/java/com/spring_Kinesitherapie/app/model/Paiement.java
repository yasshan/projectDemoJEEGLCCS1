package com.spring_Kinesitherapie.app.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @NotNull(message = "Le montant est obligatoire")
    private Double montant;

    @NotNull(message = "La date est obligatoire")
    private LocalDateTime date = LocalDateTime.now();

    private String methode;
    private String statut;
    private String notes;
}
