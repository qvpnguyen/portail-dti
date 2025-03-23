package com.portaildti.portaildti.controller;

import com.portaildti.portaildti.entities.*;
import com.portaildti.portaildti.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class AdministrateurController {
    @Autowired
    AdministrateurService adminService;
    @Autowired
    ProfesseurService profService;
    @Autowired
    EtudiantService etudiantService;
    @Autowired
    VisiteurService visiteurService;
    @Autowired
    ProjetService projetService;
    @Autowired
    NoteDeCoursService noteDeCoursService;
    @Autowired
    CoursService coursService;
    @Autowired
    EtudiantProjetService etudiantProjetService;
    @Autowired
    NotesService notesService;
    @GetMapping("/administration")
    public String afficherPageAdmin(Model model) {
        List<Professeur> listeProfesseurs = profService.afficherProfesseurs();
        List<Cours> listeCours = coursService.afficherCours();
        List<Projet> listeProjets = projetService.afficherProjet();
        String pageTitle = "Administration";
        model.addAttribute("listeProfesseurs", listeProfesseurs);
        model.addAttribute("listeCours", listeCours);
        model.addAttribute("listeProjets", listeProjets);
        model.addAttribute("pageTitle", pageTitle);
        return "administration";
    }
    @GetMapping("/utilisateurs")
    public String afficherGestionUtilisateurs(Model model) {
        List<Visiteur> visiteurs = visiteurService.afficherVisiteurs();
        List<Etudiant> etudiants = etudiantService.afficherEtudiants();
        List<Professeur> professeurs = profService.afficherProfesseurs();
        List<Administrateur> admins = adminService.afficherAdministrateurs();
        List<Cours> listeCours = coursService.afficherCours();
        List<Projet> listeProjets = projetService.afficherProjet();
        String pageTitle = "Gestion des utilisateurs";

        model.addAttribute("visiteurs", visiteurs);
        model.addAttribute("etudiants", etudiants);
        model.addAttribute("professeurs", professeurs);
        model.addAttribute("admins", admins);
        model.addAttribute("listeProfesseurs", professeurs);
        model.addAttribute("listeCours", listeCours);
        model.addAttribute("listeProjets", listeProjets);
        model.addAttribute("pageTitle", pageTitle);
        return "gestionUtilisateurs";
    }
    @GetMapping("/gestion-projets")
    public String afficherGestionProjets(Model model) {
        List<Projet> projets = projetService.afficherProjet();
        List<Etudiant> listeEtudiants = etudiantService.afficherEtudiants();
        List<Professeur> listeProfesseurs = profService.afficherProfesseurs();
        List<Cours> listeCours = coursService.afficherCours();
        List<Projet> listeProjets = projetService.afficherProjet();
        List<Notes> listeNotesProjets = notesService.afficherNote();
        String pageTitle = "Gestion des projets";
        model.addAttribute("projets", projets);
        model.addAttribute("listeEtudiants", listeEtudiants);
        model.addAttribute("listeProfesseurs", listeProfesseurs);
        model.addAttribute("listeCours", listeCours);
        model.addAttribute("listeProjets", listeProjets);
        model.addAttribute("listeNotes", listeNotesProjets);
        Map<Integer, List<Etudiant>> etudiantsParProjet = new HashMap<>();
        for (Projet projet : projets) {
            List<Etudiant> etudiants = etudiantProjetService.rechercherEtudiantsParProjet(projet.getId());
            etudiantsParProjet.put(projet.getId(), etudiants);
        }
        model.addAttribute("etudiantsParProjet", etudiantsParProjet);
        model.addAttribute("pageTitle", pageTitle);
        return "gestionProjets";
    }
    @GetMapping("/gestion-notes-de-cours")
    public String afficherGestionNotesDeCours(Model model) {
        List<NoteDeCours> notesDeCours = noteDeCoursService.afficherNoteDeCours();
        String pageTitle = "Gestion des notes de cours";
        model.addAttribute("notesDeCours", notesDeCours);
        model.addAttribute("pageTitle", pageTitle);
        return "gestionNotesDeCours";
    }
}
