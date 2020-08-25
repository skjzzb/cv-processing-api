package com.gslab.talent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gslab.talent.model.Project;
import com.gslab.talent.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	ProjectRepository projectRepoObj;

	@Override
	public void createProject(Project project) {
		projectRepoObj.save(project);
	}

	@Override
	public List<Project> getAllProject() {
		return projectRepoObj.findAll();
	}

	@Override
	public Project getProjectById(int projId) {
		return projectRepoObj.findById(projId).orElse(null);
	}

	@Override
	public void deleteProject(int projId) {
		projectRepoObj.deleteById(projId);
	}

	@Override
	public void deleteAll() {
		projectRepoObj.deleteAll();
	}

}
