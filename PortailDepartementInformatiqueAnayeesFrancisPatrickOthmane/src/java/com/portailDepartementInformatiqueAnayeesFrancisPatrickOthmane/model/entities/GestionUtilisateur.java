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
public class GestionUtilisateur {
    
    private List<Etudiant> listeTuteurs;
    private List<Etudiant> listeEtudiantsDifficulte;
    private List<Etudiant> listeTousEtudiants;
    private List<Projet> listeProjet;
    private List<Professeur> listeProfesseur;
    private List<Cours> listeCours;
    private List<NoteDeCours> listeNoteDeCours;
    private List<Utilisateur> listeMembreJury;

    public List<Etudiant> getListeTuteurs() {
        return listeTuteurs;
    }

    public void setListeTuteurs(List<Etudiant> listeTuteurs) {
        this.listeTuteurs = listeTuteurs;
    }

    public List<Etudiant> getListeEtudiantsDifficulte() {
        return listeEtudiantsDifficulte;
    }

    public void setListeEtudiantsDifficulte(List<Etudiant> listeEtudiantsDifficulte) {
        this.listeEtudiantsDifficulte = listeEtudiantsDifficulte;
    }

    public List<Etudiant> getListeTousEtudiants() {
        return listeTousEtudiants;
    }

    public void setListeTousEtudiants(List<Etudiant> listeTousEtudiants) {
        this.listeTousEtudiants = listeTousEtudiants;
    }

    public List<Projet> getListeProjet() {
        return listeProjet;
    }

    public void setListeProjet(List<Projet> listeProjet) {
        this.listeProjet = listeProjet;
    }

    public List<Professeur> getListeProfesseur() {
        return listeProfesseur;
    }

    public void setListeProfesseur(List<Professeur> listeProfesseur) {
        this.listeProfesseur = listeProfesseur;
    }

    public List<Cours> getListeCours() {
        return listeCours;
    }

    public void setListeCours(List<Cours> listeCours) {
        this.listeCours = listeCours;
    }

    public List<NoteDeCours> getListeNoteDeCours() {
        return listeNoteDeCours;
    }

    public void setListeNoteDeCours(List<NoteDeCours> listeNoteDeCours) {
        this.listeNoteDeCours = listeNoteDeCours;
    }

    public List<Utilisateur> getListeMembreJury() {
        return listeMembreJury;
    }

    public void setListeMembreJury(List<Utilisateur> listeMembreJury) {
        this.listeMembreJury = listeMembreJury;
    }
    
    
}
