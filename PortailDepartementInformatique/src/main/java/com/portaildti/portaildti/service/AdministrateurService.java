package com.portaildti.portaildti.service;

import com.portaildti.portaildti.entities.Administrateur;
import com.portaildti.portaildti.repos.AdministrateurRepository;
import com.portaildti.portaildti.service.exception.UtilisateurNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class AdministrateurService {

    @Autowired
    private AdministrateurRepository repo;
    public List<Administrateur> afficherAdministrateurs(){

        return (List<Administrateur>) repo.findAll();
    }
    public Administrateur adminExistByEmailAndPassword(String email, String mdp) {

        Administrateur admin = repo.getAdministrateurByEmailAndPassword(email,mdp);


        return admin;

    }
    public Administrateur ajouterAdmin(Administrateur admin) {

//        Administrateur adminExistant = repo.findAdministrateurByEmail(admin.getEmail());
//
//        if (adminExistant != null){
//            throw new IOException("L'administrateur existe déjà");
//
//        } else {
            return repo.save(admin);
//        }
    }
    public Administrateur get(Integer id) throws UtilisateurNotFoundException {
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
    public List<Administrateur> findByPhotoName(String photo) throws UtilisateurNotFoundException {
        try{
            return repo.findByFileName(photo);
        }catch (NoSuchElementException exception){
            throw new UtilisateurNotFoundException("On ne peut pas trouver un utilisateur avec la photo " + photo);
        }

    }
    public String getPhotoFromDatabase(Integer id) {
        Administrateur admin = repo.findById(id).get();
        if (admin != null) {
            return admin.getPhoto();
        }
        return null;
    }
    public String getPhotoByUserId(Integer id) {
        String photo = repo.findById(id).get().getPhoto();
        if (photo != null) {
            return photo;
        }
        return null;
    }
    public boolean isEmailUnique(String email, Integer id) {
        //On cherche un utilisateur à partir de son email
        Administrateur userByEmail = repo.getUtilisateurByEmail(email);
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
