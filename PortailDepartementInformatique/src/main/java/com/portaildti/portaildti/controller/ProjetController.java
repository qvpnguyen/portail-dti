package com.portaildti.portaildti.controller;

import com.portaildti.portaildti.entities.*;
import com.portaildti.portaildti.service.*;
import com.portaildti.portaildti.service.exception.ProjetNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import java.util.*;

@Controller
public class ProjetController {
    @Autowired
    ProjetService projetService;
    @Autowired
    projetVisiteurService projetVisiteurService;
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

    @GetMapping("/projets-visiteur/new")
    public String afficherFormulaireProjetVisiteur(Model model) {
        ProjetVisiteur projet = new ProjetVisiteur();
        model.addAttribute("projet", projet);
        model.addAttribute("pageTitle", "Ajouter un nouveau projet");
        return "projets-visiteur-form";
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
    public String afficherEnsembleProjets(@RequestParam(name = "professeur", required = false) List<String> nomsProfesseurs, @RequestParam(name = "cours", required = false) List<String> nomsCours, @RequestParam(name = "keyword", required = false) String keyword, Model model) throws ProjetNotFoundException {
        List<Projet> projets = projetService.afficherProjet();
        List<Projet> listeProjets = new ArrayList<>();
        List<Cours> listeCours = coursService.afficherCours();
        List<Professeur> listeProfesseurs = professeurService.afficherProfesseurs();
// Map<String, List<Etudiant>> etudiantsParProjet = new HashMap<>();
        List<Projet> projetsFiltres = new ArrayList<>();

        if (nomsProfesseurs != null && !nomsProfesseurs.isEmpty()) {
            for (String nomProfesseur : nomsProfesseurs) {
                List<Projet> projetsProfesseur = projetService.afficherProjetsParProfesseurNom(nomProfesseur);
                projetsFiltres.addAll(projetsProfesseur);
            }
            listeProjets.addAll(projetsFiltres);
        }


        else if (nomsCours != null && !nomsCours.isEmpty()) {
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
        }

        Map<Integer, List<Etudiant>> etudiantsParProjet = new HashMap<>();
        for (Projet projet : projets) {
            List<Etudiant> etudiants = etudiantProjetService.rechercherEtudiantsParProjet(projet.getId());
            etudiantsParProjet.put(projet.getId(), etudiants);
        }

        model.addAttribute("etudiantsParProjet", etudiantsParProjet);
        model.addAttribute("listeProjets", listeProjets);
        model.addAttribute("listeCours", listeCours);
        model.addAttribute("listeProfesseurs", listeProfesseurs);


        List<Projet> listeProjets1 = new ArrayList<>();

        String pageTitle = "Ensemble des projets";
        model.addAttribute("pageTitle", pageTitle);
        if (keyword != null){

            if (listeProjets1.isEmpty()) {
                listeProjets1 = projetService.rechercherProjet(keyword);
            }

            if (listeProjets1.isEmpty()) {
                listeProjets1 = projetService.afficherProjetsParCoursNom(keyword);
            }

            if (listeProjets1.isEmpty()) {
                listeProjets1 = projetService.rechercherProjetParProf(keyword);
            }

            model.addAttribute("listeProjets", listeProjets1);
            model.addAttribute("keyword", keyword);
        }


        return "projets";
    }

    @PostMapping("/projets/save")
    public String ajouterProjet(Projet projet, RedirectAttributes redirectAttributes, @RequestParam(value = "fileVideo", required = false) MultipartFile file, @RequestParam("membresEquipe") Set<Etudiant> membres, Model model) throws Exception {
       /* if (file != null && !file.isEmpty()) {
            // On spécifie une limite de taille de fichier
            long maxSize = 30000000; // 30MB
            // On vérifie si la taille du fichier ne dépasse pas la limite
            long fileSize = file.getSize();
            System.out.println(" fileSize : " + fileSize);
            if (fileSize > maxSize) {
                model.addAttribute("message","La taille " + fileSize + " du fichier dépasse la taille limite autorisée qui est " + maxSize + " soit 10MB ");
                return "utilisateurs_form";
            }
            String chemin = file.getOriginalFilename();
            String filename = StringUtils.cleanPath(chemin);
            // Association du nom de fichier à l'utilisateur enregistré
            projet.setVideo(filename);
            // Récupération des données binaires du fichier image et stockage dans l'objet Utilisateur
            projet.setData(file.getBytes());
            // Vérification si le répertoire d'images existe, s'il n'existe pas, il est créé
            File directory = new File("src/main/resources/static/videos/utilisateur");
            if (!directory.exists()) {
                directory.mkdirs();
            }
            // Création d'un fichier image sur le serveur et stockage du fichier sur le serveur
            File serverFile = new File(directory.getAbsolutePath() + File.separator + filename);
            //en utilisant la méthode transferTo() de l'objet MultipartFile
            file.transferTo(serverFile);
        } else {
            String video = projetService.getVideoByProjetId(projet.getId());
            projet.setVideo(video);
        }*/
        //System.out.println("projetid: " + projet.getId());
        //System.out.println("membres de l'equipe: " + membres);
        // Dans un formulaire d'edition, si un projet est existant en allant chercher son id, on va iterer parmi la liste des membres et mettre a jour la liste des membres de l'equipe en faisant les ajouts/suppressions des membres necessaires
        if (projet.getId() != null) {
            projet.setEtudiants(membres);
//            etudiantProjetService.supprimerEtudiantProjetsParProjetId(projet.getId());
//            for (Etudiant membre : membres) {
//                EtudiantProjet etudiantProjet = new EtudiantProjet(projet, membre);
//                etudiantProjetService.ajouterEtudiantProjet(etudiantProjet);
//            }
        } else {
            projetService.ajouterProjet(projet);
//            for (Etudiant membre : membres) {
            projet.setEtudiants(membres);
//                Projet projets = new Projet(membre);
//                EtudiantProjet etudiantProjet = new EtudiantProjet(projet, membre);
//                etudiantProjetService.ajouterEtudiantProjet(etudiantProjet);
//            }
        }
        projetService.ajouterProjet(projet);
        redirectAttributes.addFlashAttribute("message","Le projet a été ajouté/mis à jour avec succès");
        redirectAttributes.addFlashAttribute("membresEquipe", membres);
        return "redirect:/etudiants-projets";
    }

    @PostMapping("/projets-visiteur/save")
    public String ajouterProjetVisiteur(ProjetVisiteur projetVisiteur, RedirectAttributes redirectAttributes, @RequestParam(value = "fileVideo", required = false) MultipartFile file, Model model) throws IOException {
//        if (file != null && !file.isEmpty()) {
//            // On spécifie une limite de taille de fichier
//            long maxSize = 30000000; // 30MB
//            // On vérifie si la taille du fichier ne dépasse pas la limite
//            long fileSize = file.getSize();
//            System.out.println(" fileSize : " + fileSize);
//            if (fileSize > maxSize) {
//                model.addAttribute("message","La taille " + fileSize + " du fichier dépasse la taille limite autorisée qui est " + maxSize + " soit 10MB ");
//                return "utilisateurs_form";
//            }
//            String chemin = file.getOriginalFilename();
//            String filename = StringUtils.cleanPath(chemin);
//            // Association du nom de fichier à l'utilisateur enregistré
//            projetVisiteur.setDocument(filename);
//            // Récupération des données binaires du fichier image et stockage dans l'objet Utilisateur
//            projetVisiteur.setData(file.getBytes());
//            // Vérification si le répertoire d'images existe, s'il n'existe pas, il est créé
//            File directory = new File("src/main/resources/static/videos/utilisateur");
//            if (!directory.exists()) {
//                directory.mkdirs();
//            }
//            // Création d'un fichier image sur le serveur et stockage du fichier sur le serveur
//            File serverFile = new File(directory.getAbsolutePath() + File.separator + filename);
//            //en utilisant la méthode transferTo() de l'objet MultipartFile
//            file.transferTo(serverFile);
//        } else {
//            String video = projetService.getVideoByProjetId(projetVisiteur.getId());
//            projetVisiteur.setDocument(video);
//        }
        redirectAttributes.addFlashAttribute("message","Le projet a été ajouté avec succès");
        projetVisiteurService.ajouterProjetVisiteur(projetVisiteur);
        return "redirect:/visiteur";
    }



    @GetMapping("/videos/utilisateur/{fileId}")
    public void telechargerFichier(@PathVariable String fileId, HttpServletResponse response, HttpServletRequest request) throws IOException, ProjetNotFoundException {
        HttpSession session = request.getSession();
        File directory = new File("src/main/resources/static/videos/utilisateur");
        if (!directory.exists()) {
            directory.mkdirs();
        }
        //On crée un fichier correspondant à l'ID passé en paramètre
        File file = new File(directory.getAbsolutePath() + File.separator + fileId);

        List<Projet> listeProjets = projetService.findByVideoName(fileId);
        for(Projet projet: listeProjets){
            if (projet.getData()!=null) {
                // Si le fichier existe sur le serveur
                if (file.exists()) {
                    // On spécifie le type de contenu de la réponse HTTP
                    response.setContentType("video/mp4");

                    // On spécifie le nom du fichier à télécharger dans la réponse HTTP
                    response.setHeader("Content-Disposition", "inline; filename=\"" + fileId + "\"");
                    // On lit le contenu du fichier à télécharger
                    FileInputStream fileInputStream = new FileInputStream(file);
                    // On écrit le contenu du fichier dans la réponse HTTP
                    OutputStream outputStream = response.getOutputStream();
                    //on déclare un tableau de bytes (byte[]) appelé buffer de taille 1024,
                    //qui servira de tampon pour la lecture du fichier.
                    byte[] buffer = new byte[1024];
                    //On initialise une variable bytesRead à -1,
                    //qui sera utilisée pour stocker le nombre de bytes
                    //lus à chaque lecture dans le tampon.
                    int bytesRead = -1;
                    //Dans la boucle while, on lit les bytes du fichier
                    //dans le tampon à l'aide de la méthode read()
                    //de l'objet fileInputStream.
                    while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                        //on écrit ces bytes dans le flux de sortie (outputStream)
                        //à l'aide de la méthode write()
                        outputStream.write(buffer, 0, bytesRead);
                    }
                    fileInputStream.close();
                    outputStream.flush();
                    outputStream.close();
                }
            }

        }

    }

    @GetMapping("projets/edit/{projetid}")
    public String mettreAJourProjet(@PathVariable(name = "projetid") Integer id, RedirectAttributes redirectAttributes, Model model) {
        try {
//            while (true) {
                Projet projet = projetService.get(id);
                List<Etudiant> listeEtudiants = etudiantService.afficherEtudiants();
                List<Professeur> listeProfesseurs = professeurService.afficherProfesseurs();
                List<Cours> listeCours = coursService.afficherCours();
                List<Projet> projets = projetService.afficherProjet();
                Map<Integer, List<Etudiant>> etudiantsParProjet = new HashMap<>();
                for (Projet unProjet : projets) {
                    List<Etudiant> etudiants = etudiantProjetService.rechercherEtudiantsParProjet(unProjet.getId());
                    etudiantsParProjet.put(unProjet.getId(), etudiants);
                }
                model.addAttribute("etudiantsParProjet", etudiantsParProjet);
                model.addAttribute("projet", projet);
                model.addAttribute("listeEtudiants", listeEtudiants);
                model.addAttribute("listeProfesseurs", listeProfesseurs);
                model.addAttribute("listeCours", listeCours);
                return "projets-edit-form";
//            }
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
    @GetMapping("/projets-visiteurs")
    public String afficherProjetsVisiteurs(@RequestParam(name = "professeur", required = false) List<String> nomsProfesseurs, @RequestParam(name = "cours", required = false) List<String> nomsCours, @RequestParam(name = "keyword", required = false) String keyword, Model model) throws ProjetNotFoundException {
        List<ProjetVisiteur> projetsVisiteurs = projetVisiteurService.afficherProjetVisiteur();
        List<ProjetVisiteur> listeProjetsVisiteurs = new ArrayList<>();
        List<Cours> listeCours = coursService.afficherCours();
        List<Professeur> listeProfesseurs = professeurService.afficherProfesseurs();
// Map<String, List<Etudiant>> etudiantsParProjet = new HashMap<>();
        List<Projet> projetsFiltres = new ArrayList<>();



        Map<Integer, List<Etudiant>> etudiantsParProjet = new HashMap<>();
        for (ProjetVisiteur projet : projetsVisiteurs) {
            List<Etudiant> etudiants = etudiantProjetService.rechercherEtudiantsParProjet(projet.getId());
            etudiantsParProjet.put(projet.getId(), etudiants);
        }

        model.addAttribute("etudiantsParProjet", etudiantsParProjet);
        model.addAttribute("projetsVisiteurs", projetsVisiteurs);
        model.addAttribute("listeCours", listeCours);
        model.addAttribute("listeProfesseurs", listeProfesseurs);


        List<Projet> listeProjets1 = new ArrayList<>();

        String pageTitle = "Ensemble des projets visiteurs";
        model.addAttribute("pageTitle", pageTitle);
        if (keyword != null){

            if (listeProjets1.isEmpty()) {
                listeProjets1 = projetService.rechercherProjet(keyword);
            }

            if (listeProjets1.isEmpty()) {
                listeProjets1 = projetService.afficherProjetsParCoursNom(keyword);
            }

            if (listeProjets1.isEmpty()) {
                listeProjets1 = projetService.rechercherProjetParProf(keyword);
            }

            model.addAttribute("listeProjets", listeProjets1);
            model.addAttribute("keyword", keyword);
        }


        return "projets-visiteurs";
    }

}
