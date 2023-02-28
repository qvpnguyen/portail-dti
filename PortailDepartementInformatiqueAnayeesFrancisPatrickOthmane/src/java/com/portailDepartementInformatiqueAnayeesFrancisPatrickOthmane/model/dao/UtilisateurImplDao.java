/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.dao;


import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Utilisateur;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.singleton.ConnexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.relation.Role;

/**
 *
 * @author dahamada
 */
public class UtilisateurImplDao implements UtilisateurDao {
    
 //Utilisateur
//SELECT * FROM mangerbiodb.utilisateurs, mangerbiodb.roles where mangerbiodb.utilisateurs.id =5 ;
    private static final String SQL_SELECT_UTILISATEURS = "select * from utilisateurs";
    private static final String SQL_SELECT_UTILISATEUR_PAR_ID = "select * from utilisateurs where id = ?";
    private static final String SQL_SELECT_UTILISATEUR_PAR_NOM = "select * from utilisateurs where nom = ?";
    private static final String SQL_SELECT_UTILISATEUR_PAR_EMAIL = "select * from utilisateurs where email = ?";
//    private static final String SQL_SELECT_ROLES = "select * from roles ";
//    private static final String SQL_SELECT_ROLE_PAR_NOM_ROLE = "select * from roles where nom = ? ";
   private static final String SQL_SELECT_UTILISATEUR_PAR_NOM_ROLE ="SELECT * from utilisateurs u join utilisateurs_roles ur on u.id = ur.utilisateur_id join roles r on ur.role_id = r.id where r.nom=? ";

    private static final String SQL_INSERT_UTILISATEUR = "insert into utilisateurs(email,active,nom,prenom,password, photo) value(?,?,?,?,?,?)";
  //  private static final String SQL_INSERT_ROLE = "insert into roles(nom, description) value(?,?)";
//    private static final String SQL_INSERT_UTILISATEUR_ROLE = "insert into utilisateurs_roles(utilisateur_id,role_id) value(?,?)";
    private static final String SQL_UPDATE_UTILISATEUR = "update utilisateurs set email =?, active =?,password = ? where id = ?";

    //"DELETE FROM intermediary_table WHERE parent_id = ?");
    private static final String SQL_DELETE_UTILISATEUR_ROLE_PAR_UTILISATEUR_ID = "delete from utilisateurs_roles where utilisateur_id = ?";
    //"DELETE FROM child_table1 WHERE id IN (SELECT child_id FROM intermediary_table WHERE parent_id = ?)");
    private static final String SQL_DELETE_ROLE_ID_EGAL_UTILISATEUR_ID = "delete from roles where id IN(select role_id from utilisateurs_roles where utilisateur_id = ?)";
    //"DELETE FROM child_table2 WHERE id IN (SELECT child_id FROM intermediary_table WHERE parent_id = ?)");
    private static final String SQL_DELETE_UTILISATEUR_ID_EGAL_ROLE_ID = "delete from utilisateurs where id IN(select utilisateur_id from utilisateurs_roles where role_id = ?)";
    // "DELETE FROM parent_table WHERE id = ?");
    private static final String SQL_DELETE_UTILISATEUR_PAR_ID = "delete from utilisateurs where id = ?";
    private static final String SQL_CONNEXION_PAR_EMAIL_AND_PASSWORD = "select nom, prenom from utilisateurs where email=? and password=?";
  //  private static final String SQL_DESACTIVER_CONTRAINTS = "SET FOREIGN_KEY_CHECKS = 0";
   // private static final String SQL_ACTIVER_CONTRAINTS = "SET FOREIGN_KEY_CHECKS = 1";
        
    private static final String SQL_SELECT_NOTES = "select * from note";

    @Override
    public List<Utilisateur> findAll() {
        List<Utilisateur> listeUtilisateurs = null;
        try {

            //Initialise la requête préparée basée sur la connexion
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_UTILISATEURS);
               System.out.println(" result : " + ps.toString());
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();
               
            listeUtilisateurs = new ArrayList<>();
            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                Utilisateur utilisateur = new Utilisateur();
                 System.out.println(" result : " + result.getString("email"));
                utilisateur.setId(result.getInt("id"));
                utilisateur.setEmail(result.getString("email"));
                utilisateur.setActive(result.getBoolean("active"));
                utilisateur.setNom(result.getString("nom"));
                utilisateur.setPrenom(result.getString("prenom"));
                utilisateur.setPassword(result.getString("password"));
                utilisateur.setPhoto(result.getString("photo"));
                listeUtilisateurs.add(utilisateur);
            };
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return listeUtilisateurs;
    }

    @Override
    public Utilisateur findById(int id) {
        Utilisateur utilisateur = null;
        try {

            //Initialise la requête préparée basée sur la connexion
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_UTILISATEUR_PAR_ID);
            // on initialise la propriété id du bean avec sa valeur
            ps.setInt(1, id);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();

            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                utilisateur = new Utilisateur();
                utilisateur.setId(result.getInt("id"));
                utilisateur.setEmail(result.getString("email"));
                utilisateur.setActive(result.getBoolean("active"));
                utilisateur.setNom(result.getString("nom"));
                utilisateur.setPrenom(result.getString("prenom"));
                utilisateur.setPassword(result.getString("password"));
                utilisateur.setPhoto(result.getString("photo"));

            };
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return utilisateur;
    }

    @Override
    public Utilisateur findByName(String nom) {
        Utilisateur utilisateur = null;
        try {

            //Initialise la requête préparée basée sur la connexion
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_UTILISATEUR_PAR_NOM);
            // on initialise la propriété nom du bean avec sa premiere valeur
            ps.setString(1, nom);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();

            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                utilisateur = new Utilisateur();
                utilisateur.setId(result.getInt("id"));
                utilisateur.setEmail(result.getString("email"));
                utilisateur.setActive(result.getBoolean("active"));
                utilisateur.setNom(result.getString("nom"));
                utilisateur.setPrenom(result.getString("prenom"));
                utilisateur.setPassword(result.getString("password"));
                utilisateur.setPhoto(result.getString("photo"));

            };
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return utilisateur;
    }

    @Override
    public Utilisateur findByEmail(String email) {
        Utilisateur utilisateur = null;
        try {

            //Initialise la requête préparée basée sur la connexion
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_UTILISATEUR_PAR_EMAIL);
            // on initialise la propriété email du bean avec sa premiere valeur
            ps.setString(1, email);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();

            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                utilisateur = new Utilisateur();
                utilisateur.setId(result.getInt("id"));
                utilisateur.setEmail(result.getString("email"));
                utilisateur.setActive(result.getBoolean("active"));
                utilisateur.setNom(result.getString("nom"));
                utilisateur.setPrenom(result.getString("prenom"));
                utilisateur.setPassword(result.getString("password"));
                utilisateur.setPhoto(result.getString("photo"));

            };
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return utilisateur;
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
    
    public boolean deleteUtil(int id) {
        boolean retour = false;
        int nbLigne = 0;

        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        PreparedStatement ps3 = null;
        PreparedStatement ps;

        try {
            ps1 = ConnexionBD.getConnection().prepareStatement(SQL_DELETE_UTILISATEUR_ROLE_PAR_UTILISATEUR_ID);
            ps2 = ConnexionBD.getConnection().prepareStatement(SQL_DELETE_ROLE_ID_EGAL_UTILISATEUR_ID);
            ps3 = ConnexionBD.getConnection().prepareStatement(SQL_DELETE_UTILISATEUR_ID_EGAL_ROLE_ID);

            ps = ConnexionBD.getConnection().prepareStatement(SQL_DELETE_UTILISATEUR_PAR_ID);

            // Supprimer les lignes dans la table intermédiaire qui dépendent de la ligne parente
            ps1.setInt(1, id);
            ps1.executeUpdate();
            // Supprimer les lignes enfants dans les deux tables qui dépendent de la ligne parente
            ps2.setInt(1, id);
            ps2.executeUpdate();
            ps3.setInt(1, id);
            ps3.executeUpdate();

            // Supprimer la ligne parente
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }
     
    public boolean createUtil(Utilisateur utilisateur) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;

        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_INSERT_UTILISATEUR);
            //   Insérer les données dans la table parente, utilisateurs
            ps.setString(1, utilisateur.getEmail());
            ps.setBoolean(2, utilisateur.isActive());
            ps.setString(3, utilisateur.getNom());
            ps.setString(4, utilisateur.getPrenom());

            ps.setString(5, utilisateur.getPassword());
            ps.setString(6, utilisateur.getPhoto());
            nbLigne = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(UtilisateurImplDao.class.getName()).log(Level.SEVERE, null, e);
        }

//		System.out.println("nb ligne " + nbLigne);
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }


    public boolean updateUtil(Utilisateur utilisateur) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;

        try {

            ps = ConnexionBD.getConnection().prepareStatement(SQL_UPDATE_UTILISATEUR);
            ps.setString(1, utilisateur.getEmail());
            ps.setBoolean(2, utilisateur.isActive());

            ps.setString(3, utilisateur.getPassword());

            ps.setInt(4, utilisateur.getId());

            nbLigne = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(UtilisateurImplDao.class.getName()).log(Level.SEVERE, null, e);
        }

//		System.out.println("nb ligne " + nbLigne);
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }

    @Override
    public Utilisateur existsByEmailAndPassword(String email, String motDePasse) {
        Utilisateur utilisateur = null;
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
                utilisateur = new Utilisateur();

                utilisateur.setNom(result.getString("nom"));
                utilisateur.setPrenom(result.getString("prenom"));

            };
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return utilisateur;
    }

    @Override
    public List<Utilisateur> findAllByNameRole(String nomRole) {
            List<Utilisateur> listeUtilisateurs = null;
        try {

            //Initialise la requête préparée basée sur la connexion
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_UTILISATEUR_PAR_NOM_ROLE);
             ps.setString(1, nomRole);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();
            listeUtilisateurs = new ArrayList<>();
            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                 Utilisateur utilisateur = new Utilisateur();
                utilisateur.setId(result.getInt("id"));
                utilisateur.setEmail(result.getString("email"));
                utilisateur.setActive(result.getBoolean("active"));
                utilisateur.setNom(result.getString("nom"));
                utilisateur.setPrenom(result.getString("prenom"));
                utilisateur.setPassword(result.getString("password"));
                utilisateur.setPhoto(result.getString("photo"));
                  utilisateur.setNom(result.getString("description"));
             utilisateur.setNom(result.getString("nom"));
                listeUtilisateurs.add(utilisateur);
            };
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return listeUtilisateurs;
    }

    @Override
    public Utilisateur findByNameRole(String nomRole) {
           Utilisateur utilisateur = null;
        try {

            //Initialise la requête préparée basée sur la connexion
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_UTILISATEUR_PAR_NOM_ROLE);
             ps.setString(1, nomRole);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();
           /// utilisateur = new Utilisateur();
            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                utilisateur = new Utilisateur();
                utilisateur.setId(result.getInt("id"));
                utilisateur.setEmail(result.getString("email"));
                utilisateur.setActive(result.getBoolean("active"));
                utilisateur.setNom(result.getString("nom"));
                utilisateur.setPrenom(result.getString("prenom"));
                utilisateur.setPassword(result.getString("password"));
                utilisateur.setPhoto(result.getString("photo"));
                
              
            };
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return utilisateur;
    }

}
