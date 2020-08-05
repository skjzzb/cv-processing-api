package com.gslab.talent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gslab.talent.model.Question;
import com.gslab.talent.service.QuestionService;

@RestController
@CrossOrigin(allowedHeaders = "*")
@RequestMapping(value = "/api")
public class QuestionController {

	@Autowired
	QuestionService questionServiceObj;
	
	/*@PostMapping(value = "/addQuestion")
	public ResponseEntity<Void> createQuestion(@RequestBody Question question) {
		questionServiceObj.createQuestion(question);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}*/
}
	