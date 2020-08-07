package com.gslab.talent.service;

import java.util.TreeMap;

import org.springframework.stereotype.Service;
@Service
public class TechnologyExperienceServiceImpl implements TechnologyExperienceService {

	@Override
	public TreeMap<String, Integer> getExperienceByTechnology(String technology) {
		TreeMap<String, Integer> Experience =new TreeMap<>();
		Experience.put("0-5 Years", 100);
		Experience.put("5-8 Years", 200);
		Experience.put("8-15 Years", 300);
		Experience.put("15-20 Years", 250);
		
		return Experience;
	}

}
