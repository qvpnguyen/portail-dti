/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities;

import java.sql.Date;

/**
 *
 * @author anayeesFrancisPatrickOthmane
 */
public class Etudiant extends Utilisateur {

    private Date ddn;
    //private boolean active;
    //private String role;
    private boolean formationCompletee;
    private int coursId;
    private boolean dispoTutorat;

    public Etudiant() {
    }

    public Etudiant(int id) {
        this.id = id;
    }

    public Etudiant(Date ddn, boolean formationCompletee, int coursId, boolean dispoTutorat, int id, String prenom, String nom, String email, String profil, String role, boolean active, String nomUtilisateur, String motDePasse, String photo) {
        super(id, prenom, nom, email, profil, role, active, nomUtilisateur, motDePasse, photo);
        this.ddn = ddn;
        this.formationCompletee = formationCompletee;
        this.coursId = coursId;
        this.dispoTutorat = dispoTutorat;
    }

    public Etudiant(int id, String prenom, String nom, String email, String profil, boolean active, String nomUtilisateur, String motDePasse, Date ddn, String role, boolean formationCompletee, int coursId, boolean dispoTutorat) {
        super(id, prenom, nom, email, profil, active, nomUtilisateur, motDePasse);
        this.ddn = ddn;
        this.role = role;
        this.formationCompletee = formationCompletee;
        this.coursId = coursId;
        this.dispoTutorat = dispoTutorat;
    }

    public boolean isDispoTutorat() {
        return dispoTutorat;
    }

    public void setDispoTutorat(boolean dispoTutorat) {
        this.dispoTutorat = dispoTutorat;
    }

    public Date getDdn() {
        return ddn;
    }

    public void setDdn(Date ddn) {
        this.ddn = ddn;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isFormationCompletee() {
        return formationCompletee;
    }

    public void setFormationCompletee(boolean formationCompletee) {
        this.formationCompletee = formationCompletee;
    }

    public int getCoursId() {
        return coursId;
    }

    public void setCoursId(int coursId) {
        this.coursId = coursId;
    }

}
