package com.gslab.talent.service;

import java.util.List;

import com.gslab.talent.model.Vacancy;

public interface VacancyService {
	List<Vacancy> getAllVacancy();
	Vacancy getVacancyById(Integer vacancyId);
	void createNewVacancy(Vacancy vacancy);
	void updateVacancy(Vacancy vacancy);
	void deleteVacancy(int vacancyId);
}
