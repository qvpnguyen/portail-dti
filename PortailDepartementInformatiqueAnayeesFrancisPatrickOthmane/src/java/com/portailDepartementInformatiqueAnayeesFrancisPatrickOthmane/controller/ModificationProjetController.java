/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.controller;

import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.dao.GestionUtilisateurImplDao;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Cours;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Notes;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Professeur;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Projet;
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
public class ModificationProjetController extends HttpServlet {
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
        //Assignation du titre de la page à l'uri correspondant
        String pageName = "";
        if (request.getRequestURI().startsWith("modificationProjetController")) {
            pageName = "Portail du département informatique - Modification d'un projet";
        }
        
        String nom = request.getParameter("nomProjet");
        String annee = request.getParameter("annee");
        String[] membresEquipe = request.getParameterValues("membresEquipe");
        String description = request.getParameter("description");
        String video = request.getParameter("video");
        String lienGitlab = request.getParameter("lienGitlab");
        int anneeInt = 0;
        if (annee != null) {
            anneeInt = Integer.valueOf(annee);
        }
        
        String professeur = request.getParameter("professeur");
        int professeurID = 0;
        Professeur profModif = null;
        if (professeur != null) {
            professeurID = Integer.valueOf(professeur);
            profModif = dao.findProfById(professeurID);
        }
      
        String cours = request.getParameter("cours");
        int coursID = 0;
        Cours coursModif = null;
        if (cours != null) {
            coursID = Integer.valueOf(cours);
            coursModif = dao.findCoursById(coursID);
        }
        
        String notes = request.getParameter("notes");
        int notesID = 0;
        Notes notesModif = null;
        if (notes != null) {
            notesID = Integer.valueOf(notes);
//            notesModif = dao.findNotesById(notesID);
        }
        
        int projetID = Integer.parseInt(request.getParameter("id"));
        projet = dao.findProjetById(projetID);
//        projet.setNom(nom);
//        projet.setAnnee(anneeInt);
//        projet.setListeEquipeProjet(membresEquipe);
//        projet.setDescription(description);
//        projet.setVideo(video);
//        projet.setLienGitlab(lienGitlab);
//        projet.setCours(coursModif);
//        projet.setProfesseur(profModif);
//        projet.setNotes(notesModif);
        listeProfesseurs = dao.findAllProfesseurs();
        listeCours = dao.findAllCours();
        
//        retour = dao.updateProjet(projet);

        request.setAttribute("projet", projet);
        request.setAttribute("listeProfesseurs", listeProfesseurs);
        request.setAttribute("listeCours", listeCours);
        request.getRequestDispatcher("modificationProjet.jsp").forward(request, response);
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
