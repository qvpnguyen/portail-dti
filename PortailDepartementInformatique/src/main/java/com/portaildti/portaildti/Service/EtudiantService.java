package com.portaildti.portaildti.Service;

import com.portaildti.portaildti.entities.Etudiant;
import com.portaildti.portaildti.entities.Professeur;
import com.portaildti.portaildti.repos.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class EtudiantService {
    @Autowired
    private EtudiantRepository repo;

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

}
