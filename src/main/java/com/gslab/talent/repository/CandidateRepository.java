package com.gslab.talent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gslab.talent.model.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
	

}
