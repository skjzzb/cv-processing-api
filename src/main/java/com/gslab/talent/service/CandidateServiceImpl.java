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
import com.gslab.talent.model.Vacancy;
import com.gslab.talent.repository.CandidateRepository;
import com.gslab.talent.repository.VacancyRepository;


@Service
public class CandidateServiceImpl implements CandidateService {

	@Autowired
	CandidateRepository candidateRepoObj;

	@Autowired
	VacancyRepository vacancyRepository;
	
	@PersistenceUnit
	private EntityManagerFactory emf;
	
	@Transactional
	@Override
	public void createCandidate(Candidate candidateObj,int id) {
			Optional<Vacancy> vacancy= vacancyRepository.findById(id); 
			Vacancy v=vacancy.get();
			v.addCandidate(candidateObj);
			candidateRepoObj.save(candidateObj);
	}
	
	
	public List<Candidate> getCandidateByVacancyId(int id)
	{
		String jpql="select c from Candidate c left join fetch c.vacancy v where v.vacancyId=:id";
		 EntityManager em = emf.createEntityManager();
	        List<Candidate> listOfCandidate = em
	        		.createQuery(jpql,Candidate.class).setParameter("id", id)
	                .getResultList();	        		
		return listOfCandidate;	
	}

	@Override
	public List<Candidate> getAllCandidate() {
		return (List<Candidate>) candidateRepoObj.findAll();
	}

	@Override
	public Candidate findById(long id) {
//		return employeeRepoObj.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
		Optional<Candidate> optionObj = candidateRepoObj.findById(id);
		return optionObj.get();
	}

	@Override
	public void update(Candidate candidateObj,int id) {
		createCandidate(candidateObj, id);
		//return candidateRepoObj.save(candidateObj);
	}

	@Override
	public void deleteCandidateById(long id) {
		candidateRepoObj.deleteById(id);
	}
	

}
