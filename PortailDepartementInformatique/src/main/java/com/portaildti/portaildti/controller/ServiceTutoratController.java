package com.portaildti.portaildti.controller;

import com.portaildti.portaildti.entities.*;
import com.portaildti.portaildti.service.EtudiantService;
import com.portaildti.portaildti.service.ServiceTutoratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ServiceTutoratController {

    @Autowired
    ServiceTutoratService serviceTutoratService;

    @Autowired
    EtudiantService etudiantService;

    @GetMapping("/service-tutorat")
    public String afficherTuteurs(Model model) {

        String pageTitle = "Service d'aide et tutorat";
        model.addAttribute("pageTitle", pageTitle);

        List<Etudiant> listeTuteurs = etudiantService.rechercherEtudiantsTuteur();
        Map<String, List<Cours>> coursParTuteur = new HashMap<>();
        Map<Etudiant, String> disponibiliteTuteurs = new HashMap<>();
        String disponibilite;

        if (listeTuteurs.isEmpty()) {
            model.addAttribute("aucunResultat", true);
        } else {
            for (Etudiant tuteur : listeTuteurs) {
                List<Cours> listeCoursTuteurs = serviceTutoratService.afficherCoursParTuteur(tuteur.getId());

                if (listeCoursTuteurs.isEmpty()) {

                    Cours aucunCours = new Cours();
                    aucunCours.setNom("Aucun cours assigné");
                    listeCoursTuteurs.add(aucunCours);
                }

                coursParTuteur.put(tuteur.getNom(), listeCoursTuteurs);

//if (disponibiliteTuteurs.)
//disponibiliteTuteurs.put(tuteur, tuteur.getDispoTutorat() ? "Disponible" : "Non disponible"); // Set tutor availability

            }
        }

        model.addAttribute("coursParTuteur", coursParTuteur);
        model.addAttribute("listeTuteurs", listeTuteurs);
        model.addAttribute("disponibiliteTuteurs", disponibiliteTuteurs);

        return "serviceTutorat";
    }

    @GetMapping("/service-tutorat/liste-tutores")
    public String afficherListeTutoresPourTuteur(Model model, HttpSession session) {
        Integer id = (Integer) session.getAttribute("idUtilisateur");

        String pageTitle = "Service d'aide et tutorat";
        model.addAttribute("pageTitle", pageTitle);
        List<Etudiant> listeTutoresPourTuteur = serviceTutoratService.afficherEtudiantsParTuteur(id);
        System.out.println("liste tutores: " + listeTutoresPourTuteur);
        if (listeTutoresPourTuteur.isEmpty()) {
            model.addAttribute("message", "Aucun tutoré à afficher");
        } else {
            model.addAttribute("listeTutoresPourTuteur", listeTutoresPourTuteur);
        }
        List<ServiceTutorat> listeTutoratsPourTuteur = serviceTutoratService.afficherServiceTutoratsParTuteur(id);
        System.out.println("liste tutores: " + listeTutoratsPourTuteur);
        model.addAttribute("listeTutoratsPourTuteur", listeTutoratsPourTuteur);
//        Map<Integer, List<ServiceTutorat>> tutoreParListeTutoratPourTuteur = new HashMap<>();
//        for (Etudiant tutore : tutoreParListeTutoratPourTuteur) {
//            List<ServiceTutorat> tutorats = serviceTutoratService.afficherServiceTutoratsParTuteur()
//        }
        return "servicetutorat-listetutores";
    }

}
