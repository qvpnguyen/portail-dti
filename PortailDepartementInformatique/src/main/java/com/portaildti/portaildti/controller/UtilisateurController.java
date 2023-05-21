package com.portaildti.portaildti.controller;

import com.portaildti.portaildti.entities.*;
import com.portaildti.portaildti.service.*;
import com.portaildti.portaildti.service.exception.UtilisateurNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UtilisateurController {
    @Autowired
    AdministrateurService adminService;
    @Autowired
    ProfesseurService profService;
    @Autowired
    EtudiantService etudiantService;
    @Autowired
    VisiteurService visiteurService;
    @GetMapping("/admins/new")
    public String afficherFormulaireAdmin(Model model) {
        Administrateur administrateur = new Administrateur();
        model.addAttribute("administrateur", administrateur);
        model.addAttribute("pageTitle", "Ajouter un nouveau utilisateur");
        return "inscription-admin";
    }
    @GetMapping("/professeurs/new")
    public String afficherFormulaireProf(Model model) {
        Professeur professeur = new Professeur();
        model.addAttribute("professeur", professeur);
        model.addAttribute("pageTitle", "Ajouter un nouveau utilisateur");
        return "inscription-professeur";
    }
    @GetMapping("/etudiants/new")
    public String afficherFormulaireEtudiant(Model model) {
        Etudiant etudiant = new Etudiant();
        List<Cours> listeCours = etudiantService.afficherCours();
        model.addAttribute("etudiant", etudiant);
        model.addAttribute("listeCours", listeCours);
        model.addAttribute("pageTitle", "Ajouter un nouveau utilisateur");
        return "inscription-etudiant";
    }
    @GetMapping("/visiteurs/new")
    public String afficherFormulaireVisiteur(Model model) {
        Visiteur visiteur = new Visiteur();
        model.addAttribute("visiteur", visiteur);
        model.addAttribute("pageTitle", "Ajouter un nouveau utilisateur");
        return "inscription-visiteur";
    }
    @PostMapping("/admins/save")
    public String ajouterAdmin(Administrateur admin, RedirectAttributes redirectAttributes, @RequestParam("fileImage") MultipartFile file, @RequestParam("role") String role) throws Exception {
        String chemin = file.getOriginalFilename();
        String filename = StringUtils.cleanPath(chemin);
        admin.setPhoto(filename);
        admin.setRole(role);
        redirectAttributes.addFlashAttribute("message","L'utilisateur a été ajouté avec succès");
        adminService.ajouterAdmin(admin);
        return "redirect:/utilisateurs";
    }
    @PostMapping("/professeurs/save")
    public String ajouterProf(Professeur prof, RedirectAttributes redirectAttributes, @RequestParam("fileImage") MultipartFile file, @RequestParam("role") String role) throws Exception {
        String chemin = file.getOriginalFilename();
        String filename = StringUtils.cleanPath(chemin);
        prof.setPhoto(filename);
        prof.setRole(role);
        redirectAttributes.addFlashAttribute("message","L'utilisateur a été ajouté avec succès");
        profService.ajouterProfesseur(prof);
        return "redirect:/utilisateurs";
    }
    @PostMapping("/etudiants/save")
    public String ajouterEtudiant(Etudiant etudiant, RedirectAttributes redirectAttributes, @RequestParam("fileImage") MultipartFile file, @RequestParam("role") String role) throws Exception {
        String chemin = file.getOriginalFilename();
        String filename = StringUtils.cleanPath(chemin);
        etudiant.setPhoto(filename);
        etudiant.setRole(role);
        redirectAttributes.addFlashAttribute("message","L'utilisateur a été ajouté avec succès");
        etudiantService.ajouterEtudiant(etudiant);
        return "redirect:/utilisateurs";
    }
    @PostMapping("/visiteurs/save")
    public String ajouterVisiteur(Visiteur visiteur, RedirectAttributes redirectAttributes, @RequestParam("fileImage") MultipartFile file, @RequestParam("role") String role) throws Exception {
        String chemin = file.getOriginalFilename();
        String filename = StringUtils.cleanPath(chemin);
        visiteur.setPhoto(filename);
        visiteur.setRole(role);
        redirectAttributes.addFlashAttribute("message","L'utilisateur a été ajouté avec succès");
        visiteurService.ajouterVisiteur(visiteur);
        return "redirect:/utilisateurs";
    }
    @GetMapping("/admins/edit/{id}")
    public String mettreAJourAdmin(@PathVariable(name = "id") Integer id, RedirectAttributes redirectAttributes, Model model) {
        try {
            Administrateur admin = adminService.get(id);
            model.addAttribute("admin", admin);
            return "inscription-admin";
        } catch (UtilisateurNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", "On ne peut pas trouver l'utilisateur avec l'id " + id);
            return "redirect:/utilisateurs";
        }
    }
    @GetMapping("/professeurs/edit/{id}")
    public String mettreAJourProf(@PathVariable(name = "id") Integer id, RedirectAttributes redirectAttributes, Model model) {
        try {
            Professeur prof = profService.get(id);
            model.addAttribute("prof", prof);
            return "inscription-professeur";
        } catch (UtilisateurNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", "On ne peut pas trouver l'utilisateur avec l'id " + id);
            return "redirect:/utilisateurs";
        }
    }
    @GetMapping("/etudiants/edit/{id}")
    public String mettreAJourEtudiant(@PathVariable(name = "id") Integer id, RedirectAttributes redirectAttributes, Model model) {
        try {
            Etudiant etudiant = etudiantService.get(id);
            model.addAttribute("etudiant", etudiant);
            List<Cours> listeCours = etudiantService.afficherCours();
            model.addAttribute("listeCours", listeCours);
            return "inscription-etudiant";
        } catch (UtilisateurNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", "On ne peut pas trouver l'utilisateur avec l'id " + id);
            return "redirect:/utilisateurs";
        }
    }
    @GetMapping("/visiteurs/edit/{id}")
    public String mettreAJourVisiteur(@PathVariable(name = "id") Integer id, RedirectAttributes redirectAttributes, Model model) {
        try {
            Visiteur visiteur = visiteurService.get(id);
            model.addAttribute("visiteur", visiteur);
            return "inscription-visiteur";
        } catch (UtilisateurNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", "On ne peut pas trouver l'utilisateur avec l'id " + id);
            return "redirect:/utilisateurs";
        }
    }
    @GetMapping("/admins/delete/{id}")
    public String supprimerAdmin(@PathVariable(name = "id") Integer id, Model model, RedirectAttributes redirectAttributes) {
        try {
            adminService.delete(id);
            redirectAttributes.addFlashAttribute("message", "L'utilisateur ID " + id + " a été supprimé avec succès");
        } catch (UtilisateurNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", "On ne peut pas trouver l'utilisateur avec l'id " + id);
        }
        return "redirect:/utilisateurs";
    }
    @GetMapping("/professeurs/delete/{id}")
    public String supprimerProf(@PathVariable(name = "id") Integer id, Model model, RedirectAttributes redirectAttributes) {
        try {
            profService.delete(id);
            redirectAttributes.addFlashAttribute("message", "L'utilisateur ID " + id + " a été supprimé avec succès");
        } catch (UtilisateurNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", "On ne peut pas trouver l'utilisateur avec l'id " + id);
        }
        return "redirect:/utilisateurs";
    }
    @GetMapping("/etudiants/delete/{id}")
    public String supprimerEtudiant(@PathVariable(name = "id") Integer id, Model model, RedirectAttributes redirectAttributes) {
        try {
            etudiantService.delete(id);
            redirectAttributes.addFlashAttribute("message", "L'utilisateur ID " + id + " a été supprimé avec succès");
        } catch (UtilisateurNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", "On ne peut pas trouver l'utilisateur avec l'id " + id);
        }
        return "redirect:/utilisateurs";
    }
    @GetMapping("/visiteurs/delete/{id}")
    public String supprimerVisiteur(@PathVariable(name = "id") Integer id, Model model, RedirectAttributes redirectAttributes) {
        try {
            visiteurService.delete(id);
            redirectAttributes.addFlashAttribute("message", "L'utilisateur ID " + id + " a été supprimé avec succès");
        } catch (UtilisateurNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", "On ne peut pas trouver l'utilisateur avec l'id " + id);
        }
        return "redirect:/utilisateurs";
    }
}
