/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.dao;


import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Professeur;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Utilisateur;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Visiteur;
import java.util.List;
import javax.management.relation.Role;

/**
 *
 * @author dahamada
 */
public interface UtilisateurDao {

    List<Utilisateur> findAll();

    Utilisateur findById(int id);

    Utilisateur findByName(String nom);

    Utilisateur findByEmail(String email);

    Utilisateur findByNameRole(String nomRole);

    List<Utilisateur> findAllByNameRole(String nomRole);

    Utilisateur existsByEmailAndPassword(String email, String motDePasse);

    boolean deleteUtil(int id);

    boolean createUtil(Utilisateur utilisateur);


    boolean updateUtil(Utilisateur utilisateur);

}
