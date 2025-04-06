package com.spring_Kinesitherapie.app.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rendezvous")
public class RendezVous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;
    @NotNull(message = "La date est obligatoires")
    private LocalDateTime date = LocalDateTime.now();;
    @NotNull(message = "L'heure est obligatoires")
    private String heure;
    @NotBlank(message = "Le statut est obligatoire")
    private String statut;
    private String notes;
}
