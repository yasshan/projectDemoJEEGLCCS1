package com.spring_Kinesitherapie.app.repository;

import com.spring_Kinesitherapie.app.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    @Override
    Optional<Patient> findById(Long aLong);
    // méthodes personnalisées si nécessaire
}
