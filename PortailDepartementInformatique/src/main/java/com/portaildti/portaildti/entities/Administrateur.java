package com.portaildti.portaildti.entities;

import javax.persistence.Entity;
import java.time.LocalDate;

/**
 *
 * @author anayeesFrancisPatrickOthmane
 */
@Entity
public class Administrateur extends Utilisateur {
    //private GestionUtilisateur gestion ;

    public Administrateur() {
    }

//    public Administrateur(GestionUtilisateur gestion) {
//       // this.gestion = new GestionUtilisateur();
//    }

    public Administrateur(Integer id, String prenom, String nom, String email, String role, Boolean active, String motDePasse, LocalDate ddn, String photo) {
        super(id, prenom, nom, email, role, active, motDePasse, ddn, photo);
        //this.gestion = new GestionUtilisateur();
    }

    public Administrateur(String prenom, String nom) {
        super(prenom, nom);
        //this.gestion = new GestionUtilisateur();
    }

    public Administrateur(Integer id) {
        super(id);
        //this.gestion = new GestionUtilisateur();
    }


//    public Administrateur(int id, String prenom, String nom, String email, String role, boolean active, String nomUtilisateur, String motDePasse, Date ddn) {
//        super(id, prenom, nom, email, role, active, nomUtilisateur, motDePasse, ddn);
//
//    public Administrateur(int id, String prenom, String nom, String email, String profil, String role, boolean active, String nomUtilisateur, String motDePasse, String photo) {
//        super(id, prenom, nom, email, profil, role, active, nomUtilisateur, motDePasse, photo);
//        gestion = new GestionUtilisateur();
//    }
//
//    public Administrateur(int id, String prenom, String nom, String email, String profil, boolean active, String nomUtilisateur, String motDePasse) {
//        super(id, prenom, nom, email, profil, active, nomUtilisateur, motDePasse);
//
//        gestion = new GestionUtilisateur();
//    }

//    public void activer(int id ){
//
//
//        for(int i=0;i<= gestion.getListeTousEtudiants().size();i++){
//            if(gestion.getListeTousEtudiants().get(i).getId()==id){
//                gestion.getListeTousEtudiants().get(i).setActive(true);
//            }
//        }
//
//    }
//    public void desactiver(int id ){
//
//        for(int i=0;i<= gestion.getListeTousEtudiants().size();i++){
//            if(gestion.getListeTousEtudiants().get(i).getId()==id){
//                gestion.getListeTousEtudiants().get(i).setActive(false);
//            }
//        }
//
//    }

}
