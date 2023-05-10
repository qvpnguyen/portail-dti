package com.portaildti.portaildti.repos;

import com.portaildti.portaildti.entities.Etudiant;
import com.portaildti.portaildti.entities.Visiteur;
import org.springframework.data.repository.CrudRepository;

public interface VisiteurRepository extends CrudRepository<Visiteur, Integer> {
}
