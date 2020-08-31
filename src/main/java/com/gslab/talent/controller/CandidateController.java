package com.gslab.talent.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
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
import com.gslab.talent.model.Helper;
import com.gslab.talent.repository.CandidateRepository;
import com.gslab.talent.service.CandidateService;



@RestController
@CrossOrigin(allowedHeaders = "*")
@RequestMapping(value = "/v1")
public class CandidateController {
	static int  exp5 = 0,exp10 = 0,exp15 = 0,exp20 = 0;
	Integer exp;
	@Autowired
	private CandidateService ServiceObj;
	
	@Autowired
	private CandidateRepository CandidateRepo;
	
	@GetMapping(value = Constant.GET_LIST_OF_CANDIDATES, headers = Constant.ACCEPT_JSON, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Candidate> getAllCandidates() {
		return ServiceObj.getAllCandidate();
	}

//	@GetMapping(value = Constant.GET_CANDIDATE_BY_ID, produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Candidate> getCandidateById(@PathVariable(Constant.CANDIDATE_ID) long id) {
//		Candidate candidateObj = ServiceObj.findById(id);
//		if (candidateObj == null) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//		return new ResponseEntity<>(candidateObj, HttpStatus.OK);
//	}
	@GetMapping(value = Constant.GET_CANDIDATE_BY_ID, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getCandidateById(@PathVariable(Constant.CANDIDATE_ID) long userId) {
		return new ResponseEntity<>(CandidateRepo.findById(userId), HttpStatus.OK);
	}

	@PutMapping(value = Constant.ADD_CANDIDATE, headers = Constant.ACCEPT_JSON)
	public ResponseEntity<Void> createCandidate(@PathVariable int id,@RequestBody Candidate candidateObj, UriComponentsBuilder ucBuilder) {
//		if(candidateObj.getFinalStatus().equals(""))
//			candidateObj.setFinalStatus("NOT_SELECTED");
//		if(candidateObj.getInterviewStatus().equals(""))
//			candidateObj.setInterviewStatus("Not scheduled any round");
//		if(candidateObj.getFinalStatus() == null)
//			candidateObj.setFinalStatus("NOT_SELECTED");
		if(candidateObj.getInterviewStatus() == null)
			candidateObj.setInterviewStatus("Not scheduled any round");
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
			if (exp == null)
				continue;
			else if(exp >= 0 && exp <=5) 
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
	public ResponseEntity<Map<Integer, Integer>> getAllApplicationInMonth(){
		return new ResponseEntity<Map<Integer,Integer>>(ServiceObj.getAllApplicationInMonth(),HttpStatus.OK);
	}
	
	@GetMapping(value = "/getCountOfApplicationForProject")
	public ResponseEntity<HashMap<String,Integer>> getCountOfApplicationForProject(){
		return new ResponseEntity<HashMap<String,Integer>>(ServiceObj.getCountOfApplicationForProject(),HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/getCountOfCandidateByProjectAndVacancy/{projNanme}")
	ResponseEntity<Helper> getCandidateByProjectAndPosition(@PathVariable String projNanme ){
		 ServiceObj.getAllCandidateByProjectAndPosition(projNanme);
		return new ResponseEntity<>( ServiceObj.getAllCandidateByProjectAndPosition(projNanme),HttpStatus.OK);
	}
	
	@GetMapping(value = "/getCountOfSelectedForProject")
	ResponseEntity<HashMap<String,Integer>> getCountOfSelectedForProject(){
		return new ResponseEntity<HashMap<String,Integer>>( ServiceObj.getCountOfSelectedForProject(),HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectedMonthly")
	ResponseEntity<TreeMap<Integer,Integer>> getSelectedMonthly(){
		return new ResponseEntity<TreeMap<Integer,Integer>>( ServiceObj.getSelectedMonthly(),HttpStatus.OK);
	}
}
