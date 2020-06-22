package com.gslab.talent.service;

import java.util.List;

import com.gslab.talent.model.SubTechnology;

public interface SubTechnologyService {
	
	public void createSubTechnology(SubTechnology Obj);
	public  List<SubTechnology> getAllSubTechnology();
	public  SubTechnology update(SubTechnology Obj);
	public SubTechnology findById(long id);
	public void deleteSubTechnologyById(long id);

}
