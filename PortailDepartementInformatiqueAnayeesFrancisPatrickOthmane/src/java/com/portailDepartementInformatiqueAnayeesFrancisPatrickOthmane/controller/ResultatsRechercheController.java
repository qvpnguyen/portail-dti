/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.controller;

import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.dao.GestionUtilisateurImplDao;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Cours;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.NoteDeCours;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Notes;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Professeur;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Projet;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Anayees
 */
public class ResultatsRechercheController extends HttpServlet {

    Projet projet = null;
    List<Projet> listeProjets = null;
    NoteDeCours noteCours = null;
    Professeur profDuProjet = null;
    Notes notes = null;
    GestionUtilisateurImplDao dao = new GestionUtilisateurImplDao();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String pageName = "";
        String cours = "";

//        if (request.getRequestURI().endsWith("resultatsRechercheController")) {
//            pageName = "Portail du Département Informatique - Résultat(s) de votre recherche";
//        } else if (pageName.isEmpty()) {
//            pageName = "Portail du Département Informatique - Résultat(s) de votre recherche";
//        }
        //System.out.println("Setting pageName to " + pageName);
        //System.out.println("pageName attribute set: " + request.getAttribute("pageName"));
        String query = request.getParameter("query");

        if (query != null && !query.equals("")) {

            if (request.getRequestURI().endsWith("resultatsRechercheController")) {
                pageName = "Portail du Département Informatique - Résultat(s) de : <i>" + query + "</i>";
            } else if (pageName.isEmpty()) {
                pageName = "Portail du Département Informatique - Résultat(s) de : " + query;
            }
            request.setAttribute("pageName", pageName);

            projet = dao.findProjetByName(query);
            profDuProjet = dao.findProfByProjectName(query);
            noteCours = dao.findNotesDeCoursByName(query);
            listeProjets = dao.findAllProjetsByNomPrenomProf(query);

            if (projet != null) {
                notes = dao.findNoteByProjet(projet.getNom());
                System.out.println(notes);
                //System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                request.setAttribute("results", projet);
                request.setAttribute("notes", notes);
                request.setAttribute("profDuProjet", profDuProjet);
                System.out.println("");
                request.getRequestDispatcher("projetEtudiants.jsp").forward(request, response);
            } else if (listeProjets != null) {

                request.setAttribute("listeProjets", listeProjets);
                request.getRequestDispatcher("projets.jsp").forward(request, response);

            }
        }
        //else {
//                request.getRequestDispatcher("EtudiantController").forward(request, response);
//
//            }
//
////            if (noteCours != null) {
////                request.setAttribute("results", noteCours);
////                request.getRequestDispatcher("resultatRecherche.jsp").forward(request, response);
////            } else {
////                request.getRequestDispatcher("EtudiantController").forward(request, response);
////
////            }
//            
//        }
//
//        if (nomProjet != null) {
//            projet = dao.findProjetByName(nomProjet);
//            profDuProjet = dao.findProfByProjectName(nomProjet);
//            noteCours = dao.findNotesDeCoursByName(nomProjet);
//            System.out.println(projet);
//            notes = dao.findNoteByProjet(projet.getNom());
//            System.out.println("############################################");
//            System.out.println(notes);
//
//            if (projet != null) {
//                request.setAttribute("results", projet);
//                request.setAttribute("notes", notes);
//                request.setAttribute("profDuProjet", profDuProjet);
//                request.getRequestDispatcher("projetEtudiants.jsp").forward(request, response);
//            } else {
//                request.getRequestDispatcher("EtudiantController").forward(request, response);
//
//            }
//
////            if (noteCours != null) {
////                request.setAttribute("results", noteCours);
////                request.getRequestDispatcher("resultatRecherche.jsp").forward(request, response);
////            } else {
////                request.getRequestDispatcher("EtudiantController").forward(request, response);
////
////            }
//        }
//
//        request.getRequestDispatcher("resultatRecherche.jsp").include(request, response);

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
