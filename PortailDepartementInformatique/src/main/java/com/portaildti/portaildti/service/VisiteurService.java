package com.portaildti.portaildti.service;

import com.portaildti.portaildti.entities.Visiteur;
import com.portaildti.portaildti.repos.VisiteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisiteurService {
    @Autowired
    private VisiteurRepository repo;

    public List<Visiteur> afficherVisiteurs() {
        return (List<Visiteur>) repo.findAll();
    }
    public Visiteur ajouterVisiteur(Visiteur visiteur) {
        return repo.save(visiteur);
    }
}
