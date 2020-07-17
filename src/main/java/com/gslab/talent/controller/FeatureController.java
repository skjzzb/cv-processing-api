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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.gslab.talent.constant.Constant;
import com.gslab.talent.model.Document;
import com.gslab.talent.model.Feature;
import com.gslab.talent.service.DocumentService;
import com.gslab.talent.service.FeatureService;


@RestController
@CrossOrigin(allowedHeaders = "*")
@RequestMapping(value = "/v1")
public class FeatureController {

		@Autowired
		private FeatureService ServiceObj;
		
		@GetMapping(value = Constant.GET_LIST_OF_FEATURE, headers = Constant.ACCEPT_JSON, produces = MediaType.APPLICATION_JSON_VALUE)
		public List<Feature> getAllFeature() {
			return ServiceObj.getAllFeature();
		}

		@GetMapping(value = Constant.GET_FEATURE_BY_ROLE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Feature> getFeatureByRole(@PathVariable(Constant.FEATURE_NAME) String role) {
			Feature obj = ServiceObj.findByName(role);
			if (obj == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(obj, HttpStatus.OK);
		}


		@PostMapping(value = Constant.ADD_FEATURE, headers = Constant.ACCEPT_JSON)
		public ResponseEntity<Void> createFeature(@RequestBody Feature obj, UriComponentsBuilder ucBuilder) {
			ServiceObj.createFeature(obj);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path(Constant.GET_FEATURE_BY_ROLE).buildAndExpand(obj.getRoles()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		}
		
		@PostMapping(value = Constant.UPDATE_FEATURE ,headers = Constant.ACCEPT_JSON)
		public ResponseEntity<Void> updateFeatureInfo(@RequestBody Feature obj )
		{
			ServiceObj.update(obj);
			return new ResponseEntity<Void>(HttpStatus.FOUND);
		}
		
		@DeleteMapping(Constant.DELETE_FEATURE)
		public ResponseEntity<Void> deleteFeatureById(@PathVariable Integer id, UriComponentsBuilder ucBuilder) {
			ServiceObj.deleteFeatureById(id);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path(Constant.DELETE_FEATURE).buildAndExpand(id).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.OK);
		}
		

	}


