package com.portaildti.portaildti.service;
import com.portaildti.portaildti.entities.NoteDeCours;
import com.portaildti.portaildti.entities.Notes;
import com.portaildti.portaildti.repos.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class NotesService {
    @Autowired
    private NotesRepository repo;

    public List<Notes> afficherNote(){

        return ( List<Notes>)  repo.findAll();
    }
    public Notes rechercherNotesParID(Integer id){

        return repo.findById(id).get();

    }
    public Notes ajouterNotes(Notes notes){
        return  repo.save(notes);
    }

    public void deleteNotes(Integer id){
         repo.deleteById(id);
    }

    public List<Notes> rechercherNotesParProjetNom(String nomProjet){
        if (nomProjet != null) {
            System.out.println(nomProjet);
            return repo.findNotesByProjetName(nomProjet);
        }
        return null;
    }

    public Notes rechercherNotesParProjetID(Integer id){

        return repo.findNotesByProjetID(id);

    }

    public void modifierNoteObtenue(Integer id, int note) {

        repo.updateNoteObtenue(id,note);
    }


}
