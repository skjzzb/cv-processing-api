package com.gslab.talent.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Feature {

	Integer id;
	String roles;
	Boolean vacancy;
	Boolean candidate;
	Boolean userList;
	Boolean dashboard;
	
	public Feature() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Feature(Integer id, String roles, Boolean vacancy, Boolean candidate, Boolean userList, Boolean dashboard) {
		super();
		this.id = id;
		this.roles = roles;
		this.vacancy = vacancy;
		this.candidate = candidate;
		this.userList = userList;
		this.dashboard = dashboard;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public Boolean getVacancy() {
		return vacancy;
	}

	public void setVacancy(Boolean vacancy) {
		this.vacancy = vacancy;
	}

	public Boolean getCandidate() {
		return candidate;
	}

	public void setCandidate(Boolean candidate) {
		this.candidate = candidate;
	}

	public Boolean getUserList() {
		return userList;
	}

	public void setUserList(Boolean userList) {
		this.userList = userList;
	}
	
	public Boolean getDashboard() {
		return dashboard;
	}

	public void setDashboard(Boolean dashboard) {
		this.dashboard = dashboard;
	}

	@Override
	public String toString() {
		return "Feature [id=" + id + ", roles=" + roles + ", vacancy=" + vacancy + ", candidate=" + candidate
				+ ", userList=" + userList + ", dashboard=" + dashboard + "]";
	}
	
}
