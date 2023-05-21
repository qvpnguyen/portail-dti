package com.portaildti.portaildti.service;

import com.portaildti.portaildti.entities.EtudiantProjet;
import com.portaildti.portaildti.repos.EtudiantProjetRepository;
import com.portaildti.portaildti.service.exception.ProjetNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
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
    public List<EtudiantProjet> rechercherEtudiantsParProjet(Integer projetId) {
        if (projetId != null) {
            return repo.findEtudiantsByProjetId(projetId);
        }
        return null;
    }
    
}
