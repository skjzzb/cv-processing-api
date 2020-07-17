package com.gslab.talent.service;

import java.util.List;

import com.gslab.talent.model.Document;
import com.gslab.talent.model.Feature;

public interface FeatureService {

	public void createFeature(Feature Obj);
	public  List<Feature> getAllFeature();
	public  Feature update(Feature Obj);
	public Feature findByName(String role);
	public void deleteFeatureById(int id);
	
}
