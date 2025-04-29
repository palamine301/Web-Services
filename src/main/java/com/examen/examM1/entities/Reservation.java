package com.examen.examM1.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Reservation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long livreId;
    private String utilisateur;
    private LocalDate dateReservation;

    public Reservation() {}
    public Reservation(Long livreId, String utilisateur, LocalDate dateReservation) {
        this.livreId = livreId;
        this.utilisateur = utilisateur;
        this.dateReservation = dateReservation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLivreId() {
        return livreId;
    }

    public void setLivreId(Long livreId) {
        this.livreId = livreId;
    }

    public String getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(String utilisateur) {
        this.utilisateur = utilisateur;
    }

    public LocalDate getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(LocalDate dateReservation) {
        this.dateReservation = dateReservation;
    }
// Getters et Setters
}

