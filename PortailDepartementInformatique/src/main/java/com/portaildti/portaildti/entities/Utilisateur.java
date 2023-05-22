/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portaildti.portaildti.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author anayeesFrancisPatrickOthmane
 */
@MappedSuperclass
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    Integer id;
    @Column(length = 64, nullable = false)
    String prenom;
    @Column(length = 64, nullable = false)
    String nom;
    @Column(length = 128, nullable = false, unique = true)
    private String email;
//    private String profil;
    @Column(nullable = false)
    String role;
    Boolean active;
    @Column(length = 64, nullable = false)
    private String motDePasse;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate ddn;
    @Column(length = 64)
    private String photo;

    @Lob
    private byte[] data;

    public Utilisateur() {
    }


    public Utilisateur(Integer id, String prenom, String nom, String email, String role, Boolean active, String motDePasse, LocalDate ddn, String photo) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
//        this.profil = profil;
        this.role = role;
        this.active = active;
        this.motDePasse = motDePasse;
        this.ddn = ddn;
        this.photo = photo;
    }

    public Utilisateur(Integer id, LocalDate ddn, String email, Boolean active, String nom, String prenom, String password, String photo) {
        this.ddn = ddn;
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.active = active;
        this.email = email;
        this.motDePasse = password;
        this.photo = photo;
    }

    public Utilisateur(String prenom, String nom, String email, String role, Boolean active, String motDePasse, LocalDate ddn, String photo) {

        //this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
//        this.profil = profil;
        this.role = role;
        this.active = active;
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

    public Utilisateur(Integer id) {
        this.id = id;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }


    public LocalDate getDdn() {
        return ddn;
    }

    public void setDdn(LocalDate ddn) {
        this.ddn = ddn;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String afficherTitreDesColonnes() {
        String message = "";
        message = String.format(" %-10s %15s %15s %15s %15s %15s %25s ", "Id", "Active", "Nom", "Prenom","Date de naissance", "Role",
                "MotDePasse");
        message+="\n --------------------------------------------------------------------------------------------------------------------------------------";
        return message;
    }

    @Override
    public String toString() {
        String message = "";
        message = String.format(" %-10d %15b %15s %15s %15s %15s %25s ",this.id, this.active,this.nom,this.prenom,
                this.ddn, this.role, this.motDePasse);
        return message;
    }
}
