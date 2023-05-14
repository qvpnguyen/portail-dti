package com.portaildti.portaildti.controller;


import com.portaildti.portaildti.entities.NoteDeCours;
import com.portaildti.portaildti.service.NoteDeCoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class NoteDeCoursController {
    @Autowired
    NoteDeCoursService service;

    @GetMapping("/notesDeCours")
    public String afficherListeNotesDeCours(Model model) {
        Iterable<NoteDeCours> listNotesDeCours = service.afficherNoteDeCours();
        model.addAttribute("listeNotesCoursProf",listNotesDeCours);
        return "gestionNotesDeCours";
    }
    @GetMapping("/rechercher/noteDeCours")
    public String rechercherNoteDeCours(
            Model model, @Param("note") String note)
    {
        NoteDeCours noteDeCours = service.rechercherNoteDeCoursPaNom(note);
        model.addAttribute("tnote", noteDeCours);
        model.addAttribute("note", note);
        return "gestionNotesDeCours";
    }
    @GetMapping("/notesDeCours/supprimmer/{id}")
    public String supprimerNoteDeCours(@PathVariable(name = "supprimerNoteDeCours") Integer id,
                                       Model model,
                                       RedirectAttributes redirectAttributes) {
        Optional<NoteDeCours> noteDeCours = service.rechercherNoteDeCoursParID(id);
        if(noteDeCours != null) {
            service.deleteNoteDeCours(id);
            redirectAttributes.addFlashAttribute("message",
                    "Note de cours avec  ID " + id + " a été supprimé avec succès ");
        }else{
            redirectAttributes.addFlashAttribute("message",
                    "Note de cours avec  ID " + id + " n'existe pas");
        }

        return "redirect:/gestionNotesDeCours";
    }

}
