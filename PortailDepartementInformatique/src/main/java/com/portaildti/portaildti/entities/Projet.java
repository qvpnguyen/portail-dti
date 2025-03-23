package com.portaildti.portaildti.entities;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author anayeesFrancisPatrickOthmane
 */
@Entity
public class Projet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 100, nullable = false)
    private String nom;
    @Column(length = 4)
    private Integer annee;
    @Column(length = 5000)
    private String description;
    @Column
    private String video;
    @Column
    private String lienGitlab;
    @ManyToOne
    @JoinColumn(name = "CoursID")
    private Cours cours;
    @ManyToOne
    @JoinColumn(name = "ProfesseurID")
    private Professeur professeur;

    @ManyToMany
    @JoinTable(
            name = "étudiant_projet",
            joinColumns = @JoinColumn(name = "ProjetID"),
            inverseJoinColumns = @JoinColumn(name = "ÉtudiantID")
    )
    private Set<Etudiant> etudiants = new HashSet();
    @Lob
    private byte[] data;

//    @OneToMany(mappedBy = "projet", cascade = CascadeType.ALL)
//    private List<Vote> votes = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "RatingID")
    private Vote rating;

    public Projet() {
    }

    public Projet(Set<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    public Projet(String nom, Integer annee, String description, String video, String lienGitlab, Cours cours, Professeur professeur) {
        this.nom = nom;
        this.annee = annee;
        this.description = description;
        this.video = video;
        this.lienGitlab = lienGitlab;
        this.cours = cours;
        this.professeur = professeur;

    }

    public Projet(Integer id, String nom, Integer annee, String description, String video, String lienGitlab, Cours cours, Professeur professeur) {
        this.id = id;
        this.nom = nom;
        this.annee = annee;
        this.description = description;
        this.video = video;
        this.lienGitlab = lienGitlab;
        this.cours = cours;
        this.professeur = professeur;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getAnnee() {
        return annee;
    }

    public void setAnnee(Integer annee) {
        this.annee = annee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getLienGitlab() {
        return lienGitlab;
    }

    public void setLienGitlab(String lienGitlab) {
        this.lienGitlab = lienGitlab;
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }

    public Set<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(Set<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    //    public void ajouter(Etudiant etudiant) {
//        this.etudiants.add(etudiant);
//    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

//    public List<Vote> getVotes() {
//        return votes;
//    }
//
//    public void setVotes(List<Vote> votes) {
//        this.votes = votes;
//    }


    public Vote getRating() {
        return rating;
    }

    public void setRating(Vote rating) {
        this.rating = rating;
    }

    public String afficherTitreDesColonnes() {
        String message = "";
        message = String.format(" %-10s  %30s %15s %30s %15s %15s %15s %15s %15s %25s ", "Id", "Nom", "Annee", "Liste etudiants", "Description", "Video", "LienGitlab",
                "Cours", "Professeur", "Rating");
        message += "\n --------------------------------------------------------------------------------------------------------------------------------------";
        return message;
    }

    @Override
    public String toString() {
        String message = "";
        message = String.format(" %-10d  %30s %15d %30s %15s %15s %15s %15s %15d", this.id, this.nom, this.annee, this.description, this.video, this.lienGitlab, this.cours, this.professeur, this.rating);
        return message;
    }

}

