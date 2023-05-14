package com.portaildti.portaildti.Service;

import com.portaildti.portaildti.entities.Administrateur;
import com.portaildti.portaildti.entities.Professeur;
import com.portaildti.portaildti.repos.AdministrateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AdministrateurService {

    @Autowired
    private AdministrateurRepository repo;
    public boolean professeurExistByEmailAndPassword(String email, String mdp) {

        Administrateur admin = repo.getAdministrateurByEmailAndPassword(email,mdp);

        if (admin != null) return true;


        return false;

    }
}
