/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author franc
 */
public class Projet {
    
    private int id;
    private String nom;
    private int annee;
    private List<Etudiant> listeEquipeProjet;
    private String description;
    private String video;
    private String lienGitlab;
    private int coursID;  
    private int professeurEnChargeID;
    private int noteID;  

    public Projet() {
    }

    public Projet(int id, String nom, int annee, String description, String video, String lienGitlab, int coursID, int professeurEnChargeID, int noteID) {
        this.id = id;
        this.nom = nom;
        this.annee = annee;
        this.description = description;
        this.video = video;
        this.lienGitlab = lienGitlab;
        this.coursID = coursID;
        this.professeurEnChargeID = professeurEnChargeID;
        this.noteID = noteID;
        this.listeEquipeProjet = new ArrayList();
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

    public int getCoursID() {
        return coursID;
    }

    public void setCoursID(int coursID) {
        this.coursID = coursID;
    }

    public int getProfesseurEnChargeID() {
        return professeurEnChargeID;
    }

    public void setProfesseurEnChargeID(int professeurEnChargeID) {
        this.professeurEnChargeID = professeurEnChargeID;
    }

    public int getNoteID() {
        return noteID;
    }

    public void setNoteID(int noteID) {
        this.noteID = noteID;
    }

          public String afficherTitreDesColonnes() {
        String message = "";
        message = String.format(" %-10s  %30s %15s %15s %15s %15s %15s %15s %25s ", "Id", "Nom", "Annee", "Description", "Video","LienGitlab",
                "CoursID","ProfesseurID","NotesID");
       message+="\n --------------------------------------------------------------------------------------------------------------------------------------";
       return message;
    }
  
    @Override
       public String toString() {
         String message = "";
       message = String.format(" %-10d  %30s %15b %15s %15s %15s %15s %15s %25s ",this.id,this.nom, this.annee,this.description,this.video,
                   this.lienGitlab, this.coursID,this.professeurEnChargeID,this.noteID); 
       return message;
    }

  
}
