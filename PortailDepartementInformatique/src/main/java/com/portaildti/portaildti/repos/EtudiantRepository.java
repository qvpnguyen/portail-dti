package com.portaildti.portaildti.repos;

import com.portaildti.portaildti.entities.Etudiant;
import com.portaildti.portaildti.entities.Projet;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EtudiantRepository extends CrudRepository<Etudiant, Integer> {

    @Query("SELECT e FROM Etudiant e WHERE e.nom = :nom")
    public List<Etudiant> findEtudiantsByNom(@Param("nom") String nom);

    @Query("SELECT e FROM Etudiant e WHERE e.prenom LIKE %?1% OR e.nom LIKE %?1%")
    public List<Etudiant> findEtudiantsByPrenomAndNom(String keyword);

    @Query("SELECT e FROM Etudiant e WHERE e.nom = :nom AND e.role = :role")
    public List<Etudiant> findEtudiantsByNomAndRole(@Param("nom") String nom, @Param("role") String role);

    @Query("SELECT e FROM Etudiant e WHERE e.email = :email")
    public Etudiant findEtudiantByEmail(@Param("email") String email);
    @Query("SELECT e FROM Etudiant e WHERE e.isTuteur = true ")
    public List<Etudiant> finEtudiantTuteur();

    @Query("SELECT e FROM Etudiant e WHERE e.coursSet = :coursID")
    public List<Etudiant> findEtudiantsByCoursID(@Param("coursID") Long coursID);

    @Query("SELECT e FROM Etudiant e WHERE e.dispoTutorat = :disponibilite")
    public List<Etudiant> findEtudiantsByDisponibilite(@Param("disponibilite") String disponibilite);

    @Query("SELECT e FROM Etudiant e WHERE e.formationCompletee = false ")
    public List<Etudiant> findEtudiantsActuel();

    @Query("SELECT e FROM Etudiant e WHERE e.role = :role")
    public List<Etudiant> findEtudiantsByRole(@Param("role") String role);
    @Query("SELECT e FROM Etudiant e WHERE e.isTuteur = true")
    public List<Etudiant> findEtudiantsTuteurs();

    @Query("SELECT e FROM Etudiant e WHERE e.formationCompletee = true")
    public List<Etudiant> findEtudiantsAnciens();

    @Query("SELECT e FROM Etudiant e WHERE e.role = :role AND e.dispoTutorat = :disponibilite")
    public List<Etudiant> findEtudiantsByRoleAndDisponibilite(@Param("role") String role, @Param("disponibilite") String disponibilite);

    @Query("SELECT e FROM Etudiant e WHERE e.email = :email and e.motDePasse=:motDePasse")
    public Etudiant findEtudiantByEmailAndPassword(@Param("email") String email, @Param("motDePasse") String motDePasse);
    public Long countById(Integer id);
    @Modifying
    @Query("UPDATE Etudiant e SET e.active = ?2 WHERE e.id = ?1")
    public void updateActiveStatusEtudiant(Integer id, boolean active);

    @Query("SELECT DISTINCT e FROM Etudiant e JOIN e.projets p WHERE p.nom = :nomProjet")
    public List<Etudiant> findEtudiantsParProjetNom(@Param("nomProjet") String nomProjet);

    @Query("SELECT DISTINCT e FROM Etudiant e JOIN e.projets p WHERE p.id = :idProjet")
    public List<Etudiant> findEtudiantsParProjetId(@Param("idProjet") Integer idProjet);

    @Query("SELECT e FROM Etudiant e WHERE e.photo = :fileName")
    public List<Etudiant> findByFileName(@Param("fileName") String fileName);
    @Query("SELECT e FROM Etudiant e WHERE e.email = :email")
    public Etudiant getUtilisateurByEmail(@Param("email") String email);
    @Query("SELECT e FROM Etudiant e WHERE e.isTuteur = true ")
    public List<Etudiant> findEtudiantTuteur();
}
