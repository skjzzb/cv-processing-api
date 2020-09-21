package com.gslab.talent.controller;

import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.gslab.talent.constant.Constant;
import com.gslab.talent.model.Candidate;
import com.gslab.talent.service.CandidateService;
import com.gslab.talent.repository.CandidateRepository;



@RestController
@CrossOrigin(allowedHeaders = "*")
@RequestMapping(value = "/v1")
public class CandidateController {
	static int  exp5 = 0,exp10 = 0,exp15 = 0,exp20 = 0;
	Integer exp;
	@Autowired
	private CandidateService ServiceObj;
	@Autowired
	private CandidateRepository CanRepo;
	
	@GetMapping(value = Constant.GET_LIST_OF_CANDIDATES, headers = Constant.ACCEPT_JSON, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Candidate> getAllCandidates() {
		return ServiceObj.getAllCandidate();
	}
	@GetMapping(value = Constant.GET_CANDIDATE_BY_ID, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getCandidateById(@PathVariable(Constant.GET_CANDIDATE_BY_ID) long userId) {
		return new ResponseEntity<>(CanRepo.findById(userId), HttpStatus.OK);
	}
	// @GetMapping(value = Constant.GET_CANDIDATE_BY_ID, produces = MediaType.APPLICATION_JSON_VALUE)
	// public ResponseEntity<Candidate> getCandidateById(@PathVariable(Constant.CANDIDATE_ID) long id) {
	// 	Candidate candidateObj = ServiceObj.findById(id);
	// 	if (candidateObj == null) {
	// 		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	// 	}
	// 	return new ResponseEntity<>(candidateObj, HttpStatus.OK);
	// }


	@PutMapping(value = Constant.ADD_CANDIDATE, headers = Constant.ACCEPT_JSON)
	public ResponseEntity<Void> createCandidate(@PathVariable int id,@RequestBody Candidate candidateObj, UriComponentsBuilder ucBuilder) {
		ServiceObj.createCandidate(candidateObj,id);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path(Constant.GET_CANDIDATE_BY_ID).buildAndExpand(candidateObj.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping(value = Constant.UPDATE_CANDIDATE ,headers = Constant.ACCEPT_JSON)
	public ResponseEntity<Void> updateCandidateInfo(@PathVariable int id,@RequestBody Candidate candidateObj )
	{
		ServiceObj.update(candidateObj,id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping(Constant.DELETE_CANDIDATE_BY_ID)
	public ResponseEntity<Void> deleteCandidateById(@PathVariable long id, UriComponentsBuilder ucBuilder) {
		ServiceObj.deleteCandidateById(id);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path(Constant.DELETE_CANDIDATE_BY_ID).buildAndExpand(id).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.OK);
	}
	
	@GetMapping(value = Constant.GET_CANDIDATE_BY_VACANCY_ID, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Candidate> getCandidateByVacancyId(@PathVariable(Constant.VACANCY_ID) int id)
	{   
		return ServiceObj.getCandidateByVacancyId(id);
	}
	
	@GetMapping(value = "/getCandidateCountByVacancyId/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getCandidateCountByVacancyId(@PathVariable(Constant.VACANCY_ID) int id)
	{
		List<Candidate> list = ServiceObj.getCandidateByVacancyId(id);
		for(Candidate c : list) {
			 exp = c.getYearOfExperience();
			if(exp >= 0 && exp <=5) 
				exp5++;
				
			else if (exp >=6 && exp <=10) 
				exp10++;
			else if (exp >=11 && exp <=15) 
				exp15++;
			else 
				exp20++;
		}
		return "experience 0 to 5 = "+exp5+" \nexperience 5 to 10 = "+exp10+" \nexperience 11 to 15 = "+exp15+" \nexperience 15 and above = "+exp20;
	}
	
	@GetMapping(value="/monthapplication")
	public ResponseEntity<TreeMap<Integer, Integer>> getAllApplicationInMonth(){
		return new ResponseEntity<TreeMap<Integer,Integer>>(ServiceObj.getAllApplicationInMonth(),HttpStatus.OK);
	}
	
	@GetMapping(value = "/getCountOfApplicationForProject/{str}")
	public HashMap<String,Integer> getCountOfApplicationForProject(@RequestParam String str){
		return ServiceObj.getCountOfApplicationForProject(str);
		
	}
}
