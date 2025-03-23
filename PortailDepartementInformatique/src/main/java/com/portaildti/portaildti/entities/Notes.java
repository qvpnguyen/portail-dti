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
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 3)
    private Integer noteObtenue;
    @Column(length = 10)
    private String session;
    @Column(length = 4)
    private Integer annee;
    private String commentaire;
    @ManyToOne
    @JoinColumn(name = "ProfesseurID")
    private Professeur professeurID;
    @OneToOne
    @JoinColumn(name = "CoursID")
    private Cours coursID;
    @OneToOne
    @JoinColumn(name = "ProjetID")
    private Projet projetID;

    public Notes() {
    }

    public Notes(Integer id, Integer noteObtenue, String session, Integer annee, String commentaire, Projet projetID) {
        this.id = id;
        this.noteObtenue = noteObtenue;
        this.session = session;
        this.annee = annee;
        this.commentaire = commentaire;
        this.projetID = projetID;
    }

    public Notes(int noteObtenue, String session, Integer annee, String commentaire, Professeur professeurID, Cours coursID, Projet projetID) {
        this.noteObtenue = noteObtenue;
        this.session = session;
        this.annee = annee;
        this.commentaire = commentaire;
        this.professeurID = professeurID;
        this.coursID = coursID;
        this.projetID = projetID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNoteObtenue() {
        return noteObtenue;
    }

    public void setNoteObtenue(Integer noteObtenue) {
        this.noteObtenue = noteObtenue;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public Integer getAnnee() {
        return annee;
    }

    public void setAnnee(Integer annee) {
        this.annee = annee;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Professeur getProfesseurID() {
        return professeurID;
    }

    public void setProfesseurID(Professeur professeurID) {
        this.professeurID = professeurID;
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

