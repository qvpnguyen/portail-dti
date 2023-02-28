/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.dao;

import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Projet;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.singleton.ConnexionBD;
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
public class ProjetImplDao {
    
    private static final String SQL_SELECT_PROJETS = "select * from projet";
    
    
    public List<Projet> findAllProjet() {
        List<Projet> listeProjets = null;
        try {

            //Initialise la requête préparée basée sur la connexion
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_PROJETS);
               System.out.println(" result : " + ps.toString());
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();
               
            listeProjets = new ArrayList<>();
            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                Projet projet = new Projet();
                 
                projet.setId(result.getInt("Id"));
                projet.setNom(result.getString("Nom"));
              projet.setAnnee(result.getDate("Annee"));
                projet.setDescription(result.getString("Description"));
                projet.setVideo(result.getString("Video"));
                projet.setLienGitlab(result.getString("LienGitLab"));
                projet.setNotesID(result.getInt("NotesID"));
                projet.setId(result.getInt("ProfesseurID"));
                listeProjets.add(projet);
            };
        } catch (SQLException ex) {
            Logger.getLogger(ProjetImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return listeProjets;
    }
    
}
