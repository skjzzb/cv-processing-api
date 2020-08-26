package com.gslab.talent.service;

import java.time.LocalDate;
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
	public TreeMap<String, Integer> getAllApplicationInMonth() {
		List<Candidate> listOfCandidate = candidateRepoObj.findAll();

		TreeMap<String, Integer> applicationDetail = new TreeMap<>();
		applicationDetail.put("January", 0);
		applicationDetail.put("February", 0);
		applicationDetail.put("March", 0);
		applicationDetail.put("April", 0);
		applicationDetail.put("May", 0);
		applicationDetail.put("June", 0);
		applicationDetail.put("July", 0);
		applicationDetail.put("August", 0);
		applicationDetail.put("September", 0);
		applicationDetail.put("October", 0);
		applicationDetail.put("November", 0);
		applicationDetail.put("December", 0);
		
		
		System.out.println(listOfCandidate.size());
		for (Candidate candidate : listOfCandidate) {
			Date posDate = candidate.getVacancy().getPosOpenDate();
			Integer date1 = posDate.getMonth();
			String month = date1.toString();
			System.out.println("month is :"+month);

			switch (date1) {
			case 1:
				if (applicationDetail.get("January") != null) {
					applicationDetail.put("January", applicationDetail.get("January") + 1);
				} else {
					applicationDetail.put("January", 1);
				}

				break;
			case 2:
				if (applicationDetail.get("February") != null) {
					applicationDetail.put("February", applicationDetail.get("February") + 1);
				} else {
					applicationDetail.put("February", 1);
				}

				break;
			case 3:
				if (applicationDetail.get("March") != null) {
					applicationDetail.put("March", applicationDetail.get("March") + 1);
				} else {
					applicationDetail.put("March", 1);
				}

				break;
			case 4:
				if (applicationDetail.get("April") != null) {
					applicationDetail.put("April", applicationDetail.get("April") + 1);
				} else {
					applicationDetail.put("April", 1);
				}

				break;
			case 5:
				if (applicationDetail.get("May") != null) {
					applicationDetail.put("May", applicationDetail.get("May") + 1);
				} else {
					applicationDetail.put("May", 1);
				}
				
				break;
			case 6:
				if (applicationDetail.get("June") != null) {
					applicationDetail.put("June", applicationDetail.get("June") + 1);
				} else {
					applicationDetail.put("June", 1);
				}
				
				break;
			case 7:
				if (applicationDetail.get("July") != null) {
					applicationDetail.put("July", applicationDetail.get("July") + 1);
				} else {
					applicationDetail.put("July", 1);
				}
				
				break;
			case 8:
				if (applicationDetail.get("August") != null) {
					applicationDetail.put("August", applicationDetail.get("August") + 1);
				} else {
					applicationDetail.put("August", 1);
				}
				
				break;
			case 9:
				if (applicationDetail.get("September") != null) {
					applicationDetail.put("September", applicationDetail.get("September") + 1);
				} else {
					applicationDetail.put("September", 1);
				}

				break;
			case 10:
				if (applicationDetail.get("October") != null) {
					applicationDetail.put("October", applicationDetail.get("October") + 1);
				} else {
					applicationDetail.put("October", 1);
				}

				break;
			case 11:
				if (applicationDetail.get("November") != null) {
					applicationDetail.put("November", applicationDetail.get("November") + 1);
				} else {
					applicationDetail.put("November", 1);
				}

				break;
			case 12:
				if (applicationDetail.get("December") != null) {
					applicationDetail.put("December", applicationDetail.get("December") + 1);
				} else {
					applicationDetail.put("December", 1);
				}

				break;

			default:
				break;
			}
		}
		return applicationDetail;
	}

	@Override
	public HashMap<String, Integer> getCountOfApplicationForProject(String str) {
		List<Candidate> listOfCandidate = candidateRepoObj.findAll();
		HashMap<String, Integer> hashmap = new HashMap<String, Integer>();

		switch (str) {

		case "year": {
			for (Candidate candidate : listOfCandidate) {
				String projectName = candidate.getVacancy().getProjectName();
				
				if (hashmap.containsKey(projectName)) {
					hashmap.put(projectName, hashmap.get(projectName) + 1);

				} else
					hashmap.put(projectName, 1);
			}
			break;
		}
		
		case "month": {
			long millis=System.currentTimeMillis();  
			Date date = new Date(millis);
			int month = date.getMonth();
			
			for (Candidate candidate : listOfCandidate) {
				
				String projectName = candidate.getVacancy().getProjectName();
				Date date1 = candidate.getVacancy().getPosOnBoardDate();
				int month1 = date1.getMonth();
				hashmap.put(projectName, 0);
				
				if(month == month1) {
					if (hashmap.containsKey(projectName)) {
						hashmap.put(projectName, hashmap.get(projectName) + 1);
					} else
						hashmap.put(projectName, 1);
 
				}
				else
					continue;
				
			}	
			
			break;
		}
		}
		return hashmap;
		
	}
	
}
	

