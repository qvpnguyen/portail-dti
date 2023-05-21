package com.portaildti.portaildti.controller;

import com.portaildti.portaildti.entities.*;
import com.portaildti.portaildti.service.*;
import com.portaildti.portaildti.service.exception.ProjetNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
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
    public String ajouterProjet(Projet projet, RedirectAttributes redirectAttributes, @RequestParam("fileVideo") MultipartFile file, @RequestParam("membresEquipe") List<Etudiant> membres) throws Exception {
        String chemin = file.getOriginalFilename();
        String filename = StringUtils.cleanPath(chemin);
        projet.setVideo(filename);
        redirectAttributes.addFlashAttribute("message","Le projet a été ajouté avec succès");
        projetService.ajouterProjet(projet);
        for (Etudiant membre : membres) {
            EtudiantProjet etudiantProjet = new EtudiantProjet(projet, membre);
            etudiantProjetService.ajouterEtudiantProjet(etudiantProjet);
        }
        redirectAttributes.addFlashAttribute("membresEquipe", membres);
        return "redirect:/gestion-projets";
    }
    @GetMapping("projets/edit/{projetid}")
    public String mettreAJourProjet(@PathVariable(name = "projetid") Integer id, RedirectAttributes redirectAttributes, Model model) {
        try {
            while (true) {
                Projet projet = projetService.get(id);
                List<Etudiant> listeEtudiants = etudiantService.afficherEtudiants();
                List<Professeur> listeProfesseurs = professeurService.afficherProfesseurs();
                List<Cours> listeCours = coursService.afficherCours();
//                List<EtudiantProjet> membresEquipe = etudiantProjetService.rechercherEtudiantsParProjet(id);
                model.addAttribute("projet", projet);
//                model.addAttribute("membresEquipe", membres);
                model.addAttribute("listeEtudiants", listeEtudiants);
                model.addAttribute("listeProfesseurs", listeProfesseurs);
                model.addAttribute("listeCours", listeCours);
                return "projets-edit-form";
            }
        } catch (ProjetNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", "On ne peut pas trouver le projet avec l'id " + id);
            return "redirect:/gestion-projets";
        }
    }
    @GetMapping("/projets/delete/{projetid}")
    public String supprimerProjet(@PathVariable(name = "projetid") Integer id, Model model, RedirectAttributes redirectAttributes) {
        try {
            projetService.delete(id);
            redirectAttributes.addFlashAttribute("message", "Le projet ID " + id + " a été supprimé avec succès");
        } catch (ProjetNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", "On ne peut pas trouver le projet avec l'id " + id);
        }
        return "redirect:/gestion-projets";
    }
}
