package com.portaildti.portaildti.repos;

import com.portaildti.portaildti.entities.Administrateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministrateurRepository extends CrudRepository<Administrateur, Integer> {

}
