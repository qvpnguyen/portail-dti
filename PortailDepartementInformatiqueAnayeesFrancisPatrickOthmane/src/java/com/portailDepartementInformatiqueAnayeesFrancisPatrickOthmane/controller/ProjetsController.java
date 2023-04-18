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
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Anayees
 */
public class ProjetsController extends HttpServlet {

    private List<Projet> listeProjets = null;
    private Projet projet = null;
    private List<Professeur> listeProfesseurs = null;
    private List<Cours> listeCours = null;

    GestionUtilisateurImplDao dao = new GestionUtilisateurImplDao();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String[] profsChoisi = request.getParameterValues("professeurs");
        String[] coursChoisi = request.getParameterValues("cours");
        String[] anneeChoisi = request.getParameterValues("annee");

        //Assignation du titre de la page à l'uri correspondant
        String pageName = "";

        if (request.getRequestURI().endsWith("ProjetsController")) {
            pageName = "Portail du département informatique - Ensemble des projets";
        } else if (pageName.isEmpty()) {
            pageName = "Portail du département informatique - Ensemble des projets";
        }

        request.setAttribute("pageName", pageName);

        listeProjets = dao.findAllProjets();
        listeCours = dao.findAllCours();
        listeProfesseurs = dao.findAllProfesseurs();

        if (listeProjets != null) {
            request.setAttribute("listeProjets", listeProjets);

        }

        if (listeCours != null) {
            request.setAttribute("listeCours", listeCours);

        }

        if (listeProfesseurs != null) {
            request.setAttribute("listeProfesseurs", listeProfesseurs);
        }

        if (profsChoisi != null) {
            for (String professor : profsChoisi) {
                listeProjets = dao.findAllProjetsByNomPrenomProf(professor);
                request.setAttribute("listeProjets", listeProjets);

            }
        }

        if (coursChoisi != null) {
            for (String cours : coursChoisi) {
                listeProjets = dao.findAllProjetsByNomCours(cours);
                request.setAttribute("listeProjets", listeProjets);
            }
        }

        if (anneeChoisi != null) {
            for (String annee : anneeChoisi) {
                listeProjets = dao.findAllProjetsByAnnee(Integer.parseInt(annee));
                request.setAttribute("listeProjets", listeProjets);
            }
        }

        request.getRequestDispatcher("projets.jsp").forward(request, response);

        //listeCours = dao.findAllCoursByNomProfesseur(cours);
        //request.getRequestDispatcher("projets.jsp").forward(request, response);
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
