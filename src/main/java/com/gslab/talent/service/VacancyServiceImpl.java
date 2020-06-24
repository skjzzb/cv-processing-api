package com.gslab.talent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gslab.talent.model.Vacancy;
import com.gslab.talent.repository.VacancyRepository;

@Service
public class VacancyServiceImpl implements VacancyService {
	@Autowired
	VacancyRepository vacancyRepoObj;

	@Override
	public List<Vacancy> getAllVacancy() {
		System.out.println("VacancyServiceImpl.getAllVacancy()");
		return vacancyRepoObj.findAll();
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

}
