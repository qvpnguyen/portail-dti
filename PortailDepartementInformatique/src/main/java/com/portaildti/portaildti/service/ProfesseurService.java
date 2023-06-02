package com.portaildti.portaildti.service;

import com.portaildti.portaildti.entities.Professeur;
import com.portaildti.portaildti.repos.ProfesseurRepository;
import com.portaildti.portaildti.service.exception.ProfesseurNotFoundException;
import com.portaildti.portaildti.service.exception.UtilisateurNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class ProfesseurService {

    @Autowired
    private ProfesseurRepository repo;


    public List<Professeur> afficherProfesseurs(){

        return (List<Professeur>)  repo.findAll();
    }

    public Professeur ajouterProfesseur(Professeur professeur) {

//        Professeur professeurExistant = repo.getProfesseurByEmail(professeur.getEmail());
//
//        if (professeurExistant != null){
//            throw new IOException("Le professeur existe déjà");
//
//        } else {
            return repo.save(professeur);
//        }
    }

    public List<Professeur> rechercherProfesseurParNom(String nom){

        if (nom != null) {
            return repo.getProfesseurParNom(nom);
        }
        return null;
    }
    public Professeur rechercherProfesseurSeulParNom(String nom){

        if (nom != null) {
            return repo.getProfesseurSeulParNom(nom);
        }
        return null;
    }

    public Professeur rechercherProfesseurParID(Integer id){

        if (id != null) {
            return repo.findById(id).get();
        }
        return null;
    }
    public List<Professeur> rechercherProfesseurParProjetNom(String nomProjet){
        if (nomProjet != null) {
            return repo.findProfesseursByProjetName(nomProjet);
        }
        return null;
    }
    public List<Professeur> rechercherProfesseurParCoursNom(String nomCours){
        if (nomCours != null) {
            return repo.findProfesseursByCoursName(nomCours);
        }
        return null;
    }
    public Professeur rechercherProfesseurParNoteDeCoursNom(String nomNotesDeCours){
        if (nomNotesDeCours != null) {
            return repo.findProfesseursByNoteDeCoursName(nomNotesDeCours);
        }
        return null;
    }


    public boolean isEmailProfesseurUnique(String email) {

        Professeur userByEmail = repo.getProfesseurByEmail(email);

        if (userByEmail == null) return true;


        return false;

    }
    public Professeur professeurExistByEmailAndPassword(String email, String mdp) {

        Professeur prof = repo.getProfesseurByEmailAndPassword(email,mdp);




        return prof;

    }
    public void deleteProfesseur(Integer id) throws ProfesseurNotFoundException {
        Long countById = repo.countById(id);
        if (countById == null || countById == 0) {
            throw new ProfesseurNotFoundException("On ne peut pas trouver un utilisateur avec l'id" + id);
        }

        repo.deleteById(id);
    }
    public void updateActiveStatus(Integer id, boolean enabled) {
        repo.updateActiveStatus(id, enabled);
    }
    public Professeur get(Integer id) throws UtilisateurNotFoundException {
        try {
            return repo.findById(id).get();
        } catch (NoSuchElementException exception) {
            throw new UtilisateurNotFoundException("On ne peut pas trouver l'utilisateur avec l'id " + id);
        }
    }
    public void delete(Integer id) throws UtilisateurNotFoundException {
        Long countById = repo.countById(id);
        // S'il n'y a pas d'utilisateur dans la BD, on lance une exception avec un message explicatif
        if (countById == null || countById == 0) {
            throw new UtilisateurNotFoundException("On ne peut pas trouver l'utilisateur avec l'id " + id);
        }
        repo.deleteById(id);
    }
    public List<Professeur> findByPhotoName(String photo) throws UtilisateurNotFoundException {
        try{
            return repo.findByFileName(photo);
        }catch (NoSuchElementException exception){
            throw new UtilisateurNotFoundException("On ne peut pas trouver un utilisateur avec la photo " + photo);
        }

    }
    public String getPhotoByUserId(Integer id) {
        return repo.findById(id).get().getPhoto();
    }
    public boolean isEmailUnique(String email, Integer id) {
        //On cherche un utilisateur à partir de son email
        Professeur userByEmail = repo.getUtilisateurByEmail(email);
        //On vérifie l'unicité de l'email
        // quand on crée un nouveau utilisateur
        // S'il l'utilisateur n'existe pas déjà dans la bd avec l'email passé en paramètre
        // cela suppose que l'email n'existe pas
        // Autrement dit la méthode retourne true alors, l'email est unique parce que
        // l'utilisateur est null
        if (userByEmail == null) {
            return true;
        }
        //Si l' id utilisateur est null, il n'existe pas, isCreatingNew = true sinon false
        boolean isCreatingNewUser = false;
        if (id == null) {
            isCreatingNewUser = true;
        }
        //Si l' id utilisateur n'existe pas mais l' email existe,
        //on retourne false car pas email unique, on ne peut pas creer un nouveau utilisateur
        //dans le mode de création utilisateur
        if (isCreatingNewUser) {
            //mais l'email existe, on retourne false car pas unique email
            if (userByEmail != null) {
                return false;
            }
        } else {
            //dans le mode d'edition utilisateur
            //Si l'id existe mais l'id qu'on edite  est différent de celui
            //de l'utilisateur possedant l'email,
            //on retourne false, car on ne peut pas creer un nouveau , puisqu email existe
            if (userByEmail.getId() != id) {
                return false;
            }
        }
        // dans tous les cas on peut creer, editer
        return true;
    }
}
