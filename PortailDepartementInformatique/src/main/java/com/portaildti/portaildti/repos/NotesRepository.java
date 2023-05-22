package com.portaildti.portaildti.repos;

import com.portaildti.portaildti.entities.Notes;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NotesRepository extends CrudRepository<Notes,Integer> {

    @Query("SELECT n FROM  Notes n JOIN n.projetID p  WHERE p.nom = :nom")
    public List<Notes> findNotesByProjetName(@Param("nom") String nom);

    @Query("SELECT n FROM  Notes n JOIN n.projetID p  WHERE p.id = ?1")
    public Notes findNotesByProjetID(Integer id);

    @Query("UPDATE Notes n SET n.noteObtenue = ?2 WHERE n.id = ?1")
    @Modifying
    public void updateNoteObtenue(Integer id, int note);

}
