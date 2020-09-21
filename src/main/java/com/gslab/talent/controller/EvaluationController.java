package com.gslab.talent.controller;


import java.util.List;

import javax.websocket.server.PathParam;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.gslab.talent.constant.Constant;
import com.gslab.talent.model.Candidate;
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
	
	@GetMapping(value = "/GetEvaluationReportByCandidateId/{id}")
	public List<Evaluation> GetEvaluationReport(@PathVariable int id)
	{
		return evaluationServiceObj.getEvaluationReport(id);
		
	}
	
	@GetMapping(value = "/getAllEvaluationReport")
	public List<Evaluation> getAllEvaluationReport() {
		return evaluationServiceObj.getAllEvaluationReport();
	}
	
	@DeleteMapping(value = "/DeleteEvaluationReportByCandidateId/{id}")
	public ResponseEntity<Void> DeleteEvaluationReportByCandidateId(@PathVariable int id) {
		return new ResponseEntity<Void>(evaluationServiceObj.DeleteEvaluationReportByCandidateId(id), HttpStatus.OK);
	}
}
