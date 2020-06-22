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
import com.gslab.talent.model.Technology;
import com.gslab.talent.service.TechnologyService;

@RestController
@CrossOrigin(allowedHeaders = "*")
@RequestMapping(value = "/v1")
public class TechnologyController {
	
	@Autowired
	private TechnologyService ServiceObj;
	
	@GetMapping(value = Constant.GET_LIST_OF_TECHNOLOGY, headers = Constant.ACCEPT_JSON, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Technology> getAllTechnology() {
		return ServiceObj.getAllTechnology();
	}

	@GetMapping(value = Constant.GET_TECHNOLOGY_BY_ID, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Technology> getTechnologyById(@PathVariable(Constant.TECHNOLOGY_ID) int id) {
		Technology obj = ServiceObj.findById(id);
		if (obj == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}


	@PostMapping(value = Constant.ADD_TECHNOLOGY, headers = Constant.ACCEPT_JSON)
	public ResponseEntity<Void> createTechnology(@RequestBody Technology obj, UriComponentsBuilder ucBuilder) {
		ServiceObj.createTechnology(obj);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path(Constant.GET_TECHNOLOGY_BY_ID).buildAndExpand(obj.getTechnologyId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping(value = Constant.UPDATE_TECHNOLOGY ,headers = Constant.ACCEPT_JSON)
	public ResponseEntity<Void> updateTechnologyInfo(@PathVariable(Constant.TECHNOLOGY_ID) int id,@RequestBody Technology obj )
	{
		obj.setTechnologyId(id);
		ServiceObj.update(obj);
		return new ResponseEntity<Void>(HttpStatus.FOUND);
	}
	
	@DeleteMapping(Constant.DELETE_TECHNOLOGY)
	public ResponseEntity<Void> deleteTechnologyById(@PathVariable int technologyId, UriComponentsBuilder ucBuilder) {
		ServiceObj.deleteTechnologyById(technologyId);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path(Constant.DELETE_DOCUMENT_BY_ID).buildAndExpand(technologyId).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.OK);
	}

}
