package com.spring_Kinesitherapie.app.repository;

import com.spring_Kinesitherapie.app.model.FicheMedicale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FicheMedicaleRepository extends JpaRepository<FicheMedicale, Long> {
    List<FicheMedicale> findByPatientIdOrderByDateCreationDesc(Long patientId);
}
