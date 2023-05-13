package com.portaildti.portaildti.entities;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.persistence.*;

/**
 *
 * @author anayeesFrancisPatrickOthmane
 */
@Entity
public class Projet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private Integer annee;
    private String description;
    private String video;
    private String lienGitlab;
    @ManyToOne
    @JoinColumn(name = "CoursID")
    private Cours cours;
    @ManyToOne
    @JoinColumn(name = "ProfesseurID")
    private Professeur professeur;
    @OneToOne
    @JoinColumn(name = "NotesID")
    private Notes notes;

    public Projet() {
    }


    public Projet(String nom, Integer annee, String description, String video, String lienGitlab, Cours cours, Professeur professeur) {
        this.nom = nom;
        this.annee = annee;
        this.description = description;
        this.video = video;
        this.lienGitlab = lienGitlab;
        this.cours = cours;
        this.professeur = professeur;
        this.notes = null;

    }

    public Projet(Integer id, String nom, Integer annee, String description, String video, String lienGitlab, Cours cours, Professeur professeur, Notes notes) {
        this.id = id;
        this.nom = nom;
        this.annee = annee;
        this.description = description;
        this.video = video;
        this.lienGitlab = lienGitlab;
        this.cours = cours;
        this.professeur = professeur;
        this.notes = notes;

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

    public Notes getNotes() {
        return notes;
    }

    public void setNotes(Notes notes) {
        this.notes = notes;
    }

    public String afficherTitreDesColonnes() {
        String message = "";
        message = String.format(" %-10s  %30s %15s %30s %15s %15s %15s %15s %15s %25s ", "Id", "Nom", "Annee", "Liste etudiants", "Description", "Video", "LienGitlab",
                "Cours", "Professeur", "Notes");
        message += "\n --------------------------------------------------------------------------------------------------------------------------------------";
        return message;
    }

    @Override
    public String toString() {
        String message = "";
        message = String.format(" %-10d  %30s %15d %30s %15s %15s %15s %15s %15s %25s ", this.id, this.nom, this.annee, this.description, this.video,
                this.lienGitlab, this.cours, this.professeur, this.notes);
        return message;
    }

}

