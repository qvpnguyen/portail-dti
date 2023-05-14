package com.portaildti.portaildti.controller;

import com.portaildti.portaildti.entities.*;
import com.portaildti.portaildti.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProjetController {
    @Autowired
    ProjetService projetService;
    @Autowired
    EtudiantService etudiantService;
    @Autowired
    ProfesseurService professeurService;
    @Autowired
    CoursService coursService;
    @Autowired
    EtudiantProjetService etudiantProjetService;
    @GetMapping("/projets/new")
    public String afficherFormulaireProjet(Model model) {
        Projet projet = new Projet();
        List<Etudiant> listeEtudiants = etudiantService.afficherEtudiants();
        List<Professeur> listeProfesseurs = professeurService.afficherProfesseurs();
        List<Cours> listeCours = coursService.afficherCours();
        model.addAttribute("projet", projet);
        model.addAttribute("listeEtudiants", listeEtudiants);
        model.addAttribute("listeProfesseurs", listeProfesseurs);
        model.addAttribute("listeCours", listeCours);
        model.addAttribute("pageTitle", "Ajouter un nouveau projet");
        return "projets-form";
    }
    @PostMapping("/projets/save")
    public String ajouterProjet(Projet projet, EtudiantProjet etudiantProjet, RedirectAttributes redirectAttributes, @RequestParam("fileVideo") MultipartFile file, @RequestParam("membresEquipe") List<Etudiant> membres) throws Exception {
        String chemin = file.getOriginalFilename();
        String filename = StringUtils.cleanPath(chemin);
        projet.setVideo(filename);
        redirectAttributes.addFlashAttribute("message","Le projet a été ajouté avec succès");
        projetService.ajouterProjet(projet);
        for (Etudiant membre : membres) {
            etudiantProjet.setProjet(projet);
            etudiantProjet.setEtudiant(membre);
            etudiantProjetService.ajouterEtudiantProjet(etudiantProjet);
        }
        return "redirect:/gestion-projets";
    }
}
