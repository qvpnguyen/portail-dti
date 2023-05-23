package com.portaildti.portaildti.repos;

import com.portaildti.portaildti.entities.Projet;
import com.portaildti.portaildti.entities.Vote;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteRepository extends CrudRepository<Vote, Long> {
    @Query("SELECT v FROM Vote v WHERE v.projetID.id = :projetId")
    List<Vote> findByProjetId(@Param("projetId") Integer projetId);

    @Query("SELECT v.rating FROM Vote v WHERE v.projetID.id = :projetId")
    Vote findVoteRatingByProjetId(@Param("projetId") Integer projetId);
}

