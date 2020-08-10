package com.gslab.talent.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gslab.talent.model.Candidate;
import com.gslab.talent.model.Level;
import com.gslab.talent.model.Question;
import com.gslab.talent.model.Technology;
import com.gslab.talent.repository.QuestionRepository;
import com.gslab.talent.repository.TechnologyRepository;

@Service
public class QuestionServiceImpl implements QuestionService{
	
	@Autowired
	QuestionRepository questionRepoObj;
	
	@PersistenceUnit
	private EntityManagerFactory emf;
	
	@Transactional
	@Override
	public void createQuestion(Question question) {
		questionRepoObj.save(question);

		}

	@Override
	public List<Question> getAllConceptByTechName(String technologyName) {
		String jpql="select q from Question q left join fetch q.technology t where t.technologyName=:id";
		 EntityManager em = emf.createEntityManager();
	        List<Question> listOfQuestion = em
	        		.createQuery(jpql,Question.class).setParameter("id", technologyName)
	                .getResultList();	        		
		return listOfQuestion;	
	}

	@Override
	public Question getQuestionById(Integer questionId) {
		return questionRepoObj.findById(questionId).orElse(null);
	}

}
