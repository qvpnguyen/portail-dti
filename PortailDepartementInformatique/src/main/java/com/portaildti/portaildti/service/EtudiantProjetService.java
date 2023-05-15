package com.portaildti.portaildti.service;

import com.portaildti.portaildti.entities.EtudiantProjet;
import com.portaildti.portaildti.repos.EtudiantProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantProjetService {
    @Autowired
    EtudiantProjetRepository repo;
    public EtudiantProjet ajouterEtudiantProjet(EtudiantProjet etudiantProjet){
        return repo.save(etudiantProjet);
    }
}
