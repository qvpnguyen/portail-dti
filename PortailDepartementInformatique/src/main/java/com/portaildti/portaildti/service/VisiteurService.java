package com.portaildti.portaildti.service;

import com.portaildti.portaildti.entities.Visiteur;
import com.portaildti.portaildti.repos.VisiteurRepository;
import com.portaildti.portaildti.service.exception.UtilisateurNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class VisiteurService {

    @Autowired
    private VisiteurRepository repo;

    public List<Visiteur> afficherVisiteurs(){

        return (List<Visiteur>) repo.findAll();
    }

    public List<Visiteur> rechercherVisiteur(String keyword) {

        if (keyword != null) {
            return (List<Visiteur>) repo.findAll();
        }

        return  null;
    }

    public Visiteur ajouterVisiteur(Visiteur visiteur) {

//        Visiteur visiteurExistant = repo.findVisiteurByEmail(visiteur.getEmail());
//
//        if (visiteurExistant != null){
//            throw new IOException("Le visiteur existe déjà");
//
//        } else {
            return repo.save(visiteur);
//        }
    }

    public boolean isEmailVisiteurUnique(String email){

        Visiteur visiteurEmail = repo.findVisiteurByEmail(email);

        if (visiteurEmail == null){
            return true;
        }

        return false;
    }

    public Visiteur visiteurExistsByEmailAndPassword(String email, String password){

        Visiteur visiteurEmailPassword = repo.findVisiteurByEmailAndPassword(email, password);


        return visiteurEmailPassword;
    }

    public void supprimerVisiteur(Integer id) throws IOException {

        Visiteur visiteur = repo.findById(id).orElse(null);

        if (visiteur == null) {
            throw new IOException("Le visiteur n'existe pas");

        } else {
            repo.delete(visiteur);
        }
    }
    public Visiteur get(Integer id) throws UtilisateurNotFoundException {
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
    public List<Visiteur> findByPhotoName(String photo) throws UtilisateurNotFoundException {
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
        Visiteur userByEmail = repo.getUtilisateurByEmail(email);
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
