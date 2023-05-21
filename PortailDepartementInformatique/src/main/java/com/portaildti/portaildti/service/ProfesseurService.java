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

    public Professeur ajouterProfesseur(Professeur professeur) throws Exception {

        Professeur professeurExistant = repo.getProfesseurByEmail(professeur.getEmail());

        if (professeurExistant != null){
            throw new Exception("Le professeur existe déjà");

        } else {
            return repo.save(professeur);
        }
    }
    public Professeur rechercherProfesseurPaNom(String nom){
        if (nom != null) {
            return repo.getProfesseurParNom(nom);
        }
        return null;
    }
    public Professeur rechercherProfesseurParProjetNom(String nomProjet){
        if (nomProjet != null) {
            return repo.findProfesseursByProjetName(nomProjet);
        }
        return null;
    }
    public Professeur rechercherProfesseurParCoursNom(String nomCours){
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
    public boolean professeurExistByEmailAndPassword(String email, String mdp) {

        Professeur prof = repo.getProfesseurByEmailAndPassword(email,mdp);

        if (prof != null) return true;


        return false;

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
}
