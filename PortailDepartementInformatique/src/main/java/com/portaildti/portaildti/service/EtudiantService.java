package com.portaildti.portaildti.service;

import com.portaildti.portaildti.entities.Cours;
import com.portaildti.portaildti.entities.Etudiant;
import com.portaildti.portaildti.repos.CoursRepository;
import com.portaildti.portaildti.repos.EtudiantRepository;
import com.portaildti.portaildti.service.exception.UtilisateurNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class EtudiantService {
    @Autowired
    private EtudiantRepository repo;
    @Autowired
    private CoursRepository coursRepo;

    public List<Etudiant> afficherEtudiants(){

        return (List<Etudiant>) repo.findAll();
    }

    public List<Etudiant> rechercherEtudiants(String keyword) {

        if (keyword != null) {
            return (List<Etudiant>) repo.findAll();
        }

        return  null;
    }



    public Etudiant ajouterEtudiant(Etudiant etudiant){
        return repo.save(etudiant);
    }

    public boolean isEmailEtudiantUnique(String email){

        Etudiant etudiantEmail = repo.findEtudiantByEmail(email);

        if (etudiantEmail == null){
            return true;
        }

        return false;
    }

    public Etudiant etudiantExistsByEmailAndPassword(String email, String password){

        Etudiant etudiantEmailPassword = repo.findEtudiantByEmailAndPassword(email, password);

        return etudiantEmailPassword;
    }

    public void supprimerEtudiant(Integer id) throws Exception {

        Etudiant etudiant = repo.findById(id).orElse(null);

        if (etudiant == null) {
            throw new Exception("L'étudiant n'existe pas");

        } else {
            repo.delete(etudiant);
        }
    }
    public List<Cours> afficherCours(){

        return (List<Cours>) coursRepo.findAll();
    }
    public Etudiant get(Integer id) throws UtilisateurNotFoundException {
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
    public List<Etudiant> afficherEtudiantsParProjetNom(String projetNom) {
        if (projetNom != null) {
            return repo.findEtudiantsParProjetNom(projetNom);
        }
        return null;
    }

    public List<Etudiant> afficherEtudiantsParProjetId(Integer projetId) {
        if (projetId != null) {
            return repo.findEtudiantsParProjetId(projetId);
        }
        return null;
    }
    public List<Etudiant> findByPhotoName(String photo) throws UtilisateurNotFoundException {
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
        Etudiant userByEmail = repo.getUtilisateurByEmail(email);
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

    public List<Etudiant> afficherEtudiantsParRole(String role){

        return repo.findEtudiantsByRole(role);
    }
    public List<Etudiant> afficherEtudiantsAnciens(){

        return repo.findEtudiantsAnciens();
    }
    public List<Etudiant> afficherEtudiantsActuels(){

        return repo.findEtudiantsActuel();
    }
    public List<Etudiant> rechercherEtudiantsTuteur(){

        return repo.findEtudiantsTuteurs();
    }


    public void updateActiveStatus(Integer id, boolean enabled) {
        repo.updateActiveStatusEtudiant(id, enabled);
    }

}
