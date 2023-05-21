package com.portaildti.portaildti.repos;

import com.portaildti.portaildti.entities.Etudiant;
import com.portaildti.portaildti.entities.EtudiantProjet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EtudiantProjetRepository extends CrudRepository<EtudiantProjet, Integer> {
    @Query("SELECT e FROM EtudiantProjet e WHERE e.projet.id = :projetid")
    public List<EtudiantProjet> findEtudiantsByProjetId(@Param("projetid") Integer projetid);

    public Long countById(Integer id);
}
