/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities;

import java.util.Date;

/**
 *
 * @author anayeesFrancisPatrickOthmane
 */
public class Notes {

    private int id;
    private int noteObtenue;
    private String session;
    private int annee;
    private String commentaire;
    private Etudiant etudiantID;
    private Cours coursID;
    private Projet projetID;

    public Notes() {
    }

    public Notes(int id, int noteObtenue, String session, int annee, String commentaire, Projet projetID) {
        this.id = id;
        this.noteObtenue = noteObtenue;
        this.session = session;
        this.annee = annee;
        this.commentaire = commentaire;
        this.projetID = projetID;
    }

    public Notes(int noteObtenue, String session, int annee, String commentaire, Etudiant etudiantID, Cours coursID, Projet projetID) {
        this.noteObtenue = noteObtenue;
        this.session = session;
        this.annee = annee;
        this.commentaire = commentaire;
        this.etudiantID = etudiantID;
        this.coursID = coursID;
        this.projetID = projetID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNoteObtenue() {
        return noteObtenue;
    }

    public void setNoteObtenue(int noteObtenue) {
        this.noteObtenue = noteObtenue;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Etudiant getEtudiantID() {
        return etudiantID;
    }

    public void setEtudiantID(Etudiant etudiantID) {
        this.etudiantID = etudiantID;
    }

    public Cours getCoursID() {
        return coursID;
    }

    public void setCoursID(Cours coursID) {
        this.coursID = coursID;
    }

    public Projet getProjetID() {
        return projetID;
    }

    public void setProjetID(Projet projetID) {
        this.projetID = projetID;
    }

}
