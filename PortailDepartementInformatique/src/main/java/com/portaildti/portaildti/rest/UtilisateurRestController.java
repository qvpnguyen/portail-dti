package com.portaildti.portaildti.rest;

import com.portaildti.portaildti.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UtilisateurRestController {
    @Autowired
    AdministrateurService administrateurService;
    @Autowired
    ProfesseurService professeurService;
    @Autowired
    EtudiantService etudiantService;
    @Autowired
    VisiteurService visiteurService;
    @Autowired
    NoteDeCoursService noteDeCoursService;
    @Autowired
    ProjetService projetService;
    @PostMapping("/admins/check_email")
    public String verifierDoublonEmailAdmin(@Param("email") String email, @Param("id") Integer id) {
        //Pour la simplicité on retourne pas un Objet JSON mais plutôt une chaine de charactère
        // Selon la valeur que retourne la méthode isEmailUnique
        return administrateurService.isEmailUnique(email,id) ? "OK" : "Doublon";
    }
    @PostMapping("/professeurs/check_email")
    public String verifierDoublonEmailProf(@Param("email") String email, @Param("id") Integer id) {
        //Pour la simplicité on retourne pas un Objet JSON mais plutôt une chaine de charactère
        // Selon la valeur que retourne la méthode isEmailUnique
        return professeurService.isEmailUnique(email,id) ? "OK" : "Doublon";
    }
    @PostMapping("/etudiants/check_email")
    public String verifierDoublonEmailEtudiant(@Param("email") String email, @Param("id") Integer id) {
        //Pour la simplicité on retourne pas un Objet JSON mais plutôt une chaine de charactère
        // Selon la valeur que retourne la méthode isEmailUnique
        return etudiantService.isEmailUnique(email,id) ? "OK" : "Doublon";
    }
    @PostMapping("/visiteurs/check_email")
    public String verifierDoublonEmailVisiteur(@Param("email") String email, @Param("id") Integer id) {
        //Pour la simplicité on retourne pas un Objet JSON mais plutôt une chaine de charactère
        // Selon la valeur que retourne la méthode isEmailUnique
        return visiteurService.isEmailUnique(email,id) ? "OK" : "Doublon";
    }

    @PostMapping("/noteDeCours/check_note")
    public String verifierDoublonNoteDeCours(@Param("nom") String nom) {
        //Pour la simplicité on retourne pas un Objet JSON mais plutôt une chaine de charactère
        // Selon la valeur que retourne la méthode isEmailUnique
        System.out.println("nom: " + nom );
        return noteDeCoursService.isnomNoteDeCoursUnique(nom) ? "OK" : "Doublon";
    }
    @PostMapping("/note/check_note")
    public @ResponseBody String verifierDoublonNote(@RequestParam("projetID") Integer projetID) {
        // Vous devez définir cette méthode dans votre service.
        // Elle doit vérifier si le projet avec cet ID a déjà une note.
        return projetService.isProjetDejaNote(projetID) ? "OK" : "Doublon";
    }

}
