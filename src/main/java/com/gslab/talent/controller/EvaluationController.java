package com.gslab.talent.controller;


import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gslab.talent.model.Evaluation;
import com.gslab.talent.service.EvaluationService;

@RestController
@CrossOrigin(allowedHeaders = "*")
@RequestMapping(value = "/v1")
public class EvaluationController {
	
	@Autowired
	EvaluationService evaluationServiceObj;
	
	@PostMapping(value = "/evaluation")
	public ResponseEntity<Void> createNewEvaluation(@RequestBody Evaluation evaluation)
	{
		evaluationServiceObj.createNewEvaluation(evaluation);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/GetEvaluationReport/{id}")
	public List<Evaluation> GetEvaluationReport(@PathVariable int id)
	{
		return evaluationServiceObj.getEvaluationReport(id);
		
	}
}
