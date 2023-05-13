package com.portaildti.portaildti.repos;

import com.portaildti.portaildti.entities.Visiteur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisiteurRepository extends CrudRepository<Visiteur, Integer> {
}
