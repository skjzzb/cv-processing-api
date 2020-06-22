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
import com.gslab.talent.model.Candidate;
import com.gslab.talent.model.User;
import com.gslab.talent.service.UserService;


@RestController
@CrossOrigin(allowedHeaders = "*")
@RequestMapping(value = "/v1")
public class UserController {
	
	@Autowired
	UserService userServiceObj;
	
	@GetMapping(value = Constant.GET_LIST_OF_USERS, headers = Constant.ACCEPT_JSON, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAllUsers() {
		return userServiceObj.getAllUser();
	}
	

	@GetMapping(value = Constant.GET_USER_BY_ID, headers = Constant.ACCEPT_JSON, produces = MediaType.APPLICATION_JSON_VALUE)
	public User getUserById( @PathVariable int userId) {
		return userServiceObj.getUserById(userId);
	}
	
	
	@PostMapping(value = Constant.ADD_USER, headers = Constant.ACCEPT_JSON)
	public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
		
		userServiceObj.createUser(user);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path(Constant.GET_USER_BY_ID).buildAndExpand(user.getUserId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping(value = Constant.UPDATE_USER ,headers = Constant.ACCEPT_JSON)
	public ResponseEntity<Void> updateUserInfo(@RequestBody User user )
	{
		userServiceObj.updateUser(user);
		return new ResponseEntity<Void>(HttpStatus.FOUND);
	}
	
	@DeleteMapping(value = Constant.DELETE_USER, headers = Constant.ACCEPT_JSON)
	public ResponseEntity<Void> deleteUser(@PathVariable int userId)
	{
		userServiceObj.deleteById(userId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
