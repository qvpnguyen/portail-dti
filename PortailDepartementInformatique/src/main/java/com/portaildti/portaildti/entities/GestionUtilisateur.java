//package com.portaildepartementinformatiqueanayeespatrickothmane.portaildepartementinformatiqueanayeespatrickothmane.entities;
//
///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//
//import javax.persistence.*;
//import java.util.List;
//
///**
// *
// * @author anayeesFrancisPatrickOthmane
// */
//
//@Entity
//public class GestionUtilisateur {
//
//    @OneToMany
//    private List<Etudiant> listeTuteurs;
//    @OneToMany
//
//    private List<Etudiant> listeEtudiantsDifficulte;
//    @OneToMany
//
//    private List<Etudiant> listeTousEtudiants;
//    @OneToMany
//
//    private List<Projet> listeProjet;
//    @OneToMany
//
//    private List<Professeur> listeProfesseur;
//    @OneToMany
//
//    private List<Cours> listeCours;
//    @OneToMany
//
//    private List<NoteDeCours> listeNoteDeCours;
//    @OneToMany
//
//    private List<Utilisateur> listeMembreJury;
//
//    @OneToOne(mappedBy = "gestion")
//    private Administrateur administrateur;
//    @Id
//    private Long id;
//
//    public GestionUtilisateur(){
//
//    }
//
//    public List<Etudiant> getListeTuteurs() {
//        return listeTuteurs;
//    }
//
//    public void setListeTuteurs(List<Etudiant> listeTuteurs) {
//        this.listeTuteurs = listeTuteurs;
//    }
//
//    public List<Etudiant> getListeEtudiantsDifficulte() {
//        return listeEtudiantsDifficulte;
//    }
//
//    public void setListeEtudiantsDifficulte(List<Etudiant> listeEtudiantsDifficulte) {
//        this.listeEtudiantsDifficulte = listeEtudiantsDifficulte;
//    }
//
//    public List<Etudiant> getListeTousEtudiants() {
//        return listeTousEtudiants;
//    }
//
//    public void setListeTousEtudiants(List<Etudiant> listeTousEtudiants) {
//        this.listeTousEtudiants = listeTousEtudiants;
//    }
//
//    public List<Projet> getListeProjet() {
//        return listeProjet;
//    }
//
//    public void setListeProjet(List<Projet> listeProjet) {
//        this.listeProjet = listeProjet;
//    }
//
//    public List<Professeur> getListeProfesseur() {
//        return listeProfesseur;
//    }
//
//    public void setListeProfesseur(List<Professeur> listeProfesseur) {
//        this.listeProfesseur = listeProfesseur;
//    }
//
//    public List<Cours> getListeCours() {
//        return listeCours;
//    }
//
//    public void setListeCours(List<Cours> listeCours) {
//        this.listeCours = listeCours;
//    }
//
//    public List<NoteDeCours> getListeNoteDeCours() {
//        return listeNoteDeCours;
//    }
//
//    public void setListeNoteDeCours(List<NoteDeCours> listeNoteDeCours) {
//        this.listeNoteDeCours = listeNoteDeCours;
//    }
//
//    public List<Utilisateur> getListeMembreJury() {
//        return listeMembreJury;
//    }
//
//    public void setListeMembreJury(List<Utilisateur> listeMembreJury) {
//        this.listeMembreJury = listeMembreJury;
//    }
//
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Long getId() {
//        return id;
//    }
//}
//
