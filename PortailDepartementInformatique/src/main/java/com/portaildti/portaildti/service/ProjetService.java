package com.portaildti.portaildti.service;

import com.portaildti.portaildti.entities.Cours;
import com.portaildti.portaildti.entities.Projet;
import com.portaildti.portaildti.entities.Visiteur;
import com.portaildti.portaildti.repos.NoteDeCoursRepository;
import com.portaildti.portaildti.repos.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProjetService {

    @Autowired
    private ProjetRepository repo;

    public List<Projet> afficherProjet(){

        return (List<Projet>) repo.findAll();
    }

    public List<Projet> rechercherProjet(String keyword) {

        if (keyword != null) {
            return (List<Projet>) repo.findAll();
        }

        return  null;
    }
    public Projet ajouterProjet(Projet projet) {
        return repo.save(projet);
    }
}
