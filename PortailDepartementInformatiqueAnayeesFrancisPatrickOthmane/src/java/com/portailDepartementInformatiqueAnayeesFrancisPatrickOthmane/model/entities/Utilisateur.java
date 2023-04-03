/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities;

import java.util.Date;

/**
 *
 * @author anayeesFrancisPatrickOthmane
 */
public class Utilisateur {
    
    int id;
    String prenom;
    String nom;
    private String email;
    //private String profil;
    private String role;
    private boolean active;
    private String nomUtilisateur;
    private String motDePasse;
    private Date ddn;
    private String photo;
    

    public Utilisateur() {
    }


    public Utilisateur(int id, String prenom, String nom, String email, String role, boolean active, String nomUtilisateur, String motDePasse, Date ddn, String photo) {

        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        //this.profil = profil;
        this.role = role;
        this.active = active;
        this.nomUtilisateur = nomUtilisateur;
        this.motDePasse = motDePasse;
        this.ddn = ddn;
        this.photo = photo;
    }

//    public Utilisateur(int id, String prenom, String nom, String email, String profil, boolean active, String nomUtilisateur, String motDePasse) {
//
//        this.id = id;
//        this.prenom = prenom;
//        this.nom = nom;
//        this.email = email;
//        this.role = role;
//        this.active = active;
//        this.nomUtilisateur = nomUtilisateur;
//        this.motDePasse = motDePasse;
//        this.ddn = ddn;
//    }
//    
//    public Utilisateur(String prenom, String nom, String email, String role, boolean active, String nomUtilisateur, String motDePasse, Date ddn) {
//        this.prenom = prenom;
//        this.nom = nom;
//        this.email = email;
//        this.role = role;
//        this.active = active;
//        this.nomUtilisateur = nomUtilisateur;
//        this.motDePasse = motDePasse;
//        this.ddn = ddn;
//    }
//
//    public Utilisateur(int id, String prenom, String nom, String email, String profil, String role, boolean active, String nomUtilisateur, String motDePasse, Date ddn) {
//        this.id = id;
//        this.prenom = prenom;
//        this.nom = nom;
//        this.email = email;
//        this.profil = profil;
//        this.role = role;
//        this.active = active;
//        this.nomUtilisateur = nomUtilisateur;
//        this.motDePasse = motDePasse;
//        this.ddn = ddn;
//    }
    
    public Utilisateur(String prenom, String nom) {
        this.prenom = prenom;
        this.nom = nom;
    }
    
    public Utilisateur(int id) {
        this.id = id;
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

//    public String getProfil() {
//        return profil;
//    }
//
//    public void setProfil(String profil) {
//        this.profil = profil;
//    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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


    public Date getDdn() {
        return ddn;
    }

    public void setDdn(Date ddn) {
        this.ddn = ddn;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    


    public String afficherTitreDesColonnes() {
        String message = "";
        message = String.format(" %-10s  %30s %15s %15s %15s %15s %15s %25s ", "Id", "nomUtilisateur", "Active", "Nom", "Prenom","Date de naissance", "Role",
                "MotDePasse");
       message+="\n --------------------------------------------------------------------------------------------------------------------------------------";
       return message;
    }
  
    @Override
    public String toString() {
        String message = "";
        message = String.format(" %-10d  %30s %15b %15s %15s %15s %15s %25s ",this.id,this.nomUtilisateur, this.active,this.nom,this.prenom,
                   this.ddn, this.role, this.motDePasse); 
       return message;
    }
}
