package com.gslab.talent.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gslab.talent.model.Candidate;
import com.gslab.talent.model.Evaluation;
import com.gslab.talent.repository.EvaluationRepository;

@Service
public class EvaluationServiceImpl implements EvaluationService{
	
	@PersistenceUnit
	private EntityManagerFactory emf;
	
	@Autowired
	EvaluationRepository evaluationRepoObj;
	
	@Override
	public void createNewEvaluation(Evaluation evaluation) {
		evaluationRepoObj.save(evaluation);
	}

	@Override
	public List<Evaluation> getEvaluationReport(int id)
	{   
		List<Evaluation> evaluationList= evaluationRepoObj.findByCandidateId(id);
		return evaluationList;
	}
}
