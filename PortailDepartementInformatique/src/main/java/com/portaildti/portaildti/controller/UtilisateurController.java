package com.portaildti.portaildti.controller;

import com.portaildti.portaildti.entities.*;
import com.portaildti.portaildti.service.AdministrateurService;
import com.portaildti.portaildti.service.EtudiantService;
import com.portaildti.portaildti.service.ProfesseurService;
import com.portaildti.portaildti.service.VisiteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
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
    @GetMapping("/inscription-admin")
    public String afficherFormulaireAdmin(Model model) {
        Administrateur administrateur = new Administrateur();
        model.addAttribute("administrateur", administrateur);
        model.addAttribute("pageTitle", "Ajouter un nouveau utilisateur");
        return "inscription-admin";
    }
    @GetMapping("/inscription-professeur")
    public String afficherFormulaireProf(Model model) {
        Professeur professeur = new Professeur();
        model.addAttribute("professeur", professeur);
        model.addAttribute("pageTitle", "Ajouter un nouveau utilisateur");
        return "inscription-professeur";
    }
    @GetMapping("/inscription-etudiant")
    public String afficherFormulaireEtudiant(Model model) {
        Etudiant etudiant = new Etudiant();
        List<Cours> listeCours = etudiantService.afficherCours();
        model.addAttribute("etudiant", etudiant);
        model.addAttribute("listeCours", listeCours);
        model.addAttribute("pageTitle", "Ajouter un nouveau utilisateur");
        return "inscription-etudiant";
    }
    @GetMapping("/inscription-visiteur")
    public String afficherFormulaireVisiteur(Model model) {
        Visiteur visiteur = new Visiteur();
        model.addAttribute("visiteur", visiteur);
        model.addAttribute("pageTitle", "Ajouter un nouveau utilisateur");
        return "inscription-visiteur";
    }
    @PostMapping("/admins/save")
    public String ajouterAdmin(Administrateur admin, RedirectAttributes redirectAttributes, @RequestParam("fileImage") MultipartFile file) throws Exception {
        String chemin = file.getOriginalFilename();
        String filename = StringUtils.cleanPath(chemin);
        admin.setPhoto(filename);
        redirectAttributes.addFlashAttribute("message","L'utilisateur a été ajouté avec succès");
        adminService.ajouterAdmin(admin);
        return "redirect:/utilisateurs";
    }
    @PostMapping("/professeurs/save")
    public String ajouterProf(Professeur prof, RedirectAttributes redirectAttributes, @RequestParam("fileImage") MultipartFile file) throws Exception {
        String chemin = file.getOriginalFilename();
        String filename = StringUtils.cleanPath(chemin);
        prof.setPhoto(filename);
        redirectAttributes.addFlashAttribute("message","L'utilisateur a été ajouté avec succès");
        profService.ajouterProfesseur(prof);
        return "redirect:/utilisateurs";
    }
    @PostMapping("/etudiants/save")
    public String ajouterEtudiant(Etudiant etudiant, RedirectAttributes redirectAttributes, @RequestParam("fileImage") MultipartFile file) throws Exception {
        String chemin = file.getOriginalFilename();
        System.out.println("chemin: " + chemin);
        System.out.println("typeContenu: " + file.getContentType());
        String filename = StringUtils.cleanPath(chemin);
        etudiant.setPhoto(filename);
        redirectAttributes.addFlashAttribute("message","L'utilisateur a été ajouté avec succès");
        etudiantService.ajouterEtudiant(etudiant);
        return "redirect:/utilisateurs";
    }
    @PostMapping("/visiteurs/save")
    public String ajouterVisiteur(Visiteur visiteur, RedirectAttributes redirectAttributes, @RequestParam("fileImage") MultipartFile file, @RequestParam("ddn") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) throws Exception {
        String chemin = file.getOriginalFilename();
        System.out.println("chemin: " + chemin);
        System.out.println("typeContenu: " + file.getContentType());
        String filename = StringUtils.cleanPath(chemin);
        visiteur.setPhoto(filename);
//        visiteur.setDdn(date);
        redirectAttributes.addFlashAttribute("message","L'utilisateur a été ajouté avec succès");
        visiteurService.ajouterVisiteur(visiteur);
        return "redirect:/utilisateurs";
    }
}
