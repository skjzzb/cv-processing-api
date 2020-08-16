package com.gslab.talent.service;


import java.util.TreeMap;



public interface VacancyDetailService {
	
	TreeMap<Integer, Integer> getAllVacancy();
	TreeMap<Integer, Integer> getTotalApplicationInMonth();
	TreeMap<Integer, Integer> getAllSelected();
	TreeMap<Integer, Integer> getAllRejected();
	
	
	

}
