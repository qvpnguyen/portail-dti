package com.portaildepartementinformatiqueanayeespatrickothmane.portaildepartementinformatiqueanayeespatrickothmane.entities;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

/**
 *
 * @author anayeesFrancisPatrickOthmane
 */
@Entity
public class Etudiant extends Utilisateur {

    //    private Date ddn;
    //private boolean active;
//    private String role;
    private boolean formationCompletee;
    @ManyToOne
    @JoinColumn(name = "ProfesseurID")
    private Cours cours;
    private boolean dispoTutorat;
    private String profil;

    @ManyToMany
    @JoinTable(
            name = "étudiant_projet",
            joinColumns = @JoinColumn(name = "ÉtudiantID"),
            inverseJoinColumns = @JoinColumn(name = "ProjetID")
    )
    private Set<Projet> projets = new HashSet();

    public Etudiant() {

    }

//    public Etudiant(boolean formationCompletee, Cours cours, boolean dispoTutorat) {
//        this.formationCompletee = formationCompletee;
//        this.cours = cours;
//        this.dispoTutorat = dispoTutorat;
//    }

    public Etudiant(int id) {

        this.id = id;

    }

    public Etudiant(int id, String prenom, String nom, LocalDate ddn, String email, boolean active, String role, boolean formationCompletee, String profil, String nomUtilisateur, String motDePasse, Cours coursID, String photo, boolean dispoTutorat) {

        super(id, prenom, nom, email, role, active, nomUtilisateur, motDePasse, ddn, photo);
        this.formationCompletee = formationCompletee;
        this.cours = coursID;
        this.dispoTutorat = dispoTutorat;
        this.profil = profil;

    }

    public Etudiant(boolean formationCompletee, Cours cours, boolean dispoTutorat, String profil, int id, String prenom, String nom, String email, String role, boolean active, String nomUtilisateur, String motDePasse, LocalDate ddn, String photo) {

        super(prenom, nom, email, role, active, nomUtilisateur, motDePasse, ddn, photo);
        this.formationCompletee = formationCompletee;
        this.cours = cours;
        this.dispoTutorat = dispoTutorat;
        this.profil = profil;

    }

    public Etudiant(boolean formationCompletee, Cours cours, boolean dispoTutorat, String profil, String prenom, String nom) {
        super(prenom, nom);
        this.formationCompletee = formationCompletee;
        this.cours = cours;
        this.dispoTutorat = dispoTutorat;
        this.profil = profil;

    }

    public Etudiant(boolean formationCompletee, Cours cours, boolean dispoTutorat, String profil, int id) {
        super(id);
        this.formationCompletee = formationCompletee;
        this.cours = cours;
        this.dispoTutorat = dispoTutorat;
        this.profil = profil;

    }

    //    public Etudiant(int id,String prenom, String nom, String email, String profil, String role, boolean active, String nomUtilisateur, String motDePasse, Date ddn, boolean formationCompletee, Cours cours, boolean dispoTutorat) {
//        super(id, prenom, nom, email, role, profil, active, nomUtilisateur, motDePasse, ddn);
//
//    public Etudiant(int id) {
//        this.id = id;
//    }
//
//    public Etudiant(Date ddn, boolean formationCompletee, int coursId, boolean dispoTutorat, int id, String prenom, String nom, String email, String profil, String role, boolean active, String nomUtilisateur, String motDePasse, String photo) {
//        super(id, prenom, nom, email, profil, role, active, nomUtilisateur, motDePasse, photo);
//        this.ddn = ddn;
//        this.formationCompletee = formationCompletee;
//        this.coursId = coursId;
//        this.dispoTutorat = dispoTutorat;
//    }
//
//    public Etudiant(int id, String prenom, String nom, String email, String profil, boolean active, String nomUtilisateur, String motDePasse, Date ddn, String role, boolean formationCompletee, int coursId, boolean dispoTutorat) {
//        super(id, prenom, nom, email, profil, active, nomUtilisateur, motDePasse);
//        this.ddn = ddn;
//        this.role = role;
//
//        this.formationCompletee = formationCompletee;
//        this.cours = cours;
//        this.dispoTutorat = dispoTutorat;
//    }
    public Etudiant(String prenom, String nom) {
        super(prenom, nom);
    }

    //    public Etudiant(int id) {
//        super(id);
//    }
//    public Date getDdn() {
//        return ddn;
//    }
//
//    public void setDdn(Date ddn) {
//        this.ddn = ddn;
//    }
    public boolean isDispoTutorat() {
        return dispoTutorat;
    }

    public void setDispoTutorat(boolean dispoTutorat) {
        this.dispoTutorat = dispoTutorat;
    }

    //    public String getRole() {
//        return role;
//    }
//
//    public void setRole(String role) {
//        this.role = role;
//    }
    public boolean isFormationCompletee() {
        return formationCompletee;
    }

    public void setFormationCompletee(boolean formationCompletee) {
        this.formationCompletee = formationCompletee;
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }

    //ajouter les projets
    public void ajouter(Projet projet) {
        this.projets.add(projet);
    }

    @Override
    public String toString() {
        String message = "";
        message = String.format("%s %s", super.prenom, this.nom);
        return message;
    }
}

