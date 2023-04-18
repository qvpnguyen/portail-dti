/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.controller;

import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.dao.GestionUtilisateurImplDao;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Cours;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Etudiant;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.NoteDeCours;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Notes;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Professeur;
import com.portailDepartementInformatiqueAnayeesFrancisPatrickOthmane.model.entities.Projet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
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
public class CreationNotesController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    GestionUtilisateurImplDao dao = new GestionUtilisateurImplDao();
    //private List<NoteDeCours> listeNotesCours;
    Notes notes = null;
    boolean retour = false;
    List<Etudiant> listeEtudiants = new ArrayList();
    List<Cours> listeCours = new ArrayList();
    List<Projet> listeProjets = new ArrayList();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String session = request.getParameter("session");
        String commentaire = request.getParameter("commentaire");
        String noteObtenueString = request.getParameter("noteObtenue");
        int noteObtenue = 0;
        if(noteObtenueString!=null){
             noteObtenue = Integer.valueOf(noteObtenueString);
        }
        
        String etudiant = request.getParameter("etudiant");
         int etudiantID = 0;
        if (etudiant != null) {
            etudiantID = Integer.valueOf(etudiant);
        }
        String cours = request.getParameter("cours");
        int coursID = 0;
        if (cours != null) {
            coursID = Integer.valueOf(cours);
        }
        String projet = request.getParameter("projet");
        int  projetID = 0;
        if (projet != null) {
             projetID = Integer.valueOf(projet);
        }
        
        String dateString = request.getParameter("date");
        int date = 0;
        if(dateString!=null){
        date = Integer.parseInt(dateString);
}

        listeEtudiants = dao.findAllEtudiants();
        listeCours = dao.findAllCours();
        listeProjets = dao.findAllProjets();
        
        Cours unCours = new Cours();
        unCours.setId(coursID);
        Etudiant unProf = new Etudiant();
        unProf.setId(etudiantID);
        Projet unProjet = new Projet();
        unProjet.setId(projetID);
        
        notes = new Notes(noteObtenue,session,date,commentaire,unProf,unCours,unProjet);
        
        System.out.println("notessssssssssssssssssssssssssss");
        System.out.println("noteObtenueeeeeee: " + notes.getNoteObtenue());
        System.out.println("etudiantsssssssss: " + notes.getEtudiantID().getId());
        System.out.println("Session: " + notes.getSession());
        System.out.println("date: " + notes.getAnnee());
        System.out.println("Commentaire: " + notes.getCommentaire());
        System.out.println("cours: " + notes.getCoursID().getId());
        System.out.println("Projet: " + notes.getProjetID().getId());
        retour = dao.createNotes(notes);
        if (retour) {
            //String message = String.format("Le note de cours " +  nom + " a été créé avec succès");
            //request.setAttribute("message", message);
            request.setAttribute("listeEtudiants", listeEtudiants);
            request.setAttribute("listeCours", listeCours);
            request.setAttribute("notes", notes);
            
            request.getRequestDispatcher("notesController").forward(request, response);
            
        }
            request.setAttribute("listeCours", listeCours);
            request.setAttribute("listeEtudiants", listeEtudiants);
            request.setAttribute("listeProjets", listeProjets);
            request.getRequestDispatcher("creationDepotNotes.jsp").include(request, response);
            
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
