package com.portaildti.portaildti.service;

import com.portaildti.portaildti.entities.Administrateur;
import com.portaildti.portaildti.repos.AdministrateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AdministrateurService {

    @Autowired
    private AdministrateurRepository repo;
    public List<Administrateur> afficherAdministrateurs(){

        return (List<Administrateur>) repo.findAll();
    }
    public boolean professeurExistByEmailAndPassword(String email, String mdp) {

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
}
