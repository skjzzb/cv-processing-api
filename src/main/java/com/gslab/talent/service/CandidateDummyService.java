package com.gslab.talent.service;

import java.util.List;

import com.gslab.talent.model.Candidate;
import com.gslab.talent.model.CandidateDummy;

public interface CandidateDummyService {

	void createNewCandidate(CandidateDummy candidateDummy);

	void deleteDummyCandidate(long id);

	List<CandidateDummy> getAllCandidate();

	

}
