package com.portaildti.portaildti.rest;

import com.portaildti.portaildti.service.AdministrateurService;
import com.portaildti.portaildti.service.EtudiantService;
import com.portaildti.portaildti.service.ProfesseurService;
import com.portaildti.portaildti.service.VisiteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
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
    @PostMapping("/admins/check_email")
    public String verifierDoublonEmailAdmin(@Param("email") String email, @Param("id") Integer id) {
        //Pour la simplicité on retourne pas un Objet JSON mais plutôt une chaine de charactère
        // Selon la valeur que retourne la méthode isEmailUnique
        System.out.println("email: " + email + " id: " + id);
        return administrateurService.isEmailUnique(email,id) ? "OK" : "Doublon";
    }
    @PostMapping("/professeurs/check_email")
    public String verifierDoublonEmailProf(@Param("email") String email, @Param("id") Integer id) {
        //Pour la simplicité on retourne pas un Objet JSON mais plutôt une chaine de charactère
        // Selon la valeur que retourne la méthode isEmailUnique
        System.out.println("email: " + email + " id: " + id);
        return professeurService.isEmailUnique(email,id) ? "OK" : "Doublon";
    }
    @PostMapping("/etudiants/check_email")
    public String verifierDoublonEmailEtudiant(@Param("email") String email, @Param("id") Integer id) {
        //Pour la simplicité on retourne pas un Objet JSON mais plutôt une chaine de charactère
        // Selon la valeur que retourne la méthode isEmailUnique
        System.out.println("email: " + email + " id: " + id);
        return etudiantService.isEmailUnique(email,id) ? "OK" : "Doublon";
    }
    @PostMapping("/visiteurs/check_email")
    public String verifierDoublonEmailVisiteur(@Param("email") String email, @Param("id") Integer id) {
        //Pour la simplicité on retourne pas un Objet JSON mais plutôt une chaine de charactère
        // Selon la valeur que retourne la méthode isEmailUnique
        System.out.println("email: " + email + " id: " + id);
        return visiteurService.isEmailUnique(email,id) ? "OK" : "Doublon";
    }
}
