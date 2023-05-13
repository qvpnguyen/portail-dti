package com.portaildti.portaildti.repos;

import com.portaildti.portaildti.entities.Professeur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesseurRepository extends CrudRepository<Professeur, Integer> {

}
