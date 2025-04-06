package com.spring_Kinesitherapie.app.service;

import com.spring_Kinesitherapie.app.model.Patient;
import com.spring_Kinesitherapie.app.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Optional<Patient> updatePatient(Long id, Patient patientDetails) {
        return patientRepository.findById(id).map(existingPatient -> {
            existingPatient.setNom(patientDetails.getNom());
            existingPatient.setPrenom(patientDetails.getPrenom());
            existingPatient.setTelephone(patientDetails.getTelephone());
            existingPatient.setAdresse(patientDetails.getAdresse());
            return patientRepository.save(existingPatient);
        });
    }

    public boolean deletePatient(Long id) {
        if (patientRepository.existsById(id)) {
            patientRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
