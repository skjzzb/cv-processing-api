package com.gslab.talent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.gslab.talent.constant.Constant;
import com.gslab.talent.model.Document;
import com.gslab.talent.service.DocumentService;


@RestController
@RequestMapping(value = "/v1")
public class DocumentController {

	@Autowired
	private DocumentService ServiceObj;
	
	@GetMapping(value = Constant.GET_LIST_OF_DOCUMENTS, headers = Constant.ACCEPT_JSON, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Document> getAllDocuments() {
		return ServiceObj.getAllDocuments();
	}

	@GetMapping(value = Constant.GET_DOCUMENT_BY_ID, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Document> getDocumentById(@PathVariable(Constant.DOCUMENT_ID) long id) {
		Document obj = ServiceObj.findById(id);
		if (obj == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}


	@PostMapping(value = Constant.ADD_DOCUMENT, headers = Constant.ACCEPT_JSON)
	public ResponseEntity<Void> createEmployee(@RequestBody Document obj, UriComponentsBuilder ucBuilder) {
		ServiceObj.createDocument(obj);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path(Constant.GET_CANDIDATE_BY_ID).buildAndExpand(obj.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PostMapping(value = Constant.UPDATE_DOCUMENT ,headers = Constant.ACCEPT_JSON)
	public ResponseEntity<Void> updateDocumentInfo(@RequestBody Document obj )
	{
		ServiceObj.update(obj);
		return new ResponseEntity<Void>(HttpStatus.FOUND);
	}
	
	@DeleteMapping(Constant.DELETE_DOCUMENT_BY_ID)
	public ResponseEntity<Void> deleteDOcumentById(@PathVariable long id, UriComponentsBuilder ucBuilder) {
		ServiceObj.deleteDocumentById(id);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path(Constant.DELETE_DOCUMENT_BY_ID).buildAndExpand(id).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.OK);
	}
	

}
