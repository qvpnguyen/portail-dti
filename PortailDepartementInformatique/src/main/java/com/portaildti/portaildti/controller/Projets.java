package com.portaildti.portaildti.controller;

import com.portaildti.portaildti.entities.Etudiant;
import com.portaildti.portaildti.entities.EtudiantProjet;
import com.portaildti.portaildti.entities.Projet;
import com.portaildti.portaildti.repos.ProjetRepository;
import com.portaildti.portaildti.service.EtudiantProjetService;
import com.portaildti.portaildti.service.EtudiantService;
import com.portaildti.portaildti.service.ProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class Projets {

    @Autowired
    ProjetService projetService;
    @Autowired
    EtudiantService etudiantService;
    @Autowired
    EtudiantProjetService etudiantProjetService;

    @GetMapping("/projets")
    public String afficherProjets(Model model){

        Iterable<Projet> listeProjets = projetService.afficherProjet();
        Map<String, List<Etudiant>> etudiantsParProjet = new HashMap<>();

        for (Projet projet : listeProjets){

            List<Etudiant> listeEtudiants = etudiantService.afficherEtudiantsParProjet(projet.getNom());
            etudiantsParProjet.put(projet.getNom(), listeEtudiants);
        }

        model.addAttribute("etudiantsParProjet", etudiantsParProjet);
        model.addAttribute("listeProjets", listeProjets);


        return "projets";
    }
}
