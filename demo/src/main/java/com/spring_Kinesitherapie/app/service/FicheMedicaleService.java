package com.spring_Kinesitherapie.app.service;

import com.spring_Kinesitherapie.app.model.FicheMedicale;
import com.spring_Kinesitherapie.app.model.Patient;
import com.spring_Kinesitherapie.app.repository.FicheMedicaleRepository;
import com.spring_Kinesitherapie.app.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class FicheMedicaleService {

    private final FicheMedicaleRepository ficheRepository;
    private final PatientRepository patientRepository;

    @Autowired
    public FicheMedicaleService(FicheMedicaleRepository ficheRepository,
                                PatientRepository patientRepository) {
        this.ficheRepository = ficheRepository;
        this.patientRepository = patientRepository;
    }

    public List<FicheMedicale> getFichesByPatientId(Long patientId) {
        return ficheRepository.findByPatientIdOrderByDateCreationDesc(patientId);
    }

    public FicheMedicale createFiche(Long patientId, String description) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient non trouvé"));

        FicheMedicale fiche = new FicheMedicale();
        fiche.setPatient(patient);
        fiche.setDescription(description);
        fiche.setDateCreation(LocalDateTime.now());

        return ficheRepository.save(fiche);
    }

    public FicheMedicale updateFiche(Long id, String description) {
        FicheMedicale fiche = ficheRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Fiche non trouvée"));

        fiche.setDescription(description);
        return ficheRepository.save(fiche);
    }

    public void deleteFiche(Long id) {
        if (!ficheRepository.existsById(id)) {
            throw new EntityNotFoundException("Fiche non trouvée");
        }
        ficheRepository.deleteById(id);
    }
}
