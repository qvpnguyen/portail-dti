/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.controller;

import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.dao.GestionUtilisateurImplDao;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Notes;
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
 * @author othma
 */
public class ModificationNotesController extends HttpServlet {

    private List<Notes> listeNotes = null;
    Notes note = null;
    GestionUtilisateurImplDao dao = new GestionUtilisateurImplDao();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String pageName = "";

        if (request.getRequestURI().endsWith("modificationNotesController")) {
            
            pageName = "Portail du Département Informatique - Gestion des notes de projets";
            request.setAttribute("pageName", pageName);
        }

        String noteOb = request.getParameter("noteObtenue");
        String id = request.getParameter("id");
        String supp = request.getParameter("supprimer");

        if (noteOb != null && id != null) {
            
            int not = Integer.parseInt(noteOb);

            int idNote = Integer.parseInt(id);
            note = dao.findNoteById(idNote);
            note.setNoteObtenue(not);
            boolean retour = dao.updateNoteObtenue(note);
            if (retour) {
                listeNotes = dao.findAllNotes();
                request.setAttribute("listeNotes", listeNotes);
                request.getRequestDispatcher("evaluationProjet.jsp").forward(request, response);
            }

        }
        if (supp != null) {
            
            int idSupp = Integer.parseInt(supp);
            note = dao.findNoteById(idSupp);
            dao.deleteNotes(note);

            listeNotes = dao.findAllNotes();

            request.setAttribute("listeNotes", listeNotes);
            request.setAttribute("message", "la note avec ID : " + note.getId() + " est supprimee");

            request.getRequestDispatcher("evaluationProjet.jsp").forward(request, response);
        } else {

            listeNotes = dao.findAllNotes();
            request.setAttribute("listeNotes", listeNotes);
            request.getRequestDispatcher("evaluationProjet.jsp").forward(request, response);
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
