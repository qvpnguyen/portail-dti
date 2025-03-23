package com.portaildti.portaildti.repos;

import com.portaildti.portaildti.entities.Projet;
import com.portaildti.portaildti.entities.Visiteur;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjetRepository extends CrudRepository<Projet, Integer> {

    @Query("SELECT p FROM Projet p WHERE p.nom = :nom")
    public List<Projet> findProjetByNom(@Param("nom") String nom);
    @Query("SELECT p FROM Projet p WHERE p.nom = :nom")
    public Projet findProjetSeulByNom(@Param("nom") String nom);
    @Query("SELECT p FROM Projet p WHERE p.id = :id")
    public Projet findProjetById(@Param("id") Integer id);

    @Query("SELECT p FROM Projet p JOIN p.cours c WHERE c.nom = :nomCours")
    public List<Projet> findProjetsByNomCours(@Param("nomCours") String nomCours);
    @Query("SELECT p FROM Projet p JOIN p.professeur pr WHERE pr.id = :idProf")
    public List<Projet> findProjetsByIdProf(@Param("idProf") Integer idProf);
    @Query("SELECT p FROM Projet p JOIN p.etudiants pr WHERE pr.id = :idProf")
    public List<Projet> findProjetsByIdEtudiant(@Param("idProf") Integer idProf);
    @Query("SELECT p FROM Projet p JOIN p.professeur pr WHERE pr.nom = :nomProf")
    public List<Projet> findProjetsByNomProf(@Param("nomProf") String nomProf);
    public Long countById(Integer id);
    @Query("SELECT p FROM Projet p WHERE p.video = :fileVideo")
    public List<Projet> findByFileName(@Param("fileVideo") String fileVideo);
    @Query("SELECT p FROM Projet p JOIN p.professeur pr WHERE pr.nom = :professeurNom")
    public List<Projet> findProjetsByProfesseurNom(@Param("professeurNom") String professeurNom);
    @Query("SELECT p FROM Projet p JOIN p.professeur pr WHERE pr.id = :professeurId")
    public List<Projet> findProjetsByProfesseurId(@Param("professeurId") Integer professeurId);
    @Query("SELECT p FROM Projet p JOIN p.professeur pr WHERE pr.nom = :professeurNom")
    public Projet findProjetByProfesseurNom(@Param("professeurNom") String professeurNom);
    @Query("SELECT p FROM Projet p WHERE p.annee = :annee")
    public List<Projet> findProjetByAnnee(@Param("annee") Integer annee);
    @Query("SELECT p FROM Projet p JOIN p.professeur pr JOIN p.cours c WHERE pr.nom = :nomProf AND c.nom = :nomCours")
    public List<Projet> findProjetsByProfesseurEtCours(@Param("nomProf") String nomProf, @Param("nomCours") String nomCours);
    @Query("SELECT ep.projet FROM EtudiantProjet ep WHERE ep.etudiant.id = :idEtudiant")
    public List<Projet> findProjetByEtudiant(@Param("idEtudiant") Integer idEtudiant);

    @Query("SELECT e.projets FROM Etudiant e WHERE e.id = :etudiantId")
    public List<Projet> findProjetsByEtudiantId(@Param("etudiantId") Integer etudiantId);





}
