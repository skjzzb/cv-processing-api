package com.gslab.talent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.gslab.talent.constant.Constant;
import com.gslab.talent.model.Candidate;
import com.gslab.talent.model.CandidateDummy;
import com.gslab.talent.model.Vacancy;
import com.gslab.talent.repository.CandidateDummyRepository;
import com.gslab.talent.repository.CandidateRepository;
import com.gslab.talent.service.CandidateDummyService;
import com.gslab.talent.service.CandidateService;

@RestController
@CrossOrigin(allowedHeaders = "*")
@RequestMapping(value = "/v1")
public class CandidateDummyController {

	@Autowired
	private CandidateDummyService ServiceObj;
	
	@Autowired
	private CandidateDummyRepository CandidateRepo;
	
	@PostMapping(value = "/createNewCandidate")
	public ResponseEntity<Void> createNewCandidate(@RequestBody CandidateDummy candidateDummy)
	{
		System.out.println("CandidateDummy "+candidateDummy);
		ServiceObj.createNewCandidate(candidateDummy);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getAllCandidate")
	public List<CandidateDummy> getAllCandidates() {
		return ServiceObj.getAllCandidate();
	}

	
	@DeleteMapping(value = "/deleteDummyCandidate/{id}")
	public ResponseEntity<Void> deleteDummyCandidateById(@PathVariable long id) {
		ServiceObj.deleteDummyCandidate(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
