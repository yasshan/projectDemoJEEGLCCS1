package com.spring_Kinesitherapie.app.controller;

import com.spring_Kinesitherapie.app.model.Patient;
import com.spring_Kinesitherapie.app.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    // 🔹 Récupérer tous les patients
    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    // 🔹 Ajouter un patient
    @PostMapping("/ajouter")
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
        return ResponseEntity.ok(patientService.addPatient(patient));
    }

    // 🔹 Modifier un patient
    @PutMapping("/modifier/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
        Optional<Patient> updatedPatient = patientService.updatePatient(id, patient);
        return updatedPatient.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 🔹 Supprimer un patient
    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        boolean deleted = patientService.deletePatient(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
