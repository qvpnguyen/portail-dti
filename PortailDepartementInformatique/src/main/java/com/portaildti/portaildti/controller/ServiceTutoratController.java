package com.portaildti.portaildti.controller;

import com.portaildti.portaildti.entities.*;
import com.portaildti.portaildti.service.EtudiantService;
import com.portaildti.portaildti.service.ServiceTutoratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ServiceTutoratController {

    @Autowired
    ServiceTutoratService serviceTutoratService;

    @Autowired
    EtudiantService etudiantService;

    @GetMapping("/service-tutorat")
    public String afficherTuteurs(Model model) {

        String pageTitle = "Service d'aide et Tutorat";
        model.addAttribute("pageTitle", pageTitle);

        List<Etudiant> listeTuteurs = etudiantService.afficherEtudiantsParRole("Tuteur");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println(listeTuteurs);
        model.addAttribute("listeTuteurs", listeTuteurs);

        return "serviceTutorat";
    }
}
