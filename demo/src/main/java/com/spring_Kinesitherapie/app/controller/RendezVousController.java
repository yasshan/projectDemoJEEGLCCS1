package com.spring_Kinesitherapie.app.controller;

import com.spring_Kinesitherapie.app.model.RendezVous;
import com.spring_Kinesitherapie.app.service.FicheMedicaleService;
import com.spring_Kinesitherapie.app.service.RendezVousService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rendezvous")
public class RendezVousController {
    @Autowired
    private final RendezVousService rendezVousService;
    @Autowired
    public RendezVousController(RendezVousService rendezVousService) {
        this.rendezVousService = rendezVousService;
    }


    @PostMapping("/ajouter/{patientId}")
    public RendezVous ajouterRendezVous(@PathVariable Long patientId, @RequestBody RendezVous rendezVous) {
        return rendezVousService.ajouterRendezVous(patientId, rendezVous);
    }

    @GetMapping
    public List<RendezVous> listeRendezVous() {
        return rendezVousService.listeRendezVous();
    }

    @PutMapping("/modifier/{id}/{patientId}")
    public RendezVous modifierRendezVous(@PathVariable Long id, @PathVariable Long patientId,@Valid @RequestBody RendezVous rendezVous) {
        return rendezVousService.modifierRendezVous(id, patientId, rendezVous);
    }

    @DeleteMapping("/supprimer/{id}")
    public void supprimerRendezVous(@PathVariable Long id) {
        rendezVousService.supprimerRendezVous(id);
    }
}
