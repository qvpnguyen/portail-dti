package com.portaildti.portaildti.Service;

import com.portaildti.portaildti.entities.NoteDeCours;
import com.portaildti.portaildti.repos.NoteDeCoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class NoteDeCoursService {
    @Autowired
    private NoteDeCoursRepository repo;

    public List<NoteDeCours> afficherNoteDeCours(){

        return (List<NoteDeCours>)  repo.findAll();
    }

    public NoteDeCours ajouterNoteDeCours(NoteDeCours noteDeCours){
        return  repo.save(noteDeCours);
    }


    public NoteDeCours rechercherNoteDeCoursPaNom(String nom){
        if (nom != null) {
            return repo.getNoteDeCoursByName(nom);
        }
        return null;
    }
    public Optional<NoteDeCours> rechercherNoteDeCoursParID(Integer id){

            return repo.findById(id);

    }

    public List<NoteDeCours> rechercherNoteDeCoursParProfesseurNom(String nomProfesseur){
        if (nomProfesseur != null) {
            return repo.findAllNoteDeCoursByNameProfesseur(nomProfesseur);
        }
        return null;
    }

    public List<NoteDeCours> rechercherNoteDeCoursParCoursNom(String nomCours){
        if (nomCours != null) {
            return repo.findAllNoteDeCoursByNameCours(nomCours);
        }
        return null;
    }

    public boolean isnomNoteDeCoursUnique(String nom) {

        NoteDeCours noteDeCours = repo.getNoteDeCoursByName(nom);

        if (noteDeCours == null) return true;


        return false;

    }
    public void deleteNoteDeCours(Integer id)  {
        repo.deleteById(id);
    }




}
