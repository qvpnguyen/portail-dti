package com.portaildti.portaildti.service;

import com.portaildti.portaildti.entities.NoteDeCours;
import com.portaildti.portaildti.repos.NoteDeCoursRepository;
import com.portaildti.portaildti.service.exception.DocumentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
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


    public List<NoteDeCours> rechercherNoteDeCoursPaNom(String nom){
        if (nom != null) {
            return repo.getNoteDeCoursByName(nom);
        }
        return null;
    }
    public NoteDeCours rechercherNoteDeCoursParID(Integer id){

            return repo.findById(id).get();

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

        NoteDeCours noteDeCours = repo.getNoteDeCoursSeulByName(nom);

        if (noteDeCours == null) return true;


        return false;

    }
    public void deleteNoteDeCours(Integer id)  {
        repo.deleteById(id);
    }

    public List<NoteDeCours> rechercherNoteDeCoursParCoursId (Integer id) {

        return repo.findAllNoteDeCoursByIdCours(id);
    }

    public String getDocumentByProjetId(Integer id) {
        return repo.findById(id).get().getDocument();
    }

   /* public String getDocumentByProjetId(Integer id) {
        Optional<NoteDeCours> optionalEntity = repo.findById(id);
        NoteDeCours entity = optionalEntity.orElse(null);
        if (entity != null) {
            return entity.getDocument();
        } else {

            throw new EntityNotFoundException("Entity with ID " + id + " not found");
        }
    }*/
    public List<NoteDeCours> findByDocumentName(String document) throws DocumentNotFoundException {
        try {
            return repo.findByDocumentName(document);
        } catch (NoSuchElementException exception) {
            throw new DocumentNotFoundException("On ne peut pas trouver le note de cours " + document);
        }
    }

}
