package com.portaildti.portaildti.controller;

import com.portaildti.portaildti.entities.*;
import com.portaildti.portaildti.service.*;
import com.portaildti.portaildti.service.exception.ProjetNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ProjetController {
    @Autowired
    ProjetService projetService;
    @Autowired
    EtudiantService etudiantService;
    @Autowired
    ProfesseurService professeurService;
    @Autowired
    CoursService coursService;
    @Autowired
    EtudiantProjetService etudiantProjetService;
    @Autowired
    NotesService notesService;
    @GetMapping("/projets/new")
    public String afficherFormulaireProjet(Model model) {
        Projet projet = new Projet();
        List<Etudiant> listeEtudiants = etudiantService.afficherEtudiants();
        List<Professeur> listeProfesseurs = professeurService.afficherProfesseurs();
        List<Cours> listeCours = coursService.afficherCours();
        model.addAttribute("projet", projet);
        model.addAttribute("listeEtudiants", listeEtudiants);
        model.addAttribute("listeProfesseurs", listeProfesseurs);
        model.addAttribute("listeCours", listeCours);
        model.addAttribute("pageTitle", "Ajouter un nouveau projet");
        return "projets-form";
    }

//    @GetMapping("/etudiants-projets/rechercher")
//    public String rechercherUtilisateur(
//            Model model, @Param("keyword") String keyword)
//    {
//        List<Projet> listeProjets = projetService.rechercherProjet(keyword);
//
//        model.addAttribute("listeProjets",listeProjets);
//        model.addAttribute("keyword", keyword);
//        return "projets";
//    }

    @GetMapping("/etudiants-projets")
    public String afficherEnsembleProjets(@RequestParam(name = "professeur", required = false) List<String> nomsProfesseurs, @RequestParam(name = "cours", required = false) List<String> nomsCours,  @RequestParam(name = "keyword", required = false) String keyword, Model model) throws ProjetNotFoundException {

        List<Projet> listeProjets = new ArrayList<>();
        List<Cours> listeCours = coursService.afficherCours();
        List<Professeur> listeProfesseurs = professeurService.afficherProfesseurs();
        Map<String, List<Etudiant>> etudiantsParProjet = new HashMap<>();
        List<Projet> projetsFiltres = new ArrayList<>();

        if (nomsProfesseurs != null && !nomsProfesseurs.isEmpty()) {
            for (String nomProfesseur : nomsProfesseurs) {
                List<Projet> projetsProfesseur = projetService.afficherProjetsParProfesseurNom(nomProfesseur);
                projetsFiltres.addAll(projetsProfesseur);
            }
            listeProjets.addAll(projetsFiltres);
        }

        if (nomsCours != null && !nomsCours.isEmpty()) {
            for (String nomCours : nomsCours) {
                List<Projet> projetsCours = projetService.afficherProjetsParCoursNom(nomCours);
                projetsFiltres.addAll(projetsCours);
            }
            listeProjets.addAll(projetsFiltres);
        }

        if ((nomsProfesseurs == null || nomsProfesseurs.isEmpty()) && (nomsCours == null || nomsCours.isEmpty())) {
            listeProjets = projetService.afficherProjet();
        }

        if (listeProjets.isEmpty()) {
            model.addAttribute("aucunResultat", true);
        } else {
            for (Projet projet : listeProjets) {
                List<Etudiant> listeEtudiants = etudiantService.afficherEtudiantsParProjetNom(projet.getNom());
                etudiantsParProjet.put(projet.getNom(), listeEtudiants);
            }
        }

        model.addAttribute("etudiantsParProjet", etudiantsParProjet);
        model.addAttribute("listeProjets", listeProjets);
        model.addAttribute("listeCours", listeCours);
        model.addAttribute("listeProfesseurs", listeProfesseurs);

        if (keyword != null){
            List<Projet> listeProjetsParNom = projetService.rechercherProjet(keyword);
            List<Projet> listeProjetsParCours = projetService.afficherProjetsParCoursNom(keyword);
            List<Projet> listeProjetsParProf = projetService.rechercherProjetParProf(keyword);
            List<Projet> listeProjetsParAnnee = projetService.afficherProjetsParAnnee(Integer.valueOf(keyword));

            model.addAttribute("listeProjets",listeProjetsParNom);
            model.addAttribute("listeProjets",listeProjetsParCours);
            model.addAttribute("listeProjets",listeProjetsParProf);
            model.addAttribute("listeProjets",listeProjetsParAnnee);
            model.addAttribute("keyword", keyword);
        }

        return "projets";
    }


//    @GetMapping("/etudiants-projets")
//    public String afficherEnsembleProjets(@RequestParam(name = "professeur", required = false) List<String> nomsProfesseurs, @RequestParam(name = "cours", required = false) List<String> nomsCours, Model model) throws ProjetNotFoundException {
//
//        Iterable<Projet> listeProjets = null;
//        List<Cours> listeCours = coursService.afficherCours();
//        List<Professeur> listeProfesseurs = professeurService.afficherProfesseurs();
//        Map<String, List<Etudiant>> etudiantsParProjet = new HashMap<>();
//        List<Projet> projetsFiltres = new ArrayList<>();
//
//        if (nomsProfesseurs != null && !nomsProfesseurs.isEmpty()) {
//
//            for (String nomProfesseur : nomsProfesseurs) {
//                List<Projet> projetsProfesseur = projetService.afficherProjetsParProfesseurNom(nomProfesseur);
//                projetsFiltres.addAll(projetsProfesseur);
//            }
//
//            listeProjets = projetsFiltres;
//
//        } else if (nomsCours != null && !nomsCours.isEmpty()) {
//
//            for (String nomCours : nomsCours) {
//                List<Projet> projetsCours = projetService.afficherProjetsParCoursNom(nomCours);
//                projetsFiltres.addAll(projetsCours);
//            }
//
//            listeProjets = projetsFiltres;
//
//        }else {
//            listeProjets = projetService.afficherProjet();
//
//            for (Projet projet : listeProjets) {
//                List<Etudiant> listeEtudiants = etudiantService.afficherEtudiantsParProjetNom(projet.getNom());
//                etudiantsParProjet.put(projet.getNom(), listeEtudiants);
//            }
//        }
//
//        model.addAttribute("etudiantsParProjet", etudiantsParProjet);
//        model.addAttribute("listeProjets", listeProjets);
//        model.addAttribute("listeCours", listeCours);
//        model.addAttribute("listeProfesseurs", listeProfesseurs);
//
//        return "projets";
//    }

    @PostMapping("/projets/save")
    public String ajouterProjet(Projet projet, RedirectAttributes redirectAttributes, @RequestParam("fileVideo") MultipartFile file, @RequestParam("membresEquipe") List<Etudiant> membres) throws Exception {
        String chemin = file.getOriginalFilename();
        String filename = StringUtils.cleanPath(chemin);
        projet.setVideo(filename);
        redirectAttributes.addFlashAttribute("message","Le projet a été ajouté avec succès");
        projetService.ajouterProjet(projet);
        for (Etudiant membre : membres) {
            EtudiantProjet etudiantProjet = new EtudiantProjet(projet, membre);
            etudiantProjetService.ajouterEtudiantProjet(etudiantProjet);
        }
        redirectAttributes.addFlashAttribute("membresEquipe", membres);
        return "redirect:/gestion-projets";
    }
    @GetMapping("projets/edit/{projetid}")
    public String mettreAJourProjet(@PathVariable(name = "projetid") Integer id, RedirectAttributes redirectAttributes, Model model) {
        try {
            while (true) {
                Projet projet = projetService.get(id);
                List<Etudiant> listeEtudiants = etudiantService.afficherEtudiants();
                List<Professeur> listeProfesseurs = professeurService.afficherProfesseurs();
                List<Cours> listeCours = coursService.afficherCours();
//                List<EtudiantProjet> membresEquipe = etudiantProjetService.rechercherEtudiantsParProjet(id);
                model.addAttribute("projet", projet);
//                model.addAttribute("membresEquipe", membres);
                model.addAttribute("listeEtudiants", listeEtudiants);
                model.addAttribute("listeProfesseurs", listeProfesseurs);
                model.addAttribute("listeCours", listeCours);
                return "projets-edit-form";
            }
        } catch (ProjetNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", "On ne peut pas trouver le projet avec l'id " + id);
            return "redirect:/gestion-projets";
        }
    }
    @GetMapping("/projets/delete/{projetid}")
    public String supprimerProjet(@PathVariable(name = "projetid") Integer id, Model model, RedirectAttributes redirectAttributes) {
        try {
            List<EtudiantProjet> listeEtudiantProjets = etudiantProjetService.rechercherEtudiantProjetsParProjetId(id);
            System.out.println("listeEtudiantProjets: " + listeEtudiantProjets);
            for (EtudiantProjet etudiantProjet : listeEtudiantProjets) {
                etudiantProjetService.supprimerEtudiantProjetsParProjetId(id);
            }
            projetService.delete(id);
            redirectAttributes.addFlashAttribute("message", "Le projet ID " + id + " a été supprimé avec succès");
        } catch (ProjetNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", "On ne peut pas trouver le projet avec l'id " + id);
        }
        return "redirect:/gestion-projets";
    }

    @GetMapping("/projets/evaluation")
    public String evaluerProjet(Model model) {

        List<Notes> listeNotesProjets = notesService.afficherNote();
        model.addAttribute("listeNotes", listeNotesProjets);

        return "evaluationProjets";
    }

    @GetMapping("/modifier/note/{id}")
    public String modifierNote (Model model,@PathVariable(name = "id") Integer id,@RequestParam("noteObtenue") int noteObtenue) {
    notesService.modifierNoteObtenue(id,noteObtenue);
        return "redirect:/projets/evaluation";
    }

    @GetMapping("/rechercher/note_projet/")
    public String rechercherNoteParNomProjet (Model model,@RequestParam("note") String nomProjet) {
        List<Notes> listNotesProjet = notesService.rechercherNotesParProjetNom(nomProjet);
        System.out.println(listNotesProjet);
        model.addAttribute("listeNotes", listNotesProjet);
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
        List<Etudiant> listeEtudiants = etudiantService.afficherEtudiants();
        List<Cours> listeCours = coursService.rechercherCoursParProf(nomProf);
        List<Projet> listeProjets = projetService.rechercherProjetParProf(nomProf);
        model.addAttribute("listeEtudiants", listeEtudiants);
        model.addAttribute("listeCours", listeCours);
        model.addAttribute("note", note);
        model.addAttribute("listeProjets", listeProjets);

        return "notes-form";
    }
    @PostMapping("/notes/save")
    public String ajouterNoteDeCours(Notes notes, RedirectAttributes redirectAttributes) throws Exception {

        redirectAttributes.addFlashAttribute("message","Le note du projet "+ notes.getProjetID().getNom()+" a été ajouté avec succès");
        notesService.ajouterNotes(notes);

        return "redirect:/projets/evaluation";
    }
}
