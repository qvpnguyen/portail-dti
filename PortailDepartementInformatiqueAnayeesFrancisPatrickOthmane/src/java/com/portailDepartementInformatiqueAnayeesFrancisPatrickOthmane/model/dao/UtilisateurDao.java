///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
// */
//package com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.dao;
//
//import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Administrateur;
//import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Cours;
//import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Etudiant;
//import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.NoteDeCours;
//import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Professeur;
//import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Projet;
//import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Visiteur;
//import java.util.List;
//
///**
// *
// * @author anayeesFrancisPatrickOthmane
// */
//public interface UtilisateurDao {
//
//    //List<Etudiant> findAllEtudiants();
//    //List<Etudiant> findAllEtudiantsByRole();
//    //List<Etudiant> findAllEtudiantsByCours();
//    //List<Etudiant> findAllEtudiantsByDisponibilité();
//    //List<Etudiant> findAllEtudiantsByDisponibilitéAndByRole();
//    //List<Projet> findAllProjets();
//    Projet findProjetByName(String nom);
//
//    //List<NoteDeCours> findAllNotesDeCours();
//    NoteDeCours findNotesDeCoursParNom(String nom);
//
//    List<Visiteur> findAllVisiteurs();
//
//    Visiteur findVisiteurById(int id);
//
//    Visiteur findVisiteurByName(String nom);
//
//    Visiteur findVisiteurByEmail(String email);
//
//    // List<Professeur> findAllProfesseurs(); 
//    List<Professeur> findAllProfByDisponibilité();
//
//    List<Administrateur> findAllAdmins();
//    //List<Cours> findAllCours();
//
//    List<NoteDeCours> findNotesDeCours(Professeur prof);
//
//    // Etudiant findEtudiantById(int id);
//    //Etudiant findEtudiantByName(String nom);
//    //Etudiant findEtudiantByEmail(String email);
//    // Etudiant findEtudiantByRole(String prenom,String nom, String role);
//    //Professeur findProfById(int id);
//    //Professeur findProfByName(String nom);
//    //Professeur findProfByEmail(String email);
//    //boolean deleteEtudiant(int id);
//    //boolean deleteProf(int id);
//    boolean deleteVisiteur(int id);
//    // boolean createEtudiant(Etudiant etudiant);
//    //boolean createProf(Professeur  prof);
//
//    boolean createVisiteur(Visiteur visiteur);
//
//    // boolean updateEtudiant(Etudiant etudiant);
//    //boolean updateProf(Professeur prof);
//    boolean updateVisiteur(Visiteur visiteur);
//
//}
