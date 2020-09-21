package com.gslab.talent.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gslab.talent.model.CandidateDummy;
import com.gslab.talent.repository.CandidateDummyRepository;
import com.gslab.talent.repository.CandidateRepository;

@Service
public class CandidateDummyServiceImpl implements CandidateDummyService{

	@Autowired
	CandidateDummyRepository candidateSummyRepoObj;

	
	@Override
	public void createNewCandidate(CandidateDummy candidateDummy) {
		candidateSummyRepoObj.save(candidateDummy);
	}

}
