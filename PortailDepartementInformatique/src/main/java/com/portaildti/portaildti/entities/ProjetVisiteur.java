package com.portaildti.portaildti.entities;

import javax.persistence.*;

@Entity
public class ProjetVisiteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 100, nullable = false)
    private String nom;
    @Column(length = 5000)
    private String description;

    @Column
    private String document;

    @Lob
    private byte[] data;
    @ManyToOne
    @JoinColumn(name = "visiteur_id")
    private Visiteur visiteur;

    public ProjetVisiteur() {
    }

    public ProjetVisiteur(String nom, String description, String document, Visiteur visiteur) {
        this.nom = nom;
        this.description = description;
        this.document = document;
        this.visiteur = visiteur;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Visiteur getVisiteur() {
        return visiteur;
    }

    public void setVisiteur(Visiteur visiteur) {
        this.visiteur = visiteur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}

