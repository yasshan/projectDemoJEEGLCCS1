package com.spring_Kinesitherapie.app.service;

import com.spring_Kinesitherapie.app.model.Patient;
import com.spring_Kinesitherapie.app.model.RendezVous;
import com.spring_Kinesitherapie.app.repository.PatientRepository;
import com.spring_Kinesitherapie.app.repository.RendezVousRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RendezVousService {
    @Autowired
    private RendezVousRepository rendezVousRepository;

    @Autowired
    private PatientRepository patientRepository;

    public RendezVous ajouterRendezVous(Long patientId, RendezVous rendezVous) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient non trouvé avec l'ID: " + rendezVous.getPatient().getId()));
        rendezVous.setPatient(patient);
        return rendezVousRepository.save(rendezVous);
    }

    public List<RendezVous> listeRendezVous() {
        return rendezVousRepository.findAllByOrderByDateDesc();
    }

    public RendezVous modifierRendezVous(Long id, Long patientId, RendezVous rendezVousDetails) {
        Patient patient = patientRepository.findById(patientId)
           .orElseThrow(() -> new EntityNotFoundException("Patient non trouvé avec l'ID: " + rendezVousDetails.getPatient().getId()));
        RendezVous rendezVous = rendezVousRepository.findById(id).orElseThrow(() -> new RuntimeException("Rendez-vous non trouvé"));
        rendezVous.setDate(rendezVousDetails.getDate());
        rendezVous.setHeure(rendezVousDetails.getHeure());
        rendezVous.setStatut(rendezVousDetails.getStatut());
        rendezVous.setPatient(patient);
        return rendezVousRepository.save(rendezVous);
    }

    public void supprimerRendezVous(Long id) {
        rendezVousRepository.deleteById(id);
    }
}
