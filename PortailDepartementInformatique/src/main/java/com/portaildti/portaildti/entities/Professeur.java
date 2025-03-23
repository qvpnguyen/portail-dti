package com.portaildti.portaildti.entities;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author anayeesFrancisPatrickOthmane
 */
@Entity
public class Professeur extends Utilisateur{
//    private List<NoteDeCours> notesDeCours;
//    private List<Projet> projets;

    @ManyToMany
    @JoinTable(
            name = "professeur_cours",
            joinColumns = @JoinColumn(name = "professeurID"),
            inverseJoinColumns = @JoinColumn(name = "coursID")
    )
    private Set<Cours> coursSet = new HashSet<>();

    public Professeur() {
//        this.notesDeCours = new ArrayList();
//        this.projets = new ArrayList();
    }

    public Professeur(Integer id, String prenom, String nom, String email, String role, Boolean active, String motDePasse, LocalDate ddn, String photo) {
        super(id, prenom, nom, email, role, active, motDePasse, ddn, photo);
//        this.notesDeCours = new ArrayList();
//        this.projets = new ArrayList();
    }

    public Professeur(String prenom, String nom) {
        super(prenom, nom);
//        this.notesDeCours = new ArrayList();
//        this.projets = new ArrayList();
    }

    public Professeur(Integer id) {
        super(id);
//        this.notesDeCours = new ArrayList();
//        this.projets = new ArrayList();
    }

    public Set<Cours> getCoursSet() {
        return coursSet;
    }

    public void setCoursSet(Set<Cours> coursSet) {
        this.coursSet = coursSet;
    }

    //    public Professeur(List<NoteDeCours> notesDeCours, List<Projet> projets, int id, String prenom, String nom, String email, String role, boolean active, String nomUtilisateur, String motDePasse, Date ddn) {
//        super(id, prenom, nom, email, role, active, nomUtilisateur, motDePasse, ddn);
//        this.notesDeCours = notesDeCours;
//        this.projets = projets;
//
//    public Professeur(int id, String prenom, String nom, String email, String role, boolean active, String nomUtilisateur, String motDePasse, Date ddn, String photo) {
//        super(id, prenom, nom, email, role, active, nomUtilisateur, motDePasse, ddn, photo);
//        this.notesDeCours = new ArrayList<>();
//        this.projets = new ArrayList<>();
//    }
//
//    public Professeur(int id, String prenom, String nom, String email, String role, boolean active, String nomUtilisateur, String motDePasse) {
//        super(id, prenom, nom, email, role, active, nomUtilisateur, motDePasse);
//        this.notesDeCours = new ArrayList<>();
//        this.projets = new ArrayList<>();
//    }
//
//    public Professeur(String prenom, String nom, String email, String role, boolean active, String nomUtilisateur, String motDePasse) {
//        super(prenom, nom, email, role, active, nomUtilisateur, motDePasse);
//    }

//    public List<NoteDeCours> getNotesDeCours() {
//        return notesDeCours;
//    }

//    public void setNotesDeCours(List<NoteDeCours> notesDeCours) {
//        this.notesDeCours = notesDeCours;
//    }

//    public List<Projet> getProjets() {
//        return projets;
//    }
//
//    public void setProjets(List<Projet> projets) {
//        this.projets = projets;
//    }

//    public List<NoteDeCours> consulterNotesProf(Professeur prof) {
//        GestionUtilisateur gestion = null;
//        for(int i =0; i<=gestion.getListeProfesseur().size();i++){
//            if(gestion.getListeProfesseur().get(i).getNom().equals(prof.getNom())){
//                return prof.getNotesDeCours();
//            }
//        }
//        return prof.getNotesDeCours();
//    }
//
//    public void consulterNotesDeCours(NoteDeCours notes) {
//        System.out.println(notes.toString());
//    }
//
//    public void telechargerNotesDeCours(NoteDeCours notes) {
//        notesDeCours.add(notes);
//    }
//
//    public void ajouterProjet(Projet projet) {
//        projets.add(projet);
//    }
//
//    public void modifierProjet(Projet projet) {
//        // code pour modifier un projet existant
//    }
//
//    public void supprimerProjet(Projet projet) {
//        for(int i =0; i<=projets.size();i++){
//            if(projets.get(i).getId() == projet.getId()){
//                projets.remove(i);
//            }
//        }
//    }
//
//    public void ajouterNotesDeCours(NoteDeCours notes) {
//        notesDeCours.add(notes);
//    }
//
//    public void modifierNotesDeCours(NoteDeCours notes) {
//
//    }
//
//    public void supprimerNotesDeCours(NoteDeCours notes) {
//        for(int i =0; i<=notesDeCours.size();i++){
//            if(notesDeCours.get(i).getId() == notes.getId()){
//                notesDeCours.remove(i);
//            }
//        }
//    }

    public int compareTo(Professeur professeur) {

        return 0;

    }
}







