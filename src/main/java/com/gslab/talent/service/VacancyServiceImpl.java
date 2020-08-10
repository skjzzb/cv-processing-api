package com.gslab.talent.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.TreeMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
}
