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
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author patri
 */
public class SauvegardeProjetController extends HttpServlet {
    private List<Professeur> listeProfesseurs = null;
    private List<Cours> listeCours = null;
    Projet projet = null;
    boolean retour = false;
    GestionUtilisateurImplDao dao = new GestionUtilisateurImplDao();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String nom = request.getParameter("nomProjet");
        String annee = request.getParameter("annee");
        int anneeInt = 0;
        if (annee != null) {
            anneeInt = Integer.valueOf(annee);
        }
        System.out.println("annee!!!!!"+annee);
        System.out.println("anneeInt!!!!!"+anneeInt);
        String professeur = request.getParameter("professeur");
        int professeurID = 0;
        if (professeur != null) {
            professeurID = Integer.valueOf(professeur);
        }
        System.out.println("professeur!!!!!"+professeur);
        String cours = request.getParameter("cours");
        int coursID = 0;
        if (cours != null) {
            coursID = Integer.valueOf(cours);
        }
        System.out.println("cours!!!!!"+cours);
        String[] membresEquipe = request.getParameterValues("membresEquipe");
//        List<String> liste = Arrays.asList(membresEquipe);
//        List<Etudiant> listeEquipeProjet = new ArrayList(liste);
        String description = request.getParameter("description");
        String video = request.getParameter("video");
        String lienGitlab = request.getParameter("lienGitlab");
        listeProfesseurs = dao.findAllProfesseurs();
        listeCours = dao.findAllCours();
        Cours unCours = new Cours();
        unCours.setId(coursID);
        Professeur unProf = new Professeur();
        unProf.setId(professeurID);
        projet = new Projet(nom, anneeInt, membresEquipe, description, video, lienGitlab, unCours, unProf);
        retour = dao.createProjet(projet);
        if (retour) {
            String message = String.format("Le projet %s a été créé avec succès", nom);
            request.setAttribute("message", message);
            request.setAttribute("projet", projet);
            request.setAttribute("listeProfesseurs", listeProfesseurs);
            request.setAttribute("listeCours", listeCours);
            request.getRequestDispatcher("creationDepotProjet.jsp").forward(request, response);
        } else {
            request.setAttribute("listeProfesseurs", listeProfesseurs);
            request.setAttribute("listeCours", listeCours);
            request.getRequestDispatcher("creationDepotProjet.jsp").forward(request, response);
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
