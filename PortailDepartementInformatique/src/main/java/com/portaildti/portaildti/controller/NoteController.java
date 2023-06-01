package com.portaildti.portaildti.controller;

import com.portaildti.portaildti.entities.Cours;
import com.portaildti.portaildti.entities.Notes;
import com.portaildti.portaildti.entities.Professeur;
import com.portaildti.portaildti.entities.Projet;
import com.portaildti.portaildti.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class NoteController {
    @Autowired
    ProjetService projetService;
    @Autowired
    EtudiantService etudiantService;
    @Autowired
    ProfesseurService professeurService;
    @Autowired
    VisiteurService visiteurService;
    @Autowired
    CoursService coursService;
    @Autowired
    EtudiantProjetService etudiantProjetService;
    @Autowired
    NotesService notesService;

    @GetMapping("/projets/evaluation")
    public String evaluerProjet(Model model) {

        List<Notes> listeNotesProjets = notesService.afficherNote();
        model.addAttribute("listeNotes", listeNotesProjets);
        String pageTitle = "Évaluation des projets";
        model.addAttribute("pageTitle", pageTitle);
        return "evaluationProjets";
    }

    @GetMapping("/modifier/note/{id}")
    public String modifierNote (@PathVariable(name = "id") Integer id, @RequestParam("noteObtenue") int noteObtenue) {
        notesService.modifierNoteObtenue(id,noteObtenue);
        return "redirect:/projets/evaluation";
    }

    @GetMapping("/rechercher/note_projet/")
    public String rechercherNoteParNomProjet (Model model,@RequestParam("note") String nomProjet) {
        List<Notes> listNotesProjet = notesService.rechercherNotesParProjetNom(nomProjet);
        System.out.println(listNotesProjet);
        model.addAttribute("listeNotes", listNotesProjet);
        String pageTitle = "Évaluation des projets";
        model.addAttribute("pageTitle", pageTitle);
        return "evaluationProjets";
    }

    @GetMapping("/note/supprimer/{id}")
    public String supprimerNote(@PathVariable(name = "id") Integer id,
                                Model model,
                                RedirectAttributes redirectAttributes) {
        Notes notes = notesService.rechercherNotesParID(id);
        if(notes != null) {
            notesService.deleteNotes(id);
            redirectAttributes.addFlashAttribute("message",
                    "Note avec  ID " + id + " a été supprimé avec succès ");
        }else{
            redirectAttributes.addFlashAttribute("message",
                    "Note  avec  ID " + id + " n'existe pas");
        }

        return "redirect:/projets/evaluation";
    }

    @GetMapping("/note/new/{nomProfSession}")
    public String afficherFormNotesProjets(Model model, @PathVariable("nomProfSession") String nomProf) {
        Notes note = new Notes();
        System.out.println(nomProf);
        Professeur professeur = professeurService.rechercherProfesseurSeulParNom(nomProf);
        List<Cours> listeCours = coursService.rechercherCoursParProf(nomProf);
        List<Projet> listeProjets = projetService.rechercherProjetParProf(nomProf);
        model.addAttribute("professeur", professeur);
        model.addAttribute("listeCours", listeCours);
        model.addAttribute("note", note);
        model.addAttribute("listeProjets", listeProjets);
        model.addAttribute("pageTitle", "Ajouter une note a un projet");
        return "notes-form";
    }

    @PostMapping("/notes/save")
    public String ajouterNoteDeCours(Notes notes, RedirectAttributes redirectAttributes) throws Exception {
        redirectAttributes.addFlashAttribute("message","Le note du projet "+ notes.getProjetID().getNom()+" a été ajouté avec succès");
        System.out.println(notes.getProfesseurID());
        notesService.ajouterNotes(notes);
        return "redirect:/projets/evaluation";
    }
}
