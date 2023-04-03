/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.singleton.ConnexionBD;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anayeesFrancisPatrickOthmane
 */
public class GestionUtilisateurImplDao implements GestionUtilisateurDao {

    private static final String SQL_SELECT_ETUDIANT = "SELECT * FROM étudiant";
    private static final String SQL_SELECT_ADMINISTRATEURS = "select * from administrateur";
    private static final String SQL_SELECT_VISITEURS = "select * from visiteur";
    private static final String SQL_SELECT_VISITEURS_PAR_ID = "select * from visiteur where ID=?";
    private static final String SQL_SELECT_VISITEURS_PAR_NOM = "select * from visiteur where Nom=?";
    private static final String SQL_SELECT_VISITEURS_PAR_EMAIL = "select * from visiteur where Email=?";
    private static final String SQL_SELECT_COURS = "SELECT * FROM cours";

    private static final String SQL_SELECT_COURS_PAR_ID = "SELECT * FROM cours WHERE ID=?";
    private static final String SQL_SELECT_COURS_PAR_NOMPROF = "SELECT * FROM cours JOIN professeur ON cours.ProfesseurID = professeur.ID WHERE professeur.nom = ?";
    private static final String SQL_SELECT_PROJET = "SELECT * FROM projet";
    private static final String SQL_SELECT_NOTES = "SELECT * FROM notes";
    private static final String SQL_SELECT_NOTES_PAR_ID = "SELECT * FROM notes WHERE ID = ?";
    private static final String SQL_SELECT_NOTESDECOURS = "SELECT * FROM notesdecours";

    private static final String SQL_SELECT_NOTESCOURS_PAR_ID = "SELECT * FROM notesdecours where ID = ?";
    private static final String SQL_SELECT_NOTESCOURS_PAR_NOM = "SELECT * FROM notesdecours where Nom = ?";
    private static final String SQL_SELECT_NOTESCOURS_PAR_COURSID = "SELECT * FROM notesdecours WHERE coursid = ?";
    private static final String SQL_SELECT_NOTESCOURS_PAR_AUTHOR = "SELECT * FROM notesdecours JOIN cours ON notesdecours.coursID = cours.ID JOIN professeur ON cours.ProfesseurID = professeur.ID WHERE professeur.nom = ?";
    private static final String SQL_SELECT_PROFESSEURS = "SELECT * FROM professeur";
    private static final String SQL_SELECT_ETUDIANT_PAR_NOM = "select * from étudiant where Nom = ?";
    private static final String SQL_SELECT_ETUDIANT_PAR_PRENOM_NOM = "select * from étudiant where Prénom = ? and Nom = ?";
    private static final String SQL_SELECT_PROJET_PAR_NOM = "select * from projet where Nom = ?";
    private static final String SQL_SELECT_PROJET_PAR_ID = "select * from projet where ID = ?";
    private static final String SQL_SELECT_ETUDIANT_PAR_NOM_AND_ROLE = "select * from étudiant where Nom = ? and Role = ?";
    private static final String SQL_SELECT_ETUDIANT_PAR_EMAIL = "select * from étudiant where Email = ?";
    private static final String SQL_SELECT_ETUDIANT_PAR_COURS = "select * from étudiant where CoursID = ?";
    private static final String SQL_SELECT_ETUDIANT_PAR_DISPO = "select * from étudiant where Disponibilité = ?";
    private static final String SQL_SELECT_ETUDIANT_PAR_DISPO_AND_ROLE = "select * from étudiant WHERE Role = ? and Disponibilité = ?";
    private static final String SQL_SELECT_ETUDIANT_PAR_ID = "select * from étudiant where id = ?";
    private static final String SQL_INSERT_ETUDIANT = "INSERT INTO étudiant (id,Prénom, Nom, Email, DDN, Active, Role, FormationComplétée, Profil, NomUtilisateur, MotDePasse, CoursID,Disponibilité) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_INSERT_PROF = "INSERT INTO professeur (id,Prénom, Nom, Email, Active,Role , NomUtilisateur, MotDePasse) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_INSERT_PROJET = "INSERT INTO projet (id,nom,annee,listeequipe,description,video,liengitlab,coursID,professeurID,notesID) values (?,?,?,?,?,?,?,?,?,null)";
    private static final String SQL_DELETE_PROFESSEUR_PAR_ID = "delete from professeur where id = ?";
    private static final String SQL_INSERT_VISITEUR = "INSERT INTO visiteur (id,Prenom, Nom, Email, Active,Profil , NomUtilisateur, MotDePasse) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_DELETE_VISITEUR_PAR_ID = "delete from visiteur where ID = ?";
    private static final String SQL_DELETE_ETUDIANT_PAR_ID = "delete from étudiant where id = ?";
    private static final String SQL_SELECT_ETUDIANTS_PAR_ROLE = "select * from étudiant where Role = ? ";
    private static final String SQL_UPDATE_ETUDIANT = "update étudiant set Prénom=?, Nom=?, Email=?, DDN=?, Active=?, Role=?, FormationComplétée=?, Profil=?, NomUtilisateur=?, MotDePasse=?, CoursID=?,Disponibilité=? where id=?";
    private static final String SQL_UPDATE_PROF = "update professeur set Prénom=?, Nom=?, Email=?, Active=?, NomUtilisateur=?, MotDePasse=? where id=?";
    private static final String SQL_UPDATE_VISITEUR = "update visiteur set Prénom=?, Nom=?, Email=?, Active=?, NomUtilisateur=?, MotDePasse=? where id=?";
    private static final String SQL_UPDATE_PROJET = "update projet set Nom=?, Annee=?, ListeEquipe=?, Description=?, Video=?, LienGitlab=?, CoursID=?, ProfesseurID=?, NotesID=? where id=?";
    private static final String SQL_SELECT_PROFESSEUR_PAR_ID = "select * from professeur where id = ?";
    private static final String SQL_SELECT_PROFESSEUR_PAR_NOM = "select * from professeur where Nom = ?";
    private static final String SQL_SELECT_PROFESSEUR_PAR_EMAIL = "select * from professeur where Email = ?";
    private static final String SQL_INSERT_NOTES = "insert into notesdecours(Lien,CoursID,Nom) value(?,?,?)";


    @Override
    public List<Etudiant> findAllEtudiants() {
        List<Etudiant> listeEtudiants = null;
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
//                utilisateur.setCoursId(result.getInt("CoursID"));
                int coursID = result.getInt("CoursID");
                PreparedStatement ps1 = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_COURS_PAR_ID);
                ps1.setInt(1, coursID);
                ResultSet result1 = ps1.executeQuery();
                while (result1.next()) {
                    Cours cours = new Cours();
                    cours.setId(result1.getInt("ID"));
                    cours.setNom(result1.getString("Nom"));
                    cours.setCredits(result1.getInt("Crédits"));
                    cours.setGroupe(result1.getInt("Groupe"));
                    cours.setProfID(result1.getInt("ProfesseurID"));
                    utilisateur.setCours(cours);
                }
                utilisateur.setDispoTutorat(result.getBoolean("Disponibilité"));
                //utilisateur.setPhoto(result.getString("photo"));
                listeEtudiants.add(utilisateur);
            };
        } catch (SQLException ex) {
            Logger.getLogger(GestionUtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return listeEtudiants;
    }

    @Override
    public List<Etudiant> findAllEtudiantsByRole(String nom) {
        List<Etudiant> listeEtudiants = null;
        try {

            //Initialise la requête préparée basée sur la connexion
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_ETUDIANTS_PAR_ROLE);
            ps.setString(1, nom);
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
//                utilisateur.setCoursId(result.getInt("CoursID"));
                int coursID = result.getInt("CoursID");
                PreparedStatement ps1 = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_COURS_PAR_ID);
                ps1.setInt(1, coursID);
                ResultSet result1 = ps1.executeQuery();
                while (result1.next()) {
                    Cours cours = new Cours();
                    cours.setId(result1.getInt("ID"));
                    cours.setNom(result1.getString("Nom"));
                    cours.setCredits(result1.getInt("Crédits"));
                    cours.setGroupe(result1.getInt("Groupe"));
                    cours.setProfID(result1.getInt("ProfesseurID"));
                    utilisateur.setCours(cours);
                }
                utilisateur.setDispoTutorat(result.getBoolean("Disponibilité"));
                utilisateur.setPhoto(result.getString("photo"));
                listeEtudiants.add(utilisateur);
            };
        } catch (SQLException ex) {
            Logger.getLogger(GestionUtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return listeEtudiants;
    }

    @Override
    public List<Etudiant> findAllEtudiantsByCours(int coursID) {
        List<Etudiant> listeEtudiants = null;
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
//                utilisateur.setCours(result.getInt("CoursID"));
                PreparedStatement ps1 = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_COURS_PAR_ID);
                ps1.setInt(1, coursID);
                ResultSet result1 = ps1.executeQuery();
                while (result1.next()) {
                    Cours cours = new Cours();
                    cours.setId(result1.getInt("ID"));
                    cours.setNom(result1.getString("Nom"));
                    cours.setCredits(result1.getInt("Crédits"));
                    cours.setGroupe(result1.getInt("Groupe"));
                    cours.setProfID(result1.getInt("ProfesseurID"));
                    utilisateur.setCours(cours);
                }
                utilisateur.setDispoTutorat(result.getBoolean("Disponibilité"));
                utilisateur.setPhoto(result.getString("photo"));
                listeEtudiants.add(utilisateur);
            };
        } catch (SQLException ex) {
            Logger.getLogger(GestionUtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return listeEtudiants;
    }

    @Override
    public List<Etudiant> findAllEtudiantsByDisponibilité(boolean dispo) {
        List<Etudiant> listeEtudiants = null;
        try {

            //Initialise la requête préparée basée sur la connexion
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_ETUDIANT_PAR_DISPO);

            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ps.setBoolean(1, dispo);
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
//                utilisateur.setCoursId(result.getInt("CoursID"));
                int coursID = result.getInt("CoursID");
                PreparedStatement ps1 = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_COURS_PAR_ID);
                ps1.setInt(1, coursID);
                ResultSet result1 = ps1.executeQuery();
                while (result1.next()) {
                    Cours cours = new Cours();
                    cours.setId(result1.getInt("ID"));
                    cours.setNom(result1.getString("Nom"));
                    cours.setCredits(result1.getInt("Crédits"));
                    cours.setGroupe(result1.getInt("Groupe"));
                    cours.setProfID(result1.getInt("ProfesseurID"));
                    utilisateur.setCours(cours);
                }
                utilisateur.setDispoTutorat(result.getBoolean("Disponibilité"));
                utilisateur.setPhoto(result.getString("photo"));
                listeEtudiants.add(utilisateur);
            };
        } catch (SQLException ex) {
            Logger.getLogger(GestionUtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return listeEtudiants;
    }

    @Override
    public List<Etudiant> findAllEtudiantsByDisponibilitéAndByRole(String role, boolean dispo) {
        List<Etudiant> listeEtudiants = null;
        try {

            //Initialise la requête préparée basée sur la connexion
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_ETUDIANT_PAR_DISPO_AND_ROLE);

            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ps.setString(1, role);
            ps.setBoolean(2, dispo);

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
//                utilisateur.setCoursId(result.getInt("CoursID"));
                int coursID = result.getInt("CoursID");
                PreparedStatement ps1 = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_COURS_PAR_ID);
                ps1.setInt(1, coursID);
                ResultSet result1 = ps1.executeQuery();
                while (result1.next()) {
                    Cours cours = new Cours();
                    cours.setId(result1.getInt("ID"));
                    cours.setNom(result1.getString("Nom"));
                    cours.setCredits(result1.getInt("Crédits"));
                    cours.setGroupe(result1.getInt("Groupe"));
                    cours.setProfID(result1.getInt("ProfesseurID"));
                    utilisateur.setCours(cours);
                }
                utilisateur.setDispoTutorat(result.getBoolean("Disponibilité"));
                utilisateur.setPhoto(result.getString("photo"));
                listeEtudiants.add(utilisateur);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionUtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return listeEtudiants;
    }

    @Override
    public List<Cours> findAllCours() {
        List<Cours> listeCours = null;
        try {

            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_COURS);

            ResultSet result = ps.executeQuery();

            listeCours = new ArrayList<>();

            while (result.next()) {
                Cours cours = new Cours();
                cours.setId(result.getInt("ID"));
                cours.setNom(result.getString("Nom"));
                cours.setCredits(result.getInt("Crédits"));
                cours.setGroupe(result.getInt("Groupe"));
                cours.setProfID(result.getInt("ProfesseurID"));
                listeCours.add(cours);

            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionUtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return listeCours;
    }

    @Override
    public List<Projet> findAllProjets() {
        List<Projet> listeProjet = null;
        try {

            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_PROJET);

            ResultSet result = ps.executeQuery();

            listeProjet = new ArrayList<>();

            while (result.next()) {
                Projet projet = new Projet();
                projet.setId(result.getInt("ID"));
                projet.setNom(result.getString("Nom"));
                projet.setAnnee(result.getInt("Annee"));
//                projet.setListeEquipeProjet(result.getString("ListeEquipe").split(","));
                String[] stringListeEquipe = result.getString("ListeEquipe").split(",");
                Etudiant[] etudiantListeEquipe = new Etudiant[stringListeEquipe.length];
                for (int i = 0; i < stringListeEquipe.length; i++) {
                    String[] stringEtudiant = stringListeEquipe[i].split(" ");
                    String prenom = stringEtudiant[0];
                    String nom = stringEtudiant[1];
                    PreparedStatement psEtud = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_ETUDIANT_PAR_PRENOM_NOM);
                    psEtud.setString(1, prenom);
                    psEtud.setString(2, nom);
                    ResultSet resultEtud = psEtud.executeQuery();
                    while (resultEtud.next()) {
                        Etudiant etudiant = new Etudiant();
                        etudiant.setId(resultEtud.getInt("ID"));
                        etudiant.setPrenom(resultEtud.getString("Prénom"));
                        etudiant.setNom(resultEtud.getString("Nom"));
                        etudiant.setEmail(resultEtud.getString("Email"));
                        etudiant.setProfil(resultEtud.getString("Profil"));
                        etudiant.setRole(resultEtud.getString("Role"));
                        etudiant.setActive(resultEtud.getBoolean("Active"));
                        etudiant.setNomUtilisateur(resultEtud.getString("NomUtilisateur"));
                        etudiant.setMotDePasse(resultEtud.getString("MotDePasse"));
                        etudiant.setDdn(resultEtud.getDate("DDN"));
                        etudiant.setFormationCompletee(resultEtud.getBoolean("FormationComplétée"));
                        etudiant.setPhoto(resultEtud.getString("photo"));
                        int coursID = result.getInt("CoursID");
                        PreparedStatement ps1 = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_COURS_PAR_ID);
                        ps1.setInt(1, coursID);
                        ResultSet result1 = ps1.executeQuery();
                        while (result1.next()) {
                            Cours cours = new Cours();
                            cours.setId(result1.getInt("ID"));
                            cours.setNom(result1.getString("Nom"));
                            cours.setCredits(result1.getInt("Crédits"));
                            cours.setGroupe(result1.getInt("Groupe"));
                            cours.setProfID(result1.getInt("ProfesseurID"));
                            etudiant.setCours(cours);
                        }
                        etudiant.setDispoTutorat(resultEtud.getBoolean("Disponibilité"));
                        etudiantListeEquipe[i] = etudiant;
                    }
                }
                projet.setListeEquipeProjet(etudiantListeEquipe);
                projet.setDescription(result.getString("Description"));
                projet.setVideo(result.getString("Video"));
                projet.setLienGitlab(result.getString("LienGitlab"));
                
                int coursID = result.getInt("CoursID");
                PreparedStatement ps1 = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_COURS_PAR_ID);
                ps1.setInt(1, coursID);
                ResultSet result1 = ps1.executeQuery();
                while (result1.next()) {
                    Cours cours = new Cours();
                    cours.setId(result1.getInt("ID"));
                    cours.setNom(result1.getString("Nom"));
                    cours.setCredits(result1.getInt("Crédits"));
                    cours.setGroupe(result1.getInt("Groupe"));
                    cours.setProfID(result1.getInt("ProfesseurID"));
                    projet.setCours(cours);
                }
                
                int professeurID = result.getInt("ProfesseurID");
                PreparedStatement ps2 = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_PROFESSEUR_PAR_ID);
                ps2.setInt(1, professeurID);
                ResultSet result2 = ps2.executeQuery();
                while (result2.next()) {
                    Professeur professeur = new Professeur();
                    professeur.setId(result2.getInt("ID"));
                    professeur.setPrenom(result2.getString("Prénom"));
                    professeur.setNom(result2.getString("Nom"));
                    professeur.setEmail(result2.getString("Email"));
                    professeur.setRole(result2.getString("Role"));
                    professeur.setActive(result2.getBoolean("Active"));
                    professeur.setNomUtilisateur(result2.getString("NomUtilisateur"));
                    professeur.setMotDePasse(result2.getString("MotDePasse"));
                    professeur.setPhoto(result2.getString("photo"));
                    projet.setProfesseur(professeur);
                }
                
                int notesID = result.getInt("NotesID");
                PreparedStatement ps3 = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_NOTES_PAR_ID);
                ps3.setInt(1, notesID);
                ResultSet result3 = ps3.executeQuery();
                while (result3.next()) {
                    Notes notes = new Notes();
                    notes.setId(result3.getInt("ID"));
                    notes.setNoteObtenue(result3.getInt("NoteObtenue"));
                    notes.setSession(result3.getString("Session"));
                    notes.setAnnee(result3.getDate("Année"));
                    notes.setCommentaire(result3.getString("Commentaire"));
                    projet.setNotes(notes);
                }
                listeProjet.add(projet);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionUtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return listeProjet;
    }

    @Override
    public List<NoteDeCours> findAllNotesDeCours() {
        List<NoteDeCours> listeNoteDeCours = null;
        try {

            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_NOTES);

            ResultSet result = ps.executeQuery();

            listeNoteDeCours = new ArrayList<>();

            while (result.next()) {
                NoteDeCours notes = new NoteDeCours();
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

    @Override
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
                utilisateur.setPhoto(result.getString("photo"));
//                utilisateur.setCoursId(result.getInt("CoursID"));
                // Changer type de CoursID de int à Cours
                int coursID = result.getInt("CoursID");
                PreparedStatement ps1 = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_COURS_PAR_ID);
                ps1.setInt(1, coursID);
                ResultSet result1 = ps1.executeQuery();
                while (result1.next()) {
                    Cours cours = new Cours();
                    cours.setId(result1.getInt("ID"));
                    cours.setNom(result1.getString("Nom"));
                    cours.setCredits(result1.getInt("Crédits"));
                    cours.setGroupe(result1.getInt("Groupe"));
                    cours.setProfID(result1.getInt("ProfesseurID"));
                    utilisateur.setCours(cours);
                }

            };
        } catch (SQLException ex) {
            Logger.getLogger(GestionUtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return utilisateur;
    }
    
    @Override
    public Etudiant findEtudiantByPrenomNom(String prenom, String nom) {
        Etudiant utilisateur = null;
        try {

            //Initialise la requête préparée basée sur la connexion
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_ETUDIANT_PAR_PRENOM_NOM);
            
            ps.setString(1, prenom);
            ps.setString(2, nom);
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
                utilisateur.setPhoto(result.getString("photo"));
//                utilisateur.setCoursId(result.getInt("CoursID"));
                int coursID = result.getInt("CoursID");
                PreparedStatement ps1 = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_COURS_PAR_ID);
                ps1.setInt(1, coursID);
                ResultSet result1 = ps1.executeQuery();
                while (result1.next()) {
                    Cours cours = new Cours();
                    cours.setId(result1.getInt("ID"));
                    cours.setNom(result1.getString("Nom"));
                    cours.setCredits(result1.getInt("Crédits"));
                    cours.setGroupe(result1.getInt("Groupe"));
                    // Changer type de ProfesseurID de int à Professeur
                    cours.setProfID(result1.getInt("ProfesseurID"));
                    utilisateur.setCours(cours);
                }
                utilisateur.setPhoto(result.getString("photo"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionUtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return utilisateur;
    }

    @Override
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
                utilisateur.setPhoto(result.getString("photo"));
//                utilisateur.setCoursId(result.getInt("CoursID"));
                int coursID = result.getInt("CoursID");
                PreparedStatement ps1 = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_COURS_PAR_ID);
                ps1.setInt(1, coursID);
                ResultSet result1 = ps1.executeQuery();
                while (result1.next()) {
                    Cours cours = new Cours();
                    cours.setId(result1.getInt("ID"));
                    cours.setNom(result1.getString("Nom"));
                    cours.setCredits(result1.getInt("Crédits"));
                    cours.setGroupe(result1.getInt("Groupe"));
                    cours.setProfID(result1.getInt("ProfesseurID"));
                    utilisateur.setCours(cours);
                }
                utilisateur.setPhoto(result.getString("photo"));


            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionUtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return utilisateur;
    }

    @Override
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
                utilisateur.setPhoto(result.getString("photo"));
//                utilisateur.setCoursId(result.getInt("CoursID"));
                int coursID = result.getInt("CoursID");
                PreparedStatement ps1 = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_COURS_PAR_ID);
                ps1.setInt(1, coursID);
                ResultSet result1 = ps1.executeQuery();
                while (result1.next()) {
                    Cours cours = new Cours();
                    cours.setId(result1.getInt("ID"));
                    cours.setNom(result1.getString("Nom"));
                    cours.setCredits(result1.getInt("Crédits"));
                    cours.setGroupe(result1.getInt("Groupe"));
                    cours.setProfID(result1.getInt("ProfesseurID"));
                    utilisateur.setCours(cours);
                }
                utilisateur.setPhoto(result.getString("photo"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionUtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return utilisateur;
    }
   

    @Override
    public Etudiant findEtudiantByRole(String prenom, String nom, String role) {
        Etudiant utilisateur = null;
        try {

            //Initialise la requête préparée basée sur la connexion
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_ETUDIANT_PAR_NOM_AND_ROLE);
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
                utilisateur.setPhoto(result.getString("photo"));
//                utilisateur.setCoursId(result.getInt("CoursID"));
                int coursID = result.getInt("CoursID");
                PreparedStatement ps1 = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_COURS_PAR_ID);
                ps1.setInt(1, coursID);
                ResultSet result1 = ps1.executeQuery();
                while (result1.next()) {
                    Cours cours = new Cours();
                    cours.setId(result1.getInt("ID"));
                    cours.setNom(result1.getString("Nom"));
                    cours.setCredits(result1.getInt("Crédits"));
                    cours.setGroupe(result1.getInt("Groupe"));
                    cours.setProfID(result1.getInt("ProfesseurID"));
                    utilisateur.setCours(cours);
                }
                utilisateur.setPhoto(result.getString("photo"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionUtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return utilisateur;
    }

    @Override
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
            ps.setDate(5, (Date) utilisateur.getDdn());
            ps.setBoolean(6, utilisateur.isActive());
            ps.setString(7, utilisateur.getRole());
            ps.setBoolean(8, utilisateur.isFormationCompletee());
            ps.setString(9, utilisateur.getProfil());
            ps.setString(10, utilisateur.getNomUtilisateur());
            ps.setString(11, utilisateur.getMotDePasse());
            ps.setInt(12, utilisateur.getCours().getId());
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

    @Override
    public boolean updateEtudiant(Etudiant utilisateur) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;

        try {

            ps = ConnexionBD.getConnection().prepareStatement(SQL_UPDATE_ETUDIANT);

            ps.setString(1, utilisateur.getPrenom());
            ps.setString(2, utilisateur.getNom());
            ps.setString(3, utilisateur.getEmail());
            ps.setDate(4, (Date) utilisateur.getDdn());
            ps.setBoolean(5, utilisateur.isActive());
            ps.setString(6, utilisateur.getRole());
            ps.setBoolean(7, utilisateur.isFormationCompletee());
            ps.setString(8, utilisateur.getProfil());
            ps.setString(9, utilisateur.getNomUtilisateur());
            ps.setString(10, utilisateur.getMotDePasse());
            ps.setInt(11, utilisateur.getCours().getId());
            ps.setBoolean(12, utilisateur.isDispoTutorat());
            ps.setInt(13, utilisateur.getId());
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

    @Override
    public boolean deleteEtudiant(int id) {
        boolean retour = false;
        int nbLigne = 0;

        PreparedStatement ps;

        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_DELETE_ETUDIANT_PAR_ID);
            ps.setInt(1, id);
            nbLigne = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GestionUtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }

    @Override
    public List<Professeur> findAllProfesseurs() {
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
                professeur.setRole(result.getString("Role"));
                professeur.setNomUtilisateur(result.getString("NomUtilisateur"));
                professeur.setMotDePasse(result.getString("MotDePasse"));
//                professeur.setPhoto(result.getString("photo"));
                listeProfesseurs.add(professeur);
            };
        } catch (SQLException ex) {
            Logger.getLogger(GestionUtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return listeProfesseurs;
    }

    @Override
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
                professeur.setPhoto(result.getString("photo"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionUtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        ConnexionBD.closeConnection();
        return professeur;
    }

    @Override
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
                professeur.setPhoto(result.getString("photo"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionUtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return professeur;
    }

    @Override
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
                professeur.setPhoto(result.getString("photo"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionUtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return professeur;
    }

    @Override
    public boolean createProf(Professeur utilisateur) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;

        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_INSERT_PROF);
            //   Insérer les données dans la table parente, utilisateurs
            ps.setInt(1, utilisateur.getId());
            ps.setString(2, utilisateur.getPrenom());
            ps.setString(3, utilisateur.getNom());
            ps.setString(4, utilisateur.getEmail());
            ps.setBoolean(5, utilisateur.isActive());
            ps.setString(6, utilisateur.getRole());
            ps.setString(7, utilisateur.getNomUtilisateur());
            ps.setString(8, utilisateur.getMotDePasse());

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

    @Override
    public boolean updateProf(Professeur utilisateur) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;

        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_UPDATE_PROF);

            ps.setString(1, utilisateur.getPrenom());
            ps.setString(2, utilisateur.getNom());
            ps.setString(3, utilisateur.getEmail());
            ps.setBoolean(4, utilisateur.isActive());
//            ps.setString(5, utilisateur.getProfil());
            ps.setString(5, utilisateur.getNomUtilisateur());
            ps.setString(6, utilisateur.getMotDePasse());
            ps.setInt(7, utilisateur.getId());

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

    @Override
    public boolean deleteProf(int id) {
        boolean retour = false;
        int nbLigne = 0;

        PreparedStatement ps;

        try {

            ps = ConnexionBD.getConnection().prepareStatement(SQL_DELETE_PROFESSEUR_PAR_ID);
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

//    @Override
//    public List<Projet> findAllProjets() {
//        List<Projet> listeProjet = null;
//        try {
//
//            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_PROJET);
//
//            ResultSet result = ps.executeQuery();
//
//            listeProjet = new ArrayList<>();
//
//            while (result.next()) {
//                Projet projet = new Projet();
//                projet.setId(result.getInt("ID"));
//                projet.setNom(result.getString("Nom"));
//                projet.setAnnee(result.getInt("Annee"));
//                projet.setDescription(result.getString("Description"));
//                projet.setVideo(result.getString("Video"));
//                projet.setLienGitlab(result.getString("LienGitlab"));
//
//                int coursId = result.getInt("CoursID");
//                Cours cours = this.findCoursById(coursId);
//                projet.setCours(cours);
//
//                int professeurId = result.getInt("ProfesseurID");
//                Professeur professeur = this.findProfById(professeurId);
//                projet.setProfesseur(professeur);
//
//                int notesId = result.getInt("NotesID");
//                Notes notes = this.findNoteById(notesId);
//                projet.setNotes(notes);
//
//                listeProjet.add(projet);
//
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(GestionUtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        ConnexionBD.closeConnection();
//        return listeProjet;
//    }

    @Override
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
                //projet.setCours((Cours) result.getObject("CoursID"));
                //projet.setProfesseur((Professeur) result.getObject("ProfesseurID"));
                //projet.setNotes((Notes) result.getObject("NotesID"));
                
                int coursId = result.getInt("CoursID");
                Cours cours = this.findCoursById(coursId);
                projet.setCours(cours);

                int professeurId = result.getInt("ProfesseurID");
                Professeur professeur = this.findProfById(professeurId);
                projet.setProfesseur(professeur);

                int notesId = result.getInt("NotesID");
                Notes notes = this.findNoteById(notesId);
                projet.setNotes(notes);

            };
        } catch (SQLException ex) {
            Logger.getLogger(GestionUtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        ConnexionBD.closeConnection();
        return projet;
    }

    @Override
    public boolean createProjet(Projet projet) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;

        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_INSERT_PROJET);
            ps.setInt(1, projet.getId());
            ps.setString(2, projet.getNom());
            ps.setInt(3, projet.getAnnee());
            ps.setString(4, Arrays.toString(projet.getListeEquipeProjet()));
            ps.setString(5, projet.getDescription());
            ps.setString(6, projet.getVideo());
            ps.setString(7, projet.getLienGitlab());
            ps.setInt(8, projet.getCours().getId());
            ps.setInt(9, projet.getProfesseur().getId());
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

    @Override
    public List<Visiteur> findAllVisiteurs() {
        List<Visiteur> listeVisiteurs = null;
        try {

            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_VISITEURS);

            ResultSet result = ps.executeQuery();

            listeVisiteurs = new ArrayList<>();

            while (result.next()) {
                Visiteur visiteur = new Visiteur();
                visiteur.setId(result.getInt("ID"));
                visiteur.setPrenom(result.getString("Prénom"));
                visiteur.setNom(result.getString("Nom"));
                visiteur.setEmail(result.getString("Email"));
                visiteur.setActive(result.getBoolean("Active"));
                visiteur.setNomUtilisateur(result.getString("NomUtilisateur"));
                visiteur.setMotDePasse(result.getString("MotDePasse"));
                visiteur.setPhoto(result.getString("photo"));
                listeVisiteurs.add(visiteur);
            };
        } catch (SQLException ex) {
            Logger.getLogger(GestionUtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return listeVisiteurs;
    }

    @Override
    public Visiteur findVisiteurById(int id) {
        Visiteur visiteur = null;
        try {
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_VISITEURS_PAR_ID);
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                visiteur = new Visiteur();
                visiteur.setId(result.getInt("ID"));
                visiteur.setPrenom(result.getString("Prenom"));
                visiteur.setNom(result.getString("Nom"));
                visiteur.setEmail(result.getString("Email"));
                visiteur.setActive(result.getBoolean("Active"));
                visiteur.setNomUtilisateur(result.getString("NomUtilisateur"));
                visiteur.setMotDePasse(result.getString("MotDePasse"));

            };
        } catch (SQLException ex) {
            Logger.getLogger(GestionUtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        ConnexionBD.closeConnection();
        return visiteur;
    }

    @Override
    public Visiteur findVisiteurByName(String nom) {
        Visiteur visiteur = null;
        try {
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_VISITEURS_PAR_NOM);
            ps.setString(1, nom);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                visiteur = new Visiteur();
                visiteur.setId(result.getInt("ID"));
                visiteur.setPrenom(result.getString("Prenom"));
                visiteur.setNom(result.getString("Nom"));
                visiteur.setEmail(result.getString("Email"));
                visiteur.setActive(result.getBoolean("Active"));
                visiteur.setNomUtilisateur(result.getString("NomUtilisateur"));
                visiteur.setMotDePasse(result.getString("MotDePasse"));

            };
        } catch (SQLException ex) {
            Logger.getLogger(GestionUtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        ConnexionBD.closeConnection();
        return visiteur;
    }

    @Override
    public Visiteur findVisiteurByEmail(String email) {
        Visiteur visiteur = null;
        try {
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_VISITEURS_PAR_EMAIL);
            ps.setString(1, email);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                visiteur = new Visiteur();
                visiteur.setId(result.getInt("ID"));
                visiteur.setPrenom(result.getString("Prenom"));
                visiteur.setNom(result.getString("Nom"));
                visiteur.setEmail(result.getString("Email"));
                visiteur.setActive(result.getBoolean("Active"));
                visiteur.setNomUtilisateur(result.getString("NomUtilisateur"));
                visiteur.setMotDePasse(result.getString("MotDePasse"));

            };
        } catch (SQLException ex) {
            Logger.getLogger(GestionUtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        ConnexionBD.closeConnection();
        return visiteur;
    }

    @Override
    public boolean createVisiteur(Visiteur utilisateur) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;

        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_INSERT_VISITEUR);
            //   Insérer les données dans la table parente, utilisateurs
            ps.setInt(1, utilisateur.getId());
            ps.setString(2, utilisateur.getPrenom());
            ps.setString(3, utilisateur.getNom());
            ps.setString(4, utilisateur.getEmail());
            ps.setBoolean(5, utilisateur.isActive());
//            ps.setString(6, utilisateur.getProfil());
            ps.setString(6, utilisateur.getNomUtilisateur());
            ps.setString(7, utilisateur.getMotDePasse());

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

    @Override
    public boolean updateVisiteur(Visiteur utilisateur) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;

        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_UPDATE_VISITEUR);

            ps.setString(1, utilisateur.getPrenom());
            ps.setString(2, utilisateur.getNom());
            ps.setString(3, utilisateur.getEmail());
            ps.setBoolean(4, utilisateur.isActive());
//            ps.setString(5, utilisateur.getProfil());
            ps.setString(5, utilisateur.getNomUtilisateur());
            ps.setString(6, utilisateur.getMotDePasse());
            ps.setInt(7, utilisateur.getId());

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

    @Override
    public boolean deleteVisiteur(int id) {
        boolean retour = false;
        int nbLigne = 0;

        PreparedStatement ps;

        try {

            ps = ConnexionBD.getConnection().prepareStatement(SQL_DELETE_VISITEUR_PAR_ID);
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

    @Override
    public NoteDeCours findNotesDeCoursById(int id) {
        NoteDeCours notes = null;
        try {

            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_NOTESCOURS_PAR_ID);
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                notes = new NoteDeCours();
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

    @Override
    public NoteDeCours findNotesDeCoursByName(String nom) {
        NoteDeCours notes = null;
        try {
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_NOTESCOURS_PAR_NOM);
            ps.setString(1, nom);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                notes = new NoteDeCours();
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

//    @Override
//    public List<Cours> findAllCoursByNomProfesseur(String nomProfesseur) {

    

    @Override
    public Cours findCoursById(int idCours) {
        Cours cours = null;

        try {
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_COURS_PAR_ID);
            ps.setInt(1, idCours);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                cours = new Cours();
                cours.setId(result.getInt("ID"));
                cours.setNom(result.getString("Nom"));
                cours.setCredits(result.getInt("Crédits"));
                cours.setGroupe(result.getInt("Groupe"));
                cours.setProfID(result.getInt("ProfesseurID"));
            };
        } catch (SQLException ex) {
            Logger.getLogger(GestionUtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return cours;

    }

    @Override
    public List<Cours> findAllCoursByNomProfesseur(String nomProfesseur) {
        List<Cours> listeCours = null;
        return listeCours;
    }

    @Override
    public List<Notes> findAllNotes() {
        List<Notes> listeNotes = null;
        try {

            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_COURS);

            ResultSet result = ps.executeQuery();

            listeNotes = new ArrayList<>();

            while (result.next()) {
                Notes notes = new Notes();
                notes.setId(result.getInt("id"));
                notes.setNoteObtenue(result.getInt("NoteObtenue"));
                notes.setSession(result.getString("Session"));
                notes.setAnnee(result.getDate("Année"));
                notes.setCommentaire(result.getString("Commentaire"));
                listeNotes.add(notes);

            };
        } catch (SQLException ex) {
            Logger.getLogger(GestionUtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return listeNotes;
    }

    @Override
    public Notes findNoteById(int id) {
        Notes notes = null;
        try {

            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_NOTES);

            ResultSet result = ps.executeQuery();

            while (result.next()) {
                notes = new Notes();
                notes.setId(result.getInt("Id"));
                notes.setNoteObtenue(result.getInt("NoteObtenue"));
                notes.setSession(result.getString("Session"));
                notes.setAnnee(result.getDate("Année"));
                notes.setCommentaire(result.getString("Commentaire"));
                notes.setEtudiantID(result.getInt("ÉtudiantID"));
                notes.setCoursID(result.getInt("CoursID"));
            };
        } catch (SQLException ex) {
            Logger.getLogger(GestionUtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return notes;
    }

    @Override
    public List<NoteDeCours> findNotesDeCoursByCoursID(int coursID) {
        List<NoteDeCours> listeNoteDeCours = null;

        try {
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_NOTESCOURS_PAR_COURSID);
            ps.setInt(1, coursID);
            ResultSet result = ps.executeQuery();

            listeNoteDeCours = new ArrayList<>();

            while (result.next()) {
                NoteDeCours noteDeCours = new NoteDeCours();
                noteDeCours.setId(result.getInt("ID"));
                noteDeCours.setNom(result.getString("Nom"));
                noteDeCours.setLien(result.getString("Lien"));
                noteDeCours.setCoursID(result.getInt("CoursID"));
                listeNoteDeCours.add(noteDeCours);
            };
        } catch (SQLException ex) {
            Logger.getLogger(GestionUtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return listeNoteDeCours;
    }

    @Override
    public List<NoteDeCours> findNotesDeCoursByAuthor(String professeurAuteur) {
        List<NoteDeCours> listeNoteDeCours = null;

        try {
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_NOTESCOURS_PAR_AUTHOR);
            ps.setString(1, professeurAuteur);
            ResultSet result = ps.executeQuery();

            listeNoteDeCours = new ArrayList<>();

            while (result.next()) {
                NoteDeCours noteDeCours = new NoteDeCours();
                noteDeCours.setId(result.getInt("ID"));
                noteDeCours.setNom(result.getString("Nom"));
                noteDeCours.setLien(result.getString("Lien"));
                noteDeCours.setCoursID(result.getInt("CoursID"));
                listeNoteDeCours.add(noteDeCours);
            };
        } catch (SQLException ex) {
            Logger.getLogger(GestionUtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return listeNoteDeCours;
    }


    public boolean createNotesDeCours(NoteDeCours notes) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;

        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_INSERT_NOTES);
            //   Insérer les données dans la table notedecours
            
            ps.setString(1, notes.getNom());
            ps.setInt(2, notes.getCoursID());
            ps.setString(3, notes.getLien());
            nbLigne = ps.executeUpdate();
             } catch (SQLException ex) {
            // TODO Auto-generated catch block
             Logger.getLogger(GestionUtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }

//        System.out.println("nb ligne " + nbLigne);
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }

  

    @Override
    public Projet findProjetById(int id) {
        Projet projet = null;
        try {
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_PROJET_PAR_ID);
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                projet = new Projet();
                projet.setId(result.getInt("ID"));
                projet.setNom(result.getString("Nom"));
                projet.setAnnee(result.getInt("Annee"));
                projet.setDescription(result.getString("Description"));
                projet.setVideo(result.getString("Video"));
                projet.setLienGitlab(result.getString("LienGitlab"));
                
                int coursID = result.getInt("CoursID");
                PreparedStatement ps1 = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_COURS_PAR_ID);
                ps1.setInt(1, coursID);
                ResultSet result1 = ps1.executeQuery();
                while (result1.next()) {
                    Cours cours = new Cours();
                    cours.setId(result1.getInt("ID"));
                    cours.setNom(result1.getString("Nom"));
                    cours.setCredits(result1.getInt("Crédits"));
                    cours.setGroupe(result1.getInt("Groupe"));
                    cours.setProfID(result1.getInt("ProfesseurID"));
                    projet.setCours(cours);
                }
                
                int professeurID = result.getInt("ProfesseurID");
                PreparedStatement ps2 = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_PROFESSEUR_PAR_ID);
                ps2.setInt(1, professeurID);
                ResultSet result2 = ps2.executeQuery();
                while (result2.next()) {
                    Professeur professeur = new Professeur();
                    professeur.setId(result2.getInt("ID"));
                    professeur.setPrenom(result2.getString("Prénom"));
                    professeur.setNom(result2.getString("Nom"));
                    professeur.setEmail(result2.getString("Email"));
                    professeur.setRole(result2.getString("Role"));
                    professeur.setActive(result2.getBoolean("Active"));
                    professeur.setNomUtilisateur(result2.getString("NomUtilisateur"));
                    professeur.setMotDePasse(result2.getString("MotDePasse"));
                    projet.setProfesseur(professeur);
                }
                
                int notesID = result.getInt("NotesID");
                PreparedStatement ps3 = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_NOTES_PAR_ID);
                ps3.setInt(1, notesID);
                ResultSet result3 = ps3.executeQuery();
                while (result3.next()) {
                    Notes notes = new Notes();
                    notes.setId(result3.getInt("ID"));
                    notes.setNoteObtenue(result3.getInt("NoteObtenue"));
                    notes.setSession(result3.getString("Session"));
                    notes.setAnnee(result3.getDate("Année"));
                    notes.setCommentaire(result3.getString("Commentaire"));
                    projet.setNotes(notes);
                }

            }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(GestionUtilisateurImplDao.class.getName()).log(Level.SEVERE, null, e);
        }
        ConnexionBD.closeConnection();
        return projet;
    }

    @Override
    public boolean updateProjet(Projet projet) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;

        try {

            ps = ConnexionBD.getConnection().prepareStatement(SQL_UPDATE_PROJET);
            ps.setString(1, projet.getNom());
            ps.setInt(2, projet.getAnnee());
            ps.setString(3, Arrays.toString(projet.getListeEquipeProjet()));
            ps.setString(4, projet.getDescription());
            ps.setString(5, projet.getVideo());
            ps.setString(6, projet.getLienGitlab());
            ps.setInt(7, projet.getCours().getId());
            ps.setInt(8, projet.getProfesseur().getId());
            ps.setInt(9, projet.getNotes().getId());
            ps.setInt(10, projet.getId());
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

    @Override
    public boolean deleteProjet(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

      
    

    @Override
    public List<Administrateur> findAllAdmins() {
        List<Administrateur> listeAdmins = null;
        try {

            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_ADMINISTRATEURS);

            ResultSet result = ps.executeQuery();

            listeAdmins = new ArrayList<>();

            while (result.next()) {
                Administrateur admin = new Administrateur();
                admin.setId(result.getInt("ID"));
                admin.setPrenom(result.getString("Prénom"));
                admin.setNom(result.getString("Nom"));
                admin.setEmail(result.getString("Email"));
                admin.setRole(result.getString("Role"));
                admin.setNomUtilisateur(result.getString("NomUtilisateur"));
                admin.setMotDePasse(result.getString("MotDePasse"));
                admin.setPhoto(result.getString("photo"));
                listeAdmins.add(admin);
            };
        } catch (SQLException ex) {
            Logger.getLogger(GestionUtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return listeAdmins;
    }


}
