package com.gslab.talent.service;

import java.util.List;

import com.gslab.talent.model.Project;

public interface ProjectService {
	
	void createProject(Project project);
	List<Project> getAllProject();
	Project getProjectById(int projId);
	void deleteProject(int projId);
	void deleteAll();
	void updateProject(Project project);
}
