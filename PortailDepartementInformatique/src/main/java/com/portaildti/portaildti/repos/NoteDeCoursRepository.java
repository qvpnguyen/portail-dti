package com.portaildti.portaildti.repos;

import com.portaildti.portaildti.entities.NoteDeCours;
import com.portaildti.portaildti.entities.Professeur;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NoteDeCoursRepository extends CrudRepository<NoteDeCours,Integer> {

    @Query("SELECT n FROM NoteDeCours n WHERE n.nom = :nom")
    public List<NoteDeCours> getNoteDeCoursByName(@Param("nom") String nom);

    @Query("SELECT n FROM NoteDeCours n WHERE n.nom = :nom")
    public NoteDeCours getNoteDeCoursSeulByName(@Param("nom") String nom);

    @Query("SELECT n FROM NoteDeCours n  JOIN n.cours c WHERE c.nom = ?1")
    public List<NoteDeCours> findAllNoteDeCoursByNameCours(String nom);
    @Query("SELECT n FROM NoteDeCours n  JOIN n.cours c WHERE c.id = ?1")
    public List<NoteDeCours> findAllNoteDeCoursByIdCours(Integer id);

    @Query("SELECT n FROM NoteDeCours n  JOIN n.professeur p WHERE p.nom = ?1")
    public List<NoteDeCours> findAllNoteDeCoursByNameProfesseur(String nom);
    @Query("SELECT n FROM NoteDeCours n WHERE n.document = :document")
    public List<NoteDeCours> findByDocumentName(@Param("document") String document);

}
