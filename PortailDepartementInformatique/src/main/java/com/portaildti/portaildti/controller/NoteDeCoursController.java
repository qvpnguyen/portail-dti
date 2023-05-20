package com.portaildti.portaildti.controller;


import com.portaildti.portaildti.entities.*;
import com.portaildti.portaildti.repos.NoteDeCoursRepository;
import com.portaildti.portaildti.service.CoursService;
import com.portaildti.portaildti.service.NoteDeCoursService;
import com.portaildti.portaildti.service.ProfesseurService;
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

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
public class NoteDeCoursController {
    @Autowired
    NoteDeCoursService service;
    @Autowired
    ProfesseurService professeurService;
    @Autowired
    CoursService coursService;

    @Autowired
    NoteDeCoursRepository repos;

    @GetMapping("/notesDeCours")
    public String afficherListeNotesDeCours(Model model) {

        Iterable<NoteDeCours> listNotesDeCours = service.afficherNoteDeCours();
        System.out.println("teesssssssssst  "+listNotesDeCours);
        model.addAttribute("listNotesDeCours",listNotesDeCours);


        return "gestionNotesDeCours";
    }
    @GetMapping("/notesDeCours/new")
    public String afficherFormNoteDeCours(Model model) {
        NoteDeCours noteDeCours = new NoteDeCours();
        List<Professeur> listeProfesseurs = professeurService.afficherProfesseurs();
        List<Cours> listeCours = coursService.afficherCours();
        model.addAttribute("listeProfesseurs", listeProfesseurs);
        model.addAttribute("listeCours", listeCours);
        model.addAttribute("noteDeCours",noteDeCours);

        return "notesDeCours-form";
    }
    @GetMapping("/rechercher/noteDeCours")
    public String rechercherNoteDeCours(
            Model model, @Param("note") String note)
    {
        List<NoteDeCours> listNotesDeCours = service.rechercherNoteDeCoursPaNom(note);
        model.addAttribute("listNotesDeCours", listNotesDeCours);

        return "gestionNotesDeCours";
    }
    @GetMapping("/notesDeCours/supprimer/{id}")
    public String supprimerNoteDeCours(@PathVariable(name = "id") Integer id,
                                       Model model,
                                       RedirectAttributes redirectAttributes) {
       NoteDeCours noteDeCours = service.rechercherNoteDeCoursParID(id);
        if(noteDeCours != null) {
            service.deleteNoteDeCours(id);
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
        service.ajouterNoteDeCours(noteDeCours);

        return "redirect:/notesDeCours";
    }






}
