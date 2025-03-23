package com.portaildti.portaildti.entities;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.persistence.Entity;
import java.time.LocalDate;

/**
 *
 * @author anayeesFrancisPatrickOthmane
 */

@Entity
public class Visiteur extends Utilisateur {


    private String statut;


    private String compagnie;

    public Visiteur() {
    }

    public Visiteur(Integer id, String prenom, String nom, String email, String role, Boolean active, String motDePasse, LocalDate ddn, String photo, String statut, String compagnie) {
        super(id, prenom, nom, email, role, active, motDePasse, ddn, photo);
        this.statut = statut;
        this.compagnie = compagnie;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getCompagnie() {
        return compagnie;
    }

    public void setCompagnie(String compagnie) {
        this.compagnie = compagnie;
    }
}


