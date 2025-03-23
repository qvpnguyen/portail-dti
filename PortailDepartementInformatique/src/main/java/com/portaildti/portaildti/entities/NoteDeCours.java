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
public class NoteDeCours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String nom;
    @Column
    private String lien;
    @ManyToOne
    @JoinColumn(name = "CoursID")
    private Cours cours;
    @ManyToOne
    @JoinColumn(name = "ProfesseurID")
    private Professeur professeur;
    @Column
    private String document;
    @Lob
    private byte[] data;

    public NoteDeCours() {
    }

    public NoteDeCours(String nom, String lien, Cours cours, Professeur professeur, String document) {
        this.nom = nom;
        this.lien = lien;
        this.cours = cours;
        this.professeur = professeur;
        this.document = document;
    }

    public NoteDeCours(String nom, String lien, Cours cours, Professeur professeur) {
        this.nom = nom;
        this.lien = lien;
        this.cours = cours;
        this.professeur = professeur;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
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

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String afficherTitreDesColonnes() {
        String message = "";
        message = String.format(" %-10s  %30s %15s  %25s ", "Id", "Lien", "CoursID", "Nom");
        message += "\n --------------------------------------------------------------------------------------------------------------------------------------";
        return message;
    }

    @Override
    public String toString() {
        String message = "";
        message = String.format(" %-10d  %30s %15d  %25s ", this.id, this.lien, this.cours.getId(), this.nom);
        return message;
    }

}

