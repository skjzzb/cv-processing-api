package com.gslab.talent.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gslab.talent.model.SubTechnology;
import com.gslab.talent.model.Technology;
import com.gslab.talent.repository.TechnologyRepository;

@Service
public class TechnologyServiceImpl implements TechnologyService {

	@Autowired
	TechnologyRepository repoObj;
	
	@Override
	public void createTechnology(Technology Obj) {
		
		this.repoObj.save(Obj);
		
	}

	@Override
	public List<Technology> getAllTechnology() {
		return (List<Technology>) repoObj.findAll();
	}

	@Override
	public Technology update(Technology Obj) {
		deleteTechnologyById(Obj.getTechnologyId());
		Obj.setTechnologyId(0);
		return this.repoObj.save(Obj);
	}

	@Override
	public Technology findById(int id) {
		Optional optObj =  this.repoObj.findById(id);
		return (Technology) optObj.get();
	}

	@Override
	public void deleteTechnologyById(int id) {
		this.repoObj.deleteById(id);
		
	}

}
