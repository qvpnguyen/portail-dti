/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.dao;

import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Administrateur;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Cours;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Etudiant;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.NoteDeCours;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Professeur;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Projet;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Utilisateur;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Visiteur;
import java.util.List;

/**
 *
 * @author anayeesFrancisPatrickOthmane
 */
public interface GestionUtilisateurDao {
    
    List<Visiteur> findAllVisiteurs();

    Visiteur findVisiteurById(int id);

    Visiteur findVisiteurByName(String nom);

    Visiteur findVisiteurByEmail(String email);
    
    boolean createVisiteur(Visiteur visiteur);   

    boolean updateVisiteur(Visiteur visiteur);

    boolean deleteVisiteur(int id);
    
    List<Etudiant> findAllEtudiants();

    List<Etudiant> findAllEtudiantsByRole(String nom);

    List<Etudiant> findAllEtudiantsByCours();

    List<Etudiant> findAllEtudiantsByDisponibilité();

    List<Etudiant> findAllEtudiantsByDisponibilitéAndByRole();
    
    Etudiant findEtudiantById(int id);

    Etudiant findEtudiantByName(String nom);

    Etudiant findEtudiantByEmail(String email);

    Etudiant findEtudiantByRole(String prenom, String nom, String role);
    
    boolean createEtudiant(Etudiant etudiant);
    
    boolean updateEtudiant(Etudiant etudiant);
    
    boolean deleteEtudiant(int id);
    
    List<Professeur> findAllProfesseurs();
    
    Professeur findProfById(int id);

    Professeur findProfByName(String nom);

    Professeur findProfByEmail(String email);
    
    boolean createProf(Professeur prof);
    
    boolean updateProf(Professeur prof);
    
    boolean deleteProf(int id);

    List<Administrateur> findAllAdmins();

    List<Projet> findAllProjets();

    Projet findProjetByName(String nom);
    
    List<Cours> findAllCours();
    
    List<Cours> findAllCoursByNomProfesseur(String nomProfesseur);

    List<NoteDeCours> findAllNotesDeCours();

    NoteDeCours findNotesDeCoursById(int id);
    
    NoteDeCours findNotesDeCoursByName(String nom);
    
    List<NoteDeCours> findNotesDeCoursByCoursID(int coursID);

    List<NoteDeCours> findNotesDeCoursByAuthor(String professeurAuteur);

}
