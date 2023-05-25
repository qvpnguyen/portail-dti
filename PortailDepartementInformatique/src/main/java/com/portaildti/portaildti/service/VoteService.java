package com.portaildti.portaildti.service;

import com.portaildti.portaildti.entities.Vote;
import com.portaildti.portaildti.repos.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class VoteService {

    @Autowired
    VoteRepository voteRepository;

    public Vote afficherRatingParProjetId(Integer projetId){

        return voteRepository.findVoteRatingByProjetId(projetId);
    }
}

