package com.portaildti.portaildti.service;

import com.portaildti.portaildti.entities.Etudiant;
import com.portaildti.portaildti.entities.EtudiantProjet;
import com.portaildti.portaildti.repos.EtudiantProjetRepository;
import com.portaildti.portaildti.service.exception.ProjetNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class EtudiantProjetService {
    @Autowired
    EtudiantProjetRepository repo;
    public EtudiantProjet ajouterEtudiantProjet(EtudiantProjet etudiantProjet){
        return repo.save(etudiantProjet);
    }
    public EtudiantProjet get(Integer id) throws ProjetNotFoundException {
        try {
            return repo.findById(id).get();
        } catch (NoSuchElementException exception) {
            throw new ProjetNotFoundException("On ne peut pas trouver le projet avec l'id " + id);
        }
    }
    public void delete(Integer id) throws ProjetNotFoundException {
        Long countById = repo.countById(id);
        if (countById == null || countById == 0) {
            throw new ProjetNotFoundException("On ne peut pas trouver le projet avec l'id " + id);
        }
        repo.deleteById(id);
    }
    public List<Etudiant> rechercherEtudiantsParProjet(Integer projetId) {
        if (projetId != null) {
            return repo.findEtudiantsByProjetId(projetId);
        }
        return null;
    }
    public List<EtudiantProjet> rechercherEtudiantProjetsParProjetId(Integer projetId) {
        if (projetId != null) {
            return repo.findEtudiantProjetsByProjetId(projetId);
        }
        return null;
    }
    // Suppression d'une entree EtudiantProjet comptant tous ses etudiants
    public void supprimerEtudiantProjetsParProjetId(Integer projetId) {
        if (projetId != null) {
            repo.deleteEtudiantProjetsByProjetId(projetId);
        }
    }
    // Suppression d'une entree EtudiantProjet selon un etudiant deselectionnee dans le formulaire Projet
    public void supprimerEtudiantProjetParEtudiantId(Integer projetId, Integer etudiantId) {
        if (projetId != null) {
            repo.deleteEtudiantFromEtudiantProjet(projetId, etudiantId);
        }
    }
}
