package com.gslab.talent.controller;



import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gslab.talent.constant.Constant;
import com.gslab.talent.model.Candidate;
import com.gslab.talent.model.Question;
import com.gslab.talent.model.Technology;
import com.gslab.talent.model.Vacancy;
import com.gslab.talent.service.QuestionService;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = "*")
@RequestMapping(value = "/api")
public class QuestionController {

	@Autowired
	QuestionService questionServiceObj;
	
	@PostMapping(value = "/addQuestion")
	public ResponseEntity<Void> createQuestion(@RequestBody Question question) {
		System.out.println("Question obj :"+question);
		questionServiceObj.createQuestion(question);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/getAllConcept/{technologyName}")
	public List<Question> getAllConcept(@PathVariable String technologyName) {
		return questionServiceObj.getAllConceptByTechName(technologyName);
	}
	
	@GetMapping(value = "/getAllQuestion/{id}")
	public ArrayList<String> getAllQuestion(@PathVariable Integer id) {
		ArrayList<String> list = new ArrayList<String>();
		
		Question question = questionServiceObj.getQuestionById(id);
		String que = question.getQuestion();
		String split[] = que.split(",");
		for(int i=0;i<split.length;i++) {
			System.out.println(split[i]);
			list.add(split[i]);
			
		}
		return list;
	}
}
	