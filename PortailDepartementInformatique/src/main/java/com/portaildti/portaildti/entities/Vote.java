package com.portaildti.portaildti.entities;

import javax.persistence.*;

@Entity
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer rating;
    private double ratingAverage;

    @ManyToOne
    @JoinColumn(name = "ProjetID")
    private Projet projetID;
    @ManyToOne
    @JoinColumn(name = "EtudiantID")
    private Etudiant etudiant;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public double getRatingAverage() {
        return ratingAverage;
    }

    public void setRatingAverage(double ratingAverage) {
        this.ratingAverage = ratingAverage;
    }

    public Projet getProjetID() {
        return projetID;
    }

    public void setProjetID(Projet projetID) {
        this.projetID = projetID;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "id=" + id +
                ", rating=" + rating +
                ", projetID=" + projetID +
                '}';
    }
}

