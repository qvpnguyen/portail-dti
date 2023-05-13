package com.portaildti.portaildti.service;

import com.portaildti.portaildti.entities.Cours;
import com.portaildti.portaildti.entities.Etudiant;
import com.portaildti.portaildti.repos.CoursRepository;
import com.portaildti.portaildti.repos.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EtudiantService {
    @Autowired
    private EtudiantRepository repo;
    @Autowired
    private CoursRepository coursRepo;
    public List<Etudiant> afficherEtudiants() {
        return (List<Etudiant>) repo.findAll();
    }
    public Etudiant ajouterEtudiant(Etudiant etudiant) {
        return repo.save(etudiant);
    }
    public List<Cours> afficherCours() { return (List<Cours>) coursRepo.findAll(); }
}
