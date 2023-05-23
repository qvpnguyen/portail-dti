package com.portaildti.portaildti.service;

import com.portaildti.portaildti.entities.Etudiant;
import com.portaildti.portaildti.entities.ServiceTutorat;
import com.portaildti.portaildti.repos.EtudiantRepository;
import com.portaildti.portaildti.repos.ServiceTutoratRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTutoratService {

    @Autowired
    ServiceTutoratRepository serviceTutoratRepository;

    @Autowired
    EtudiantRepository etudiantRepository;

    public List<Etudiant> afficherListeTuteurs(String role){

        return etudiantRepository.findEtudiantsByRole(role);
    }
}
