package com.portaildti.portaildti.service;

import com.portaildti.portaildti.entities.Administrateur;
import com.portaildti.portaildti.repos.AdministrateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministrateurService {
    @Autowired
    private AdministrateurRepository repo;
    public List<Administrateur> afficherAdministrateurs() {
        return (List<Administrateur>) repo.findAll();
    }
    public Administrateur ajouterAdmin(Administrateur admin) {
        return repo.save(admin);
    }
}
