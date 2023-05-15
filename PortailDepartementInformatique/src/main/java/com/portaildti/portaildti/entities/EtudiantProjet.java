package com.portaildti.portaildti.entities;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.persistence.*;

/**
 *
 * @author Anayees
 */
@Entity
public class EtudiantProjet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "projetid")
    private Projet projet;
    @ManyToOne
    @JoinColumn(name = "étudiantid")
    private Etudiant etudiant;
    public EtudiantProjet() {

    }
    public EtudiantProjet(Projet projet, Etudiant etudiant) {
        this.projet = projet;
        this.etudiant = etudiant;
    }

    public Projet getProjet() {
        return projet;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    @Override
    public String toString() {
        return "EtudiantProjet{" + "projet=" + projet + ", etudiant=" + etudiant + '}';
    }

}

