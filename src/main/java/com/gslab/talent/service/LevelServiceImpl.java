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
import com.gslab.talent.model.Feature;
import com.gslab.talent.model.Level;
import com.gslab.talent.model.Technology;
import com.gslab.talent.model.User;
import com.gslab.talent.model.Vacancy;
import com.gslab.talent.repository.LevelRepository;
import com.gslab.talent.repository.VacancyRepository;

@Service
public class LevelServiceImpl implements LevelService{

	@Autowired
	LevelRepository levelRepoObj;
	
	@Autowired
	VacancyRepository vacancyRepoObj;
	
	@Autowired
	VacancyRepository vacancyRepository;
	
	@Autowired
	LevelRepository levelRepository;
	
	@PersistenceUnit
	private EntityManagerFactory emf;
	
	@Override
	public List<Level> getAllLevel() {
		return (List<Level>) levelRepoObj.findAll();
	}
	
	@Override
	public void createLevel(Level level) {
		levelRepoObj.save(level);

	}

	@Override
	public Level getUserById(int levelId) {
		return levelRepoObj.findById(levelId).orElse(null);
	}

	@Override
	public Level deleteByDescription(Level level) {
		return levelRepoObj.deleteByDescription(level);
	}

	@Override
	public Level findByLevel(String level) {
		Level f=null;
		List<Level> list = getAllLevel(); 
		for(Level l:list)
		{
			if(l.getLevel().equalsIgnoreCase(level))
			{
				f=l;
			}
		}
		return f;
	}

	@Override
	public void deleteLevelById(Integer i) {
		levelRepoObj.deleteById(i);
	}

	@Override
	public Level findById(int id) {
//		return employeeRepoObj.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
		Optional<Level> optionObj = levelRepoObj.findById(id);
		return optionObj.get();
	}

	@Override
	public void createLevelList(Vacancy levelObj, int id) {
		// TODO Auto-generated method stub
		
	}	
	
	

	//@Override
	/*public List<Level> getLevelsByVacancyId(int id) {
		List<Level> f=null;
		List<Level> list = getAllLevel(); 
		for(Level l:list)
		{
			if(l.getVacancy() != null)
			{
				System.out.println("f is "+f);
				f=(List<Level>) l;
			}
		}
		return f;
	}*/


}
