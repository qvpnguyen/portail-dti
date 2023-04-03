/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities;

import java.util.Date;


/**
 *
 * @author anayeesFrancisPatrickOthmane
 */
public class Etudiant extends Utilisateur {
    
   
//    private Date ddn;
    //private boolean active;
//    private String role;
    private boolean formationCompletee;
    private Cours cours; 
    private boolean dispoTutorat;

    public Etudiant() {
    }

    public Etudiant(int id,String prenom, String nom, String email, String profil, String role, boolean active, String nomUtilisateur, String motDePasse, Date ddn, boolean formationCompletee, Cours cours, boolean dispoTutorat) {
        super(id, prenom, nom, email, role, profil, active, nomUtilisateur, motDePasse, ddn);
        this.formationCompletee = formationCompletee;
        this.cours = cours;
        this.dispoTutorat = dispoTutorat;
    }
    
    public Etudiant(String prenom, String nom) {
        super(prenom, nom);
    }
    
//    public Etudiant(int id) {
//        super(id);
//    }

//    public Date getDdn() {
//        return ddn;
//    }
//
//    public void setDdn(Date ddn) {
//        this.ddn = ddn;
//    }

//    public String getRole() {
//        return role;
//    }
//
//    public void setRole(String role) {
//        this.role = role;
//    }

    public boolean isFormationCompletee() {
        return formationCompletee;
    }

    public void setFormationCompletee(boolean formationCompletee) {
        this.formationCompletee = formationCompletee;
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }
    
    public boolean isDispoTutorat() {
        return dispoTutorat;
    }

    public void setDispoTutorat(boolean dispoTutorat) {
        this.dispoTutorat = dispoTutorat;
    }
    
    @Override
       public String toString() {
         String message = "";
       message = String.format("%s %s",super.prenom, this.nom); 
       return message;
    }


}
    

