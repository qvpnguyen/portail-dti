package com.portaildti.portaildti.entities;

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
    @Column
    private Boolean formationCompletee;
    @ManyToMany
    @JoinTable(
            name = "étudiant_cours",
            joinColumns = @JoinColumn(name = "étudiantID"),
            inverseJoinColumns = @JoinColumn(name = "coursID")
    )
    private Set<Cours> coursSet = new HashSet();

    @Column
    private Boolean dispoTutorat;
    @Column(name = "is_tuteur")
    private Boolean isTuteur;
    @Column
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

    public Etudiant(Integer id) {

        this.id = id;

    }

    public Etudiant(Set<Projet> projet) {
        this.projets = projet;
    }

    public Etudiant(Integer id, String prenom, String nom, LocalDate ddn, String email, Boolean active, String role, Boolean formationCompletee, String profil, String motDePasse, Set<Cours> coursID, String photo, Boolean dispoTutorat, Boolean isTuteur) {

        super(id, prenom, nom, email, role, active, motDePasse, ddn, photo);
        this.formationCompletee = formationCompletee;
        this.coursSet = coursID;
        this.dispoTutorat = dispoTutorat;
        this.profil = profil;
        this.isTuteur = isTuteur;
    }

    public Etudiant(Boolean formationCompletee, Set<Cours> cours, Boolean dispoTutorat, String profil, String prenom, String nom, String email, String role, Boolean active, String motDePasse, LocalDate ddn, String photo, Boolean isTuteur) {

        super(prenom, nom, email, role, active, motDePasse, ddn, photo);
        this.formationCompletee = formationCompletee;
        this.coursSet = cours;
        this.dispoTutorat = dispoTutorat;
        this.profil = profil;
        this.isTuteur = isTuteur;
    }

    public Etudiant(Boolean formationCompletee, Set<Cours> cours, Boolean dispoTutorat, String profil, String prenom, String nom, Boolean isTuteur) {
        super(prenom, nom);
        this.formationCompletee = formationCompletee;
        this.coursSet = cours;
        this.dispoTutorat = dispoTutorat;
        this.profil = profil;
        this.isTuteur = isTuteur;
    }

    public Etudiant(Boolean formationCompletee, Set<Cours> cours, Boolean dispoTutorat, String profil, Integer id, Boolean isTuteur) {
        super(id);
        this.formationCompletee = formationCompletee;
        this.coursSet = cours;
        this.dispoTutorat = dispoTutorat;
        this.profil = profil;
        this.isTuteur = isTuteur;
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
    public Boolean getDispoTutorat() {
        return dispoTutorat;
    }

    public void setDispoTutorat(Boolean dispoTutorat) {
        this.dispoTutorat = dispoTutorat;
    }

    public Boolean getTuteur() {
        return isTuteur;
    }

    public void setTuteur(Boolean tuteur) {
        isTuteur = tuteur;
    }

    //    public String getRole() {
//        return role;
//    }
//
//    public void setRole(String role) {
//        this.role = role;
//    }
    public Boolean getFormationCompletee() {
        return formationCompletee;
    }

    public void setFormationCompletee(Boolean formationCompletee) {
        this.formationCompletee = formationCompletee;
    }

    public Set<Cours> getCoursSet() {
        return coursSet;
    }

    public void setCoursSet(Set<Cours> coursSet) {
        this.coursSet = coursSet;
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
        message = String.format("%s %s %s %b", super.prenom, super.nom, super.role, super.active);
        return message;
    }
}

