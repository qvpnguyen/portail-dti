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
    private String nom;
    private int coursID;
    private String lien;

    
    
    public NoteDeCours() {
    }
    public NoteDeCours(int id, String nom, int coursID, String lien) {
        this.id = id;
        this.nom = nom;
        this.coursID = coursID;
        this.lien = lien;
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

    public int getCoursID() {
        return coursID;
    }

    public void setCoursID(int coursID) {
        this.coursID = coursID;
    }

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }
    
    
  

        public String afficherTitreDesColonnes() {
        String message = "";
        message = String.format(" %-10s  %30s %15s  %25s ", "Id", "Lien", "CoursID", "Nom");
       message+="\n --------------------------------------------------------------------------------------------------------------------------------------";
       return message;
    }
  
    @Override
       public String toString() {
         String message = "";
       message = String.format(" %-10d  %30s %15b  %25s ",this.id,this.lien, this.coursID, this.nom); 
       return message;
    }
    
    
}
