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
	public String getLevelList(int vacancyId);
	void createNewVacancy(Vacancy vacancy);
	public HashMap<String, Integer> getCountOfVacancyForProject(String str);
	public Vacancy findByJobTitleAndProjectName(String jobTitle, String projectName);
}
