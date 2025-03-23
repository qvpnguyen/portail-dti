package com.portaildti.portaildti.repos;

import com.portaildti.portaildti.entities.Cours;
import com.portaildti.portaildti.entities.TuteurCours;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TuteurCoursRepository extends CrudRepository<TuteurCours,Integer> {
    @Query("SELECT t.cours FROM TuteurCours t Join t.tuteur tu where tu.id = :tuteurId")
    List<Cours> findCoursByTuteur(@Param("tuteurId") Integer tuteurId);

}
