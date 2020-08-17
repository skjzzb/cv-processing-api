package com.gslab.talent.repository;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gslab.talent.model.Candidate;
import com.gslab.talent.model.Vacancy;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

	public Candidate findByEmail(String email);
	
}
