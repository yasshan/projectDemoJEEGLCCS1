package com.spring_Kinesitherapie.app.service;

import com.spring_Kinesitherapie.app.model.Paiement;
import com.spring_Kinesitherapie.app.model.Patient;
import com.spring_Kinesitherapie.app.repository.PaiementRepository;
import com.spring_Kinesitherapie.app.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaiementService {
    @Autowired
    private PaiementRepository paiementRepository;
    @Autowired
    private PatientRepository patientRepository;

    public Paiement ajouterPaiement(Long patientId, Paiement paiement) {
        Patient patient=patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient non trouvé avec l'ID: "+ paiement.getPatient().getId()));
        paiement.setPatient(patient);
        return paiementRepository.save(paiement);
    }

    public Optional<Paiement> findPaiement(Long id) {
        return paiementRepository.findById(id);
    }

    public List<Paiement> listePaiements() {
        return paiementRepository.findAll();
    }

    public Paiement modifierPaiement(Long id, Long patientId, Paiement paiement) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient non trouvé avec l'ID: " + paiement.getPatient().getId()));
        Paiement paiement1 = paiementRepository.findById(id).orElseThrow(() -> new RuntimeException("paiement non trouvé"));
        paiement1.setDate(paiement.getDate());
        paiement1.setMontant(paiement.getMontant());
        paiement1.setStatut(paiement.getStatut());
        paiement1.setMethode(paiement.getMethode());
        paiement1.setNotes(paiement.getNotes());
        paiement1.setPatient(patient);
        return paiementRepository.save(paiement1);
    }
    public void supprimerPaiement(Long id) {
        paiementRepository.deleteById(id);
    }
}
