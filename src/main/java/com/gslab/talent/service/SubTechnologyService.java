package com.gslab.talent.service;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.gslab.talent.model.SubTechnology;

public interface SubTechnologyService {
	
	public void createSubTechnology(SubTechnology Obj);
	public  List<SubTechnology> getAllSubTechnology();
	public  SubTechnology update(SubTechnology Obj);
	public SubTechnology findById(long id);
	public void deleteSubTechnologyById(long id);
	public List<SubTechnology> getAllByTechnologyId(int id);
	Set<String> getTechnologyFromSubtechnology(List<String> list1);
	public HashMap<String,Integer> getExperienceOfCandiatesFromSubtechnology(String str);
	
}
