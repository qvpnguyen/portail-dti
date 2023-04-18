/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.dao;

import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Administrateur;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Cours;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Etudiant;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.NoteDeCours;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Notes;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Professeur;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Projet;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Visiteur;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Anayees
 */
public class GestionUtilisateurImplDaoTest {
    
    public GestionUtilisateurImplDaoTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of findAllEtudiants method, of class GestionUtilisateurImplDao.
     */
    @Test
    public void testFindAllEtudiants() {
        System.out.println("findAllEtudiants");
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        List<Etudiant> expResult = null;
        List<Etudiant> result = instance.findAllEtudiants();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAllEtudiantsByRole method, of class GestionUtilisateurImplDao.
     */
    @Test
    public void testFindAllEtudiantsByRole() {
        System.out.println("findAllEtudiantsByRole");
        String nom = "";
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        List<Etudiant> expResult = null;
        List<Etudiant> result = instance.findAllEtudiantsByRole(nom);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAllEtudiantsByCours method, of class GestionUtilisateurImplDao.
     */
    @Test
    public void testFindAllEtudiantsByCours() {
        System.out.println("findAllEtudiantsByCours");
        int coursID = 0;
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        List<Etudiant> expResult = null;
        List<Etudiant> result = instance.findAllEtudiantsByCours(coursID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAllEtudiantsByDisponibilité method, of class GestionUtilisateurImplDao.
     */
    @Test
    public void testFindAllEtudiantsByDisponibilité() {
        System.out.println("findAllEtudiantsByDisponibilit\u00e9");
        boolean dispo = false;
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        List<Etudiant> expResult = null;
        List<Etudiant> result = instance.findAllEtudiantsByDisponibilité(dispo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAllEtudiantsByDisponibilitéAndByRole method, of class GestionUtilisateurImplDao.
     */
    @Test
    public void testFindAllEtudiantsByDisponibilitéAndByRole() {
        System.out.println("findAllEtudiantsByDisponibilit\u00e9AndByRole");
        String role = "";
        boolean dispo = false;
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        List<Etudiant> expResult = null;
        List<Etudiant> result = instance.findAllEtudiantsByDisponibilitéAndByRole(role, dispo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAllCours method, of class GestionUtilisateurImplDao.
     */
    @Test
    public void testFindAllCours() {
        System.out.println("findAllCours");
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        List<Cours> expResult = null;
        List<Cours> result = instance.findAllCours();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAllProjets method, of class GestionUtilisateurImplDao.
     */
    @Test
    public void testFindAllProjets() {
        System.out.println("findAllProjets");
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        List<Projet> expResult = null;
        List<Projet> result = instance.findAllProjets();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAllNotesDeCours method, of class GestionUtilisateurImplDao.
     */
    @Test
    public void testFindAllNotesDeCours() {
        System.out.println("findAllNotesDeCours");
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        List<NoteDeCours> expResult = null;
        List<NoteDeCours> result = instance.findAllNotesDeCours();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findEtudiantByName method, of class GestionUtilisateurImplDao.
     */
    @Test
    public void testFindEtudiantByName() {
        System.out.println("findEtudiantByName");
        String nom = "";
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        Etudiant expResult = null;
        Etudiant result = instance.findEtudiantByName(nom);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findEtudiantByPrenomNom method, of class GestionUtilisateurImplDao.
     */
    @Test
    public void testFindEtudiantByPrenomNom() {
        System.out.println("findEtudiantByPrenomNom");
        String prenom = "";
        String nom = "";
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        Etudiant expResult = null;
        Etudiant result = instance.findEtudiantByPrenomNom(prenom, nom);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findEtudiantByEmail method, of class GestionUtilisateurImplDao.
     */
    @Test
    public void testFindEtudiantByEmail() {
        System.out.println("findEtudiantByEmail");
        String email = "";
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        Etudiant expResult = null;
        Etudiant result = instance.findEtudiantByEmail(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findEtudiantById method, of class GestionUtilisateurImplDao.
     */
    @Test
    public void testFindEtudiantById() {
        System.out.println("findEtudiantById");
        int id = 0;
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        Etudiant expResult = null;
        Etudiant result = instance.findEtudiantById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findEtudiantByRole method, of class GestionUtilisateurImplDao.
     */
    @Test
    public void testFindEtudiantByRole() {
        System.out.println("findEtudiantByRole");
        String prenom = "";
        String nom = "";
        String role = "";
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        Etudiant expResult = null;
        Etudiant result = instance.findEtudiantByRole(prenom, nom, role);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createEtudiant method, of class GestionUtilisateurImplDao.
     */
    @Test
    public void testCreateEtudiant() {
        System.out.println("createEtudiant");
        Etudiant utilisateur = null;
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        boolean expResult = false;
        boolean result = instance.createEtudiant(utilisateur);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateEtudiant method, of class GestionUtilisateurImplDao.
     */
    @Test
    public void testUpdateEtudiant() {
        System.out.println("updateEtudiant");
        Etudiant utilisateur = null;
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        boolean expResult = false;
        boolean result = instance.updateEtudiant(utilisateur);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteEtudiant method, of class GestionUtilisateurImplDao.
     */
    @Test
    public void testDeleteEtudiant() {
        System.out.println("deleteEtudiant");
        int id = 0;
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        boolean expResult = false;
        boolean result = instance.deleteEtudiant(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAllProfesseurs method, of class GestionUtilisateurImplDao.
     */
    @Test
    public void testFindAllProfesseurs() {
        System.out.println("findAllProfesseurs");
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        List<Professeur> expResult = null;
        List<Professeur> result = instance.findAllProfesseurs();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findProfById method, of class GestionUtilisateurImplDao.
     */
    @Test
    public void testFindProfById() {
        System.out.println("findProfById");
        int id = 0;
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        Professeur expResult = null;
        Professeur result = instance.findProfById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findProfByName method, of class GestionUtilisateurImplDao.
     */
    @Test
    public void testFindProfByName() {
        System.out.println("findProfByName");
        String nom = "";
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        Professeur expResult = null;
        Professeur result = instance.findProfByName(nom);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findProfByEmail method, of class GestionUtilisateurImplDao.
     */
    @Test
    public void testFindProfByEmail() {
        System.out.println("findProfByEmail");
        String email = "";
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        Professeur expResult = null;
        Professeur result = instance.findProfByEmail(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findProfByProjectName method, of class GestionUtilisateurImplDao.
     */
    @Test
    public void testFindProfByProjectName() {
        System.out.println("findProfByProjectName");
        String nomProjet = "";
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        Professeur expResult = null;
        Professeur result = instance.findProfByProjectName(nomProjet);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createProf method, of class GestionUtilisateurImplDao.
     */
    @Test
    public void testCreateProf() {
        System.out.println("createProf");
        Professeur utilisateur = null;
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        boolean expResult = false;
        boolean result = instance.createProf(utilisateur);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateProf method, of class GestionUtilisateurImplDao.
     */
    @Test
    public void testUpdateProf() {
        System.out.println("updateProf");
        Professeur utilisateur = null;
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        boolean expResult = false;
        boolean result = instance.updateProf(utilisateur);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteProf method, of class GestionUtilisateurImplDao.
     */
    @Test
    public void testDeleteProf() {
        System.out.println("deleteProf");
        int id = 0;
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        boolean expResult = false;
        boolean result = instance.deleteProf(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findProjetByName method, of class GestionUtilisateurImplDao.
     */
    @Test
    public void testFindProjetByName() {
        System.out.println("findProjetByName");
        String nom = "";
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        Projet expResult = null;
        Projet result = instance.findProjetByName(nom);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createProjet method, of class GestionUtilisateurImplDao.
     */
    @Test
    public void testCreateProjet() {
        System.out.println("createProjet");
        Projet projet = null;
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        boolean expResult = false;
        boolean result = instance.createProjet(projet);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAllVisiteurs method, of class GestionUtilisateurImplDao.
     */
    @Test
    public void testFindAllVisiteurs() {
        System.out.println("findAllVisiteurs");
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        List<Visiteur> expResult = null;
        List<Visiteur> result = instance.findAllVisiteurs();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findVisiteurById method, of class GestionUtilisateurImplDao.
     */
    @Test
    public void testFindVisiteurById() {
        System.out.println("findVisiteurById");
        int id = 0;
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        Visiteur expResult = null;
        Visiteur result = instance.findVisiteurById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findVisiteurByName method, of class GestionUtilisateurImplDao.
     */
    @Test
    public void testFindVisiteurByName() {
        System.out.println("findVisiteurByName");
        String nom = "";
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        Visiteur expResult = null;
        Visiteur result = instance.findVisiteurByName(nom);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findVisiteurByEmail method, of class GestionUtilisateurImplDao.
     */
    @Test
    public void testFindVisiteurByEmail() {
        System.out.println("findVisiteurByEmail");
        String email = "";
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        Visiteur expResult = null;
        Visiteur result = instance.findVisiteurByEmail(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createVisiteur method, of class GestionUtilisateurImplDao.
     */
    @Test
    public void testCreateVisiteur() {
        System.out.println("createVisiteur");
        Visiteur utilisateur = null;
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        boolean expResult = false;
        boolean result = instance.createVisiteur(utilisateur);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateVisiteur method, of class GestionUtilisateurImplDao.
     */
    @Test
    public void testUpdateVisiteur() {
        System.out.println("updateVisiteur");
        Visiteur utilisateur = null;
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        boolean expResult = false;
        boolean result = instance.updateVisiteur(utilisateur);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteVisiteur method, of class GestionUtilisateurImplDao.
     */
    @Test
    public void testDeleteVisiteur() {
        System.out.println("deleteVisiteur");
        int id = 0;
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        boolean expResult = false;
        boolean result = instance.deleteVisiteur(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findNotesDeCoursById method, of class GestionUtilisateurImplDao.
     */
    @Test
    public void testFindNotesDeCoursById() {
        System.out.println("findNotesDeCoursById");
        int id = 0;
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        NoteDeCours expResult = null;
        NoteDeCours result = instance.findNotesDeCoursById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findNotesDeCoursByName method, of class GestionUtilisateurImplDao.
     */
    @Test
    public void testFindNotesDeCoursByName() {
        System.out.println("findNotesDeCoursByName");
        String nom = "";
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        NoteDeCours expResult = null;
        NoteDeCours result = instance.findNotesDeCoursByName(nom);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findCoursById method, of class GestionUtilisateurImplDao.
     */
    @Test
    public void testFindCoursById() {
        System.out.println("findCoursById");
        int idCours = 0;
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        Cours expResult = null;
        Cours result = instance.findCoursById(idCours);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAllCoursByNomProfesseur method, of class GestionUtilisateurImplDao.
     */
    @Test
    public void testFindAllCoursByNomProfesseur() {
        System.out.println("findAllCoursByNomProfesseur");
        String nomProfesseur = "";
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        List<Cours> expResult = null;
        List<Cours> result = instance.findAllCoursByNomProfesseur(nomProfesseur);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAllNotes method, of class GestionUtilisateurImplDao.
     */
    @Test
    public void testFindAllNotes() {
        System.out.println("findAllNotes");
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        List<Notes> expResult = null;
        List<Notes> result = instance.findAllNotes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findNoteById method, of class GestionUtilisateurImplDao.
     */
    @Test
    public void testFindNoteById() {
        System.out.println("findNoteById");
        int id = 0;
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        Notes expResult = null;
        Notes result = instance.findNoteById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findNotesDeCoursByCoursID method, of class GestionUtilisateurImplDao.
     */
    @Test
    public void testFindNotesDeCoursByCoursID() {
        System.out.println("findNotesDeCoursByCoursID");
        int coursID = 0;
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        List<NoteDeCours> expResult = null;
        List<NoteDeCours> result = instance.findNotesDeCoursByCoursID(coursID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findNotesDeCoursByAuthor method, of class GestionUtilisateurImplDao.
     */
    @Test
    public void testFindNotesDeCoursByAuthor() {
        System.out.println("findNotesDeCoursByAuthor");
        String professeurAuteur = "";
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        List<NoteDeCours> expResult = null;
        List<NoteDeCours> result = instance.findNotesDeCoursByAuthor(professeurAuteur);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createNotesDeCours method, of class GestionUtilisateurImplDao.
     */
    @Test
    public void testCreateNotesDeCours() {
        System.out.println("createNotesDeCours");
        NoteDeCours notes = null;
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        boolean expResult = false;
        boolean result = instance.createNotesDeCours(notes);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findProjetById method, of class GestionUtilisateurImplDao.
     */
    @Test
    public void testFindProjetById() {
        System.out.println("findProjetById");
        int id = 0;
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        Projet expResult = null;
        Projet result = instance.findProjetById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateProjet method, of class GestionUtilisateurImplDao.
     */
    @Test
    public void testUpdateProjet() {
        System.out.println("updateProjet");
        Projet projet = null;
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        boolean expResult = false;
        boolean result = instance.updateProjet(projet);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteProjet method, of class GestionUtilisateurImplDao.
     */
    @Test
    public void testDeleteProjet() {
        System.out.println("deleteProjet");
        int id = 0;
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        boolean expResult = false;
        boolean result = instance.deleteProjet(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAllAdmins method, of class GestionUtilisateurImplDao.
     */
    @Test
    public void testFindAllAdmins() {
        System.out.println("findAllAdmins");
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        List<Administrateur> expResult = null;
        List<Administrateur> result = instance.findAllAdmins();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createEtudiantProjet method, of class GestionUtilisateurImplDao.
     */
    @Test
    public void testCreateEtudiantProjet() {
        System.out.println("createEtudiantProjet");
        int etudiantID = 0;
        String nomProjet = "";
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        boolean expResult = false;
        boolean result = instance.createEtudiantProjet(etudiantID, nomProjet);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findEtudiantsParProjet method, of class GestionUtilisateurImplDao.
     */
    @Test
    public void testFindEtudiantsParProjet() {
        System.out.println("findEtudiantsParProjet");
        String nomProjet = "";
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        List<Etudiant> expResult = null;
        List<Etudiant> result = instance.findEtudiantsParProjet(nomProjet);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findNoteByProjet method, of class GestionUtilisateurImplDao.
     */
    @Test
    public void testFindNoteByProjet() {
        System.out.println("findNoteByProjet");
        String nomProjet = "";
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        Notes expResult = null;
        Notes result = instance.findNoteByProjet(nomProjet);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAllProjetsByNomPrenomProf method, of class GestionUtilisateurImplDao.
     */
    @Test
    public void testFindAllProjetsByNomPrenomProf() {
        System.out.println("findAllProjetsByNomPrenomProf");
        String nomProf = "";
        GestionUtilisateurImplDao instance = new GestionUtilisateurImplDao();
        List<Projet> expResult = null;
        List<Projet> result = instance.findAllProjetsByNomPrenomProf(nomProf);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
