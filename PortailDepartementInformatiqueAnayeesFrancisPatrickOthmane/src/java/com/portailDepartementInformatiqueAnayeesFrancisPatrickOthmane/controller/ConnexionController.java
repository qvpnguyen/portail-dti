/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.controller;

import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.dao.GestionUtilisateurImplDao;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Administrateur;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Etudiant;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Professeur;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Visiteur;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

/**
 *
 * @author othma
 */
public class ConnexionController extends HttpServlet {

    Etudiant etudiant = null;
    Professeur professeur = null;
    Visiteur visiteur = null;
    Administrateur admin = null;
    GestionUtilisateurImplDao dao = new GestionUtilisateurImplDao();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        //Assignation du titre de la page à l'uri correspondant
        String pageName = "";
        String pagePrincipale = "";

        if (request.getRequestURI().endsWith("professeurController")) {
            pageName = "Portail du département informatique - Professeur";
        } else if (pageName.isEmpty()) {
            pageName = "Portail du département informatique - Professeur";
        }

        request.setAttribute("pageName", pageName);
        //request.getRequestDispatcher("professeur.jsp").include(request, response);

        String userType = request.getParameter("btnradio");
        String nomUtilisateur = request.getParameter("nomUtilisateur");
        String motDePasse = request.getParameter("motDePasse");
        etudiant = dao.existsByEmailAndPasswordEtudiant(nomUtilisateur, motDePasse);
        professeur = dao.existsByEmailAndPasswordProf(nomUtilisateur, motDePasse);
        visiteur = dao.existsByEmailAndPasswordVisiteur(nomUtilisateur, motDePasse);
        admin = dao.existsByEmailAndPasswordAdmin(nomUtilisateur, motDePasse);

        boolean retour = false;

        if (userType != null) {
            if (userType.equals("btnetudiant")) {
                if (etudiant != null) {
                    retour = true;
                    HttpSession session = request.getSession(true);
                    session.setAttribute("nom", etudiant.getNom());
                    session.setAttribute("prenom", etudiant.getPrenom());
                    pagePrincipale = "EtudiantController";
                    session.setAttribute("pagePrincipale", pagePrincipale);
                    request.getRequestDispatcher("EtudiantController").forward(request, response);
//                    request.getRequestDispatcher("enTete.jsp").include(request, response);
                }
                if (admin != null) {
                    retour = true;
                    HttpSession session = request.getSession(true);
                    session.setAttribute("nom", admin.getNom());
                    session.setAttribute("prenom", admin.getPrenom());
                    request.getRequestDispatcher("administration.jsp").forward(request, response);

                }
                if (!retour) {
                    ///   out.println("<center><b><font color=red>" + "L'email ou mot de passe invalide" + "</font><b></center>");
                    request.setAttribute("invalide", "L'email ou mot de passe est invalide");
                    request.getRequestDispatcher("index.jsp").forward(request, response);

                }

            } else if (userType.equals("btnprofesseur")) {
                if (professeur != null) {
                    retour = true;
                    HttpSession session = request.getSession(true);
                    session.setAttribute("nom", professeur.getNom());
                    session.setAttribute("prenom", professeur.getPrenom());
                    pagePrincipale = "professeurController";
                    session.setAttribute("pagePrincipale", pagePrincipale);
                    request.getRequestDispatcher("professeurController").forward(request, response);
                    //request.getRequestDispatcher("enTete.jsp").include(request, response);
                }
                if (admin != null) {
                    retour = true;
                    HttpSession session = request.getSession(true);
                    session.setAttribute("nom", admin.getNom());
                    session.setAttribute("prenom", admin.getPrenom());
                    request.getRequestDispatcher("administration.jsp").forward(request, response);

                }
                if (!retour) {
                    ///   out.println("<center><b><font color=red>" + "L'email ou mot de passe invalide" + "</font><b></center>");
                    request.setAttribute("invalide", "L'email ou mot de passe est invalide");
                    request.getRequestDispatcher("index.jsp").forward(request, response);

                }

            } else if (userType.equals("btnvisiteur")) {
                if (visiteur != null) {
                    retour = true;
                    HttpSession session = request.getSession(true);
                    session.setAttribute("nom", visiteur.getNom());
                    session.setAttribute("prenom", visiteur.getPrenom());
                    request.getRequestDispatcher("ProjetsController").forward(request, response);

                }
                if (admin != null) {
                    retour = true;
                    HttpSession session = request.getSession(true);
                    session.setAttribute("nom", admin.getNom());
                    session.setAttribute("prenom", admin.getPrenom());
                    request.getRequestDispatcher("administration.jsp").forward(request, response);

                }
                if (!retour) {
                    ///   out.println("<center><b><font color=red>" + "L'email ou mot de passe invalide" + "</font><b></center>");
                    request.setAttribute("invalide", "L'email ou mot de passe est invalide");
                    request.getRequestDispatcher("index.jsp").forward(request, response);

                }
            }
        } else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
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
