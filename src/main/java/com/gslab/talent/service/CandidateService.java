package com.gslab.talent.service;

import java.util.List;

import com.gslab.talent.model.Candidate;

public interface CandidateService {

	public void createCandidate(Candidate candidateObj,int id);
	public  List<Candidate> getAllCandidate();
	public Candidate findById(long id);
	public  void update(Candidate candidateObj,int id);
	public void deleteCandidateById(long id);
	public List<Candidate> getCandidateByVacancyId(int id);
}
