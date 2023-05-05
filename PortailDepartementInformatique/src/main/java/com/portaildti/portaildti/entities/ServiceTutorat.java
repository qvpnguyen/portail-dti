package com.portaildti.portaildti.entities;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalTime;

/**
 *
 * @author anayeesFrancisPatrickOthmane
 */
@Entity
public class ServiceTutorat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date dateTutorat;
    private LocalTime heure;
    private double duree;
    private String typeDeRencontre;
    @ManyToOne
    @JoinColumn(name = "ÉtudiantTuteurID")
    private Etudiant tuteur;
    @ManyToOne
    @JoinColumn(name = "ÉtudiantTutoréID")
    private Etudiant etudiantTutore;
    @ManyToOne
    @JoinColumn(name = "CoursID")
    private Cours cours;

    public ServiceTutorat(){

    }

    public ServiceTutorat(Integer id, Date dateTutorat, LocalTime heure, double duree, String typeDeRencontre, Etudiant tuteur, Etudiant etudiantTutore, Cours cours) {
        this.id = id;
        this.dateTutorat = dateTutorat;
        this.heure = heure;
        this.duree = duree;
        this.typeDeRencontre = typeDeRencontre;
        this.tuteur = tuteur;
        this.etudiantTutore = etudiantTutore;
        this.cours = cours;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateTutorat() {
        return dateTutorat;
    }

    public void setDateTutorat(Date dateTutorat) {
        this.dateTutorat = dateTutorat;
    }

    public LocalTime getHeure() {
        return heure;
    }

    public void setHeure(LocalTime heure) {
        this.heure = heure;
    }

    public double getDuree() {
        return duree;
    }

    public void setDuree(double duree) {
        this.duree = duree;
    }

    public String getTypeDeRencontre() {
        return typeDeRencontre;
    }

    public void setTypeDeRencontre(String typeDeRencontre) {
        this.typeDeRencontre = typeDeRencontre;
    }

    public Etudiant getTuteur() {
        return tuteur;
    }

    public void setTuteur(Etudiant tuteur) {
        this.tuteur = tuteur;
    }

    public Etudiant getEtudiantTutore() {
        return etudiantTutore;
    }

    public void setEtudiantTutore(Etudiant etudiantTutore) {
        this.etudiantTutore = etudiantTutore;
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }

}

