package com.gslab.talent.service;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

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
	String newTech[] ;
	Candidate candidate;
	static int j=0;
	
	@Transactional
	@Override
	public void createCandidate(Candidate candidateObj,int id) {
		
		List<Candidate> list =getCandidateByVacancyId(id);
		for (Candidate candidate : list) {
			
			if(candidate.getEmail().equalsIgnoreCase(candidateObj.getEmail()))
			{
			candidateObj.setId(candidate.getId());	
			}
		}
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


	@Override
	public TreeMap<Integer, Integer> getAllApplicationInMonth() {
		List<Candidate> listOfCandidate = candidateRepoObj.findAll();

		TreeMap<Integer, Integer> applicationDetail = new TreeMap<>();

		System.out.println(listOfCandidate.size());
		for (Candidate candidate : listOfCandidate) {
			Date posDate = candidate.getVacancy().getPosOpenDate();
			Integer date1 = posDate.getMonth();

			switch (date1) {
			case 1:
				if (applicationDetail.get(1) != null) {
					applicationDetail.put(1, applicationDetail.get(1) + 1);
				} else {
					applicationDetail.put(1, 1);
				}

				break;
			case 2:
				if (applicationDetail.get(2) != null) {
					applicationDetail.put(2, applicationDetail.get(2) + 1);
				} else {
					applicationDetail.put(2, 1);
				}

				break;
			case 3:
				if (applicationDetail.get(3) != null) {
					applicationDetail.put(3, applicationDetail.get(3) + 1);
				} else {
					applicationDetail.put(3, 1);
				}

				break;
			case 4:
				if (applicationDetail.get(4) != null) {
					applicationDetail.put(4, applicationDetail.get(4) + 1);
				} else {
					applicationDetail.put(4, 1);
				}

				break;
			case 5:
				if (applicationDetail.get(5) != null) {
					applicationDetail.put(5, applicationDetail.get(5) + 1);
				} else {
					applicationDetail.put(5, 1);
				}
				
				break;
			case 6:
				if (applicationDetail.get(6) != null) {
					applicationDetail.put(6, applicationDetail.get(6) + 1);
				} else {
					applicationDetail.put(6, 1);
				}
				
				break;
			case 7:
				if (applicationDetail.get(7) != null) {
					applicationDetail.put(7, applicationDetail.get(7) + 1);
				} else {
					applicationDetail.put(7, 1);
				}
				
				break;
			case 8:
				if (applicationDetail.get(8) != null) {
					applicationDetail.put(8, applicationDetail.get(8) + 1);
				} else {
					applicationDetail.put(8, 1);
				}
				
				break;
			case 9:
				if (applicationDetail.get(9) != null) {
					applicationDetail.put(9, applicationDetail.get(9) + 1);
				} else {
					applicationDetail.put(9, 1);
				}

				break;
			case 10:
				if (applicationDetail.get(10) != null) {
					applicationDetail.put(10, applicationDetail.get(10) + 1);
				} else {
					applicationDetail.put(10, 1);
				}

				break;
			case 11:
				if (applicationDetail.get(11) != null) {
					applicationDetail.put(11, applicationDetail.get(11) + 1);
				} else {
					applicationDetail.put(11, 1);
				}

				break;
			case 12:
				if (applicationDetail.get(12) != null) {
					applicationDetail.put(12, applicationDetail.get(12) + 1);
				} else {
					applicationDetail.put(12, 1);
				}

				break;

			default:
				break;
			}
		}
		return applicationDetail;
	}

	public HashMap<String,Integer> getCountOfApplicationForProject(){
		List<Candidate> listOfCandidate = candidateRepoObj.findAll();
		
		HashMap<String,Integer> hashmap = new HashMap<String,Integer>();
		for (Candidate candidate : listOfCandidate) {
			String projectName = candidate.getVacancy().getProjectName();
			System.out.println("projectName :"+projectName);
			
			if(hashmap.containsKey(projectName)) {
			    hashmap.put(projectName, hashmap.get(projectName)+1);
				
			}
			else
				hashmap.put(projectName,1);
		}
		return hashmap;
		
	}
}
	

