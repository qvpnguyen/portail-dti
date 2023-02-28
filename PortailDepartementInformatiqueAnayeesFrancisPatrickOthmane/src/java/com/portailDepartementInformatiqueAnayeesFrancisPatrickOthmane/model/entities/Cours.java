/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities;

import java.util.List;

/**
 *
 * @author franc
 */
public class Cours {

    
    private int id;
    private String nom;
    private int credits;
    private List<Etudiant> listeEtudiantsID;
    private int professeurId;
    private int groupe;

    public Cours() {
    }
    
    
    public Cours(int id, String nom, int credits, int professeurId, int groupe) {
        this.id = id;
        this.nom = nom;
        this.credits = credits;
        this.professeurId = professeurId;
        this.groupe = groupe;
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

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public List<Etudiant> getListeEtudiantsID() {
        return listeEtudiantsID;
    }

    public void setListeEtudiantsID(List<Etudiant> listeEtudiantsID) {
        this.listeEtudiantsID = listeEtudiantsID;
    }

    public int getProfesseurId() {
        return professeurId;
    }

    public void setProfesseurId(int professeurId) {
        this.professeurId = professeurId;
    }

    public int getGroupe() {
        return groupe;
    }

    public void setGroupe(int groupe) {
        this.groupe = groupe;
    }
    
    
    
}
