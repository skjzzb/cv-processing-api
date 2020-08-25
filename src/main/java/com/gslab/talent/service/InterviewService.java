package com.gslab.talent.service;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import com.gslab.talent.model.Interview;

public interface InterviewService {

	public List<Interview> getTodaysInterview();

	public String getInterviewStatus();
	

	public TreeMap<Integer, Integer> getRejectedMonthly();

	public TreeMap<String, TreeMap<String, Integer>> getCountOfInterviewLevelForProject();

}
