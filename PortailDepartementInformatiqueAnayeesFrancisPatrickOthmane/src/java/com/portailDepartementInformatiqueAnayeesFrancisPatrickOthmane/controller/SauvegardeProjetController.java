/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.controller;

import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.dao.GestionUtilisateurImplDao;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Cours;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Etudiant;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Professeur;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Projet;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Utilisateur;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//import javax.persistence.Entity;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
import jakarta.persistence.Entity;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author patri
 */
public class SauvegardeProjetController extends HttpServlet {

    private List<Professeur> listeProfesseurs = null;
    private List<Etudiant> listeEtudiants = null;
    private ArrayList<Etudiant> listeEquipe = null;
    private List<Cours> listeCours = null;
    Utilisateur utilisateur = null;
    Etudiant etudiant = null;
    Etudiant recherche = null;
    Projet projet = null;
    boolean retour = false;
    GestionUtilisateurImplDao dao = new GestionUtilisateurImplDao();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String pageName = "";
        if (request.getRequestURI().endsWith("sauvegardeProjetController")) {
            pageName = "Portail du département informatique - Création d'un projet";
        }
        String nom = request.getParameter("nomProjet");
        String annee = request.getParameter("annee");
        int anneeInt = 0;
        if (annee != null) {
            anneeInt = Integer.valueOf(annee);
        }
        String professeur = request.getParameter("professeur");
        int professeurID = 0;
        if (professeur != null) {
            professeurID = Integer.valueOf(professeur);
        }
        String cours = request.getParameter("cours");
        int coursID = 0;
        if (cours != null) {
            coursID = Integer.valueOf(cours);
        }

        String[] membresEquipe = request.getParameterValues("membresEquipe");
        Etudiant[] membres = null;
        listeEquipe = new ArrayList<>();

//        System.out.println("MEMBRES: " + Arrays.toString(membres));
//        Etudiant[] equipe = null;
//        if (membresEquipe != null) {
//            String[] nomsComplets = membresEquipe[0].split(",");
//            equipe = new Etudiant[nomsComplets.length];
//            String[] prenoms = new String[nomsComplets.length];
//            String[] nomsFamille = new String[nomsComplets.length];
//            for (int i = 0; i < nomsComplets.length; i++) {
//                String[] parties = nomsComplets[i].trim().split(" ");
//                prenoms[i] = parties[0];
//                nomsFamille[i] = parties[1];
//                etudiant = dao.findEtudiantByPrenomNom(prenoms[i], nomsFamille[i]);
//                if (etudiant != null) {
//                    listeEquipe.add(etudiant);
//                    equipe[i] = etudiant;
//                }
//            }
//        }
        String description = request.getParameter("description");
        String video = request.getParameter("video");
        String lienGitlab = request.getParameter("lienGitlab");
        listeProfesseurs = dao.findAllProfesseurs();
        listeCours = dao.findAllCours();
        listeEtudiants = dao.findAllEtudiants();
        Cours unCours = new Cours();
        unCours.setId(coursID);
        Professeur unProf = new Professeur();
        unProf.setId(professeurID);
        projet = new Projet(nom, anneeInt, description, video, lienGitlab, unCours, unProf);
        retour = dao.createProjet(projet);

        if (membresEquipe != null) {
            membres = new Etudiant[membresEquipe.length];
            for (int i = 0; i < membresEquipe.length; i++) {
                recherche = dao.findEtudiantById(Integer.parseInt(membresEquipe[i]));
                if (recherche != null) {
                    //membres[i] = recherche;
                    projet.getListeEquipeProjet().add(recherche);
                    retour = dao.createEtudiantProjet(recherche.getId(), projet.getNom());

                }
            }
        }

        if (retour) {
            String message = String.format("Le projet %s a été créé avec succès", nom);
            request.setAttribute("message", message);
            request.setAttribute("projet", projet);
            request.setAttribute("listeProfesseurs", listeProfesseurs);
            request.setAttribute("listeCours", listeCours);
            request.setAttribute("listeEtudiants", listeEtudiants);
            request.setAttribute("pageName", pageName);
            request.getRequestDispatcher("creationDepotProjet.jsp").include(request, response);
        } else {
            request.setAttribute("listeProfesseurs", listeProfesseurs);
            request.setAttribute("listeCours", listeCours);
            request.setAttribute("listeEtudiants", listeEtudiants);
            request.setAttribute("pageName", pageName);
            request.getRequestDispatcher("creationDepotProjet.jsp").include(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
