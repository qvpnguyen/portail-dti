/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author franc
 */
public class Etudiant extends Utilisateur {
    private Date  ddn;
    private String role;
    private boolean formationCompletee;
    private String profil;
    private ArrayList<Cours> listeCours;
    private boolean dispoTuteur;

    public Etudiant() {
    }

 
    
    public Etudiant(Date ddn, String role, boolean formationCompletee, String profil, ArrayList<Cours> listeCours, boolean dispoTuteur, int id, String email, boolean active, String nom, String prenom, String password, String photo) {
        super(email, active, nom, prenom, password, photo);
        this.ddn = ddn;
        this.role = role;
        this.formationCompletee = formationCompletee;
        this.profil = profil;
        this.listeCours = listeCours;
        this.dispoTuteur = dispoTuteur;
    }

    public Date getDdn() {
        return ddn;
    }

    public void setDdn(Date ddn) {
        this.ddn = ddn;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isFormationCompletee() {
        return formationCompletee;
    }

    public void setFormationCompletee(boolean formationCompletee) {
        this.formationCompletee = formationCompletee;
    }

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }

    public ArrayList<Cours> getListeCours() {
        return listeCours;
    }

    public void setListeCours(ArrayList<Cours> listeCours) {
        this.listeCours = listeCours;
    }

    public boolean isDispoTuteur() {
        return dispoTuteur;
    }

    public void setDispoTuteur(boolean dispoTuteur) {
        this.dispoTuteur = dispoTuteur;
    }

    
    
    
    
}
