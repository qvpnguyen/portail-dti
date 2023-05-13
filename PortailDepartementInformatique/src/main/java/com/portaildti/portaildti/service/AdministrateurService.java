package com.portaildti.portaildti.service;

import com.portaildti.portaildti.entities.Administrateur;
import com.portaildti.portaildti.repos.AdministrateurRepository;
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
    public boolean adminExistByEmailAndPassword(String email, String mdp) {

        Administrateur admin = repo.getAdministrateurByEmailAndPassword(email,mdp);

        if (admin != null) return true;


        return false;

    }
    public Administrateur ajouterAdmin(Administrateur admin) throws Exception {

        Administrateur adminExistant = repo.findAdministrateurByEmail(admin.getEmail());

        if (adminExistant != null){
            throw new Exception("L'administrateur existe déjà");

        } else {
            return repo.save(admin);
        }
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
}
