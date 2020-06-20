package com.gslab.talent.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="users")
public class User {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer userId;
	String username;
	String email;
	String firstName;
	String lastName;
	String address;
	String city;
	String country;
	String pinCode;
	String aboutMe;
	String password;
	String role;
	String url;
}
