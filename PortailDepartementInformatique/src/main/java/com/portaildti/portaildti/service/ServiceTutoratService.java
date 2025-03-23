package com.portaildti.portaildti.service;

import com.portaildti.portaildti.entities.Cours;
import com.portaildti.portaildti.entities.Etudiant;
import com.portaildti.portaildti.entities.ServiceTutorat;
import com.portaildti.portaildti.repos.EtudiantRepository;
import com.portaildti.portaildti.repos.ServiceTutoratRepository;
import com.portaildti.portaildti.repos.TuteurCoursRepository;
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
    TuteurCoursRepository tuteurCoursRepository;

    @Autowired
    EtudiantRepository etudiantRepository;

    public List<Etudiant> afficherListeTuteurs(String role) {

        return etudiantRepository.findEtudiantsByRole(role);
    }
    public List<Etudiant> afficherListeTuteurs() {

        return etudiantRepository.findEtudiantsTuteurs();
    }

    public List<Etudiant> afficherEtudiantsParTuteur(Integer id){
        return serviceTutoratRepository.findEtudiantsByTuteur(id);
    }

    public List<Etudiant> afficherLesTuteurs(){
        return serviceTutoratRepository.findDistinctTuteurs();
    }

    public List<Cours> afficherCoursParTuteur(Integer id){
        return tuteurCoursRepository.findCoursByTuteur(id);

    }
    public List<ServiceTutorat> afficherServiceTutoratsParTuteur(Integer id) {
        return serviceTutoratRepository.findServiceTutoratsByTuteur(id);
    }

}
