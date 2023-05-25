package com.portaildti.portaildti.repos;

import com.portaildti.portaildti.entities.Etudiant;
import com.portaildti.portaildti.entities.Projet;
import com.portaildti.portaildti.entities.ServiceTutorat;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.portaildti.portaildti.entities.ServiceTutorat;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ServiceTutoratRepository extends CrudRepository<Projet, Integer> {

    @Query("SELECT DISTINCT st.tuteur FROM ServiceTutorat st")
    List<ServiceTutorat> findAllTuteurs();
    @Query("SELECT t.etudiantTutore FROM ServiceTutorat t WHERE t.tuteur.id = :tuteurId")
    List<Etudiant> findEtudiantsByTuteur(@Param("tuteurId") Integer tuteurId);

    @Query("SELECT DISTINCT t.tuteur FROM ServiceTutorat t")
    List<Etudiant> findDistinctTuteurs();

    @Query("SELECT t FROM ServiceTutorat t WHERE t.tuteur.id = :tuteurId")
    List<ServiceTutorat> findTutoratsByTuteur(@Param("tuteurId") Integer tuteurId);
    @Query("SELECT t FROM ServiceTutorat t WHERE t.tuteur.id = :tuteurId")
    List<ServiceTutorat> findServiceTutoratsByTuteur(@Param("tuteurId") Integer tuteurId);


}
