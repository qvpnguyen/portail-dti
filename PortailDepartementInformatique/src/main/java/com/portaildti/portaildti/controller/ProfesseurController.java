package com.portaildti.portaildti.controller;

import com.portaildti.portaildti.entities.Cours;
import com.portaildti.portaildti.entities.Professeur;
import com.portaildti.portaildti.entities.Projet;
import com.portaildti.portaildti.service.CoursService;
import com.portaildti.portaildti.service.ProfesseurService;
import com.portaildti.portaildti.service.ProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ProfesseurController {
    @Autowired
    ProfesseurService profService;
    @Autowired
    CoursService coursService;
    @Autowired
    ProjetService projetService;
    @GetMapping("/professeur")
    public String afficherPageProfesseur(Model model) {
        List<Professeur> listeProfesseurs = profService.afficherProfesseurs();
        List<Cours> listeCours = coursService.afficherCours();
        List<Projet> listeProjets = projetService.afficherProjet();
        model.addAttribute("listeProfesseurs", listeProfesseurs);
        model.addAttribute("listeCours", listeCours);
        model.addAttribute("listeProjets", listeProjets);
        return "professeur";
    }
    @GetMapping("/professeurs")
    public String afficherListProfesseur(Model model) {
        List<Professeur> listeProfesseurs = profService.afficherProfesseurs();

        model.addAttribute("listeProfesseurs", listeProfesseurs);

        return "listProfesseurs";
    }
    @GetMapping("/rechercher/professeur")
    public String rechercherProfesseur(Model model,@Param("nom") String nom) {
        List<Professeur> listeProfesseurs = profService.rechercherProfesseurParNom(nom);

        model.addAttribute("listeProfesseurs", listeProfesseurs);

        return "listProfesseurs";
    }
    @GetMapping("/professeur/profil/{id}")
    public String afficherProfilProfesseur(Model model,@PathVariable(name = "id") Integer id) {
        Professeur professeur = profService.rechercherProfesseurParID(id);
        List<Projet> projetsProf = projetService.rechercherProjetParProfID(id);
        List<Cours> coursProf = coursService.rechercherCoursParProfId(id);
        model.addAttribute("professeur", professeur);
        model.addAttribute("projetsProf", projetsProf);
        model.addAttribute("coursProf", coursProf);


        return "profilProfesseur";
    }

}
