package com.portaildti.portaildti.controller;


import com.portaildti.portaildti.entities.*;

import com.portaildti.portaildti.repos.NotesRepository;
import com.portaildti.portaildti.repos.VoteRepository;
import com.portaildti.portaildti.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

    @Autowired
    VoteRepository voteRepository;

    @Autowired
    NotesService notesService;

    @GetMapping("/etudiants-projets/{id}")
    public String afficherProjet(Model model, @PathVariable(name = "id") Integer id) {

        Projet projetChoisi = projetService.afficherProjetParId(id);
        List<Etudiant> listeEtudiants = etudiantService.afficherEtudiantsParProjetId(id);
        List<Vote> listeVotes = voteRepository.findByProjetId(id);
        Notes note = notesService.rechercherNotesParProjetID(id);

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

        int nombreVotes = listeVotes.size();
        double moyenneRating = calculateAverageRating(listeVotes);

        model.addAttribute("moyenneRating", moyenneRating);
        model.addAttribute("nombreVotes", nombreVotes);
        model.addAttribute("etudiantsParProjet", Collections.singletonMap(projetChoisi.getNom(), listeEtudiants));
        model.addAttribute("projetChoisi", projetChoisi);
        model.addAttribute("listeProjets", projetService.afficherProjet());
        model.addAttribute("professeur", projetChoisi.getProfesseur().getNom() + " " + projetChoisi.getProfesseur().getPrenom());
        model.addAttribute("noteObtenu", noteObtenue);
        model.addAttribute("commentaire", commentaire);

        return "etudiantProjet";
    }

    @PostMapping ("/etudiants-projets/{id}/rating")
    public String afficherProjetRating(Model model, @PathVariable(name = "id") Integer id, @RequestParam(name = "rating", required = false) Integer rating){

        Projet projetChoisi = projetService.afficherProjetParId(id);

        if (projetChoisi != null) {

            List<Vote> votes = voteRepository.findByProjetId(projetChoisi.getId());
            int totalVotes = votes.size();

            if (votes != null && rating != null) {

                Vote vote = new Vote();

                vote.setRating(rating);
                vote.setProjetID(projetChoisi);
                voteRepository.save(vote);
            }

            System.out.println(votes);

            model.addAttribute("projetChoisi", projetChoisi);
            model.addAttribute("totalVotes", totalVotes);
        }

        return "redirect:/etudiants-projets/{id}";
    }

    private double calculateAverageRating(List<Vote> votes) {
        int totalVotes = votes.size();
        if (totalVotes == 0) {
            return 0.0;
        }
        int sum = 0;
        for (Vote vote : votes) {
            sum += vote.getRating();
        }
        double average = (double) sum / totalVotes;
        return Math.round(average * 100.0) / 100.0;
    }

}
