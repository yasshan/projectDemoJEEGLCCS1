package com.spring_Kinesitherapie.app.controller;

import com.spring_Kinesitherapie.app.model.Paiement;
import com.spring_Kinesitherapie.app.service.PaiementService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/paiement")
public class PaiementController {
    @Autowired
    private PaiementService paiementService;

    @PostMapping("/ajouter/{patientId}")
    public Paiement ajouterPaiement(@PathVariable Long patientId, @Valid @RequestBody Paiement paiement) {
        return paiementService.ajouterPaiement(patientId,paiement);
    }

    @GetMapping("/{id}")
    public Optional<Paiement> findPaiement(@PathVariable Long id) {
        return paiementService.findPaiement(id);
    }

    @GetMapping("/liste")
    public List<Paiement> listePaiements() {
        return paiementService.listePaiements();
    }
    @PutMapping("/modifier/{id}/{patientId}")
    public Paiement modifierPaiement(@PathVariable Long id, @PathVariable Long patientId, @Valid @RequestBody Paiement paiement) {
        return paiementService.modifierPaiement(id, patientId, paiement);
    }
    @DeleteMapping("/supprimer/{id}")
    public void supprimerPaiement(@PathVariable Long id) {
        paiementService.supprimerPaiement(id);
    }

}
