package com.gslab.talent.service;

import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import com.gslab.talent.model.Vacancy;

public interface VacancyService {
	List<Vacancy> getAllVacancy(String sort);
	Vacancy getVacancyById(Integer vacancyId);
	void updateVacancy(Vacancy vacancy);
	void deleteVacancy(int vacancyId);
	void updateVacancyList(String levelList);
	String getLevelList(int vacancyId);
	void createNewVacancy(Vacancy vacancy);
	HashMap<String, Integer> getCountOfVacancyForProject();
}
