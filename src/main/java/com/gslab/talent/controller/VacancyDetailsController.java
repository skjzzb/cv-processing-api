package com.gslab.talent.controller;

import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gslab.talent.service.VacancyDetailService;


@RestController
@CrossOrigin(allowedHeaders = "*")
@RequestMapping(value= "/v1")
public class VacancyDetailsController {
	@Autowired
	VacancyDetailService vacancyDetailServiceObj;
	
	@GetMapping(value="/totalvacancy")
	public ResponseEntity<TreeMap<Integer, Integer>> getTotalVacancy(){
		
		return new ResponseEntity<TreeMap<Integer,Integer>>(vacancyDetailServiceObj.getAllVacancy(), HttpStatus.OK);
	}
	
	@GetMapping(value="/monthapplication")
	public ResponseEntity<TreeMap<Integer, Integer>> getMonthApplicationn(){
		return new ResponseEntity<TreeMap<Integer,Integer>>(vacancyDetailServiceObj.getTotalApplicationInMonth(),HttpStatus.OK);
	}
	
	@GetMapping(value="/monthselected")
	public ResponseEntity<TreeMap<Integer,Integer>> getMonthSelected(){
		return new ResponseEntity<TreeMap<Integer,Integer>>(vacancyDetailServiceObj.getAllSelected(),HttpStatus.OK);
	}
	
	@GetMapping(value="/monthrejected")
	public ResponseEntity<TreeMap<Integer, Integer>> getMonthRejected(){
		return new ResponseEntity<TreeMap<Integer,Integer>>(vacancyDetailServiceObj.getAllRejected(),HttpStatus.OK);
	}

}
