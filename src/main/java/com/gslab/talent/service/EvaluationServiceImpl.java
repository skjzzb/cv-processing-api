package com.gslab.talent.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gslab.talent.model.Candidate;
import com.gslab.talent.model.EvaluationReport;
import com.gslab.talent.repository.EvaluationRepository;

@Service
public class EvaluationServiceImpl implements EvaluationService{
	
	@PersistenceUnit
	private EntityManagerFactory emf;
	
	@Autowired
	EvaluationRepository evaluationRepoObj;
	
	@Override
	public void createNewEvaluation(EvaluationReport evaluation) {
		evaluationRepoObj.save(evaluation);
	}

	@Override
	public List<EvaluationReport> getEvaluationReport(int id)
	{   
		/*String jpql="select e from EvaluationReport where candidateId=:id";
		 EntityManager em = emf.createEntityManager();
	        List<EvaluationReport> listOfReport = em
	        		.createQuery(jpql,EvaluationReport.class).setParameter("id", id)
	                .getResultList();	        
	        System.out.println("EvaluationReport :"+listOfReport);*/
		return null;	
	}
}
