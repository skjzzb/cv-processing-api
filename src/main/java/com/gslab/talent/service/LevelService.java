package com.gslab.talent.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gslab.talent.model.Candidate;
import com.gslab.talent.model.Level;
import com.gslab.talent.model.User;
import com.gslab.talent.model.Vacancy;

public interface LevelService {

	List<Level> getAllLevel();

	void createLevel(Level level);

	Level getUserById(int levelId);

	Level deleteByDescription(Level l);

	Level findByDescription(String description);

	void deleteLevelById(Integer i);

	Level findById(int id);

	void createLevelList(Vacancy levelObj, int id);


}
