/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities;

import java.util.List;

/**
 *
 * @author franc
 */
public class Projet {
    
    private int id;
    private String nom;
    private int annee;
    private Cours cours;
    private List<Etudiant> listeEquipeProjet;
    private String description;
    private String video;
    private String lienGitlab;
    private Professeur professeurEnCharge;
    private Notes note;  // manque un s dans le dia. de classe
    
}
