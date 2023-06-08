package com.portaildti.portaildti.controller;

import com.portaildti.portaildti.entities.Cours;
import com.portaildti.portaildti.entities.Etudiant;
import com.portaildti.portaildti.entities.Professeur;
import com.portaildti.portaildti.entities.Projet;
import com.portaildti.portaildti.service.CoursService;
import com.portaildti.portaildti.service.EtudiantService;
import com.portaildti.portaildti.service.ProfesseurService;
import com.portaildti.portaildti.service.ProjetService;
import com.portaildti.portaildti.service.exception.UtilisateurNotFoundException;
//import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;

@Controller
public class EtudiantController {
    @Autowired
    ProfesseurService profService;
    @Autowired
    CoursService coursService;
    @Autowired
    ProjetService projetService;

    @Autowired
    EtudiantService etudiantService;

    @GetMapping("/etudiant")
    public String afficherPageEtudiant(Model model) {
        List<Professeur> listeProfesseurs = profService.afficherProfesseurs();
        List<Cours> listeCours = coursService.afficherCours();
        List<Projet> listeProjets = projetService.afficherProjet();
        String pageTitle = "Étudiant";
        model.addAttribute("listeProfesseurs", listeProfesseurs);
        model.addAttribute("listeCours", listeCours);
        model.addAttribute("listeProjets", listeProjets);
        model.addAttribute("pageTitle", pageTitle);
        return "etudiant";
    }

    @GetMapping("/etudiant/anciens")
    public String afficherPageEtudiantAnciens(Model model) {
        List<Etudiant> anciensEtudiants = etudiantService.afficherEtudiantsAnciens();

        String pageTitle = " Anciens Étudiants";
        model.addAttribute("anciensEtudiants", anciensEtudiants);

        model.addAttribute("pageTitle", pageTitle);
        return "anciensEtudiants";
    }


    @GetMapping("/etudiant/profil/{id}")
    public String afficherProfilEtudiant(Model model, @PathVariable(name = "id") Integer id) throws UtilisateurNotFoundException {
        Etudiant etudiant = etudiantService.get(id);
        List<Projet> projetsProf = projetService.rechercherProjetParEtudiantID(id);
        List<Cours> coursProf = coursService.rechercherCoursParEtuidantId(id);
        String pageTitle = String.format("Profil de %s %s", etudiant.getPrenom(), etudiant.getNom());
        model.addAttribute("etudiant", etudiant);
        model.addAttribute("projetsProf", projetsProf);
        model.addAttribute("coursProf", coursProf);
        model.addAttribute("pageTitle", pageTitle);

        return "profilEtudiant";
    }

/*    @GetMapping("/utilisateurs/{id}/active/{status}")
    public String mettreAjourStatusActiveEtudiantTuteur(@PathVariable("id") Integer id,
                                                     @PathVariable("status") boolean active, RedirectAttributes redirectAttributes) {
        etudiantService.updateActiveStatus(id, active);


        return "redirect:/etudiant";
    }
    */

}
