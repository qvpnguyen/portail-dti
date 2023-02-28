/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.dao;

import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Cours;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Etudiant;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.NoteDeCours;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Professeur;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Projet;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.singleton.ConnexionBD;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author franc
 */
public class GestionUtilisateurImplDao {
private static final String SQL_SELECT_ETUDIANT = "SELECT * FROM étudiant";
private static final String SQL_SELECT_COURS = "SELECT * FROM cours";
private static final String SQL_SELECT_PROJET = "SELECT * FROM projet";
private static final String SQL_SELECT_NOTES = "SELECT * FROM notesdecours";
private static final String SQL_SELECT_NOTESCOURS_PAR_ID = "SELECT * FROM notesdecours where CoursID = ?";
private static final String SQL_SELECT_PROFESSEURS = "SELECT * FROM professeur";
private static final String SQL_SELECT_ETUDIANT_PAR_NOM = "select * from étudiant where Nom = ?";
private static final String SQL_SELECT_PROJET_PAR_NOM = "select * from projet where Nom = ?";
private static final String SQL_SELECT_UNETUDIANT_PAR_ROLE = "select * from étudiant where Nom = ? and Role = ?";
private static final String SQL_SELECT_ETUDIANT_PAR_EMAIL = "select * from étudiant where Email = ?";
private static final String SQL_SELECT_ETUDIANT_PAR_COURS = "select * from étudiant where CoursID = ?";
private static final String SQL_SELECT_ETUDIANT_PAR_DISPO = "select * from étudiant where Disponibilité = ?";
private static final String SQL_SELECT_ETUDIANT_PAR_DISPO_AND_ROLE = "select * from étudiant where Disponibilité = ? and Role = ? ";
private static final String SQL_SELECT_ETUDIANT_PAR_ID = "select * from étudiant where id = ?";
private static final String SQL_INSERT_ETUDIANT = "INSERT INTO étudiant (id,Prénom, Nom, Email, DDN, Active, Role, FormationComplétée, Profil, NomUtilisateur, MotDePasse, CoursID,Disponibilité) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)"; 
private static final String SQL_DELETE_ETUDIANT_PAR_ID = "delete from étudiant where id = ?";
private static final String SQL_SELECT_ETUDIANT_PAR_ROLE = "select * from étudiant where Role = ? ";
private static final String SQL_UPDATE_ETUDIANT = "update étudiant set id=?,Prénom=?, Nom=?, Email=?, DDN=?, Active=?, Role=?, FormationComplétée=?, Profil=?, NomUtilisateur=?, MotDePasse=?, CoursID=?,Diponibilité=?";
private static final String SQL_SELECT_PROFESSEUR_PAR_ID = "select * from professeur where id = ?";
private static final String SQL_SELECT_PROFESSEUR_PAR_NOM = "select * from professeur where Nom = ?";
private static final String SQL_SELECT_PROFESSEUR_PAR_EMAIL = "select * from professeur where Email = ?";

 

public List<Etudiant> findAllEtudiants() {
        List<Etudiant> listeEtudiants  = null;
        try {

            //Initialise la requête préparée basée sur la connexion
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_ETUDIANT);

            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();

            listeEtudiants = new ArrayList<>();
            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                Etudiant utilisateur = new Etudiant();
                utilisateur.setId(result.getInt("id"));
                utilisateur.setPrenom(result.getString("Prénom"));
                utilisateur.setNom(result.getString("Nom"));
                utilisateur.setEmail(result.getString("Email"));
                utilisateur.setDdn(result.getDate("DDN"));
                utilisateur.setActive(result.getBoolean("Active"));
                utilisateur.setRole(result.getString("Role"));
                utilisateur.setFormationCompletee(result.getBoolean("FormationComplétée"));
                utilisateur.setProfil(result.getString("Profil"));
                utilisateur.setNomUtilisateur(result.getString("NomUtilisateur"));
                utilisateur.setMotDePasse(result.getString("MotDePasse"));
                utilisateur.setCoursId(result.getInt("CoursID"));
                utilisateur.setDispoTutorat(result.getBoolean("Disponibilité"));
                listeEtudiants.add(utilisateur);
            };
        } catch (SQLException ex) {
            Logger.getLogger(GestionUtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return listeEtudiants;
    }
public List<Etudiant> findAllEtudiantsByRole(String Role) {
        List<Etudiant> listeEtudiants = null;
        try {

            //Initialise la requête préparée basée sur la connexion
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_ETUDIANT_PAR_ROLE);
            ps.setString(1, Role);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();
            
            listeEtudiants = new ArrayList<>();
            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
               Etudiant utilisateur = new Etudiant();
                utilisateur.setId(result.getInt("id"));
                utilisateur.setPrenom(result.getString("Prénom"));
                utilisateur.setNom(result.getString("Nom"));
                utilisateur.setEmail(result.getString("Email"));
                utilisateur.setDdn(result.getDate("DDN"));
                utilisateur.setActive(result.getBoolean("Active"));
                utilisateur.setRole(result.getString("Role"));
                utilisateur.setFormationCompletee(result.getBoolean("FormationComplétée"));
                utilisateur.setProfil(result.getString("Profil"));
                utilisateur.setNomUtilisateur(result.getString("NomUtilisateur"));
                utilisateur.setMotDePasse(result.getString("MotDePasse"));
                utilisateur.setCoursId(result.getInt("CoursID"));
                utilisateur.setDispoTutorat(result.getBoolean("Disponibilité"));
                listeEtudiants.add(utilisateur);
            };
        } catch (SQLException ex) {
            Logger.getLogger(GestionUtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return listeEtudiants;
    }
public List<Etudiant> findAllEtudiantsByCours() {
        List<Etudiant> listeEtudiants  = null;
        try {

            //Initialise la requête préparée basée sur la connexion
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_ETUDIANT_PAR_COURS);

            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();

            listeEtudiants = new ArrayList<>();
            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                Etudiant utilisateur = new Etudiant();
                utilisateur.setId(result.getInt("id"));
                utilisateur.setPrenom(result.getString("Prénom"));
                utilisateur.setNom(result.getString("Nom"));
                utilisateur.setEmail(result.getString("Email"));
                utilisateur.setDdn(result.getDate("DDN"));
                utilisateur.setActive(result.getBoolean("Active"));
                utilisateur.setRole(result.getString("Role"));
                utilisateur.setFormationCompletee(result.getBoolean("FormationComplétée"));
                utilisateur.setProfil(result.getString("Profil"));
                utilisateur.setNomUtilisateur(result.getString("NomUtilisateur"));
                utilisateur.setMotDePasse(result.getString("MotDePasse"));
                utilisateur.setCoursId(result.getInt("CoursID"));
                utilisateur.setDispoTutorat(result.getBoolean("Disponibilité"));
                listeEtudiants.add(utilisateur);
            };
        } catch (SQLException ex) {
            Logger.getLogger(GestionUtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return listeEtudiants;
    }
public List<Etudiant> findAllEtudiantsByDispo() {
        List<Etudiant> listeEtudiants  = null;
        try {

            //Initialise la requête préparée basée sur la connexion
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_ETUDIANT_PAR_DISPO);

            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();

            listeEtudiants = new ArrayList<>();
            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                Etudiant utilisateur = new Etudiant();
                utilisateur.setId(result.getInt("id"));
                utilisateur.setPrenom(result.getString("Prénom"));
                utilisateur.setNom(result.getString("Nom"));
                utilisateur.setEmail(result.getString("Email"));
                utilisateur.setDdn(result.getDate("DDN"));
                utilisateur.setActive(result.getBoolean("Active"));
                utilisateur.setRole(result.getString("Role"));
                utilisateur.setFormationCompletee(result.getBoolean("FormationComplétée"));
                utilisateur.setProfil(result.getString("Profil"));
                utilisateur.setNomUtilisateur(result.getString("NomUtilisateur"));
                utilisateur.setMotDePasse(result.getString("MotDePasse"));
                utilisateur.setCoursId(result.getInt("CoursID"));
                utilisateur.setDispoTutorat(result.getBoolean("Disponibilité"));
                listeEtudiants.add(utilisateur);
            };
        } catch (SQLException ex) {
            Logger.getLogger(GestionUtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return listeEtudiants;
    }
public List<Etudiant> findAllEtudiantsByDispoAndByRole() {
        List<Etudiant> listeEtudiants  = null;
        try {

            //Initialise la requête préparée basée sur la connexion
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_ETUDIANT_PAR_DISPO_AND_ROLE);

            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();

            listeEtudiants = new ArrayList<>();
            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                Etudiant utilisateur = new Etudiant();
                utilisateur.setId(result.getInt("id"));
                utilisateur.setPrenom(result.getString("Prénom"));
                utilisateur.setNom(result.getString("Nom"));
                utilisateur.setEmail(result.getString("Email"));
                utilisateur.setDdn(result.getDate("DDN"));
                utilisateur.setActive(result.getBoolean("Active"));
                utilisateur.setRole(result.getString("Role"));
                utilisateur.setFormationCompletee(result.getBoolean("FormationComplétée"));
                utilisateur.setProfil(result.getString("Profil"));
                utilisateur.setNomUtilisateur(result.getString("NomUtilisateur"));
                utilisateur.setMotDePasse(result.getString("MotDePasse"));
                utilisateur.setCoursId(result.getInt("CoursID"));
                utilisateur.setDispoTutorat(result.getBoolean("Disponibilité"));
                listeEtudiants.add(utilisateur);
            };
        } catch (SQLException ex) {
            Logger.getLogger(GestionUtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return listeEtudiants;
    }

public List<Cours> findAllCours() {
        List<Cours> listeCours  = null;
        try {

            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_COURS);

            ResultSet result = ps.executeQuery();

            listeCours = new ArrayList<>();

            while (result.next()) {
                Cours cours = new Cours();
                cours.setId(result.getInt("id"));
                cours.setNom(result.getString("Nom"));
                cours.setCredits(result.getInt("Crédits"));
                cours.setGroupe(result.getInt("Groupe"));
                cours.setProfID(result.getInt("ProfesseurID"));
                listeCours.add(cours);
                
            };
        } catch (SQLException ex) {
            Logger.getLogger(GestionUtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return listeCours;
    }
public List<Projet> findAllProjets() {
        List<Projet> listeProjet  = null;
        try {

            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_PROJET);

            ResultSet result = ps.executeQuery();

            listeProjet = new ArrayList<>();

            while (result.next()) {
                Projet projet = new Projet();
                projet.setId(result.getInt("ID"));
                projet.setNom(result.getString("Nom"));
                projet.setAnnee(result.getInt("Annee"));
                projet.setDescription(result.getString("Description"));
                projet.setVideo(result.getString("Video"));
                projet.setLienGitlab(result.getString("LienGitlab"));
                projet.setCoursID(result.getInt("CoursID"));
                projet.setProfesseurEnChargeID(result.getInt("ProfesseurID"));
                projet.setNoteID(result.getInt("NotesID"));
                listeProjet.add(projet);
                
            };
        } catch (SQLException ex) {
            Logger.getLogger(GestionUtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return listeProjet;
    }
public List<NoteDeCours> findAllNotesDeCours() {
        List<NoteDeCours> listeNoteDeCours  = null;
        try {

            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_NOTES);

            ResultSet result = ps.executeQuery();

            listeNoteDeCours = new ArrayList<>();

            while (result.next()) {
                NoteDeCours notes= new NoteDeCours();
                notes.setId(result.getInt("ID"));
                notes.setLien(result.getString("Lien"));
                notes.setCoursID(result.getInt("CoursID"));
                notes.setNom(result.getString("Nom"));
                
                
               
                listeNoteDeCours.add(notes);
                
            };
        } catch (SQLException ex) {
            Logger.getLogger(GestionUtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return listeNoteDeCours;
    }

public Etudiant findEtudiantByName(String nom) {
        Etudiant utilisateur = null;
        try {

            //Initialise la requête préparée basée sur la connexion
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_ETUDIANT_PAR_NOM);
            // on initialise la propriété nom du bean avec sa premiere valeur
            ps.setString(1, nom);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();

            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                 utilisateur = new Etudiant();
                utilisateur.setId(result.getInt("id"));
                utilisateur.setPrenom(result.getString("Prénom"));
                utilisateur.setNom(result.getString("Nom"));
                utilisateur.setEmail(result.getString("Email"));
                utilisateur.setDdn(result.getDate("DDN"));
                utilisateur.setActive(result.getBoolean("Active"));
                utilisateur.setRole(result.getString("Role"));
                utilisateur.setFormationCompletee(result.getBoolean("FormationComplétée"));
                utilisateur.setProfil(result.getString("Profil"));
                utilisateur.setNomUtilisateur(result.getString("NomUtilisateur"));
                utilisateur.setMotDePasse(result.getString("MotDePasse"));
                utilisateur.setCoursId(result.getInt("CoursID"));
                
            };
        } catch (SQLException ex) {
            Logger.getLogger(GestionUtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return utilisateur;
    }
public Etudiant findEtudiantByEmail(String email) {
        Etudiant utilisateur = null;
        try {

            //Initialise la requête préparée basée sur la connexion
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_ETUDIANT_PAR_EMAIL);
            // on initialise la propriété nom du bean avec sa premiere valeur
            ps.setString(1, email);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();

            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                 utilisateur = new Etudiant();
                utilisateur.setId(result.getInt("id"));
                utilisateur.setPrenom(result.getString("Prénom"));
                utilisateur.setNom(result.getString("Nom"));
                utilisateur.setEmail(result.getString("Email"));
                utilisateur.setDdn(result.getDate("DDN"));
                utilisateur.setActive(result.getBoolean("Active"));
                utilisateur.setRole(result.getString("Role"));
                utilisateur.setFormationCompletee(result.getBoolean("FormationComplétée"));
                utilisateur.setProfil(result.getString("Profil"));
                utilisateur.setNomUtilisateur(result.getString("NomUtilisateur"));
                utilisateur.setMotDePasse(result.getString("MotDePasse"));
                utilisateur.setCoursId(result.getInt("CoursID"));
                
            };
        } catch (SQLException ex) {
            Logger.getLogger(GestionUtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return utilisateur;
    }
public Etudiant findEtudiantById(int id) {
        Etudiant utilisateur = null;
        try {

            //Initialise la requête préparée basée sur la connexion
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_ETUDIANT_PAR_ID);
            // on initialise la propriété id du bean avec sa valeur
            ps.setInt(1, id);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();

            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                 utilisateur = new Etudiant();
                utilisateur.setId(result.getInt("id"));
                utilisateur.setPrenom(result.getString("Prénom"));
                utilisateur.setNom(result.getString("Nom"));
                utilisateur.setEmail(result.getString("Email"));
                utilisateur.setDdn(result.getDate("DDN"));
                utilisateur.setActive(result.getBoolean("Active"));
                utilisateur.setRole(result.getString("Role"));
                utilisateur.setFormationCompletee(result.getBoolean("FormationComplétée"));
                utilisateur.setProfil(result.getString("Profil"));
                utilisateur.setNomUtilisateur(result.getString("NomUtilisateur"));
                utilisateur.setMotDePasse(result.getString("MotDePasse"));
                utilisateur.setCoursId(result.getInt("CoursID"));

            };
        } catch (SQLException ex) {
            Logger.getLogger(GestionUtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return utilisateur;
    }
public Etudiant findEtudiantByRole(String nom, String role) {
        Etudiant utilisateur = null;
        try {

            //Initialise la requête préparée basée sur la connexion
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_UNETUDIANT_PAR_ROLE);
            // on initialise la propriété id du bean avec sa valeur
            ps.setString(1, nom);
            ps.setString(2, role); 
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();

            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                 utilisateur = new Etudiant();
                utilisateur.setId(result.getInt("id"));
                utilisateur.setPrenom(result.getString("Prénom"));
                utilisateur.setNom(result.getString("Nom"));
                utilisateur.setEmail(result.getString("Email"));
                utilisateur.setDdn(result.getDate("DDN"));
                utilisateur.setActive(result.getBoolean("Active"));
                utilisateur.setRole(result.getString("Role"));
                utilisateur.setFormationCompletee(result.getBoolean("FormationComplétée"));
                utilisateur.setProfil(result.getString("Profil"));
                utilisateur.setNomUtilisateur(result.getString("NomUtilisateur"));
                utilisateur.setMotDePasse(result.getString("MotDePasse"));
                utilisateur.setCoursId(result.getInt("CoursID"));

            };
        } catch (SQLException ex) {
            Logger.getLogger(GestionUtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return utilisateur;
    }    

public boolean createEtudiant(Etudiant utilisateur) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;

        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_INSERT_ETUDIANT);
            //   Insérer les données dans la table parente, utilisateurs
            ps.setInt(1, utilisateur.getId());
            ps.setString(2, utilisateur.getPrenom());
            ps.setString(3, utilisateur.getNom());
            ps.setString(4, utilisateur.getEmail());
            ps.setDate(5, utilisateur.getDdn());
            ps.setBoolean(6, utilisateur.isActive());
            ps.setString(7, utilisateur.getRole());
            ps.setBoolean(8, utilisateur.isFormationCompletee());
            ps.setString(9, utilisateur.getProfil());
            ps.setString(10, utilisateur.getNomUtilisateur());
            ps.setString(11, utilisateur.getMotDePasse());
            ps.setInt(12, utilisateur.getCoursId());
            ps.setBoolean(13, utilisateur.isDispoTutorat());

      
            nbLigne = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(GestionUtilisateurImplDao.class.getName()).log(Level.SEVERE, null, e);
        }

//		System.out.println("nb ligne " + nbLigne);
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }
public boolean updateEtudiant(Etudiant utilisateur) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;

        try {

            ps = ConnexionBD.getConnection().prepareStatement(SQL_UPDATE_ETUDIANT);
            ps.setInt(1, utilisateur.getId());
            ps.setString(2, utilisateur.getPrenom());
            ps.setString(3, utilisateur.getNom());
            ps.setString(4, utilisateur.getEmail());
            ps.setDate(5, utilisateur.getDdn());
            ps.setBoolean(6, utilisateur.isActive());
            ps.setString(7, utilisateur.getRole());
            ps.setBoolean(8, utilisateur.isFormationCompletee());
            ps.setString(9, utilisateur.getProfil());
            ps.setString(10, utilisateur.getNomUtilisateur());
            ps.setString(11, utilisateur.getMotDePasse());
            ps.setInt(12, utilisateur.getCoursId());
            ps.setBoolean(13, utilisateur.isDispoTutorat());
            nbLigne = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(GestionUtilisateurImplDao.class.getName()).log(Level.SEVERE, null, e);
        }

        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }
public boolean deleteEtudiant(int id) {
        boolean retour = false;
        int nbLigne = 0;

      
        PreparedStatement ps;

        try {
           

            ps = ConnexionBD.getConnection().prepareStatement(SQL_DELETE_ETUDIANT_PAR_ID);

            // Supprimer les lignes dans la table intermédiaire qui dépendent de la ligne parente
          
            // Supprimer les lignes enfants dans les deux tables qui dépendent de la ligne parente
           

            // Supprimer la ligne parente
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GestionUtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }

public List<Professeur> findAllProf() {
        List<Professeur> listeProfesseurs = null;
        try {

            
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_PROFESSEURS);
           
            ResultSet result = ps.executeQuery();
               
            listeProfesseurs = new ArrayList<>();
           
            while (result.next()) {
                Professeur professeur = new Professeur();
                professeur.setId(result.getInt("id"));
                professeur.setPrenom(result.getString("Prénom"));
                professeur.setNom(result.getString("Nom"));
                professeur.setEmail(result.getString("Email"));
                professeur.setActive(result.getBoolean("Active"));
                professeur.setNomUtilisateur(result.getString("NomUtilisateur"));
                professeur.setMotDePasse(result.getString("MotDePasse"));
                listeProfesseurs.add(professeur);
            };
        } catch (SQLException ex) {
            Logger.getLogger(GestionUtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return listeProfesseurs;
    }
public Professeur findProfById(int id) {
        Professeur professeur = null;
        try {
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_PROFESSEUR_PAR_ID);
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                professeur = new Professeur();
                professeur.setId(result.getInt("id"));
                professeur.setPrenom(result.getString("Prénom"));
                professeur.setNom(result.getString("Nom"));
                professeur.setEmail(result.getString("Email"));
                professeur.setActive(result.getBoolean("Active"));
                professeur.setNomUtilisateur(result.getString("NomUtilisateur"));
                professeur.setMotDePasse(result.getString("MotDePasse"));

            };
        } catch (SQLException ex) {
            Logger.getLogger(GestionUtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        ConnexionBD.closeConnection();
        return professeur;
    }
public Professeur findProfByName(String nom) {
        Professeur professeur = null;
        try {

            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_PROFESSEUR_PAR_NOM);
            ps.setString(1, nom);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                professeur = new Professeur();
              professeur.setId(result.getInt("id"));
                professeur.setPrenom(result.getString("Prénom"));
                professeur.setNom(result.getString("Nom"));
                professeur.setEmail(result.getString("Email"));
                professeur.setActive(result.getBoolean("Active"));
                professeur.setNomUtilisateur(result.getString("NomUtilisateur"));
                professeur.setMotDePasse(result.getString("MotDePasse"));

            };
        } catch (SQLException ex) {
            Logger.getLogger(GestionUtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return professeur;
    }
public Professeur findProfByEmail(String email) {
        Professeur professeur = null;
        try {


            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_PROFESSEUR_PAR_EMAIL);
            ps.setString(1, email);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                professeur = new Professeur();
                professeur.setId(result.getInt("id"));
                professeur.setPrenom(result.getString("Prénom"));
                professeur.setNom(result.getString("Nom"));
                professeur.setEmail(result.getString("Email"));
                professeur.setActive(result.getBoolean("Active"));
                professeur.setNomUtilisateur(result.getString("NomUtilisateur"));
                professeur.setMotDePasse(result.getString("MotDePasse"));

            };
        } catch (SQLException ex) {
            Logger.getLogger(GestionUtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return professeur;
    }

public Projet findProjetByName(String nom) {
        Projet projet = null;
        try {
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_PROJET_PAR_NOM);
            ps.setString(1, nom);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                projet = new Projet();
                projet.setId(result.getInt("ID"));
                projet.setNom(result.getString("Nom"));
                projet.setAnnee(result.getInt("Annee"));
                projet.setDescription(result.getString("Description"));
                projet.setVideo(result.getString("Video"));
                projet.setLienGitlab(result.getString("LienGitlab"));
                projet.setCoursID(result.getInt("CoursID"));
                projet.setProfesseurEnChargeID(result.getInt("ProfesseurID"));
                projet.setNoteID(result.getInt("NotesID"));
                

            };
        } catch (SQLException ex) {
            Logger.getLogger(GestionUtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        ConnexionBD.closeConnection();
        return projet;
    }
public NoteDeCours findNotesById(int id) {
        NoteDeCours notes = null;
        try {
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_NOTESCOURS_PAR_ID);
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                notes= new NoteDeCours();
                notes.setId(result.getInt("ID"));
                notes.setLien(result.getString("Lien"));
                notes.setCoursID(result.getInt("CoursID"));
                notes.setNom(result.getString("Nom"));
                

            };
        } catch (SQLException ex) {
            Logger.getLogger(GestionUtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        ConnexionBD.closeConnection();
        return notes;
    }
//    List<Projet> findAllProjets();
//    Projet findProjetByName(String nom);
//    List<NoteDeCours> findAllNotesDeCours();
//    NoteDeCours findNotesDeCoursParNom(String nom);



}
