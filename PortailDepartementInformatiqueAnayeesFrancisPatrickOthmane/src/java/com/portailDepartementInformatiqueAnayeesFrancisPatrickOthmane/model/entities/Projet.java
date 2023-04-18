/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author anayeesFrancisPatrickOthmane
 */
public class Projet {

    private int id;
    private String nom;
    private int annee;
    private List<Etudiant> listeEquipeProjet;
    private String description;
    private String video;
    private String lienGitlab;
    private Cours cours;
    private Professeur professeur;
    private Notes notes;

    public Projet() {
    }


    public Projet(String nom, int annee, String description, String video, String lienGitlab, Cours cours, Professeur professeur) {
        this.nom = nom;
        this.annee = annee;
        this.description = description;
        this.video = video;
        this.lienGitlab = lienGitlab;
        this.cours = cours;
        this.professeur = professeur;
        this.notes = null;
        listeEquipeProjet = new ArrayList<>();

    }

    public Projet(int id, String nom, int annee, String description, String video, String lienGitlab, Cours cours, Professeur professeur, Notes notes) {
        this.id = id;
        this.nom = nom;
        this.annee = annee;
        this.description = description;
        this.video = video;
        this.lienGitlab = lienGitlab;
        this.cours = cours;
        this.professeur = professeur;
        this.notes = notes;
        listeEquipeProjet = new ArrayList<>();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public List<Etudiant> getListeEquipeProjet() {
        return listeEquipeProjet;
    }

    public void setListeEquipeProjet(List<Etudiant> listeEquipeProjet) {
        this.listeEquipeProjet = listeEquipeProjet;
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
        message = String.format(" %-10d  %30s %15d %30s %15s %15s %15s %15s %15s %25s ", this.id, this.nom, this.annee, this.listeEquipeProjet, this.description, this.video,
                this.lienGitlab, this.cours, this.professeur, this.notes);
        return message;
    }
    
}
