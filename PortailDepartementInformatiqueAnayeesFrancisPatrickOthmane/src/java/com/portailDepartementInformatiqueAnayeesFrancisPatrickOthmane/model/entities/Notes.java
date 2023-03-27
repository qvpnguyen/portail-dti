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
    private Date annee;
    private String commentaire;
    
    public Notes() {
    }

    public Notes(int id, int noteObtenue, String session, Date annee, String commentaire) {
        this.id = id;
        this.noteObtenue = noteObtenue;
        this.session = session;
        this.annee = annee;
        this.commentaire = commentaire;
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

    public Date getAnnee() {
        return annee;
    }

    public void setAnnee(Date annee) {
        this.annee = annee;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
    
}
