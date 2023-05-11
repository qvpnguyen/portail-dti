package com.portaildti.portaildti.repos;

import com.portaildti.portaildti.entities.Cours;
import com.portaildti.portaildti.entities.Projet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoursRepository extends CrudRepository<Cours, Integer> {

    @Query("SELECT c FROM Cours c WHERE c.nom = :nom")
    public List<Cours> findCoursByNom(@Param("nom") String nom);

    @Query("SELECT c FROM Cours c JOIN c.profID p WHERE p.nom = :nomProf")
    List<Cours> findCoursParNomProf(@Param("nomProf") String nomProf);
}
