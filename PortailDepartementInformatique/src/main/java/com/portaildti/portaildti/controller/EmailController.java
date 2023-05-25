package com.portaildti.portaildti.controller;

import com.portaildti.portaildti.entities.Cours;
import com.portaildti.portaildti.entities.Etudiant;
import com.portaildti.portaildti.entities.ServiceTutorat;
import com.portaildti.portaildti.service.EmailService;
import com.portaildti.portaildti.service.EtudiantService;
import com.portaildti.portaildti.service.ServiceTutoratService;
import com.portaildti.portaildti.service.exception.UtilisateurNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.mail.MessagingException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class EmailController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private EtudiantService etudiantService;

    @Autowired
    private ServiceTutoratService serviceTutoratService;

    @GetMapping("/service-tutorat/{id}/rendez-vous")
    public String envoyerCourrielTutorat (Model model, @PathVariable(name = "id") Integer id) throws UtilisateurNotFoundException {

        model.addAttribute("pageTitle", "Prise de rendez-vous");

        Etudiant etudiant = etudiantService.get(id);
        Map<String, List<Cours>> coursParTuteur = new HashMap<>();
        List<Cours> listeCoursTuteurs = serviceTutoratService.afficherCoursParTuteur(etudiant.getId());
        ServiceTutorat service = new ServiceTutorat();

        model.addAttribute("listeCoursTuteurs", listeCoursTuteurs);
        model.addAttribute("etudiant", etudiant);
        model.addAttribute("etudiantEmail", etudiant.getEmail());
        model.addAttribute("service", service);


        return "email-form-tutorat";
    }

    @GetMapping("/etudiant/profil/{id}/contact")
    public String envoyerCourrielGeneral (Model model, @PathVariable(name = "id") Integer id) throws UtilisateurNotFoundException {

        model.addAttribute("pageTitle", "Envoie d'un message");

        Etudiant etudiant = etudiantService.get(id);

        model.addAttribute("etudiant", etudiant);
        model.addAttribute("utilisateurEmail", etudiant.getEmail());

        return "email-form-general";
    }

    @PostMapping("/email/envoie")
    public String envoyerEmailGeneral(RedirectAttributes redirectAttributes,
                               @RequestParam("destinataire") String destinataire,
                               @RequestParam("objet") String objet,
                               @RequestParam("contenu") String contenu, ServiceTutorat serviceTutorat) throws MessagingException, com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException {
        // multipartFile.getOriginalFilename();
        //String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        //System.out.println("fileName :" + fileName);


        emailService.envoyerCourriel(destinataire,objet,contenu, serviceTutorat.getDateTutorat(), serviceTutorat.getHeure());
        redirectAttributes.addFlashAttribute("message", "Le message a été envoyé avec succès à " +destinataire);


        return "redirect:/etudiant";
    }

    @PostMapping("/email/save")
    public String envoyerEmailTutorat(RedirectAttributes redirectAttributes,
                               @RequestParam("destinataire") String destinataire,
                               @RequestParam("objet") String objet,
                               @RequestParam("contenu") String contenu, ServiceTutorat serviceTutorat) throws MessagingException, com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException {
        // multipartFile.getOriginalFilename();
        //String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        //System.out.println("fileName :" + fileName);


        emailService.envoyerCourriel(destinataire,objet,contenu, serviceTutorat.getDateTutorat(), serviceTutorat.getHeure());
        redirectAttributes.addFlashAttribute("message", "Le message a été envoyé avec succès à " +destinataire);


        return "redirect:/service-tutorat";
    }
}
