package com.gslab.talent.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gslab.talent.model.Candidate;
import com.gslab.talent.repository.CandidateRepository;


@Service
public class CandidateServiceImpl implements CandidateService {

	@Autowired
	CandidateRepository candidateRepoObj;

	@Override
	public void createCandidate(Candidate candidateObj) {
		candidateRepoObj.save(candidateObj);
	}

	@Override
	public List<Candidate> getAllCandidate() {
		return (List<Candidate>) candidateRepoObj.findAll();
	}

	@Override
	public Candidate findById(long id) {
//		return employeeRepoObj.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
		Optional<Candidate> optionObj = candidateRepoObj.findById(id);
		return optionObj.get();
	}

	@Override
	public Candidate update(Candidate candidateObj) {
		return candidateRepoObj.save(candidateObj);
	}

	@Override
	public void deleteCandidateById(long id) {
		candidateRepoObj.deleteById(id);
	}
	

}
