/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities;

import java.util.List;

/**
 *
 * @author anayeesfrancispatrickothmane
 */
public class Projet {
    
    private int id;
    private String nom;
    private Date annee;
    private Cours cours;
    private List<Etudiant> listeEquipeProjet;
    private String description;
    private String video;
    private String lienGitlab;
    private int professeurEnChargeId;
    private int NotesID;

    public Projet() {
    }

    public Projet(int id, String nom, Date annee, Cours cours, List<Etudiant> listeEquipeProjet, String description, String video, String lienGitlab, int professeurEnChargeId, int NotesID) {
        this.id = id;
        this.nom = nom;
        this.annee = annee;
        this.cours = cours;
        this.listeEquipeProjet = listeEquipeProjet;
        this.description = description;
        this.video = video;
        this.lienGitlab = lienGitlab;
        this.professeurEnChargeId = professeurEnChargeId;
        this.NotesID = NotesID;
    }

    
    
   

    
    
    
    public int getProfesseurEnChargeId() {
        return professeurEnChargeId;
    }

    public void setProfesseurEnChargeId(int professeurEnChargeId) {
        this.professeurEnChargeId = professeurEnChargeId;
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

    public Date getAnnee() {
        return annee;
    }

    public void setAnnee(Date annee) {
        this.annee = annee;
    }

    

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
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

    public int getNotesID() {
        return NotesID;
    }

    public void setNotesID(int NotesID) {
        this.NotesID = NotesID;
    }

    

  
    
    
}
