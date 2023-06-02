package com.portaildti.portaildti.repos;

import com.portaildti.portaildti.entities.Etudiant;
import com.portaildti.portaildti.entities.EtudiantProjet;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EtudiantProjetRepository extends CrudRepository<EtudiantProjet, Integer> {

//    @Query("SELECT e FROM Etudiant e JOIN EtudiantProjet ep ON ep.etudiant.id = e.id WHERE ep.projet.id = :projetid")
//    public List<Etudiant> findEtudiantsByProjetId(@Param("projetid") Integer projetid);

    @Query("SELECT e FROM Etudiant e JOIN e.projets p WHERE p.id = :projectId")
    public List<Etudiant> findEtudiantsByProjetId(@Param("projectId") Integer projectId);
    @Query("SELECT ep FROM EtudiantProjet ep WHERE ep.projet.id = :projetid")
    public List<EtudiantProjet> findEtudiantProjetsByProjetId(@Param("projetid") Integer projetid);
    @Query("DELETE FROM EtudiantProjet ep WHERE ep.projet.id = :projetid")
    @Modifying
    public void deleteEtudiantProjetsByProjetId(@Param("projetid") Integer projetid);
    public Long countById(Integer id);
    @Query("DELETE FROM EtudiantProjet ep WHERE ep.projet.id = :projetid AND ep.etudiant.id = :etudiantid")
    @Modifying
    public void deleteEtudiantFromEtudiantProjet(@Param("projetid") Integer projetid, @Param("etudiantid") Integer etudiantid);
}
