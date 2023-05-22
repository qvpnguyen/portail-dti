package com.portaildti.portaildti.controller;

import com.portaildti.portaildti.entities.Etudiant;
import com.portaildti.portaildti.entities.Projet;
import com.portaildti.portaildti.service.EtudiantProjetService;
import com.portaildti.portaildti.service.EtudiantService;
import com.portaildti.portaildti.service.ProfesseurService;
import com.portaildti.portaildti.service.ProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;
import java.util.List;

@Controller
public class EtudiantProjetController {

    @Autowired
    EtudiantProjetService etudiantProjetService;
    @Autowired
    EtudiantService etudiantService;
    @Autowired
    ProfesseurService professeurService;
    @Autowired
    ProjetService projetService;

    @GetMapping("/etudiants-projets/{id}")
    public String afficherProjet(Model model, @PathVariable(name = "id") Integer id) {
        Projet projetChoisi = projetService.afficherProjetParId(id);
        List<Etudiant> listeEtudiants = etudiantService.afficherEtudiantsParProjetId(id);

        model.addAttribute("etudiantsParProjet", Collections.singletonMap(projetChoisi.getNom(), listeEtudiants));
        model.addAttribute("projetChoisi", projetChoisi);
        model.addAttribute("listeProjets", projetService.afficherProjet());
        model.addAttribute("professeur", projetChoisi.getProfesseur().getNom() + " " + projetChoisi.getProfesseur().getPrenom());
        model.addAttribute("noteObtenu", projetChoisi.getNotes().getNoteObtenue() + "%");
        model.addAttribute("commentaire", projetChoisi.getNotes().getCommentaire());

        return "etudiantProjet";
    }

}
