package com.portaildti.portaildti.entities;

import javax.persistence.*;

@   Entity
public class ProjetVisiteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String description;


    private String document;

    @ManyToOne
    @JoinColumn(name = "visiteur_id")
    private Visiteur visiteur;

    public ProjetVisiteur() {
    }

    public ProjetVisiteur(String description, String document, Visiteur visiteur) {
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
}

