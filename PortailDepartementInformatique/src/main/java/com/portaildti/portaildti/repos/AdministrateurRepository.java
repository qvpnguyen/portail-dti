package com.portaildti.portaildti.repos;

import com.portaildti.portaildti.entities.Administrateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.portaildti.portaildti.entities.Professeur;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
@Repository
public interface AdministrateurRepository extends CrudRepository<Administrateur,Integer> {
    @Query("SELECT a FROM Administrateur a WHERE a.email = :email and a.motDePasse=:motDePasse")
    public Administrateur getAdministrateurByEmailAndPassword(@Param("email") String email, @Param("motDePasse") String motDePasse);
    @Query("SELECT a FROM Administrateur a WHERE a.email = :email")
    public Administrateur findAdministrateurByEmail(@Param("email") String email);
}
