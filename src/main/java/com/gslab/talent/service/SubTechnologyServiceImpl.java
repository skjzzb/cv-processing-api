package com.gslab.talent.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.criteria.From;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gslab.talent.model.Candidate;
import com.gslab.talent.model.Document;
import com.gslab.talent.model.SubTechnology;
import com.gslab.talent.model.Technology;
import com.gslab.talent.repository.CandidateRepository;
import com.gslab.talent.repository.SubTechnologyRepository;
import com.gslab.talent.repository.TechnologyRepository;

@Service
public class SubTechnologyServiceImpl implements SubTechnologyService {

	@Autowired
	SubTechnologyRepository repoObj;
	
	@Autowired
	TechnologyRepository techRepoObj;
	
	@Autowired
	CandidateRepository candidateRepoObj;
	
	String experience1TO5="experience1TO5" ,experience6TO10="experience6TO10" ,experience11TO15="experience11TO15",experience15AndAbove="experience15AndAbove" ;
	
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
					String techName = t.get().getTechnologyName();
					set.add(techName);
					
				}
			}
			
		}
		System.out.println("set : "+set);
		return set;
	}
	
	@Override
	public HashMap<String,Integer> getExperienceOfCandiatesFromSubtechnology(String subTechName) {
		
		List<Candidate> candidate = candidateRepoObj.findAll();
		System.out.println("candidate size " + candidate.size());
		HashMap<String, Integer> hashmap = new HashMap<String, Integer>();

		for (Candidate cad : candidate) {
			String techStack = cad.getTechnologyStack();
			String split[] = techStack.split("\\s");
			for (int i = 0; i < split.length; i++) {
				String subtech = split[i];
				if (subTechName.equalsIgnoreCase(subtech)) {

					int experience = cad.getYearOfExperience();
					if (experience >= 0 && experience <= 5) {
						if (hashmap.containsKey(experience1TO5)) {
							hashmap.put(experience1TO5, hashmap.get(experience1TO5) + 1);
						} else
							hashmap.put(experience1TO5, 1);
					} else if (experience >= 6 && experience <= 10) {
						if (hashmap.containsKey(experience6TO10)) {
							hashmap.put(experience6TO10, hashmap.get(experience6TO10) + 1);
						} else
							hashmap.put(experience6TO10, 1);
					} else if (experience >= 11 && experience <= 15) {
						if (hashmap.containsKey(experience11TO15)) {
							hashmap.put(experience11TO15, hashmap.get(experience11TO15) + 1);
						} else
							hashmap.put(experience11TO15, 1);
					} else if (experience >= 16 && experience <= 50) {
						if (hashmap.containsKey(experience15AndAbove)) {
							hashmap.put(experience15AndAbove, hashmap.get(experience15AndAbove) + 1);
						} else
							hashmap.put(experience15AndAbove, 1);
					}

				}
			}

		}
		return hashmap;

	}

}
