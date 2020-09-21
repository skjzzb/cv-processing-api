package com.gslab.talent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gslab.talent.model.Evaluation;


public interface EvaluationRepository extends JpaRepository<Evaluation,Integer>{

	List<Evaluation> findByCandidateId(int id);

}
