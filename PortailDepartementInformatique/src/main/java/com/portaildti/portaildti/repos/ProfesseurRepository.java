package com.portaildti.portaildti.repos;

import com.portaildti.portaildti.entities.Professeur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.portaildti.portaildti.entities.Projet;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProfesseurRepository  extends CrudRepository<Professeur,Integer> {

    @Query("SELECT p FROM Professeur p WHERE p.nom = :nom")
    public List<Professeur> getProfesseurParNom(@Param("nom") String nom);
    @Query("SELECT p FROM Professeur p WHERE p.nom = :nom")
    public Professeur getProfesseurSeulParNom(@Param("nom") String nom);

    @Query("SELECT p FROM Professeur p WHERE p.email = :email ")
    public Professeur getProfesseurByEmail(@Param("email") String email);

    @Query("SELECT p FROM Professeur p WHERE p.email = :email and p.motDePasse=:motDePasse")
    public Professeur getProfesseurByEmailAndPassword(@Param("email") String email, @Param("motDePasse") String motDePasse);


    public Long countById(Integer id);

    @Query("UPDATE Professeur u SET u.active = ?2 WHERE u.id = ?1")
    @Modifying
    public void updateActiveStatus(Integer id, boolean active);

    @Query("SELECT p FROM Projet pr JOIN pr.professeur p WHERE pr.nom = ?1")
    public List<Professeur> findProfesseursByProjetName(String nom);

    @Query("SELECT p FROM Professeur p JOIN p.coursSet c WHERE c.nom = ?1")
    public List<Professeur> findProfesseursByCoursName(String nom);

    @Query("SELECT p FROM NoteDeCours nc JOIN nc.professeur p WHERE nc.nom = ?1")
    public Professeur findProfesseursByNoteDeCoursName(String nom);
    @Query("SELECT p FROM Professeur p WHERE p.photo = :fileName")
    public List<Professeur> findByFileName(@Param("fileName") String fileName);
    @Query("SELECT p FROM Professeur p WHERE p.email = :email")
    public Professeur getUtilisateurByEmail(@Param("email") String email);
}
