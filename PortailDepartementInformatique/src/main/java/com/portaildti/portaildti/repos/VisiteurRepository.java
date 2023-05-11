package com.portaildti.portaildti.repos;

import com.portaildti.portaildti.entities.Etudiant;
import com.portaildti.portaildti.entities.Visiteur;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VisiteurRepository extends CrudRepository<Visiteur, Integer> {

    @Query("SELECT v FROM Visiteur v WHERE v.nom = :nom")
    public List<Visiteur> findVisiteurByNom(@Param("nom") String nom);

    @Query("SELECT v FROM Visiteur v WHERE v.email = :email")
    public Visiteur findVisiteurByEmail(@Param("email") String email);

    @Modifying
    @Query("UPDATE Visiteur v SET v.prenom = :prenom, v.nom = :nom, v.email = :email, v.active = :active, v.ddn = :ddn, v.nomUtilisateur = :nomUtilisateur, v.motDePasse = :motDePasse WHERE v.id = :id")
    public void updateVisiteur(@Param("prenom") String prenom, @Param("nom") String nom, @Param("email") String email, @Param("active") boolean active, @Param("ddn") LocalDate ddn, @Param("nomUtilisateur") String nomUtilisateur, @Param("motDePasse") String motDePasse, @Param("id") Long id);

    @Query("SELECT e FROM Etudiant e WHERE e.email = :email and e.motDePasse=:motDePasse")
    public Visiteur findVisiteurByEmailAndPassword(@Param("email") String email, @Param("motDePasse") String motDePasse);
}
