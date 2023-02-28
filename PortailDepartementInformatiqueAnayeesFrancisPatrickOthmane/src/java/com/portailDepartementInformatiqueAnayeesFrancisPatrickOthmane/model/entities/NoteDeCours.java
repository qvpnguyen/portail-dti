/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities;

/**
 *
 * @author franc
 */
public class NoteDeCours {
    
    private int id;
    private Cours cours;
    private String lien;
    private int professeurAuteurId;

    public NoteDeCours(int id, Cours cours, String lien, int professeurAuteurId) {
        this.id = id;
        this.cours = cours;
        this.lien = lien;
        this.professeurAuteurId = professeurAuteurId;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    public int getProfesseurAuteurId() {
        return professeurAuteurId;
    }

    public void setProfesseurAuteurId(int professeurAuteurId) {
        this.professeurAuteurId = professeurAuteurId;
    }

    
    
        
    
}
