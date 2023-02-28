/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.dao;


import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Professeur;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.singleton.ConnexionBD;
import java.sql.Connection;
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
public class ProfesseurImpDao implements ProfesseurDao {
    
    //SELECT * FROM mangerbiodb.utilisateurs, mangerbiodb.roles where mangerbiodb.utilisateurs.id =5 ;
    private static final String SQL_SELECT_PROFESSEURS = "select * from professeur";
    private static final String SQL_SELECT_PROFESSEUR_PAR_ID = "select * from professeur where id = ?";
    private static final String SQL_SELECT_PROFESSEUR_PAR_NOM = "select * from professeur where nom = ?";
    private static final String SQL_SELECT_PROFESSEUR_PAR_EMAIL = "select * from professeur where email = ?";
    
    private static final String SQL_SELECT_PROFESSEUR_PAR_DISPO = "select * from professeur where active= ?";

    private static final String SQL_INSERT_PROFESSEUR = "insert into professeur(email,active,nom,prenom,password, photo) value(?,?,?,?,?,?)";
  //  private static final String SQL_INSERT_ROLE = "insert into roles(nom, description) value(?,?)";
    private static final String SQL_UPDATE_PROFESSEUR = "update professeur set email =?, active =?,password = ? where id = ?";

    private static final String SQL_DELETE_PROFESSEUR_PAR_ID = "delete from professeur where id = ?";
    private static final String SQL_CONNEXION_PAR_EMAIL_AND_PASSWORD = "select nom, prenom from professeur where email=? and password=?";
  //  private static final String SQL_DESACTIVER_CONTRAINTS = "SET FOREIGN_KEY_CHECKS = 0";
   // private static final String SQL_ACTIVER_CONTRAINTS = "SET FOREIGN_KEY_CHECKS = 1";

    @Override
    public List<Professeur> findAll() {
        List<Professeur> listeProfesseurs = null;
        try {

            //Initialise la requête préparée basée sur la connexion
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_PROFESSEURS);
               System.out.println(" result : " + ps.toString());
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();
               
            listeProfesseurs = new ArrayList<>();
            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                Professeur professeur = new Professeur();
                System.out.println(" result : " + result.getString("email"));
                professeur.setId(result.getInt("id"));
                professeur.setEmail(result.getString("email"));
                professeur.setActive(result.getBoolean("active"));
                professeur.setNom(result.getString("nom"));
                professeur.setPrenom(result.getString("prenom"));
                professeur.setPassword(result.getString("password"));
                professeur.setPhoto(result.getString("photo"));
                listeProfesseurs.add(professeur);
            };
        } catch (SQLException ex) {
            Logger.getLogger(ProfesseurImpDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return listeProfesseurs;
    }

    @Override
    public Professeur findById(int id) {
        Professeur professeur = null;
        try {

            //Initialise la requête préparée basée sur la connexion
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_PROFESSEUR_PAR_ID);
            // on initialise la propriété id du bean avec sa valeur
            ps.setInt(1, id);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();

            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                professeur = new Professeur();
                
                professeur.setId(result.getInt("id"));
                professeur.setEmail(result.getString("email"));
                professeur.setActive(result.getBoolean("active"));
                professeur.setNom(result.getString("nom"));
                professeur.setPrenom(result.getString("prenom"));
                professeur.setPassword(result.getString("password"));
                professeur.setPhoto(result.getString("photo"));

            };
        } catch (SQLException ex) {
            Logger.getLogger(ProfesseurImpDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return professeur;
    }

    @Override
    public Professeur findByName(String nom) {
        Professeur professeur = null;
        try {

            //Initialise la requête préparée basée sur la connexion
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_PROFESSEUR_PAR_NOM);
            // on initialise la propriété nom du bean avec sa premiere valeur
            ps.setString(1, nom);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();

            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                professeur = new Professeur();
                professeur.setId(result.getInt("id"));
                professeur.setEmail(result.getString("email"));
                professeur.setActive(result.getBoolean("active"));
                professeur.setNom(result.getString("nom"));
                professeur.setPrenom(result.getString("prenom"));
                professeur.setPassword(result.getString("password"));
                professeur.setPhoto(result.getString("photo"));

            };
        } catch (SQLException ex) {
            Logger.getLogger(ProfesseurImpDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return professeur;
    }

    @Override
    public Professeur findByEmail(String email) {
        Professeur professeur = null;
        try {

            //Initialise la requête préparée basée sur la connexion
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_PROFESSEUR_PAR_EMAIL);
            // on initialise la propriété email du bean avec sa premiere valeur
            ps.setString(1, email);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();

            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                professeur = new Professeur();
                
                professeur.setId(result.getInt("id"));
                professeur.setEmail(result.getString("email"));
                professeur.setActive(result.getBoolean("active"));
                professeur.setNom(result.getString("nom"));
                professeur.setPrenom(result.getString("prenom"));
                professeur.setPassword(result.getString("password"));
                professeur.setPhoto(result.getString("photo"));

            };
        } catch (SQLException ex) {
            Logger.getLogger(ProfesseurImpDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return professeur;
    }

    /*
    @Override
    public boolean delete(int id) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps1;
        PreparedStatement ps;
        try {
            // Désactiver les contraintes de clé étrangère
            ps1 = ConnexionBD.getConnection().prepareStatement(SQL_DESACTIVER_CONTRAINTS);
            ps1.executeUpdate();
            ps = ConnexionBD.getConnection().prepareStatement(SQL_DELETE);
            ps.setInt(1, id);

            nbLigne = ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }
*/
    
    @Override
    public boolean delete(int id) {
        boolean retour = false;
        int nbLigne = 0;

        PreparedStatement ps;

        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_DELETE_PROFESSEUR_PAR_ID);

            // Supprimer la ligne parente
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfesseurImpDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }
     
    @Override
    public boolean create(Professeur professeur) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;

        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_INSERT_PROFESSEUR);
            //   Insérer les données dans la table parente, utilisateurs
            ps.setString(1, professeur.getEmail());
            ps.setBoolean(2, professeur.isActive());
            ps.setString(3, professeur.getNom());
            ps.setString(4, professeur.getPrenom());

            ps.setString(5, professeur.getPassword());
            ps.setString(6, professeur.getPhoto());
            nbLigne = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(ProfesseurImpDao.class.getName()).log(Level.SEVERE, null, e);
        }

//		System.out.println("nb ligne " + nbLigne);
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }

    @Override
    public boolean update(Professeur professeur) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;

        try {

            ps = ConnexionBD.getConnection().prepareStatement(SQL_UPDATE_PROFESSEUR);
            ps.setString(1, professeur.getEmail());
            ps.setBoolean(2, professeur.isActive());

            ps.setString(3, professeur.getPassword());

            ps.setInt(4, professeur.getId());

            nbLigne = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(ProfesseurImpDao.class.getName()).log(Level.SEVERE, null, e);
        }

//		System.out.println("nb ligne " + nbLigne);
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }

    @Override
    public Professeur existsByEmailAndPassword(String email, String motDePasse) {
        Professeur professeur = null;
        try {

            //Initialise la requête préparée basée sur la connexion
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_CONNEXION_PAR_EMAIL_AND_PASSWORD);
            // on initialise la propriété email du bean avec sa premiere valeur
            ps.setString(1, email);
            ps.setString(2, motDePasse);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();

            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                professeur = new Professeur();

                professeur.setNom(result.getString("nom"));
                professeur.setPrenom(result.getString("prenom"));

            };
        } catch (SQLException ex) {
            Logger.getLogger(ProfesseurImpDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return professeur;
    }
    
    @Override
    public Professeur findAllProfByDispo(boolean active) {
        Professeur professeur = null;
        try {

            //Initialise la requête préparée basée sur la connexion
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_PROFESSEUR_PAR_DISPO);
            // on initialise la propriété email du bean avec sa premiere valeur
            ps.setBoolean(1, active);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();

            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                professeur = new Professeur();
                
                professeur.setId(result.getInt("id"));
                professeur.setEmail(result.getString("email"));
                professeur.setActive(result.getBoolean("active"));
                professeur.setNom(result.getString("nom"));
                professeur.setPrenom(result.getString("prenom"));
                professeur.setPassword(result.getString("password"));
                professeur.setPhoto(result.getString("photo"));

            };
        } catch (SQLException ex) {
            Logger.getLogger(ProfesseurImpDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return professeur;
    }
    
}
