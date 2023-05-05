package com.portaildti.portaildti.entities;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author anayeesFrancisPatrickOthmane
 */
@Entity
public class Cours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private int credits;
    private int groupe;

    @ManyToMany
    @JoinTable(
            name = "participationcours",
            joinColumns = @JoinColumn(name = "CoursID"),
            inverseJoinColumns = @JoinColumn(name = "ÉtudiantID")
    )
    private Set<Etudiant> etudiant = new HashSet();
    @ManyToOne
    @JoinColumn(name = "ProfesseurID")
    private Professeur profID;

    public Cours() {
    }

    public Cours(int id) {
        this.id = id;
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

    public int getCredits() {
        return credits;
    }

    public Professeur getProfID() {
        return profID;
    }

    public void setProfID(Professeur profID) {
        this.profID = profID;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getGroupe() {
        return groupe;
    }

    public void setGroupe(int groupe) {
        this.groupe = groupe;
    }

    public String afficherTitreDesColonnes() {
        String message = "";
        message = String.format(" %-10s  %30s %15s %15s %15s  ", "Id", "Nom", "Crédits", "Groupe",
                "ProfesseurID");
        message+="\n --------------------------------------------------------------------------------------------------------------------------------------";
        return message;
    }

    @Override
    public String toString() {
        String message = "";
        message = String.format(" %-10d  %30s %15d %15s %15s  ",this.id,this.nom, this.credits,this.groupe,
                this.profID);
        return message;
    }
}

