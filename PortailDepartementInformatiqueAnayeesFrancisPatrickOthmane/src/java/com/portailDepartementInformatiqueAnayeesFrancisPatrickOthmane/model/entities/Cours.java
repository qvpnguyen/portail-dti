/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities;

import java.util.List;

/**
 *
 * @author anayeesFrancisPatrickOthmane
 */
public class Cours {
    private int id;
    private String nom;
    private int credits;
    private List<Etudiant> listeEtudiants;
    private int profID;
    private int groupe;

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

    public int getProfID() {
        return profID;
    }

    public void setProfID(int profID) {
        this.profID = profID;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public List<Etudiant> getListeEtudiants() {
        return listeEtudiants;
    }

    public void setListeEtudiants(List<Etudiant> listeEtudiants) {
        this.listeEtudiants = listeEtudiants;
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
