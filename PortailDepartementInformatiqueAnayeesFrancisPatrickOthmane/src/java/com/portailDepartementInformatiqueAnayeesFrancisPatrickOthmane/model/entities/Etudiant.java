/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author franc
 */
public class Etudiant {
    
    private int id;
    private String prenom;
    private String nom;
    private Date  ddn;
    private boolean active;
    private String role;
    private boolean formationCompletee;
    private String profil;
    private Utilisateur nomUtilisateur;
    private String motDePasse;
    private ArrayList<Cours> listeCours;
    
}
