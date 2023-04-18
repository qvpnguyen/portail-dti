/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.controller;

import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.dao.GestionUtilisateurImplDao;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Cours;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Etudiant;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.NoteDeCours;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Professeur;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author othma
 */
public class CreationNotesCoursController extends HttpServlet {

    GestionUtilisateurImplDao dao = new GestionUtilisateurImplDao();
    //private List<NoteDeCours> listeNotesCours;
    NoteDeCours notes = null;
    boolean retour = false;
    List<Professeur> listeProfesseurs = new ArrayList();
    List<Cours> listeCours = new ArrayList();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        //Assignation du titre de la page à l'uri correspondant
        String pageName = "";

        if (request.getRequestURI().endsWith("notesController")) {
            pageName = "Portail du département informatique - Création note de cours";
        } else if (pageName.isEmpty()) {
            pageName = "Portail du département informatique - Création note de cours";
        }

        request.setAttribute("pageName", pageName);

        String lien = request.getParameter("lien");
        String nom = request.getParameter("nom");

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

        String document = request.getParameter("documentNotesCours");

        listeProfesseurs = dao.findAllProfesseurs();
        listeCours = dao.findAllCours();

        Cours unCours = new Cours();
        unCours.setId(coursID);
        Professeur unProf = new Professeur();
        unProf.setId(professeurID);
        notes = new NoteDeCours(nom, lien, unCours, unProf, document);
        System.out.println("Tessssssssssssssssssssssssssssssssst");
        System.out.println(listeProfesseurs.get(0).toString());
        System.out.println(listeCours.get(0).toString());
        System.out.println(notes.toString());
        retour = dao.createNotesDeCours(notes);
        if (retour) {
            String message = String.format("Le note de cours " + nom + " a été créé avec succès");
            request.setAttribute("message", message);
            request.setAttribute("listeProfesseurs", listeProfesseurs);
            request.setAttribute("listeCours", listeCours);

            request.getRequestDispatcher("notesDeCoursController").forward(request, response);

        }
        request.setAttribute("listeCours", listeCours);
        request.setAttribute("listeProfesseurs", listeProfesseurs);
        request.getRequestDispatcher("creationDepotNotesCours.jsp").include(request, response);

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
