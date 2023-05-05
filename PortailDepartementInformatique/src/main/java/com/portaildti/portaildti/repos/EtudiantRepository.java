package com.portaildti.portaildti.repos;

import com.portaildti.portaildti.entities.Etudiant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EtudiantRepository extends CrudRepository<Etudiant, Integer> {

    @Query("SELECT e FROM Etudiant e WHERE e.nom = :nom")
    public List<Etudiant> getListeEtudiantParNom(@Param("nom") String nom);
}
