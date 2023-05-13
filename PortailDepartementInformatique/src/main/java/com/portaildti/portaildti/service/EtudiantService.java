package com.portaildti.portaildti.service;

import com.portaildti.portaildti.entities.Cours;
import com.portaildti.portaildti.entities.Etudiant;
import com.portaildti.portaildti.entities.Professeur;
import com.portaildti.portaildti.repos.CoursRepository;
import com.portaildti.portaildti.repos.EtudiantRepository;
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

    public Etudiant ajouterEtudiant(Etudiant etudiant) throws Exception {

        Etudiant etudiantExistant = repo.findEtudiantByEmail(etudiant.getEmail());

        if (etudiantExistant != null){
            throw new Exception("L'étudiant existe déjà");

        } else {
            return repo.save(etudiant);
        }
    }

    public boolean isEmailEtudiantUnique(String email){

        Etudiant etudiantEmail = repo.findEtudiantByEmail(email);

        if (etudiantEmail == null){
            return true;
        }

        return false;
    }

    public boolean etudiantExistsByEmailAndPassword(String email, String password){

        Etudiant etudiantEmailPassword = repo.findEtudiantByEmailAndPassword(email, password);

        if (etudiantEmailPassword != null){
            return true;
        }

        return false;
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
}
