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
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Visiteur;
import java.text.ParseException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author othma
 */
public class GestionUtilisateurImplDaoTest {

    public static void main(String[] args) {
        testFindAllEtudiants();
        testFindAllCours();
        testFindAllProf();
        testFindAllProjets();
        testFindAllNotesDeCours();
        testFindAllVisiteurs();
        testFindAllAdministrateurs();
        testFindNotesDeCoursById();
        //testProfById();
        //testFindEtudiantByRole();
        //testFindEtudiantByName();
        //testFindEtudiantById();
        //testCreateEtudiant();
        //testDeleteEtudiant();
        //testFindAllEtudiants();
        //testUpdateEtudiant();
    }

    public static void testFindAllEtudiants() {
        System.out.println("findAllEtudiants");
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        List<Etudiant> result = instance.findAllEtudiants();
        System.out.println(result.get(0).afficherTitreDesColonnes());
        for (Etudiant utilisateur : result) {
            System.out.println(utilisateur.toString());
        }
    }

    public static void testFindAllProf() {
        System.out.println("findAllProfesseurs");
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        List<Professeur> result = instance.findAllProfesseurs();
        System.out.println(result.get(0).afficherTitreDesColonnes());
        for (Professeur prof : result) {
            System.out.println(prof.toString());
        }
    }

    public static void testFindAllAdministrateurs() {
        System.out.println("findAllAdmins");
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        List<Administrateur> result = instance.findAllAdmins();
        System.out.println(result.get(0).afficherTitreDesColonnes());
        for (Administrateur utilisateur : result) {
            System.out.println(utilisateur.toString());
        }
    }

    public static void testFindAllCours() {
        System.out.println("findAllCours");
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        List<Cours> result = instance.findAllCours();
        System.out.println(result.get(0).afficherTitreDesColonnes());
        for (Cours cours : result) {
            System.out.println(cours.toString());
        }
    }

    public static void testFindAllProjets() {
        System.out.println("findAllProjets");
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        List<Projet> result = instance.findAllProjets();
        System.out.println(result.get(0).afficherTitreDesColonnes());
        for (Projet projet : result) {
            System.out.println(projet.toString());
        }
    }

    public static void testFindAllNotesDeCours() {
        System.out.println("findAllNotes");
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        List<NoteDeCours> result = instance.findAllNotesDeCours();
        System.out.println(result.get(0).afficherTitreDesColonnes());
        for (NoteDeCours notes : result) {
            System.out.println(notes.toString());
        }
    }

    public static void testFindAllVisiteurs() {
        System.out.println("findAllVisiteurs");
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        List<Visiteur> result = instance.findAllVisiteurs();
        System.out.println(result.get(0).afficherTitreDesColonnes());
        for (Visiteur visiteur : result) {
            System.out.println(visiteur.toString());
        }
    }

    public static void testFindNotesDeCoursById() {
        System.out.println("findNotesDeCoursById");
        int id = 0;
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        System.out.println("Entrez l'id du note de cours : ");
        Scanner lectureClavier = new Scanner(System.in);
        id = lectureClavier.nextInt();
        NoteDeCours result = instance.findNotesDeCoursById(id);
        System.out.println(result.afficherTitreDesColonnes());
        System.out.println(result.toString());

    }

    public static void testFindEtudiantByName() {
        System.out.println("findByName");
        String nom = "";
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        System.out.println("Entrez le nom de l'utilisateur : ");
        Scanner lectureClavier = new Scanner(System.in);
        nom = lectureClavier.next();
        Etudiant result = instance.findEtudiantByName(nom);
        System.out.println(result.toString());

    }

    public static void testFindEtudiantById() {
        System.out.println("findById");
        int id = 0;
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        System.out.println("Entrez l'id de l'utilisateur : ");
        Scanner lectureClavier = new Scanner(System.in);
        id = lectureClavier.nextInt();
        Etudiant result = instance.findEtudiantById(id);
        System.out.println(result.toString());

    }

    public static void testFindEtudiantByRole() {
        System.out.println("findByRole");
        Scanner lectureClavier = new Scanner(System.in);
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        System.out.println("Entrez le prénom de l'étudiant: ");
        String prenom = lectureClavier.nextLine();
        System.out.println("Entrez le nom de l'etudiant: ");
        String nom = lectureClavier.nextLine();
        System.out.println("Entrez le role de l'etudiant : ");
        String role = lectureClavier.next();
        Etudiant result = instance.findEtudiantByRole(prenom, nom, role);
        System.out.println(result.toString());

    }

    public static void testCreateEtudiant() {
        System.out.println("create");
        Etudiant utilisateur = null;
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        Scanner lectureClavier = new Scanner(System.in);
        System.out.println("Entrez l'ID ");
        int id = lectureClavier.nextInt();
        System.out.println("Entrez email ");
        String email = lectureClavier.next();
        System.out.println("L'utilisateur est-il actif(oui/non)?");
        String reponse = lectureClavier.next();
        boolean active = reponse.equals("oui") ? true : false;

        System.out.println("Entrez le nom ");
        String nom = lectureClavier.next();
        System.out.println("Entrez le prenom ");
        String prenom = lectureClavier.next();
        System.out.println("Entrez le nom de l'utilisateur");
        String nomUtilisateur = lectureClavier.next();
        System.out.println("Entrez le mot de passe");
        String motDePasse = lectureClavier.next();
        System.out.println("Entrez le profil");
        String profil = lectureClavier.next();
        System.out.println("Entrez la date de naissance (au format jj-mm-aaaa)");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date ddn = null;
        try {
            java.util.Date date = sdf.parse(lectureClavier.next());
            ddn = new java.sql.Date(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Entrez le role");
        String role = lectureClavier.next();
        System.out.println("L'utilisateur est-il actif(oui/non)?");
        String reponse1 = lectureClavier.next();
        boolean formation = reponse1.equals("oui") ? true : false;
        System.out.println("Entrez l'ID du cours ");
        int coursID = lectureClavier.nextInt();
        System.out.println("L'utilisateur est-il disponible(oui/non)?");
        String reponse3 = lectureClavier.next();
        boolean dispo = reponse3.equals("oui") ? true : false;

        utilisateur = new Etudiant(id, prenom, nom, email, profil, active, nomUtilisateur, motDePasse, ddn, role, formation, coursID, dispo);

        boolean result = instance.createEtudiant(utilisateur);
        if (result) {
            System.out.println("insertion reussite");
        } else {
            System.out.println("insertion echec ");
        }

    }
    
    public static void testUpdateEtudiant() {
        System.out.println("updateEtudiant");
        Etudiant etudiant = null;
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        System.out.println("Entrez l'id de l'étudiant.e à mettre à jour: ");
        Scanner lectureClavier = new Scanner(System.in);
        int id = lectureClavier.nextInt();
        etudiant = instance.findEtudiantById(id);
        System.out.println("Entrez le prénom de l'étudiant.e: ");
        String prenom = lectureClavier.next();
        etudiant.setPrenom(prenom);
        System.out.println("Entrez le nom de l'étudiant.e: ");
        String nom = lectureClavier.next();
        etudiant.setNom(nom);
        System.out.println("Entrez le courriel de l'étudiant.e: ");
        String email = lectureClavier.next();
        etudiant.setEmail(email);
        System.out.println("Entrez la date de naissance (au format jj-mm-aaaa)");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date ddn = null;
        try {
            java.util.Date date = sdf.parse(lectureClavier.next());
            ddn = new java.sql.Date(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        etudiant.setDdn(ddn);
        System.out.println("L'étudiant est-il actif (oui/non)? ");
        String reponse = lectureClavier.next();
        boolean active = reponse.equals("oui") ? true : false;
        etudiant.setActive(active);
        System.out.println("Entrez le rôle de l'étudiant.e (Étudiant/Tuteur/Tutoré):");
        String role = lectureClavier.next();
        etudiant.setRole(role);
        System.out.println("L'étudiant a-t'il complété sa formation (oui/non)? ");
        String reponseFormation = lectureClavier.next();
        boolean formationCompletee = reponseFormation.equals("oui") ? true : false;
        etudiant.setFormationCompletee(formationCompletee);
        System.out.println("Entrez le profil de l'étudiant.e (Programmation/Réseautique): ");
        String profil = lectureClavier.next();
        etudiant.setProfil(profil);
        System.out.println("Entrez le nom d'utilisateur: ");
        String nomUtilisateur = lectureClavier.next();
        etudiant.setNomUtilisateur(nomUtilisateur);
        System.out.println("Entrez le mot de passe: ");
        String motDePasse = lectureClavier.next();
        etudiant.setMotDePasse(motDePasse);
        System.out.println("Entrez l'ID du cours ");
        int coursID = lectureClavier.nextInt();
        etudiant.setCoursId(coursID);
        System.out.println("L'utilisateur est-il disponible(oui/non)?");
        String reponse3 = lectureClavier.next();
        boolean dispo = reponse3.equals("oui") ? true : false;
        etudiant.setDispoTutorat(dispo);
        boolean result = instance.updateEtudiant(etudiant);
        if (result) {
            System.out.println(String.format("L'étudiant.e %s %s a été mis à jour dans la base de données", etudiant.getPrenom(), etudiant.getNom()));
        } else {
            System.out.println("L'étudiant.e dont l'id est " + id + " n'existe pas dans la base de données");
        }
    }

    public static void testDeleteEtudiant() {
        System.out.println("deleteEtudiant");
        int id = 0;
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        System.out.println("Entrez l'id de l'utilisateur : ");
        Scanner lectureClavier = new Scanner(System.in);
        id = lectureClavier.nextInt();
        boolean result = instance.deleteEtudiant(id);
        if (result) {
            System.out.println("l'utilisateur dont l'id est " + id + " est supprimé de la base des données");
        } else {
            System.out.println("l'utilisateur dont l'id est " + id + " n'existe pas dans la base des données");
        }
    }

    public static void testProfById() {
        System.out.println("findProfesseurById");
        int id = 0;
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        System.out.println("Entrez l'id du professeur : ");
        Scanner lectureClavier = new Scanner(System.in);
        id = lectureClavier.nextInt();
        Professeur result = instance.findProfById(id);
        System.out.println(result.toString());

    }

}
