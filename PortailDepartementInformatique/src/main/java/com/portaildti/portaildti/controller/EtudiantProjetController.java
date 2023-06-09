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


import java.util.*;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @Autowired
    VoteRepository voteRepository;

    @Autowired
    NotesService notesService;

    @GetMapping("/etudiants-projets/{id}")
    public String afficherProjet(Model model, @PathVariable(name = "id") Integer id, @RequestParam(name = "starCount", required = false) Integer starCount) {
        List<Projet> projets = projetService.afficherProjet();
        Projet projetChoisi = projetService.afficherProjetParId(id);
        List<Etudiant> listeEtudiants = etudiantService.afficherEtudiantsParProjetId(id);
        List<Vote> listeVotes = voteRepository.findByProjetId(id);
        Notes note = notesService.rechercherNotesParProjetID(id);

        Vote vote = new Vote();
        vote.setRating(starCount);


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
//<<<<<<< HEAD
//        List<Integer> idsEtudiantsMemeProjet = new ArrayList<>();
//
//        for (Projet projet : projets) {
//            List<Etudiant> etudiants = etudiantProjetService.rechercherEtudiantsParProjet(projet.getId());
//            System.out.println("la liste des etudiants du projets :" +etudiants);
//            etudiantsParProjet.put(projet.getId(), etudiants);
//            //idsEtudiantsMemeProjet
//        }
//
//        for (Map.Entry<Integer, List<Etudiant>> entry : etudiantsParProjet.entrySet()) {
//            List<Etudiant> etudiants = entry.getValue();
//=======
        Map<Integer, List<Integer>> idsEtudiantsMemeProjet = new HashMap<>();
        List<Integer> idsEtudiants;
        for (Projet projet : projets) {
            List<Etudiant> etudiants = etudiantProjetService.rechercherEtudiantsParProjet(projet.getId());
            idsEtudiants = new ArrayList<>();
//>>>>>>> 4981df7e0c41025463ab57fc8cb51aa38fb388b3
            for (Etudiant etudiant : etudiants) {
                idsEtudiants.add(etudiant.getId());
            }
            System.out.println("La liste des étudiants du projet :" + etudiants);
            etudiantsParProjet.put(projet.getId(), etudiants);
            idsEtudiantsMemeProjet.put(projet.getId(), idsEtudiants);
        }

        System.out.println("la liste  des etudiants :" +etudiantsParProjet);
        System.out.println("la liste des is des etudiants :" +idsEtudiantsMemeProjet);
        model.addAttribute("idsEtudiantsMemeProjet",idsEtudiantsMemeProjet);
        model.addAttribute("etudiantsParProjet", etudiantsParProjet);
        model.addAttribute("moyenneRating", moyenneRating);
        model.addAttribute("nombreVotes", nombreVotes);
        model.addAttribute("projetChoisi", projetChoisi);
        model.addAttribute("listeProjets", projetService.afficherProjet());
        model.addAttribute("professeur", projetChoisi.getProfesseur().getNom() + " " + projetChoisi.getProfesseur().getPrenom());
        model.addAttribute("noteObtenu", noteObtenue);
        model.addAttribute("commentaire", commentaire);
        model.addAttribute("pageTitle", "Évaluer un projet");

        return "etudiantProjet";
    }

    @PostMapping ("/etudiants-projets/{id}/rating")
    public String afficherProjetRating(Model model, @PathVariable(name = "id") Integer id, @RequestParam(name = "starCount", required = false) Integer rating){

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
