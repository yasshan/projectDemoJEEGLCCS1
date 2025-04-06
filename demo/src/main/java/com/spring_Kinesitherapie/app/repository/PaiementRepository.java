package com.spring_Kinesitherapie.app.repository;

import com.spring_Kinesitherapie.app.model.Paiement;
import com.spring_Kinesitherapie.app.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaiementRepository extends JpaRepository<Paiement, Long> {
    Optional<Paiement> findById(Long aLong);
}
