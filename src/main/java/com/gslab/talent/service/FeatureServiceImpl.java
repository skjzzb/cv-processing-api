package com.gslab.talent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gslab.talent.model.Feature;
import com.gslab.talent.repository.FeatureRepository;

@Service
public class FeatureServiceImpl implements FeatureService {

	@Autowired
	FeatureRepository featureRepository; 
	
	@Override
	public void createFeature(Feature Obj) {
		featureRepository.save(Obj);
		
	}

	@Override
	public List<Feature> getAllFeature() {
		return featureRepository.findAll();
	}

	@Override
	public Feature update(Feature Obj) {
		return featureRepository.save(Obj);
	}

	@Override
	public Feature findByName(String role) {
		Feature f=null;
		List<Feature> list=getAllFeature();
		for(Feature l:list)
		{
			if(l.getRoles().equalsIgnoreCase(role))
			{
				f=l;
			}
		}
		return f;
	}

	@Override
	public void deleteFeatureById(int id) {
		featureRepository.deleteById(id);
	}

}
