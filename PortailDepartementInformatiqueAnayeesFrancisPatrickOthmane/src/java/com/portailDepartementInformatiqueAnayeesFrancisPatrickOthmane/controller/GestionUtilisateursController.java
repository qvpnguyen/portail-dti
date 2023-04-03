/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.controller;

import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.dao.GestionUtilisateurImplDao;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Utilisateur;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author patri
 */
public class GestionUtilisateursController extends HttpServlet {
    private List listeUtilisateurs = null;
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
        String operation = request.getParameter("operation");
        String id = request.getParameter("id");
        
        //Assignation du titre de la page à l'uri correspondant
        String pageName = "";
        
        if (request.getRequestURI().endsWith("gestionProjetsController")){
            pageName = "Gestion des utilisateurs";
        }if (operation != null) {
            if (operation.equals("modifier")) {
                int utilisateurId = Integer.parseInt(id);
                utilisateur = dao.findEtudiantById(utilisateurId);
                if (utilisateur == null) {
                    utilisateur = dao.findProfById(utilisateurId);
                }
                if (utilisateur == null) {
                    utilisateur = dao.findVisiteurById(utilisateurId);
                }
                request.setAttribute("utilisateur", utilisateur);
                request.getRequestDispatcher("modificationUtilisateur.jsp").forward(request, response);
            } else {
                String message = "L'utilisateur dont l'id est " + id + "a été supprimé";
                int utilisateurId = Integer.parseInt(id);
                retour = dao.deleteEtudiant(utilisateurId);
                if (!retour) {
                    retour = dao.deleteProf(utilisateurId);
                }
                if (!retour) {
                    retour = dao.deleteVisiteur(utilisateurId);
                }
                if (retour) {
                    request.setAttribute("message", message);
                    listeUtilisateurs = dao.findAllVisiteurs();
                    listeUtilisateurs.addAll(dao.findAllEtudiants());
                    listeUtilisateurs.addAll(dao.findAllProfesseurs());
                    listeUtilisateurs.addAll(dao.findAllAdmins());
                    request.setAttribute("listeUtilisateurs", listeUtilisateurs);
                    request.getRequestDispatcher("gestionUtilisateurs.jsp").forward(request, response);
                }
                
            }
        } else {
            listeUtilisateurs = dao.findAllVisiteurs();
            listeUtilisateurs.addAll(dao.findAllEtudiants());
            listeUtilisateurs.addAll(dao.findAllProfesseurs());
            listeUtilisateurs.addAll(dao.findAllAdmins());
            request.setAttribute("listeUtilisateurs", listeUtilisateurs);
            request.setAttribute("pageName", pageName);
            request.getRequestDispatcher("gestionUtilisateurs.jsp").forward(request, response);
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
