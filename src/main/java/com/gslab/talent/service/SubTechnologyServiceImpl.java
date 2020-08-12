package com.gslab.talent.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.criteria.From;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gslab.talent.model.Document;
import com.gslab.talent.model.SubTechnology;
import com.gslab.talent.model.Technology;
import com.gslab.talent.repository.SubTechnologyRepository;
import com.gslab.talent.repository.TechnologyRepository;

@Service
public class SubTechnologyServiceImpl implements SubTechnologyService {

	@Autowired
	SubTechnologyRepository repoObj;
	
	@Autowired
	TechnologyRepository techRepoObj;
	
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
	@Override
	public Set<String> getTechnologyFromSubtechnology(List<String> list1) {
		
		Set<String> set = new HashSet();
		List<SubTechnology> list=repoObj.findAll();
		for(String l1 : list1)
		{
			for(SubTechnology l :list) {
				if(l.getSubTechnologyName().equalsIgnoreCase(l1)) {
					int id = l.getTechnologyId();
					Optional<Technology> t = techRepoObj.findById(id);
					System.out.println("technology name : "+t);
					String techName = t.get().getTechnologyName();
					System.out.println("techName : "+techName);
					//set.add(l.getTechnologyId());
					set.add(techName);
					
				}
			}
			
		}
		System.out.println("set : "+set);
		return set;
	}
	
	

}
