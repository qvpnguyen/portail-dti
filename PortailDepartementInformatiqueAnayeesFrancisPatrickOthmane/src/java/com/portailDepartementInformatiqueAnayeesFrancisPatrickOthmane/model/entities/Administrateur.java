/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities;

/**
 *
 * @author franc
 */
public class Administrateur extends Utilisateur {

    public Administrateur() {
    }

    public Administrateur(int id, String email, boolean active, String nom, String prenom, String password, String photo) {
        super(email, active, nom, prenom, password, photo);
    }
}
