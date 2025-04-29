package com.examen.examM1.repository;

import com.examen.examM1.entities.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivreRepository extends JpaRepository<Livre, Long> {
    List<Livre> findByDisponibleTrue();
}
