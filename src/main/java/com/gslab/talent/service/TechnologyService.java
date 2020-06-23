package com.gslab.talent.service;

import java.util.List;

import com.gslab.talent.model.Technology;

public interface TechnologyService {
	
	public void createTechnology(Technology Obj);
	public  List<Technology> getAllTechnology();
	public  Technology update(Technology Obj);
	public Technology findById(int id);
	public void deleteTechnologyById(int id);

}
