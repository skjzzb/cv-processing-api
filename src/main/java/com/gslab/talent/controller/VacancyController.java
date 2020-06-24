package com.gslab.talent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gslab.talent.constant.Constant;
import com.gslab.talent.model.User;
import com.gslab.talent.model.Vacancy;
import com.gslab.talent.service.VacancyService;

@Controller
@CrossOrigin(allowedHeaders = "*")
@RequestMapping(value = "/v1")
public class VacancyController {
	
	@Autowired
	VacancyService vacancyServiceObj;

	@GetMapping(value = Constant.GET_LIST_OF_VACANCY)
	public ResponseEntity<List<Vacancy>> getAllVacancy(){
		return new ResponseEntity<List<Vacancy>>(vacancyServiceObj.getAllVacancy(), HttpStatus.FOUND);
	}
	
	@GetMapping(value = Constant.GET_VACANCY_BY_ID)
	public ResponseEntity<Vacancy> getVacancyById(@PathVariable int vacancyId){
		System.out.println("VacancyController.getVacancyById()");
		return new ResponseEntity<Vacancy>(vacancyServiceObj.getVacancyById(vacancyId), HttpStatus.FOUND);
	}
	
	@PostMapping(value = "/vacancy")
	public ResponseEntity<Void> createNewVacancy(@RequestBody Vacancy vacancy)
	{
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
}
