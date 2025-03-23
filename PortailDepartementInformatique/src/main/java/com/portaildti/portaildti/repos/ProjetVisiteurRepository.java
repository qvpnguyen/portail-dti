package com.portaildti.portaildti.repos;

import com.portaildti.portaildti.entities.ProjetVisiteur;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjetVisiteurRepository extends CrudRepository<ProjetVisiteur,Integer> {

    @Query("SELECT p FROM ProjetVisiteur p WHERE p.visiteur.id = :visiteurId")
    List<ProjetVisiteur> findByVisiteurId(@Param("visiteurId") Integer visiteurId);

    @Query("SELECT p FROM ProjetVisiteur p WHERE p.visiteur.nom = :nomVisiteur")
    List<ProjetVisiteur> findByNomVisiteur(@Param("nomVisiteur") String nomVisiteur);

    @Query("SELECT p FROM ProjetVisiteur p WHERE p.id = :id")
    public ProjetVisiteur findProjetById(@Param("id") Integer id);

}
