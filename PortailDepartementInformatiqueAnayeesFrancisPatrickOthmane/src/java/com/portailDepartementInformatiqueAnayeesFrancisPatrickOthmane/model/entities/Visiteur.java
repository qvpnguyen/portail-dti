/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author anayeesFrancisPatrickOthmane
 */
public class Visiteur extends Utilisateur {

    public Visiteur() {
    }

    public Visiteur(int id, String prenom, String nom, String email, String role, boolean active, String nomUtilisateur, String motDePasse, LocalDate ddn, String photo) {
        super(id, prenom, nom, email, role, active, nomUtilisateur, motDePasse, ddn, photo);
    }

    
}
