package com.portaildti.portaildti.service;


import com.portaildti.portaildti.entities.Projet;
import com.portaildti.portaildti.entities.ProjetVisiteur;
import com.portaildti.portaildti.repos.ProjetVisiteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class projetVisiteurService {

    @Autowired
    private ProjetVisiteurRepository repos;


    public List<ProjetVisiteur> afficherProjetVisiteur(){
        return (List<ProjetVisiteur>) repos.findAll();
    }

    public List<ProjetVisiteur> rechercherProjetVisiteurParVisiteurNom(String keyword) {
        if (keyword != null) {
            return repos.findByNomVisiteur(keyword);
        }
        return null;
    }
    public List<ProjetVisiteur> rechercherProjetVisiteurParVisiteurID(Integer id) {
        if (id != null) {
            return  repos.findByVisiteurId(id);
        }
        return null;
    }
    public ProjetVisiteur ajouterProjetVisiteur(ProjetVisiteur projetVisiteur) {
        return repos.save(projetVisiteur);
    }

    public ProjetVisiteur afficherProjetParId(Integer id) {
        return repos.findProjetById(id);
    }

}
