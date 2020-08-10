package com.gslab.talent.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.TreeMap;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import com.gslab.talent.constant.Constant;
import com.gslab.talent.model.Candidate;
import com.gslab.talent.model.Level;
import com.gslab.talent.model.User;
import com.gslab.talent.model.Vacancy;
import com.gslab.talent.repository.VacancyRepository;
import com.gslab.talent.service.CandidateService;
import com.gslab.talent.service.VacancyService;

@Controller
@CrossOrigin(allowedHeaders = "*")
@RequestMapping(value = "/v1")
public class VacancyController {
	
	@Autowired
	VacancyRepository vacancyRepo;
	
	@Autowired
	VacancyService vacancyServiceObj;

	@Autowired
	CandidateService candidateServiceObj;
	
	@GetMapping(value = Constant.GET_LIST_OF_VACANCY)
	public ResponseEntity<List<Vacancy>> getAllVacancy(@RequestParam String sort){
		return new ResponseEntity<List<Vacancy>>(vacancyServiceObj.getAllVacancy(sort), HttpStatus.OK);
	}
	
	@GetMapping(value = Constant.GET_VACANCY_BY_ID)
	public ResponseEntity<Vacancy> getVacancyById(@PathVariable int vacancyId){
		return new ResponseEntity<Vacancy>(vacancyServiceObj.getVacancyById(vacancyId), HttpStatus.OK);
	}
	
	@PostMapping(value = "/vacancy")
	public ResponseEntity<Void> createNewVacancy(@RequestBody Vacancy vacancy)
	{
		System.out.println("vacancy "+vacancy);
		vacancyServiceObj.createNewVacancy(vacancy);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/vacancy/{vacancyId}")
	public ResponseEntity<Void> updateVancancy(@RequestBody Vacancy vacancy, @PathVariable int vacancyId )
	{
		vacancyServiceObj.updateVacancy(vacancy);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/vacancy/{vacancyId}")
	public ResponseEntity<Void> deleteVacancyById(@PathVariable int vacancyId)
	{
		vacancyServiceObj.deleteVacancy(vacancyId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping(value ="/addLevels/{vacancyId}")
	public ResponseEntity<?> addLevelsToVacancy(@PathVariable int vacancyId,@RequestParam String levelList) {
		String str = null;
		String levels;
		
		Vacancy vacancy = vacancyServiceObj.getVacancyById(vacancyId);
		
		if(vacancy.getlevelList() == null ) {
		vacancy.setlevelList(levelList);
		
		}
		else {
			levels = vacancy.getlevelList();

			String split[] = levels.split("\\s");
			str = levels.concat(" " + levelList);
			vacancy.setlevelList(str);
			
		}
		vacancyServiceObj.updateVacancy(vacancy);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/getLevelsByVacancyId/{vacancyId}")
	public ResponseEntity<?> getLevelsByVacancyId(@PathVariable int vacancyId){
		Vacancy vacancy = vacancyServiceObj.getVacancyById(vacancyId);
		String levels = vacancy.getlevelList();
		String split[] = levels.split("\\s");
		for(int i=0;i<split.length;i++) {
			System.out.println(split[i]);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/deleteLevel/{candidateId}")
	public ResponseEntity<Void> deleteLevelsById(@PathVariable int candidateId,@RequestParam String level)
	{String l = null;
		Candidate candidateObj = candidateServiceObj.findById(candidateId);
		String levels = candidateObj.getVacancy().getlevelList();
		System.out.println("candidateObj "+candidateObj);
		levels.replaceAll(level,"");
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/getCountOfVacancyForProject")
	public HashMap<String,Integer> getCountOfVacancyForProject(){
		return vacancyServiceObj.getCountOfVacancyForProject();

	}
}
