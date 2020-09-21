package com.gslab.talent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gslab.talent.model.CandidateDummy;

@Repository
public interface CandidateDummyRepository extends JpaRepository<CandidateDummy, Long> {
	
}