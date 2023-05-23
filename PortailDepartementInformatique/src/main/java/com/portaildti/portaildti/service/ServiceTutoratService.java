package com.portaildti.portaildti.service;

<<<<<<< HEAD
import com.portaildti.portaildti.entities.Cours;
import com.portaildti.portaildti.entities.Etudiant;
import com.portaildti.portaildti.entities.ServiceTutorat;
import com.portaildti.portaildti.repos.EtudiantRepository;
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
    ServiceTutoratRepository serviceTutoratRepository;

    @Autowired
    TuteurCourRepository tuteurCourRepository;

    @Autowired
    EtudiantRepository etudiantRepository;

    public List<Etudiant> afficherListeTuteurs(String role) {

        return etudiantRepository.findEtudiantsByRole(role);
    }

    List<Etudiant> afficherEtudiantsParTuteur(Integer id){
        return serviceTutoratRepository.findEtudiantsByTuteur(id);
    }

    List<Etudiant> afficherLesTuteurs(){
        return serviceTutoratRepository.findDistinctTuteurs();
    }

    List<Cours> afficherCoursParTuteur(Integer id){
        return tuteurCourRepository.findCoursByTuteur(id);

    }
}
