/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities;

/**
 *
 * @author anayeesFrancisPatrickOthmane
 */
public class Administrateur extends Utilisateur {
private GestionUtilisateur gestion ;

    public Administrateur() {
    }

    public Administrateur(int id, String prenom, String nom, String email, String profil, String role, boolean active, String nomUtilisateur, String motDePasse, String photo) {
        super(id, prenom, nom, email, profil, role, active, nomUtilisateur, motDePasse, photo);
        gestion = new GestionUtilisateur();
    }

    public Administrateur(int id, String prenom, String nom, String email, String profil, boolean active, String nomUtilisateur, String motDePasse) {
        super(id, prenom, nom, email, profil, active, nomUtilisateur, motDePasse);
        gestion = new GestionUtilisateur();
    }
    public void activer(int id ){
        
        
        for(int i=0;i<= gestion.getListeTousEtudiants().size();i++){
            if(gestion.getListeTousEtudiants().get(i).getId()==id){
                gestion.getListeTousEtudiants().get(i).setActive(true);
            }
        }
        
    }
     public void desactiver(int id ){
       
        for(int i=0;i<= gestion.getListeTousEtudiants().size();i++){
            if(gestion.getListeTousEtudiants().get(i).getId()==id){
                gestion.getListeTousEtudiants().get(i).setActive(false);
            }
        }
        
    }
    
}