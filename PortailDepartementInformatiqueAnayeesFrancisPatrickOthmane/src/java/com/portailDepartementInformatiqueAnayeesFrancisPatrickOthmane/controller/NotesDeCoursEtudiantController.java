/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.controller;

import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.dao.GestionUtilisateurImplDao;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.NoteDeCours;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Anayees
 */
public class NotesDeCoursEtudiantController extends HttpServlet {

    GestionUtilisateurImplDao dao = new GestionUtilisateurImplDao();
    private List<NoteDeCours> listeNotesCours;
    NoteDeCours notes = null;

    protected void processRequest(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response)
            throws jakarta.servlet.ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        //Assignation du titre de la page à l'uri correspondant
        String pageName = "";

        if (request.getRequestURI().endsWith("notesDeCoursController")) {
            pageName = "Portail du département informatique - Gestion des notes de cours";
        } else if (pageName.isEmpty()) {
            pageName = "Portail du département informatique - Gestion des notes de cours";
        }

        request.setAttribute("pageName", pageName);

        String note = request.getParameter("note");
        if (note != null && !note.equals("")) {
            notes = dao.findNotesDeCoursByName(note);
            request.setAttribute("notes", notes);
            request.getRequestDispatcher("gestionNotesCours_1.jsp").forward(request, response);
        } else {

            listeNotesCours = dao.findAllNotesDeCours();
            request.setAttribute("listeNotesCours", listeNotesCours);
            request.getRequestDispatcher("gestionNotesCours_1.jsp").forward(request, response);
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
