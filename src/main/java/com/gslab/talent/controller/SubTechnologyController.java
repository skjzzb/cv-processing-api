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
import com.gslab.talent.model.Document;
import com.gslab.talent.model.SubTechnology;
import com.gslab.talent.service.DocumentService;
import com.gslab.talent.service.SubTechnologyService;

@RestController
@CrossOrigin(allowedHeaders = "*")
@RequestMapping(value = "/v1")
public class SubTechnologyController {
	
	@Autowired
	private SubTechnologyService ServiceObj;
	
	@GetMapping(value = Constant.GET_LIST_OF_SUBTECHNOLOGY, headers = Constant.ACCEPT_JSON, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<SubTechnology> getAllSubTechnology() {
		return ServiceObj.getAllSubTechnology();
	}
	
	@GetMapping(value = Constant.GET_SUBTECHNOLOGY_BY_TECHNOLOGY_ID, headers = Constant.ACCEPT_JSON, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<SubTechnology> getAllSubTechnologyByTechnologyId(@PathVariable(Constant.TECHNOLOGY_ID) int id) {
		return ServiceObj.getAllByTechnologyId(id);
	}

	@GetMapping(value = Constant.GET_SUBTECHNOLOGY_BY_ID, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SubTechnology> getSubTechnologyById(@PathVariable(Constant.SUBTECHNOLOGY_ID) long id) {
		SubTechnology obj = ServiceObj.findById(id);
		if (obj == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}


	@PostMapping(value = Constant.ADD_SUBTECHNOLOGY, headers = Constant.ACCEPT_JSON)
	public ResponseEntity<Void> createSubTechnology(@RequestBody SubTechnology obj, UriComponentsBuilder ucBuilder) {
		ServiceObj.createSubTechnology(obj);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path(Constant.GET_SUBTECHNOLOGY_BY_ID).buildAndExpand(obj.getSubTechnologyId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping(value = Constant.UPDATE_SUBTECHNOLOGY ,headers = Constant.ACCEPT_JSON)
	public ResponseEntity<Void> updateSubTechnologyInfo(@PathVariable(Constant.SUBTECHNOLOGY_ID) long id,@RequestBody SubTechnology obj )
	{
		obj.setSubTechnologyId(id);
		ServiceObj.update(obj);
		return new ResponseEntity<Void>(HttpStatus.FOUND);
	}
	
	@DeleteMapping(Constant.DELETE_SUBTECHNOLOGY)
	public ResponseEntity<Void> deleteSubTechnologyById(@PathVariable(Constant.SUBTECHNOLOGY_ID) long id, UriComponentsBuilder ucBuilder) {
		ServiceObj.deleteSubTechnologyById(id);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path(Constant.DELETE_DOCUMENT_BY_ID).buildAndExpand(id).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.OK);
	}
	

}
