package com.spring_Kinesitherapie.app.repository;

import com.spring_Kinesitherapie.app.model.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RendezVousRepository extends JpaRepository<RendezVous, Long> {
    List<RendezVous> findAllByOrderByDateDesc();
}
