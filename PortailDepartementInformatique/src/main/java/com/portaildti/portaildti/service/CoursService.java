package com.portaildti.portaildti.service;

import com.portaildti.portaildti.entities.Cours;
import com.portaildti.portaildti.entities.NoteDeCours;
import com.portaildti.portaildti.entities.Visiteur;
import com.portaildti.portaildti.repos.CoursRepository;
import com.portaildti.portaildti.repos.NoteDeCoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CoursService {

    @Autowired
    private CoursRepository repo;

    public List<Cours> afficherCours(){

        return (List<Cours>) repo.findAll();
    }

    public List<Cours> rechercherCours(String keyword) {

        if (keyword != null) {
            return (List<Cours>) repo.findAll();
        }

        return  null;
    }
    public List<Cours> rechercherCoursParProfId(Integer id) {

        if (id != null) {
            return repo.findCoursParProfID(id);
        }

        return  null;
    }
    public List<Cours> rechercherCoursParEtuidantId(Integer id) {

        if (id != null) {
            return repo.findCoursByEtudiantId(id);
        }

        return  null;
    }
    public List<Cours> rechercherCoursParProf(String nom) {

        if (nom != null) {
            return repo.findCoursParProf(nom);
        }

        return  null;
    }
}
