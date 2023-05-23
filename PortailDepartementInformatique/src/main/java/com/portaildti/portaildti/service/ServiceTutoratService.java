package com.portaildti.portaildti.service;

import com.portaildti.portaildti.entities.Cours;
import com.portaildti.portaildti.entities.Etudiant;
import com.portaildti.portaildti.repos.ServiceTutoratRepository;
import com.portaildti.portaildti.repos.TuteurCourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ServiceTutoratService {
    @Autowired
    ServiceTutoratRepository serviceTutoratRepos;

    @Autowired
    TuteurCourRepository tuteurCourRepos;


    List<Etudiant> afficherEtudiantsParTuteur(Integer id){
        return serviceTutoratRepos.findEtudiantsByTuteur(id);
    }

    List<Etudiant> afficherLesTuteurs(){
        return serviceTutoratRepos.findDistinctTuteurs();
    }

    List<Cours> afficherCoursParTuteur(Integer id){
        return tuteurCourRepos.findCoursByTuteur(id);

    }
}
