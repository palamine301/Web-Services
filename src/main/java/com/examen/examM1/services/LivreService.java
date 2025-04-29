package com.examen.examM1.services;

import com.examen.examM1.entities.Livre;
import com.examen.examM1.repository.LivreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivreService {
    private final LivreRepository livreRepository;

    public LivreService(LivreRepository livreRepository) {
        this.livreRepository = livreRepository;
    }

    public List<Livre> getAllLivres() {
        return livreRepository.findAll();
    }

    public Optional<Livre> getLivreById(Long id) {
        return livreRepository.findById(id);
    }

    public List<Livre> getLivresDisponibles() {
        return livreRepository.findByDisponibleTrue();
    }
}
