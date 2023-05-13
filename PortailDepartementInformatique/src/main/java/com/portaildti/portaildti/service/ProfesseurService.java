package com.portaildti.portaildti.service;

import com.portaildti.portaildti.entities.Professeur;
import com.portaildti.portaildti.repos.ProfesseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesseurService {
    @Autowired
    private ProfesseurRepository repo;
    public List<Professeur> afficherProfesseurs() {
        return (List<Professeur>) repo.findAll();
    }
    public Professeur ajouterProfesseur(Professeur prof) {
        return repo.save(prof);
    }
}
