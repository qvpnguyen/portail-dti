package com.portaildti.portaildti.entities;

import java.util.ArrayList;
import java.util.List;

public class GestionUtilisateurs extends Utilisateur {
    List<Visiteur> visiteurs;
    List<Etudiant> etudiants;
    List<Professeur> professeurs;
    List<Administrateur> admins;
    List gestion = null;

    public GestionUtilisateurs() {
        gestion = new ArrayList<>();
    }

    public List<Visiteur> getVisiteurs() {
        return visiteurs;
    }

    public void setVisiteurs(List<Visiteur> visiteurs) {
        this.visiteurs = visiteurs;
        this.gestion.addAll(visiteurs);
    }

    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
        this.gestion.addAll(etudiants);
    }

    public List<Professeur> getProfesseurs() {
        return professeurs;
    }

    public void setProfesseurs(List<Professeur> professeurs) {
        this.professeurs = professeurs;
        this.gestion.addAll(professeurs);
    }

    public List<Administrateur> getAdmins() {
        return admins;
    }

    public void setAdmins(List<Administrateur> admins) {
        this.admins = admins;
        this.gestion.addAll(admins);
    }

    @Override
    public String toString() {
        return "GestionUtilisateurs{" +
                "id=" + super.id +
                ", prenom='" + super.prenom + '\'' +
                ", nom='" + super.nom + '\'' +
                ", active='" + super.active + '\'' +
                '}';
    }
}
