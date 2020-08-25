package com.gslab.talent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gslab.talent.model.EvaluationReport;


public interface EvaluationRepository extends JpaRepository<EvaluationReport,Integer>{

	//@Query("select e from EvaluationReport where candidate_id=:id")
	List<EvaluationReport> findByCandidateId(int id);

}
