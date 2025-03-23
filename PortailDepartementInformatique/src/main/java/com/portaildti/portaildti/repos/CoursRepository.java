package com.portaildti.portaildti.repos;

import com.portaildti.portaildti.entities.Cours;
import org.springframework.data.repository.CrudRepository;
import com.portaildti.portaildti.entities.Projet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoursRepository extends CrudRepository<Cours, Integer> {

    @Query("SELECT c FROM Cours c WHERE c.nom = :nom")
    public List<Cours> findCoursByNom(@Param("nom") String nom);

    @Query("SELECT c FROM Cours c JOIN c.professeurSet p WHERE p.id = :idProf")
    List<Cours> findCoursParProfID(@Param("idProf") Integer idProf);

    @Query("SELECT e.coursSet FROM Etudiant e WHERE e.id = :idEtudiant")
    List<Cours> findCoursByEtudiantId(@Param("idEtudiant") Integer idEtudiant);

    @Query("SELECT c FROM Cours c JOIN c.professeurSet p WHERE p.nom = :nomProf")
    List<Cours> findCoursParProf(@Param("nomProf") String nomProf);



}
