package com.spring_Kinesitherapie.app.controller;

import com.spring_Kinesitherapie.app.model.FicheMedicale;
import com.spring_Kinesitherapie.app.service.FicheMedicaleService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fiches/")
public class FicheMedicaleController {


    private final FicheMedicaleService ficheService;

    @Autowired
    public FicheMedicaleController(FicheMedicaleService ficheService) {
        this.ficheService = ficheService;
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<List<FicheMedicale>> getFichesByPatientId(@PathVariable Long patientId) {
        List<FicheMedicale> fiches = ficheService.getFichesByPatientId(patientId);
        return ResponseEntity.ok(fiches);
    }

    @PostMapping("/{id}")
    public ResponseEntity<FicheMedicale> createFiche(
            @RequestBody FicheMedicaleDTO ficheDTO) {
        System.out.println("Requête reçue : " + ficheDTO);
        FicheMedicale newFiche = ficheService.createFiche(
                ficheDTO.getPatientId(),
                ficheDTO.getDescription());
        return new ResponseEntity<>(newFiche, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FicheMedicale> updateFiche(
            @PathVariable Long id,
            @RequestBody FicheMedicaleDTO ficheDTO) {
        FicheMedicale updatedFiche = ficheService.updateFiche(
                id,
                ficheDTO.getDescription());
        return ResponseEntity.ok(updatedFiche);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFiche(@PathVariable Long id) {
        ficheService.deleteFiche(id);
        return ResponseEntity.noContent().build();
    }

    // DTO pour la création/mise à jour
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FicheMedicaleDTO {
        private Long patientId;
        private String description;
    }
}
