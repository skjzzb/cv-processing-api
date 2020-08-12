package com.gslab.talent.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.TreeMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.gslab.talent.model.Candidate;
import com.gslab.talent.model.Level;
import com.gslab.talent.model.Vacancy;
import com.gslab.talent.repository.LevelRepository;
import com.gslab.talent.repository.VacancyRepository;

@Service
public class VacancyServiceImpl implements VacancyService {
	@Autowired
	VacancyRepository vacancyRepoObj;

	@Autowired
	LevelRepository levelRepository;
	
	@PersistenceUnit
	private EntityManagerFactory emf;
	
	@Override
	public List<Vacancy> getAllVacancy(String sort) {
		List<Vacancy> list1=new ArrayList<Vacancy>();
		
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		   LocalDateTime now = LocalDateTime.now();
		
		   List<Vacancy> list=vacancyRepoObj.findAll();
		
		if(sort.equalsIgnoreCase("avalible")) {
			System.out.println(sort); 
			   
			   for(Vacancy l:list)
			   {
				   if(dtf.format(now).compareTo(l.getPosOnBoardDate().toString())<=0)
				   {
					   list1.add(l);
				   }
			   }
			return list1;
		}else if(sort.equalsIgnoreCase("closed"))
		{
			System.out.println(sort);  
			   for(Vacancy l:list)
			   {
				   if(dtf.format(now).compareTo(l.getPosOnBoardDate().toString())>0)
				   {
					   list1.add(l);
				   }
			   }
			return list1;
		}else {
			return list;		
		}
		
	}

	@Override
	public Vacancy getVacancyById(Integer vacancyId) {
		return vacancyRepoObj.findById(vacancyId).orElse(null);
	}

	@Override
	public void createNewVacancy(Vacancy vacancy) {
	    vacancyRepoObj.save(vacancy);
	}

	@Override
	public void updateVacancy(Vacancy vacancy) {
		vacancyRepoObj.save(vacancy);
	}

	@Override
	public void deleteVacancy(int vacancyId) {
		vacancyRepoObj.deleteById(vacancyId);
	}

	@Override
	public void updateVacancyList(String levelList) {
		 vacancyRepoObj.save(levelList);
	}

	@Override
	public String getLevelList(int vacancyId) {
		return vacancyRepoObj.findByLevelList(vacancyId);
	}
	
	@Override
	public HashMap<String,Integer> getCountOfVacancyForProject(String str){
		List<Vacancy> listOfVacancy = vacancyRepoObj.findAll();
		HashMap<String,Integer> hashmap = new HashMap<String,Integer>();
		
		switch(str) {
		
		case "year": {
			for (Vacancy vacancy : listOfVacancy) {
				String projectName = vacancy.getProjectName();
				
				if (hashmap.containsKey(projectName)) {
					hashmap.put(projectName, hashmap.get(projectName) + 1);
				} else
					hashmap.put(projectName, 1);
			}
			break;
		}
		
		case "month": {
			long millis = System.currentTimeMillis();
			java.sql.Date date = new java.sql.Date(millis);
			int month = date.getMonth();

			for (Vacancy vacancy : listOfVacancy) {
				Date date1 = vacancy.getPosOnBoardDate();
				int date1mon = date1.getMonth();
				String projectName = vacancy.getProjectName();
				hashmap.put(projectName, 0);

				if (month == date1mon) {
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
