package com.gslab.talent.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.From;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gslab.talent.model.Document;
import com.gslab.talent.model.SubTechnology;
import com.gslab.talent.repository.SubTechnologyRepository;

@Service
public class SubTechnologyServiceImpl implements SubTechnologyService {

	@Autowired
	SubTechnologyRepository repoObj;
	
	@Override
	public void createSubTechnology(SubTechnology Obj) {
		this.repoObj.save(Obj);
		
	}

	@Override
	public List<SubTechnology> getAllSubTechnology() {
		return (List<SubTechnology>) repoObj.findAll();
	}

	@Override
	public SubTechnology update(SubTechnology Obj) {
		deleteSubTechnologyById(Obj.getSubTechnologyId());
		Obj.setSubTechnologyId(0);
		return this.repoObj.save(Obj);
	}

	@Override
	public SubTechnology findById(long id) {
		Optional optObj =  this.repoObj.findById(id);
		return (SubTechnology) optObj.get();
	}

	@Override
	public void deleteSubTechnologyById(long id) {
		this.repoObj.deleteById(id);
		
	}

	@Override
	public List<SubTechnology> getAllByTechnologyId(int id) {
		
		List<SubTechnology> selected = new ArrayList<SubTechnology>();
		
		List<SubTechnology> list=repoObj.findAll();
		
		for(SubTechnology l :list)
		{
			if(l.getTechnologyId()==id)
			{
				selected.add(l);
			}
		}
		
		return selected;
	}

}
