package com.gslab.talent.service;

import java.util.TreeMap;

public interface TechnologyExperienceService {
	TreeMap<String,Integer> getExperienceByTechnology(String technology);

}
