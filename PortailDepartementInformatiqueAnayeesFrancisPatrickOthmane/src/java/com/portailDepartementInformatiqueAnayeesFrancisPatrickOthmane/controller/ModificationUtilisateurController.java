/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.controller;

import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.dao.GestionUtilisateurImplDao;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Utilisateur;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author patri
 */
public class ModificationUtilisateurController extends HttpServlet {
    private List listeUtilisateurs;
    Utilisateur utilisateur = null;
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
        
        String id = request.getParameter("id");
        int utilisateurId = Integer.parseInt(id);
        String role = request.getParameter("btnradio");
        String prenom = request.getParameter("prenom");
        String nom = request.getParameter("nom");
        String dateDeNaissance = request.getParameter("dateDeNaissance");
        String profil = request.getParameter("profil");
        String numeroUtilisateur = request.getParameter("numeroUtilisateur");
        String courriel = request.getParameter("courriel");
        String motDePasse = request.getParameter("motDePasse");
        String confirmerMotDePasse = request.getParameter("confirmerMotDePasse");
        String active = request.getParameter("active");
        boolean status = Boolean.valueOf(active);
        
        switch (role) {
            case "Étudiant":
                utilisateur = dao.findEtudiantById(utilisateurId);
                break;
            case "Professeur":
                utilisateur = dao.findProfById(utilisateurId);
                break;
            case "Visiteur":
                utilisateur = dao.findVisiteurById(utilisateurId);
                break;
        }
        utilisateur.setPrenom(prenom);
        utilisateur.setNom(nom);
        if (!motDePasse.equals(confirmerMotDePasse)) {
            String message = "Le mot de passe doit être identique dans les deux champs";
            request.setAttribute("message", message);
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
