package com.portaildti.portaildti.Service;

import com.portaildti.portaildti.entities.Professeur;
import com.portaildti.portaildti.repos.ProfesseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProfesseurService {

    @Autowired
    private ProfesseurRepository repo;


    public List<Professeur> afficherProfesseurs(){

        return ( List<Professeur>)  repo.findAll();
    }

    public Professeur ajouterProfesseur(Professeur utilisateur){
        return  repo.save(utilisateur);
    }


}
