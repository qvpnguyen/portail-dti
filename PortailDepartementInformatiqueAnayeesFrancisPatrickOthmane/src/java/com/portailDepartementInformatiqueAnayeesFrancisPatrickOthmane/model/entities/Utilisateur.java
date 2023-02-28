/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities;

/**
 *
 * @author franc
 */
public class  Utilisateur {
    
    int id;
    String prenom;
    String nom;
    String email;
    String profil;
    boolean active;
    String nomUtilisateur;
    String motDePasse;
    
    

    public Utilisateur() {
    }

    public Utilisateur(int id, String prenom, String nom, String email, String profil, boolean active, String nomUtilisateur, String motDePasse) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.profil = profil;
        this.active = active;
        this.nomUtilisateur = nomUtilisateur;
        this.motDePasse = motDePasse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

         public String afficherTitreDesColonnes() {
        String message = "";
        message = String.format(" %-10s  %30s %15s %15s %15s %15s %25s ", "Id", "nomUtilisateur", "Active", "Nom", "Prenom","Profil",
                "MotDePasse");
       message+="\n --------------------------------------------------------------------------------------------------------------------------------------";
       return message;
    }
  
    @Override
       public String toString() {
         String message = "";
       message = String.format(" %-10d  %30s %15b %15s %15s %15s %25s ",this.id,this.nomUtilisateur, this.active,this.nom,this.prenom,
                   this.profil, this.motDePasse); 
       return message;
    }
}
