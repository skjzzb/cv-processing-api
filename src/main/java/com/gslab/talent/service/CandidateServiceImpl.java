package com.gslab.talent.service;


import java.util.ArrayList;
import java.util.Comparator;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gslab.talent.model.Candidate;
import com.gslab.talent.model.Helper;
import com.gslab.talent.model.Position;
import com.gslab.talent.model.Project;
import com.gslab.talent.model.Vacancy;
import com.gslab.talent.repository.CandidateRepository;
import com.gslab.talent.repository.PositionRepository;
import com.gslab.talent.repository.ProjectRepository;
import com.gslab.talent.repository.VacancyRepository;


@Service
public class CandidateServiceImpl implements CandidateService {

	@Autowired
	CandidateRepository candidateRepoObj;

	@Autowired
	VacancyRepository vacancyRepository;
	
	@Autowired
	PositionRepository positionRepoObj;
	
	@Autowired
	ProjectRepository projectRepoObject;
	
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
	public Map<Integer, Integer> getAllApplicationInMonth() {
		List<Candidate> listOfCandidate = candidateRepoObj.findAll();

		Map<Integer, Integer> applicationDetail = new TreeMap<>();
		applicationDetail.put(1, 0);
		applicationDetail.put(2, 0);
		applicationDetail.put(3, 0);
		applicationDetail.put(4, 0);
		applicationDetail.put(5, 0);
		applicationDetail.put(6, 0);
		applicationDetail.put(7, 0);
		applicationDetail.put(8, 0);
		applicationDetail.put(9, 0);
		applicationDetail.put(10, 0);
		applicationDetail.put(11, 0);
		applicationDetail.put(12, 0);
		
		
		System.out.println(listOfCandidate.size());
		for (Candidate candidate : listOfCandidate) {
			Date posDate = candidate.getVacancy().getPosOpenDate();
			Integer date1 = posDate.getMonth();
			String month = date1.toString();
			System.out.println("month is :"+month);

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
		
		Map<Integer, Integer> newMapSortedByKey = applicationDetail.entrySet().stream()
                .sorted((e1,e2) -> e1.getKey().compareTo(e2.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1,e2) -> e1, LinkedHashMap::new));
		System.out.println("newMapSortedByKey :"+newMapSortedByKey);
		return newMapSortedByKey;
	}

	@Override
	public HashMap<String, Integer> getCountOfApplicationForProject() {
		List<Candidate> listOfCandidate = candidateRepoObj.findAll();
		HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
		List<Project> projects = projectRepoObject.findAll();
		for (Project project : projects) {
			String name = project.getName();
			hashmap.put(name, 0);
		}

		for (Candidate candidate : listOfCandidate) {
			String projectName = candidate.getVacancy().getProjectName();
			if (hashmap.containsKey(projectName)) {
				hashmap.put(projectName, hashmap.get(projectName) + 1);

			} else
				hashmap.put(projectName, 1);
		}
		return hashmap;
		
	}


	@Override
	public Helper getAllCandidateByProjectAndPosition(String projName) {
		List<Candidate> candidates = candidateRepoObj.findAll();
		List<Position> positions = positionRepoObj.findAll();
		List <Project> projects = projectRepoObject.findAll();
		Helper helperObj = new Helper();
		//counts
		int applicationCnt = 0;
        int cntTech_1 = 0;
        int cntTech_2 = 0;
        int cntTech_3 = 0;
        int cntManager = 0;
        int cntHr = 0;
        
        //list of all conuts
        List<String> posName = new ArrayList<>();
        List<Integer> application = new ArrayList<>();
        List<Integer> tech1 = new ArrayList<>();
        List<Integer> tech2 = new ArrayList<>();
        List<Integer> tech3 = new ArrayList<>();
        List<Integer> mgr = new ArrayList<>();
        List<Integer> hr = new ArrayList<>();
        //for each project
			for (Position pos : positions) 
			{
				applicationCnt = 0;
	        	cntTech_1 = 0;
	        	cntTech_2 = 0;
	        	cntTech_3 = 0;
	        	cntManager = 0;
	        	cntHr = 0;
				for (Candidate c : candidates)
				{
					if(c.getVacancy().getJobTitle().equalsIgnoreCase(pos.getName()) &&
				       c.getVacancy().getProjectName().equalsIgnoreCase(projName))
					{
						applicationCnt++;
						if(c.getInterviewStatus().contains("Technical - 1"))
							cntTech_1++;
						if(c.getInterviewStatus().contains("Technical - 2"))
							cntTech_2++;
						if(c.getInterviewStatus().contains("Technical - 3"))
							cntTech_3++;
						if(c.getInterviewStatus().contains("Manager"))
							cntManager++;
						if(c.getInterviewStatus().contains("HR"))
							cntHr++;
					}
				}
				posName.add(pos.getName());
				application.add(applicationCnt);
				tech1.add(cntTech_1);
				tech2.add(cntTech_2);
				tech3.add(cntTech_3);
				mgr.add(cntManager);
				hr.add(cntHr);
		}
		
		helperObj.setPositionName(posName);
		helperObj.setApplication(application);
		helperObj.setTech1(tech1);
		helperObj.setTech2(tech2);
		helperObj.setTech3(tech3);
		helperObj.setManager(mgr);
		helperObj.setHr(hr);
		System.out.println(helperObj);
		return helperObj;
	}


	
	
}
	

