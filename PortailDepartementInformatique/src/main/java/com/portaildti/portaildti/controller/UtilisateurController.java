package com.portaildti.portaildti.controller;

import com.portaildti.portaildti.entities.*;
import com.portaildti.portaildti.service.*;
import com.portaildti.portaildti.service.exception.UtilisateurNotFoundException;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import java.util.List;

@Controller
public class UtilisateurController {
    @Autowired
    AdministrateurService adminService;
    @Autowired
    ProfesseurService profService;
    @Autowired
    EtudiantService etudiantService;
    @Autowired
    VisiteurService visiteurService;
    @GetMapping("/utilisateur/connexion/")
    public String connexionUtilisateurs(Model model,RedirectAttributes redirectAttributes,HttpSession session, @RequestParam("btnradio") String type, @RequestParam(name = "nomUtilisateur") String email, @RequestParam(name = "motDePasse") String password) {

        Administrateur administrateur = adminService.adminExistByEmailAndPassword(email,password);
        Visiteur visiteur = visiteurService.visiteurExistsByEmailAndPassword(email,password);
        Etudiant etudiant = etudiantService.etudiantExistsByEmailAndPassword(email,password);
        Professeur prof = profService.professeurExistByEmailAndPassword(email,password);

        if(type.equals("btnetudiant")){
            if(etudiant !=null){

//                session.setAttribute("nomEtudiant", etudiant.getNom());
//                session.setAttribute("prenomEtudiant", etudiant.getPrenom());
                session.setAttribute("nomUtilisateur", etudiant.getNom());
                session.setAttribute("prenomUtilisateur", etudiant.getPrenom());
                session.setAttribute("idUtilisateur", etudiant.getId());
                session.setAttribute("roleUtilisateur", etudiant.getRole());
                session.setAttribute("dispoTutorat", etudiant.getDispoTutorat());
                session.setAttribute("isTuteur", etudiant.getTuteur());
                session.setAttribute("utilisateurActuel",etudiant);
                return "redirect:/etudiant";

            }
            else if(administrateur!=null) {
//                session.setAttribute("nomAdmin", administrateur.getNom());
//                session.setAttribute("prenomAdmin", administrateur.getPrenom());
                session.setAttribute("nomUtilisateur", administrateur.getNom());
                session.setAttribute("prenomUtilisateur", administrateur.getPrenom());
                session.setAttribute("idUtilisateur", administrateur.getId());
                session.setAttribute("roleUtilisateur", administrateur.getRole());

                return "redirect:/administration";
            }

        } else if (type.equals("btnprofesseur")) {
            if(prof !=null){
                session.setAttribute("nomProf", prof.getNom());
//                session.setAttribute("prenomProf", prof.getPrenom());
                session.setAttribute("nomUtilisateur", prof.getNom());
                session.setAttribute("prenomUtilisateur", prof.getPrenom());
                session.setAttribute("idUtilisateur", prof.getId());
                session.setAttribute("roleUtilisateur", prof.getRole());
                session.setAttribute("profProjet",prof);

                return "redirect:/professeur";

            }
            else if(administrateur!=null) {
//                session.setAttribute("nomAdmin", administrateur.getNom());
//                session.setAttribute("prenomAdmin", administrateur.getPrenom());
                session.setAttribute("nomUtilisateur", administrateur.getNom());
                session.setAttribute("prenomUtilisateur", administrateur.getPrenom());
                session.setAttribute("idUtilisateur", administrateur.getId());
                session.setAttribute("roleUtilisateur", administrateur.getRole());

                return "redirect:/administration";
            }

        } else if (type.equals("btnvisiteur")) {
            if(visiteur !=null){
//                session.setAttribute("nomVisiteur", visiteur.getNom());
//                session.setAttribute("prenomVisiteur", visiteur.getPrenom());
                session.setAttribute("nomUtilisateur", visiteur.getNom());
                session.setAttribute("prenomUtilisateur", visiteur.getPrenom());
                session.setAttribute("idUtilisateur", visiteur.getId());
                session.setAttribute("roleUtilisateur", visiteur.getRole());

                return "redirect:/visiteur";

            }
            else if(administrateur!=null) {
//                session.setAttribute("nomAdmin", administrateur.getNom());
//                session.setAttribute("prenomAdmin", administrateur.getPrenom());
                session.setAttribute("nomUtilisateur", administrateur.getNom());
                session.setAttribute("prenomUtilisateur", administrateur.getPrenom());
                session.setAttribute("idUtilisateur", administrateur.getId());
                session.setAttribute("roleUtilisateur", administrateur.getRole());

                return "redirect:/administration";
            }
        }


        redirectAttributes.addFlashAttribute("messageConnexion", "L'email ou le mot de passe est incorrect");
        System.out.println("L'email ou le mot de passe est incorrect");
        return "redirect:/";
    }

    @GetMapping("/utilisateur/getUserData")
    @ResponseBody
    public ResponseEntity<Utilisateur> getUserData(HttpSession session) {

        String firstName = (String) session.getAttribute("nomUtilisateur");
        String lastName = (String) session.getAttribute("prenomUtilisateur");

        Utilisateur userData = new Utilisateur(firstName, lastName);

        return ResponseEntity.ok(userData);
    }

    @GetMapping("/utilisateur/deconnexion")
    public String deconnexionUtilisateurs(HttpSession session, RedirectAttributes redirectAttributes) {
        String nomUtilisateur = (String) session.getAttribute("nomUtilisateur");
        String prenomUtilisateur = (String) session.getAttribute("prenomUtilisateur");

        session.invalidate();
        redirectAttributes.addFlashAttribute("message", "Vous êtes maintenant déconnecté(e), " + nomUtilisateur + " " + prenomUtilisateur); // Add the logout message

        return "redirect:/";
    }
    @GetMapping("/admins/new")
    public String afficherFormulaireAdmin(Model model) {
        Administrateur administrateur = new Administrateur();
        model.addAttribute("administrateur", administrateur);
        model.addAttribute("pageTitle", "Ajouter un nouveau utilisateur");
        return "inscription-admin";
    }


    @GetMapping("/professeurs/new")
    public String afficherFormulaireProf(Model model) {
        Professeur professeur = new Professeur();
        model.addAttribute("professeur", professeur);
        model.addAttribute("pageTitle", "Ajouter un nouveau utilisateur");
        return "inscription-professeur";
    }
    @GetMapping("/etudiants/new")
    public String afficherFormulaireEtudiant(Model model) {
        Etudiant etudiant = new Etudiant();
        List<Cours> listeCours = etudiantService.afficherCours();
        model.addAttribute("etudiant", etudiant);
        model.addAttribute("listeCours", listeCours);
        model.addAttribute("pageTitle", "Ajouter un nouveau utilisateur");
        return "inscription-etudiant";
    }
    @GetMapping("/visiteurs/new")
    public String afficherFormulaireVisiteur(Model model) {
        Visiteur visiteur = new Visiteur();
        model.addAttribute("visiteur", visiteur);
        model.addAttribute("pageTitle", "Ajouter un nouveau utilisateur");
        return "inscription-visiteur";
    }
    @PostMapping("/admins/save")
    public String ajouterAdmin(Administrateur admin, RedirectAttributes redirectAttributes, @RequestParam(value = "fileImage", required = false) MultipartFile file, @RequestParam("role") String role, Model model) throws IOException, Exception {
        try {
            if (admin != null) {
                if (file != null && !file.isEmpty()) {
                    // On spécifie une limite de taille de fichier
                    long maxSize = 10000000; // 10MB
                    // On vérifie si la taille du fichier ne dépasse pas la limite
                    long fileSize = file.getSize();
                    if (fileSize > maxSize) {
                        model.addAttribute("message", "La taille " + fileSize + " du fichier dépasse la taille limite autorisée qui est " + maxSize + ", soit 10MB.");
                        return "inscription-admin";
                    }
                    String chemin = file.getOriginalFilename();
                    System.out.println("chemin: " + chemin);
                    String filename = StringUtils.cleanPath(chemin);
                    admin.setPhoto(filename);
                    admin.setRole(role);
                    // Récupération des données binaires du fichier image et stockage dans l'objet Utilisateur
                    admin.setData(file.getBytes());
                    // Vérification si le répertoire d'images existe, s'il n'existe pas, il est créé
                    File directory = new File("src/main/resources/static/images/utilisateur");
                    if (!directory.exists()) {
                        directory.mkdirs();
                    }

                    // Création d'un fichier image sur le serveur et stockage du fichier sur le serveur
                    File serverFile = new File(directory.getAbsolutePath() + File.separator + filename);
                    //en utilisant la méthode transferTo() de l'objet MultipartFile
                    file.transferTo(serverFile);
                } else {
                    if (admin.getId() != null) {
                        String photo = adminService.getPhotoByUserId(admin.getId());
                        admin.setPhoto(photo);
                    }

                }
                redirectAttributes.addFlashAttribute("message","L'utilisateur a été ajouté/mis à jour avec succès");
                adminService.ajouterAdmin(admin);
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "Il y a déjà un utilisateur avec le même email: " + admin.getEmail());
            return "redirect:/admins/new";
        }
        return "redirect:/utilisateurs";
    }
    @PostMapping("/professeurs/save")
    public String ajouterProf(Professeur prof, RedirectAttributes redirectAttributes, @RequestParam(value = "fileImage", required = false) MultipartFile file, @RequestParam("role") String role, Model model) throws IOException {
        try {
            if (prof != null) {
                if (file != null && !file.isEmpty()) {
                    // On spécifie une limite de taille de fichier
                    long maxSize = 10000000; // 10MB
                    // On vérifie si la taille du fichier ne dépasse pas la limite
                    long fileSize = file.getSize();
                    if (fileSize > maxSize) {
                        model.addAttribute("message", "La taille " + fileSize + " du fichier dépasse la taille limite autorisée qui est " + maxSize + ", soit 10MB.");
                        return "inscription-admin";
                    }
                    String chemin = file.getOriginalFilename();
                    System.out.println("chemin: " + chemin);
                    String filename = StringUtils.cleanPath(chemin);
                    prof.setPhoto(filename);
                    prof.setRole(role);
                    // Récupération des données binaires du fichier image et stockage dans l'objet Utilisateur
                    prof.setData(file.getBytes());
                    // Vérification si le répertoire d'images existe, s'il n'existe pas, il est créé
                    File directory = new File("src/main/resources/static/images/utilisateur");
                    if (!directory.exists()) {
                        directory.mkdirs();
                    }

                    // Création d'un fichier image sur le serveur et stockage du fichier sur le serveur
                    File serverFile = new File(directory.getAbsolutePath() + File.separator + filename);
                    //en utilisant la méthode transferTo() de l'objet MultipartFile
                    file.transferTo(serverFile);
                } else {
                    if (prof.getId() != null) {
                        String photo = profService.getPhotoByUserId(prof.getId());
                        prof.setPhoto(photo);
                    }
                }
                redirectAttributes.addFlashAttribute("message","L'utilisateur a été ajouté/mis à jour avec succès");
                profService.ajouterProfesseur(prof);
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "Il y a déjà un utilisateur avec le même email: " + prof.getEmail());
            return "redirect:/professeurs/new";
        }
        if (role.equals("Professeur")) {
            return "redirect:/professeur";
        }
        return "redirect:/utilisateurs";
    }
    @PostMapping("/etudiants/save")
    public String ajouterEtudiant(Etudiant etudiant, RedirectAttributes redirectAttributes, @RequestParam(value = "fileImage", required = false) MultipartFile file, @RequestParam("role") String role, Model model) throws IOException {
        try {
            if (etudiant != null) {
                if (file != null && !file.isEmpty()) {
                    // On spécifie une limite de taille de fichier
                    long maxSize = 10000000; // 10MB
                    // On vérifie si la taille du fichier ne dépasse pas la limite
                    long fileSize = file.getSize();
                    if (fileSize > maxSize) {
                        model.addAttribute("message", "La taille " + fileSize + " du fichier dépasse la taille limite autorisée qui est " + maxSize + ", soit 10MB.");
                        return "inscription-admin";
                    }
                    String chemin = file.getOriginalFilename();
                    String filename = StringUtils.cleanPath(chemin);
                    etudiant.setPhoto(filename);
                    etudiant.setRole(role);
                    // Récupération des données binaires du fichier image et stockage dans l'objet Utilisateur
                    etudiant.setData(file.getBytes());
                    // Vérification si le répertoire d'images existe, s'il n'existe pas, il est créé
                    File directory = new File("src/main/resources/static/images/utilisateur");
                    if (!directory.exists()) {
                        directory.mkdirs();
                    }


                    // Création d'un fichier image sur le serveur et stockage du fichier sur le serveur
                    File serverFile = new File(directory.getAbsolutePath() + File.separator + filename);
                    //en utilisant la méthode transferTo() de l'objet MultipartFile
                    file.transferTo(serverFile);
                } else {
                    if (etudiant.getId() != null) {
                        String photo = etudiantService.getPhotoByUserId(etudiant.getId());
                        etudiant.setPhoto(photo);
                    }
                }
                redirectAttributes.addFlashAttribute("message","L'utilisateur a été ajouté/mis à jour avec succès");
                etudiantService.ajouterEtudiant(etudiant);
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "Il y a déjà un utilisateur avec le même email: " + etudiant.getEmail());
            return "redirect:/etudiants/new";
        }
        if (role.equals("Etudiant")) {
            return "redirect:/etudiant";
        }
        return "redirect:/utilisateurs";
    }
    @PostMapping("/visiteurs/save")
    public String ajouterVisiteur(Visiteur visiteur, RedirectAttributes redirectAttributes, @RequestParam(value = "fileImage", required = false) MultipartFile file, @RequestParam("role") String role, Model model) throws Exception {
        try {
            if (visiteur != null) {
                if (file != null && !file.isEmpty()) {
                    // On spécifie une limite de taille de fichier
                    long maxSize = 10000000; // 10MB
                    // On vérifie si la taille du fichier ne dépasse pas la limite
                    long fileSize = file.getSize();
                    if (fileSize > maxSize) {
                        model.addAttribute("message", "La taille " + fileSize + " du fichier dépasse la taille limite autorisée qui est " + maxSize + ", soit 10MB.");
                        return "inscription-admin";
                    }
                    String chemin = file.getOriginalFilename();
                    System.out.println("chemin: " + chemin);
                    String filename = StringUtils.cleanPath(chemin);
                    visiteur.setPhoto(filename);
                    visiteur.setRole(role);
                    // Récupération des données binaires du fichier image et stockage dans l'objet Utilisateur
                    visiteur.setData(file.getBytes());
                    // Vérification si le répertoire d'images existe, s'il n'existe pas, il est créé
                    File directory = new File("src/main/resources/static/images/utilisateur");
                    if (!directory.exists()) {
                        directory.mkdirs();
                    }

                    // Création d'un fichier image sur le serveur et stockage du fichier sur le serveur
                    File serverFile = new File(directory.getAbsolutePath() + File.separator + filename);
                    //en utilisant la méthode transferTo() de l'objet MultipartFile
                    file.transferTo(serverFile);
                } else {
                        if (visiteur.getId() != null) {
                            String photo = visiteurService.getPhotoByUserId(visiteur.getId());
                            visiteur.setPhoto(photo);
                        }
                }
                redirectAttributes.addFlashAttribute("message","L'utilisateur a été ajouté/mis à jour avec succès");
                visiteurService.ajouterVisiteur(visiteur);
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "Il y a déjà un utilisateur avec le même email: " + visiteur.getEmail());
            return "redirect:/visiteurs/new";
        }

        if (role.equals("Visiteur")) {
            return "redirect:/visiteur";
        }
        return "redirect:/utilisateurs";
    }
    @GetMapping("/images/admins/{fileId}")
    public void telechargerFichierAdmin(@PathVariable String fileId, HttpServletResponse response, HttpServletRequest request) throws IOException, UtilisateurNotFoundException {
        HttpSession session = request.getSession();
        File directory = new File("src/main/resources/static/images/utilisateur");
        if (!directory.exists()) {
            directory.mkdirs();
        }
        //On crée un fichier correspondant à l'ID passé en paramètre
        File file = new File(directory.getAbsolutePath() + File.separator + fileId);

        List<Administrateur> listeAdmins = adminService.findByPhotoName(fileId);
        for (Administrateur admin : listeAdmins) {
            if(admin.getData()!=null){
                // Si le fichier existe sur le serveur
                if (file.exists()) {
                    // On spécifie le type de contenu de la réponse HTTP
                    response.setContentType("image/jpeg");

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
    @GetMapping("/images/professeurs/{fileId}")
    public void telechargerFichierProf(@PathVariable String fileId, HttpServletResponse response, HttpServletRequest request) throws IOException, UtilisateurNotFoundException {
        HttpSession session = request.getSession();
        File directory = new File("src/main/resources/static/images/utilisateur");
        if (!directory.exists()) {
            directory.mkdirs();
        }
        //On crée un fichier correspondant à l'ID passé en paramètre
        File file = new File(directory.getAbsolutePath() + File.separator + fileId);

        List<Professeur> listeProfesseurs = profService.findByPhotoName(fileId);
        for (Professeur prof : listeProfesseurs) {
            if(prof.getData()!=null){
                // Si le fichier existe sur le serveur
                if (file.exists()) {
                    // On spécifie le type de contenu de la réponse HTTP
                    response.setContentType("image/jpeg");

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
    @GetMapping("/images/etudiants/{fileId}")
    public void telechargerFichierEtudiant(@PathVariable String fileId, HttpServletResponse response, HttpServletRequest request) throws IOException, UtilisateurNotFoundException {
        HttpSession session = request.getSession();
        File directory = new File("src/main/resources/static/images/utilisateur");
        if (!directory.exists()) {
            directory.mkdirs();
        }
        //On crée un fichier correspondant à l'ID passé en paramètre
        File file = new File(directory.getAbsolutePath() + File.separator + fileId);

        List<Etudiant> listeEtudiants = etudiantService.findByPhotoName(fileId);
        for (Etudiant etudiant : listeEtudiants) {
            if(etudiant.getData()!=null){
                // Si le fichier existe sur le serveur
                if (file.exists()) {
                    // On spécifie le type de contenu de la réponse HTTP
                    response.setContentType("image/jpeg");

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
    @GetMapping("/images/visiteurs/{fileId}")
    public void telechargerFichierVisiteur(@PathVariable String fileId, HttpServletResponse response, HttpServletRequest request) throws IOException, UtilisateurNotFoundException {
        HttpSession session = request.getSession();
        File directory = new File("src/main/resources/static/images/utilisateur");
        if (!directory.exists()) {
            directory.mkdirs();
        }
        //On crée un fichier correspondant à l'ID passé en paramètre
        File file = new File(directory.getAbsolutePath() + File.separator + fileId);

        List<Visiteur> listeVisiteurs = visiteurService.findByPhotoName(fileId);
        for (Visiteur visiteur : listeVisiteurs) {
            if(visiteur.getData()!=null){
                // Si le fichier existe sur le serveur
                if (file.exists()) {
                    // On spécifie le type de contenu de la réponse HTTP
                    response.setContentType("image/jpeg");

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

    @GetMapping("/admins/edit/{id}")
    public String mettreAJourAdmin(@PathVariable(name = "id") Integer id, RedirectAttributes redirectAttributes, Model model) {
        try {
            Administrateur administrateur = adminService.get(id);
            model.addAttribute("administrateur", administrateur);
            model.addAttribute("pageTitle", "Mise a jour le compte Admin");
            return "inscription-admin";
        } catch (UtilisateurNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", "On ne peut pas trouver l'utilisateur avec l'id " + id);
            return "redirect:/utilisateurs";
        }
    }
    @GetMapping("/professeurs/edit/{id}")
    public String mettreAJourProf(@PathVariable(name = "id") Integer id, RedirectAttributes redirectAttributes, Model model) {
        try {

            Professeur professeur = profService.get(id);
            model.addAttribute("professeur", professeur);
            return "inscription-professeur";
        } catch (UtilisateurNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", "On ne peut pas trouver l'utilisateur avec l'id " + id);
            return "redirect:/utilisateurs";
        }
    }
    @GetMapping("/etudiants/edit/{id}")
    public String mettreAJourEtudiant(@PathVariable(name = "id") Integer id, RedirectAttributes redirectAttributes, Model model) {
        try {
            Etudiant etudiant = etudiantService.get(id);
            model.addAttribute("etudiant", etudiant);
            List<Cours> listeCours = etudiantService.afficherCours();
            model.addAttribute("listeCours", listeCours);
            return "inscription-etudiant";
        } catch (UtilisateurNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", "On ne peut pas trouver l'utilisateur avec l'id " + id);
            return "redirect:/utilisateurs";
        }
    }
    @GetMapping("/visiteurs/edit/{id}")
    public String mettreAJourVisiteur(@PathVariable(name = "id") Integer id, RedirectAttributes redirectAttributes, Model model) {
        try {
            Visiteur visiteur = visiteurService.get(id);
            model.addAttribute("visiteur", visiteur);
            return "inscription-visiteur";
        } catch (UtilisateurNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", "On ne peut pas trouver l'utilisateur avec l'id " + id);
            return "redirect:/utilisateurs";
        }
    }
    @GetMapping("/admins/delete/{id}")
    public String supprimerAdmin(@PathVariable(name = "id") Integer id, Model model, RedirectAttributes redirectAttributes) {
        try {
            adminService.delete(id);
            redirectAttributes.addFlashAttribute("message", "L'utilisateur ID " + id + " a été supprimé avec succès");
        } catch (UtilisateurNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", "On ne peut pas trouver l'utilisateur avec l'id " + id);
        }
        return "redirect:/utilisateurs";
    }
    @GetMapping("/professeurs/delete/{id}")
    public String supprimerProf(@PathVariable(name = "id") Integer id, Model model, RedirectAttributes redirectAttributes) {
        try {
            profService.delete(id);
            redirectAttributes.addFlashAttribute("message", "L'utilisateur ID " + id + " a été supprimé avec succès");
        } catch (UtilisateurNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", "On ne peut pas trouver l'utilisateur avec l'id " + id);
        }
        return "redirect:/utilisateurs";
    }
    @GetMapping("/etudiants/delete/{id}")
    public String supprimerEtudiant(@PathVariable(name = "id") Integer id, Model model, RedirectAttributes redirectAttributes) {
        try {
            etudiantService.delete(id);
            redirectAttributes.addFlashAttribute("message", "L'utilisateur ID " + id + " a été supprimé avec succès");
        } catch (UtilisateurNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", "On ne peut pas trouver l'utilisateur avec l'id " + id);
        }
        return "redirect:/utilisateurs";
    }
    @GetMapping("/visiteurs/delete/{id}")
    public String supprimerVisiteur(@PathVariable(name = "id") Integer id, Model model, RedirectAttributes redirectAttributes) {
        try {
            visiteurService.delete(id);
            redirectAttributes.addFlashAttribute("message", "L'utilisateur ID " + id + " a été supprimé avec succès");
        } catch (UtilisateurNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", "On ne peut pas trouver l'utilisateur avec l'id " + id);
        }
        return "redirect:/utilisateurs";
    }
}
