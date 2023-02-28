/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities;

/**
 *
 * @author franc
 */
public class Professeur extends  Utilisateur {

    public Professeur() {
    }

    public Professeur(int id, String email, boolean active, String nom, String prenom, String password, String photo) {
        super(email, active, nom, prenom, password, photo);
    }   
    
}
