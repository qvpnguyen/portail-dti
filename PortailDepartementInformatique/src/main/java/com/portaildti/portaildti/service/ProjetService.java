package com.portaildti.portaildti.service;

import com.portaildti.portaildti.entities.*;
import com.portaildti.portaildti.repos.ProjetRepository;
import com.portaildti.portaildti.service.exception.ProjetNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

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
        return null;
    }
    public Projet ajouterProjet(Projet projet) {
        return repo.save(projet);
    }
    public Projet get(Integer id) throws ProjetNotFoundException {
        try {
            return repo.findById(id).get();
        } catch (NoSuchElementException exception) {
            throw new ProjetNotFoundException("On ne peut pas trouver le projet avec l'id " + id);
        }
    }
    public void delete(Integer id) throws ProjetNotFoundException {
        Long countById = repo.countById(id);
        // S'il n'y a pas de projet dans la BD, on lance une exception avec un message explicatif
        if (countById == null || countById == 0) {
            throw new ProjetNotFoundException("On ne peut pas trouver le projet avec l'id " + id);
        }
        repo.deleteById(id);
    }
    public List<Projet> findByVideoName(String video) throws ProjetNotFoundException {
        try {
            return repo.findByFileName(video);
        } catch (NoSuchElementException exception) {
            throw new ProjetNotFoundException("On ne peut pas trouver le projet avec la vidéo " + video);
        }
    }

    public Projet afficherProjetParId(Integer id) {

        return repo.findProjetById(id);
    }

    public List<Projet> afficherProjetsParProfesseurNom(String nomProfesseur) throws ProjetNotFoundException{

        try {
            return repo.findProjetsByProfesseurNom(nomProfesseur);
        } catch (NoSuchElementException exception) {
            throw new ProjetNotFoundException("On ne peut pas trouver le projet avec le nom du professeur " + nomProfesseur);
        }
    }

    public Projet afficherProjetParProfesseurNom(String nomProfesseur) throws ProjetNotFoundException{

        try {
            return repo.findProjetByProfesseurNom(nomProfesseur);
        } catch (NoSuchElementException exception) {
            throw new ProjetNotFoundException("On ne peut pas trouver le projet avec le nom du professeur " + nomProfesseur);
        }
    }

    public List<Projet> afficherProjetsParCoursNom(String nomCours) throws ProjetNotFoundException{

        try {
            return repo.findProjetsByNomCours(nomCours);
        } catch (NoSuchElementException exception) {
            throw new ProjetNotFoundException("On ne peut pas trouver le projet avec le nom du cours " + nomCours);
        }
    }    public List<Projet> afficherProjetsParAnnee(Integer annee) throws ProjetNotFoundException{

        try {
            return repo.findProjetByAnnee(annee);
        } catch (NoSuchElementException exception) {
            throw new ProjetNotFoundException("On ne peut pas trouver le projet avec l'année' " + annee);
        }
    }
}
