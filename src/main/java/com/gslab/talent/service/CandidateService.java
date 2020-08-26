package com.gslab.talent.service;

import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import com.gslab.talent.model.Candidate;
import com.gslab.talent.model.Helper;

public interface CandidateService {

	public void createCandidate(Candidate candidateObj,int id);
	public  List<Candidate> getAllCandidate();
	public Candidate findById(long id);
	public  void update(Candidate candidateObj,int id);
	public void deleteCandidateById(long id);
	public List<Candidate> getCandidateByVacancyId(int id);
	public TreeMap<Integer, Integer> getAllApplicationInMonth();
	public HashMap<String, Integer> getCountOfApplicationForProject(String str);
	Helper getAllCandidateByProjectAndPosition(String projectName);
}
