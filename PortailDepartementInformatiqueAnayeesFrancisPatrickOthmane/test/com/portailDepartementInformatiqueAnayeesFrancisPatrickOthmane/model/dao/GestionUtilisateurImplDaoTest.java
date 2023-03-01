/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.dao;

import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Administrateur;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Cours;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Etudiant;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.NoteDeCours;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Professeur;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Projet;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Visiteur;
import java.util.List;

/**
 *
 * @author patri
 */
public class GestionUtilisateurImplDaoTest {
    
    public GestionUtilisateurImplDaoTest() {
    }



    /**
     * Test of findAllEtudiants method, of class GestionUtilisateurImplDao.
     */

    public void testFindAllEtudiants() {
        System.out.println("findAllEtudiants");
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        List<Etudiant> expResult = null;
        List<Etudiant> result = instance.findAllEtudiants();
    }

    /**
     * Test of findAllEtudiantsByRole method, of class GestionUtilisateurImplDao.
     */

    public void testFindAllEtudiantsByRole() {
        System.out.println("findAllEtudiantsByRole");
        String nom = "";
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        List<Etudiant> expResult = null;
        List<Etudiant> result = instance.findAllEtudiantsByRole(nom);
    }

    /**
     * Test of findAllEtudiantsByCours method, of class GestionUtilisateurImplDao.
     */
    
    public void testFindAllEtudiantsByCours() {
        System.out.println("findAllEtudiantsByCours");
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        List<Etudiant> expResult = null;
        List<Etudiant> result = instance.findAllEtudiantsByCours();
    }

    /**
     * Test of findAllEtudiantsByDisponibilité method, of class GestionUtilisateurImplDao.
     */
    
    public void testFindAllEtudiantsByDisponibilité() {
        System.out.println("findAllEtudiantsByDisponibilit\u00e9");
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        List<Etudiant> expResult = null;
        List<Etudiant> result = instance.findAllEtudiantsByDisponibilité();
    }

    /**
     * Test of findAllEtudiantsByDisponibilitéAndByRole method, of class GestionUtilisateurImplDao.
     */
    
    public void testFindAllEtudiantsByDisponibilitéAndByRole() {
        System.out.println("findAllEtudiantsByDisponibilit\u00e9AndByRole");
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        List<Etudiant> expResult = null;
        List<Etudiant> result = instance.findAllEtudiantsByDisponibilitéAndByRole();
    }

    /**
     * Test of findAllCours method, of class GestionUtilisateurImplDao.
     */
    
    public void testFindAllCours() {
        System.out.println("findAllCours");
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        List<Cours> expResult = null;
        List<Cours> result = instance.findAllCours();
    }

    /**
     * Test of findAllProjets method, of class GestionUtilisateurImplDao.
     */
    
    public void testFindAllProjets() {
        System.out.println("findAllProjets");
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        List<Projet> expResult = null;
        List<Projet> result = instance.findAllProjets();
    }

    /**
     * Test of findAllNotesDeCours method, of class GestionUtilisateurImplDao.
     */
    
    public void testFindAllNotesDeCours() {
        System.out.println("findAllNotesDeCours");
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        List<NoteDeCours> expResult = null;
        List<NoteDeCours> result = instance.findAllNotesDeCours();
    }

    /**
     * Test of findEtudiantByName method, of class GestionUtilisateurImplDao.
     */
    
    public void testFindEtudiantByName() {
        System.out.println("findEtudiantByName");
        String nom = "";
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        Etudiant expResult = null;
        Etudiant result = instance.findEtudiantByName(nom);
    }

    /**
     * Test of findEtudiantByEmail method, of class GestionUtilisateurImplDao.
     */
    
    public void testFindEtudiantByEmail() {
        System.out.println("findEtudiantByEmail");
        String email = "";
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        Etudiant expResult = null;
        Etudiant result = instance.findEtudiantByEmail(email);
    }

    /**
     * Test of findEtudiantById method, of class GestionUtilisateurImplDao.
     */
    
    public void testFindEtudiantById() {
        System.out.println("findEtudiantById");
        int id = 0;
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        Etudiant expResult = null;
        Etudiant result = instance.findEtudiantById(id);
    }

    /**
     * Test of findEtudiantByRole method, of class GestionUtilisateurImplDao.
     */
    
    public void testFindEtudiantByRole() {
        System.out.println("findEtudiantByRole");
        String prenom = "";
        String nom = "";
        String role = "";
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        Etudiant expResult = null;
        Etudiant result = instance.findEtudiantByRole(prenom, nom, role);
    }

    /**
     * Test of createEtudiant method, of class GestionUtilisateurImplDao.
     */
    
    public void testCreateEtudiant() {
        System.out.println("createEtudiant");
        Etudiant utilisateur = null;
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        boolean expResult = false;
        boolean result = instance.createEtudiant(utilisateur);
    }

    /**
     * Test of updateEtudiant method, of class GestionUtilisateurImplDao.
     */
    
    public void testUpdateEtudiant() {
        System.out.println("updateEtudiant");
        Etudiant utilisateur = null;
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        boolean expResult = false;
        boolean result = instance.updateEtudiant(utilisateur);
    }

    /**
     * Test of deleteEtudiant method, of class GestionUtilisateurImplDao.
     */
    
    public void testDeleteEtudiant() {
        System.out.println("deleteEtudiant");
        int id = 0;
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        boolean expResult = false;
        boolean result = instance.deleteEtudiant(id);
    }

    /**
     * Test of createProf method, of class GestionUtilisateurImplDao.
     */
    
    public void testCreateProf() {
        System.out.println("createProf");
        Professeur utilisateur = null;
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        boolean expResult = false;
        boolean result = instance.createProf(utilisateur);
    }

    /**
     * Test of updateProf method, of class GestionUtilisateurImplDao.
     */
    
    public void testUpdateProf() {
        System.out.println("updateProf");
        Professeur utilisateur = null;
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        boolean expResult = false;
        boolean result = instance.updateProf(utilisateur);
    }

    /**
     * Test of deleteProf method, of class GestionUtilisateurImplDao.
     */
    
    public void testDeleteProf() {
        System.out.println("deleteProf");
        int id = 0;
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        boolean expResult = false;
        boolean result = instance.deleteProf(id);
    }

    /**
     * Test of createVisiteur method, of class GestionUtilisateurImplDao.
     */
    
    public void testCreateVisiteur() {
        System.out.println("createVisiteur");
        Visiteur utilisateur = null;
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        boolean expResult = false;
        boolean result = instance.createVisiteur(utilisateur);
    }

    /**
     * Test of updateVisiteur method, of class GestionUtilisateurImplDao.
     */
    
    public void testUpdateVisiteur() {
        System.out.println("updateVisiteur");
        Visiteur utilisateur = null;
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        boolean expResult = false;
        boolean result = instance.updateVisiteur(utilisateur);
    }

    /**
     * Test of deleteVisiteur method, of class GestionUtilisateurImplDao.
     */
    
    public void testDeleteVisiteur() {
        System.out.println("deleteVisiteur");
        int id = 0;
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        boolean expResult = false;
        boolean result = instance.deleteVisiteur(id);
    }

    /**
     * Test of findAllProfesseurs method, of class GestionUtilisateurImplDao.
     */
    
    public void testFindAllProfesseurs() {
        System.out.println("findAllProfesseurs");
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        List<Professeur> expResult = null;
        List<Professeur> result = instance.findAllProfesseurs();
    }

    /**
     * Test of findProfById method, of class GestionUtilisateurImplDao.
     */
    
    public void testFindProfById() {
        System.out.println("findProfById");
        int id = 0;
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        Professeur expResult = null;
        Professeur result = instance.findProfById(id);
    }

    /**
     * Test of findProfByName method, of class GestionUtilisateurImplDao.
     */
    
    public void testFindProfByName() {
        System.out.println("findProfByName");
        String nom = "";
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        Professeur expResult = null;
        Professeur result = instance.findProfByName(nom);
    }

    /**
     * Test of findProfByEmail method, of class GestionUtilisateurImplDao.
     */
    
    public void testFindProfByEmail() {
        System.out.println("findProfByEmail");
        String email = "";
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        Professeur expResult = null;
        Professeur result = instance.findProfByEmail(email);
    }

    /**
     * Test of findProjetByName method, of class GestionUtilisateurImplDao.
     */
    
    public void testFindProjetByName() {
        System.out.println("findProjetByName");
        String nom = "";
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        Projet expResult = null;
        Projet result = instance.findProjetByName(nom);
    }

    /**
     * Test of findNotesDeCoursById method, of class GestionUtilisateurImplDao.
     */
    
    public void testFindNotesDeCoursById() {
        System.out.println("findNotesDeCoursById");
        int id = 0;
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        NoteDeCours expResult = null;
        NoteDeCours result = instance.findNotesDeCoursById(id);
    }

    /**
     * Test of findNotesDeCoursByName method, of class GestionUtilisateurImplDao.
     */
    
    public void testFindNotesDeCoursByName() {
        System.out.println("findNotesDeCoursByName");
        String nom = "";
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        NoteDeCours expResult = null;
        NoteDeCours result = instance.findNotesDeCoursByName(nom);
    }

    /**
     * Test of findAllVisiteurs method, of class GestionUtilisateurImplDao.
     */
    
    public void testFindAllVisiteurs() {
        System.out.println("findAllVisiteurs");
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        List<Visiteur> expResult = null;
        List<Visiteur> result = instance.findAllVisiteurs();
    }

    /**
     * Test of findVisiteurById method, of class GestionUtilisateurImplDao.
     */
    
    public void testFindVisiteurById() {
        System.out.println("findVisiteurById");
        int id = 0;
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        Visiteur expResult = null;
        Visiteur result = instance.findVisiteurById(id);
    }

    /**
     * Test of findVisiteurByName method, of class GestionUtilisateurImplDao.
     */
    
    public void testFindVisiteurByName() {
        System.out.println("findVisiteurByName");
        String nom = "";
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        Visiteur expResult = null;
        Visiteur result = instance.findVisiteurByName(nom);
    }

    /**
     * Test of findVisiteurByEmail method, of class GestionUtilisateurImplDao.
     */
    
    public void testFindVisiteurByEmail() {
        System.out.println("findVisiteurByEmail");
        String email = "";
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        Visiteur expResult = null;
        Visiteur result = instance.findVisiteurByEmail(email);
    }

    /**
     * Test of findAllAdmins method, of class GestionUtilisateurImplDao.
     */
    
    public void testFindAllAdmins() {
        System.out.println("findAllAdmins");
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        List<Administrateur> expResult = null;
        List<Administrateur> result = instance.findAllAdmins();
    }

    /**
     * Test of findAllCoursByNomProfesseur method, of class GestionUtilisateurImplDao.
     */
    
    public void testFindAllCoursByNomProfesseur() {
        System.out.println("findAllCoursByNomProfesseur");
        String nomProfesseur = "";
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        List<Cours> expResult = null;
        List<Cours> result = instance.findAllCoursByNomProfesseur(nomProfesseur);
    }

    /**
     * Test of findNotesDeCoursByCoursID method, of class GestionUtilisateurImplDao.
     */
    
    public void testFindNotesDeCoursByCoursID() {
        System.out.println("findNotesDeCoursByCoursID");
        int coursID = 0;
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        List<NoteDeCours> expResult = null;
        List<NoteDeCours> result = instance.findNotesDeCoursByCoursID(coursID);
    }

    /**
     * Test of findNotesDeCoursByAuthor method, of class GestionUtilisateurImplDao.
     */
    
    public void testFindNotesDeCoursByAuthor() {
        System.out.println("findNotesDeCoursByAuthor");
        String professeurAuteur = "";
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        List<NoteDeCours> expResult = null;
        List<NoteDeCours> result = instance.findNotesDeCoursByAuthor(professeurAuteur);
    }
    
}
