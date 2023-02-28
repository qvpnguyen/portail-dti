/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.config;

/**
 *
 * @author dahamada
 */
public interface ConfigBD {
           //  Définir l’url de connexion avec le nom de la base donné
                                                // Changer le nom de la base de donnée [here]
        public final static String URL = "jdbc:mysql://127.0.0.1:3306/portailDB?serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
        //utilisateur de la bd
        public final static String USER ="root";
        //mot de passe de la bd
        public final static String PASSWORD ="root";
         // le driver mysql
        public final static String DRIVER="com.mysql.cj.jdbc.Driver";
}
