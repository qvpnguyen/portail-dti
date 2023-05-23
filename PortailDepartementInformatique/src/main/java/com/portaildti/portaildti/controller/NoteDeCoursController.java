package com.portaildti.portaildti.controller;


import com.portaildti.portaildti.entities.*;
import com.portaildti.portaildti.repos.NoteDeCoursRepository;
import com.portaildti.portaildti.service.CoursService;
import com.portaildti.portaildti.service.NoteDeCoursService;
import com.portaildti.portaildti.service.ProfesseurService;
import com.portaildti.portaildti.service.ProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
public class NoteDeCoursController {
    @Autowired
    NoteDeCoursService serviceNoteDeCours;
    @Autowired
    ProfesseurService professeurService;
    @Autowired
    CoursService coursService;
    @Autowired
    ProjetService projetService;

    @Autowired
    NoteDeCoursRepository repos;

    @GetMapping("/notesDeCours")
    public String afficherListeNotesDeCours(Model model, @RequestParam(name = "nomProfesseur", required = false) String nomProfesseur) {

        if (nomProfesseur != null) {

            Iterable<NoteDeCours> listNotesDeCours = serviceNoteDeCours.rechercherNoteDeCoursParProfesseurNom(nomProfesseur);
            model.addAttribute("listNotesDeCours",listNotesDeCours);

        }
        Iterable<NoteDeCours> listNotesDeCours = serviceNoteDeCours.afficherNoteDeCours();
        model.addAttribute("listNotesDeCours",listNotesDeCours);
        String pageTitle = "Gestion de notes de cours";
        model.addAttribute("pageTitle", pageTitle);
        return "gestionNotesDeCours";
    }

    @GetMapping("/notesDeCours/new/{nomProfSession}")
    public String afficherFormNoteDeCours(Model model, @PathVariable("nomProfSession") String nomProf) {

        NoteDeCours noteDeCours = new NoteDeCours();
        List<Professeur> listeProfesseurs = professeurService.rechercherProfesseurParNom(nomProf);
        List<Cours> listeCours = coursService.rechercherCoursParProf(nomProf);
        model.addAttribute("listeProfesseurs", listeProfesseurs);
        model.addAttribute("listeCours", listeCours);
        model.addAttribute("noteDeCours",noteDeCours);

        return "notesDeCours-form";
    }
    @GetMapping("/rechercher/noteDeCours")
    public String rechercherNoteDeCours(
            Model model, @Param("note") String note)
    {
        List<NoteDeCours> listNotesDeCours = serviceNoteDeCours.rechercherNoteDeCoursPaNom(note);
        model.addAttribute("listNotesDeCours", listNotesDeCours);
        String pageTitle = "Gestion de notes de cours";
        model.addAttribute("pageTitle", pageTitle);
        return "gestionNotesDeCours";
    }
    @GetMapping("/notesDeCours/supprimer/{id}")
    public String supprimerNoteDeCours(@PathVariable(name = "id") Integer id,
                                       Model model,
                                       RedirectAttributes redirectAttributes) {
       NoteDeCours noteDeCours = serviceNoteDeCours.rechercherNoteDeCoursParID(id);
        if(noteDeCours != null) {
            serviceNoteDeCours.deleteNoteDeCours(id);
            redirectAttributes.addFlashAttribute("message",
                    "Note de cours avec  ID " + id + " a été supprimé avec succès ");
        }else{
            redirectAttributes.addFlashAttribute("message",
                    "Note de cours avec  ID " + id + " n'existe pas");
        }

        return "redirect:/notesDeCours";
    }

    @PostMapping("/notesDeCours/save")
    public String ajouterNoteDeCours(NoteDeCours noteDeCours, RedirectAttributes redirectAttributes, @RequestParam("documentNotesCours") MultipartFile file) throws Exception {
        String chemin = file.getOriginalFilename();
        String filename = StringUtils.cleanPath(chemin);
        noteDeCours.setDocument(filename);
        redirectAttributes.addFlashAttribute("message","Le note de cours a été ajouté avec succès");
        serviceNoteDeCours.ajouterNoteDeCours(noteDeCours);

        return "redirect:/notesDeCours";
    }

    @GetMapping("/professeur/profil/{id}/{coursId}")
    public String afficherProfilProfesseur(Model model, @PathVariable(name = "id") Integer id,  @PathVariable(name = "coursId") Integer coursId) {

        Professeur professeur = professeurService.rechercherProfesseurParID(id);
        List<Projet> projetsProf = projetService.rechercherProjetParProfID(id);
        List<Cours> coursProf = coursService.rechercherCoursParProfId(id);

        model.addAttribute("professeur", professeur);
        model.addAttribute("projetsProf", projetsProf);
        model.addAttribute("coursProf", coursProf);

//        if (coursId != null) {

        Iterable<NoteDeCours> listNotesDeCours = serviceNoteDeCours.rechercherNoteDeCoursParCoursId(coursId);
        model.addAttribute("listNotesDeCours",listNotesDeCours);

//        }
//        Iterable<NoteDeCours> listNotesDeCours = serviceNoteDeCours.afficherNoteDeCours();
//        model.addAttribute("listNotesDeCours",listNotesDeCours);

        return "gestionNotesDeCours";
    }
}
