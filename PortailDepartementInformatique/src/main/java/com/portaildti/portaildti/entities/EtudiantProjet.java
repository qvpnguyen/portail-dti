package com.portaildti.portaildti.entities;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Anayees
 */
public class EtudiantProjet {

    private Projet projet;
    private Etudiant etudiant;

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

    @Override
    public String toString() {
        return "EtudiantProjet{" + "projet=" + projet + ", etudiant=" + etudiant + '}';
    }

}

