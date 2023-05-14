package com.portaildti.portaildti.repos;

import com.portaildti.portaildti.entities.EtudiantProjet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantProjetRepository extends CrudRepository<EtudiantProjet, Integer> {
}
