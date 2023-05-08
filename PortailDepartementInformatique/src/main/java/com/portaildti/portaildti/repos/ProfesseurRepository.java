package com.portaildti.portaildti.repos;


import com.portaildti.portaildti.entities.Professeur;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProfesseurRepository  extends CrudRepository<Professeur,Integer> {

    @Query("SELECT e FROM Professeur e WHERE e.nom = :nom")
    public List<Professeur> getListeProfesseurParNom(@Param("nom") String nom);
}
