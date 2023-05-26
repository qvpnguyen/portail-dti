package com.portaildti.portaildti.controller;


import com.portaildti.portaildti.entities.*;
import com.portaildti.portaildti.repos.NoteDeCoursRepository;
import com.portaildti.portaildti.service.CoursService;
import com.portaildti.portaildti.service.NoteDeCoursService;
import com.portaildti.portaildti.service.ProfesseurService;
import com.portaildti.portaildti.service.ProjetService;
import com.portaildti.portaildti.service.exception.DocumentNotFoundException;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
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
        model.addAttribute("pageTitle", "Ajouter un nouveau note de cours");

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
    public String ajouterNoteDeCours(NoteDeCours noteDeCours, RedirectAttributes redirectAttributes, @RequestParam(value = "documentNotesCours", required = false) MultipartFile file, Model model) throws Exception {
        if (file != null && !file.isEmpty()) {
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
            noteDeCours.setDocument(filename);
            // Récupération des données binaires du fichier image et stockage dans l'objet Utilisateur
            noteDeCours.setData(file.getBytes());
            // Vérification si le répertoire d'images existe, s'il n'existe pas, il est créé
            File directory = new File("src/main/resources/static/documents/utilisateur");
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Création d'un fichier image sur le serveur et stockage du fichier sur le serveur
            File serverFile = new File(directory.getAbsolutePath() + File.separator + filename);
            //en utilisant la méthode transferTo() de l'objet MultipartFile
            file.transferTo(serverFile);
        } else {
            if(noteDeCours.getId()!=null) {
                String document = serviceNoteDeCours.getDocumentByProjetId(noteDeCours.getId());
                noteDeCours.setDocument(document);
            }
        }
        serviceNoteDeCours.ajouterNoteDeCours(noteDeCours);
        redirectAttributes.addFlashAttribute("message","Le note de cours a été ajouté avec succès");
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
        model.addAttribute("pageTitle", "Gestion de notes de cours");


//        if (coursId != null) {

        Iterable<NoteDeCours> listNotesDeCours = serviceNoteDeCours.rechercherNoteDeCoursParCoursId(coursId);
        model.addAttribute("listNotesDeCours",listNotesDeCours);

//        }
//        Iterable<NoteDeCours> listNotesDeCours = serviceNoteDeCours.afficherNoteDeCours();
//        model.addAttribute("listNotesDeCours",listNotesDeCours);

        return "gestionNotesDeCours";
    }
    @GetMapping("/documents/utilisateur/{fileId}")
    public void telechargerFichier(@PathVariable String fileId, HttpServletResponse response, HttpServletRequest request) throws IOException, DocumentNotFoundException {
        HttpSession session = request.getSession();
        File directory = new File("src/main/resources/static/documents/utilisateur");
        if (!directory.exists()) {
            directory.mkdirs();
        }
        //On crée un fichier correspondant à l'ID passé en paramètre
        File file = new File(directory.getAbsolutePath() + File.separator + fileId);

        List<NoteDeCours> listeNotesDeCours = serviceNoteDeCours.findByDocumentName(fileId);
        for(NoteDeCours noteDeCours: listeNotesDeCours){
            if (noteDeCours.getData()!=null) {
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
}
