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

    public Visiteur() {
    }

    public Visiteur(int id, String prenom, String nom, String email, String role, boolean active, String nomUtilisateur, String motDePasse, LocalDate ddn, String photo) {
        super(id, prenom, nom, email, role, active, nomUtilisateur, motDePasse, ddn, photo);
    }


}

