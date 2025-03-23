package com.portaildti.portaildti.controller;

import com.portaildti.portaildti.entities.*;
import com.portaildti.portaildti.repos.VoteRepository;
import com.portaildti.portaildti.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class VisiteurController {
    @Autowired
    ProfesseurService profService;
    @Autowired
    CoursService coursService;
    @Autowired
    ProjetService projetService;
    @Autowired
    EtudiantProjetService etudiantProjetService;
    @Autowired
    projetVisiteurService projetVisiteurService;
    @Autowired
    EtudiantService etudiantService;
    @Autowired
    NotesService notesService;
    @Autowired
    VoteRepository voteRepository;
    @GetMapping("/visiteur")
    public String afficherPageEtudiant(Model model) {
        List<Professeur> listeProfesseurs = profService.afficherProfesseurs();
        List<Cours> listeCours = coursService.afficherCours();
        List<Projet> listeProjets = projetService.afficherProjet();
        String pageTitle = "Visiteur";
        model.addAttribute("listeProfesseurs", listeProfesseurs);
        model.addAttribute("listeCours", listeCours);
        model.addAttribute("listeProjets", listeProjets);
        model.addAttribute("pageTitle", pageTitle);
        return "visiteur";
    }
    @GetMapping("/projets-visiteurs/{id}")
    public String afficherProjet(Model model, @PathVariable(name = "id") Integer id, @RequestParam(name = "starCount", required = false) Integer starCount) {
        List<ProjetVisiteur> projetsVisiteurs = projetVisiteurService.afficherProjetVisiteur();
        ProjetVisiteur projetChoisi = projetVisiteurService.afficherProjetParId(id);
        List<Etudiant> listeEtudiants = etudiantService.afficherEtudiantsParProjetId(id);
        List<Vote> listeVotes = voteRepository.findByProjetId(id);
        Notes note = notesService.rechercherNotesParProjetID(id);

        Vote vote = new Vote();
        vote.setRating(starCount);

        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("The setRating is: " + vote.getRating());

        String noteObtenue;

        if (note == null || note.getNoteObtenue() == null) {
            noteObtenue = "--";
        } else {
            noteObtenue = note.getNoteObtenue().toString() + "%";
        }

        String commentaire;

        if (note == null || note.getCommentaire() == null) {
            commentaire = "";
        } else {
            commentaire = note.getCommentaire();
        }

        double moyenneRating = calculateAverageRating(listeVotes);

        int nombreVotes = listeVotes.size();
        Map<Integer, List<Etudiant>> etudiantsParProjet = new HashMap<>();
        for (ProjetVisiteur projet : projetsVisiteurs) {
            List<Etudiant> etudiants = etudiantProjetService.rechercherEtudiantsParProjet(projet.getId());
            etudiantsParProjet.put(projet.getId(), etudiants);
        }
        model.addAttribute("etudiantsParProjet", etudiantsParProjet);
        model.addAttribute("moyenneRating", moyenneRating);
        model.addAttribute("nombreVotes", nombreVotes);
        model.addAttribute("projetChoisi", projetChoisi);
        model.addAttribute("listeProjets", projetService.afficherProjet());
//        model.addAttribute("professeur", projetChoisi.getProfesseur().getNom() + " " + projetChoisi.getProfesseur().getPrenom());
        model.addAttribute("noteObtenu", noteObtenue);
        model.addAttribute("commentaire", commentaire);
        model.addAttribute("pageTitle", "Évaluer un projet visiteur");

        return "visiteurProjet";
    }
    private double calculateAverageRating(List<Vote> votes) {
        int totalVotes = votes.size();
        if (totalVotes == 0) {
            return 0.0;
        }

        int sum = 0;

        for (Vote vote : votes) {
            System.out.println("getRating: " + vote.getRating());
            sum += vote.getRating();
            System.out.println("sum inside loop: " + sum);
        }

        double average = (double) sum / totalVotes;
        System.out.println("totalVotes: " + totalVotes);
        System.out.println("sum: " + sum);
        System.out.println(" ");
        return Math.round(average * 100.0) / 100.0;
    }
}
