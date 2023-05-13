package com.portaildti.portaildti.Service;

import com.portaildti.portaildti.entities.Etudiant;
import com.portaildti.portaildti.entities.Visiteur;
import com.portaildti.portaildti.repos.EtudiantRepository;
import com.portaildti.portaildti.repos.VisiteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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

    public Visiteur ajouterVisiteur(Visiteur visiteur) throws Exception {

        Visiteur visiteurExistant = repo.findVisiteurByEmail(visiteur.getEmail());

        if (visiteurExistant != null){
            throw new Exception("Le visiteur existe déjà");

        } else {
            return repo.save(visiteur);
        }
    }

    public boolean isEmailVisiteurUnique(String email){

        Visiteur visiteurEmail = repo.findVisiteurByEmail(email);

        if (visiteurEmail == null){
            return true;
        }

        return false;
    }

    public boolean visiteurExistsByEmailAndPassword(String email, String password){

        Visiteur visiteurEmailPassword = repo.findVisiteurByEmailAndPassword(email, password);

        if (visiteurEmailPassword != null){
            return true;
        }

        return false;
    }

    public void supprimerVisiteur(Integer id) throws Exception {

        Visiteur visiteur = repo.findById(id).orElse(null);

        if (visiteur == null) {
            throw new Exception("Le visiteur n'existe pas");

        } else {
            repo.delete(visiteur);
        }
    }
}
