/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.dao;


import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Utilisateur;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author dahamada
 */
public class UtilisateurImplDaoTest {

    public static void main(String[] args) {
    testFindAll();
      //    testFindById();
      //   testFindByName();
       //   testFindByEmail();
       //  testExistsByEmailAndPassword();
          
      //  testCreate();
    // testCreate_Utilisateur_Role();
       //   testDelete();
      // testUpdate();
     //   testFindAll();
     //  testFindAllRole();
   
   //  testFindByNameRole();
  // testFindAllByNameRole();
    // testFindAll();
      
    }

    public static void testFindAll() {
        System.out.println("findAll");
        UtilisateurImplDao instance = new UtilisateurImplDao();
        // List<Utilisateur> expResult = null;
        List<Utilisateur> result = instance.findAll();
        // assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        System.out.println(result.get(0).afficherTitreDesColonnes());
        for (Utilisateur utilisateur : result) {
            System.out.println(utilisateur.toString());
        }
    }

    /**
     * Test of findById method, of class UtilisateurImplDao.
     */
    public static void testFindById() {
        System.out.println("findById");
        int id = 0;
        UtilisateurImplDao instance = new UtilisateurImplDao();
        System.out.println("Entrez l'ide l'utilisateur : ");
        Scanner lectureClavier = new Scanner(System.in);
        id = lectureClavier.nextInt();
        Utilisateur result = instance.findById(id);
        System.out.println(result.toString());

    }

    /**
     * Test of findByName method, of class UtilisateurImplDao.
     */
    public static void testFindByName() {
        System.out.println("findByName");
        String nom = "";
        UtilisateurImplDao instance = new UtilisateurImplDao();
        System.out.println("Entrez le nom de l'utilisateur : ");
        Scanner lectureClavier = new Scanner(System.in);
        nom = lectureClavier.next();
        Utilisateur result = instance.findByName(nom);
        System.out.println(result.toString());

    }

    public static void testFindByEmail() {
        System.out.println("findByEmail");
        String email = "";
        UtilisateurImplDao instance = new UtilisateurImplDao();
        System.out.println("Entrez le nom de l'utilisateur : ");
        Scanner lectureClavier = new Scanner(System.in);
        email = lectureClavier.next();
        Utilisateur result = instance.findByEmail(email);
        System.out.println(result.toString());
    }

    /**
     * Test of existsByEmailAndPassword method, of class UtilisateurImplDao.
     */
    public static void testExistsByEmailAndPassword() {
        System.out.println("existsByEmailAndPassword");
        String email = "";
        String motDePasse = "";
        UtilisateurImplDao instance = new UtilisateurImplDao();
        System.out.println("Entrez l'email de l'utilisateur : ");
        Scanner lectureClavier = new Scanner(System.in);
        email = lectureClavier.next();
        System.out.println("Entrez le mot depase de l'utilisateur : ");

        motDePasse = lectureClavier.next();
        Utilisateur result = instance.existsByEmailAndPassword(email, motDePasse);
        System.out.println(result.toString());

    }

    /**
     * Test of delete method, of class UtilisateurImplDao.
     */
    public static void testDelete() {
        System.out.println("delete");
        int id = 0;
        UtilisateurImplDao instance = new UtilisateurImplDao();
        System.out.println("Entrez l'ide l'utilisateur : ");
        Scanner lectureClavier = new Scanner(System.in);
        id = lectureClavier.nextInt();
        boolean result = instance.deleteUtil(id);
        if (result) {
            System.out.println("l'utilisateur dont l'id est " + id + " est supprimé de la base des données");
        } else {
            System.out.println("l'utilisateur dont l'id est " + id + " n'existe de la base des données");
        }

    }

    public static void testCreate() {
        System.out.println("create");
        Utilisateur utilisateur = null;
        UtilisateurImplDao instance = new UtilisateurImplDao();
        Scanner lectureClavier = new Scanner(System.in);
        System.out.println("Entrez email ");
        String email = lectureClavier.next();
        System.out.println("L'utilisateur est-il actif(oui/non)?");
        String reponse = lectureClavier.next();
        boolean active = reponse.equals("oui") ? true : false;

        System.out.println("Entrez le nom de l'utilisateur");
        String nom = lectureClavier.next();
        System.out.println("Entrez le prenom ");
        String prenom = lectureClavier.next();
        System.out.println("Entrez password");
        String password = lectureClavier.next();
        System.out.println("Entrez la photo");
        String photo = lectureClavier.next();
        
        utilisateur = new Utilisateur(email,active,nom,prenom,password,photo);
     
        boolean result = instance.createUtil(utilisateur);
        if (result) {
            System.out.println("insertion reussite");
        } else {
            System.out.println("insertion echec ");
        }

    }

    
    public static void testUpdate() {
        System.out.println("update");
        Utilisateur utilisateur = null;
        UtilisateurImplDao instance = new UtilisateurImplDao();
        Scanner lectureClavier = new Scanner(System.in);
        System.out.println("Entrez l'ide l'utilisateur à mettre à jour : ");
        int id = lectureClavier.nextInt();
        utilisateur = instance.findById(id);
        System.out.println("Entrez email ");
        String email = lectureClavier.next();
        utilisateur.setEmail(email);
        System.out.println("L'utilisateur est-il actif(oui/non)?");
        String reponse = lectureClavier.next();
        boolean active = reponse.equals("oui") ? true : false;
        utilisateur.setActive(active);

        System.out.println("Entrez password");
        String password = lectureClavier.next();
        utilisateur.setPassword(password);
        System.out.println("Entrez la photo");
        String photo = lectureClavier.next();
        utilisateur.setPhoto(photo);
        // utilisateur = new Utilisateur(email, active, nom, prenom, password, photo);
        boolean result = instance.updateUtil(utilisateur);
        if (result) {
            System.out.println("L'utilisateur est mis à jour ");
        } else {
            System.out.println("Echec de mis à jour ");
        }

    }
    

//    public static void testCreate_Utilisateur_Role() {
//        System.out.println("create role");
//        Utilisateur utilisateur = null;
//      //  Role role = null;
//        UtilisateurImplDao instance = new UtilisateurImplDao();
//        
//         Scanner lectureClavier = new Scanner(System.in);
//        System.out.println("Entrez email ");
//        String email = lectureClavier.next();
//        System.out.println("L'utilisateur est-il actif(oui/non)?");
//        String reponse = lectureClavier.next();
//        boolean active = reponse.equals("oui") ? true : false;
//
//        System.out.println("Entrez le nom de l'utilisateur");
//        String nom = lectureClavier.next();
//        System.out.println("Entrez le prenom ");
//        String prenom = lectureClavier.next();
//        System.out.println("Entrez password");
//        String password = lectureClavier.next();
//        System.out.println("Entrez la photo");
//        String photo = lectureClavier.next();
//        utilisateur = new Utilisateur(email, active, nom, prenom, password, photo);
//         //ajouter du role
//        System.out.println("Quel est le role de " + nom + " " + prenom + " ? ");
//        //   System.out.println("Entrez l'ide l'utilisateur : ");
//     
//      //  int id = lectureClavier.nextInt();
//        System.out.println("Choisir entre admin, vendeur, editeur, expediteur et assistant");
//        String roleUtilisateur = lectureClavier.next();
//        String userRole = roleUtilisateur.toLowerCase();
//   
//        boolean result = instance.createUtil(utilisateur, userRole);
//          if (result) {
//            System.out.println("L'utilisateur est mis à jour ");
//        } else {
//            System.out.println("Echec de mis à jour ");
//        }
//        
//       
//    }
    
//     public static void testFindAllRole() {
//        System.out.println("findAllRole");
//        UtilisateurImplDao instance = new UtilisateurImplDao();
//    
//        List<Role> result = instance.findAllRole();
//         System.out.println(result.get(1).afficherTitreDesColonnes());
//         for (Role role : result) {
//                 System.out.println(role.toString());
//         }
//     
//    }
//     
//       public static void testFindAllByNameRole() {
//        System.out.println("findAllByNameRole");
//        String nomRole = "";
//        UtilisateurImplDao instance = new UtilisateurImplDao();
//         Scanner lectureClavier = new Scanner(System.in);
//            System.out.println("Entrez le nom du role ");
//       nomRole = lectureClavier.next();
//        List<Utilisateur> result = instance.findAllByNameRole(nomRole);
//        System.out.println(result.get(0).afficherTitreDesColonnes());
//         for (Utilisateur utilisateur : result) {
//                 System.out.println(utilisateur.toString());
//         }
//     
//    }
//       
//       public static void testFindByNameRole() {
//        System.out.println("findByIdRole");
//         String nomRole = "";
//        UtilisateurImplDao instance = new UtilisateurImplDao();
//         Scanner lectureClavier = new Scanner(System.in);
//            System.out.println("Entrez le nom du role ");
//       nomRole = lectureClavier.next();
//        Utilisateur result = instance.findByNameRole(nomRole);
//          System.out.println(result.afficherTitreDesColonnes());
//           System.out.println(result.toString());
//      
//    }
}
