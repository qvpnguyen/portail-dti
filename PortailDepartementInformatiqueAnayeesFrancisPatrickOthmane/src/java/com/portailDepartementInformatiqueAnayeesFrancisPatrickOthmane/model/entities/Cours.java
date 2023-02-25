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
public class Cours {
    private int id;
    private String nom;
    private int credits;
    private List<Etudiant> listeEtudiants;
    private Professeur professeur;
    private int groupe;
    
}
