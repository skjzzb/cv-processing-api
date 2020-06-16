package com.gslab.talent.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Candidate")
public class Candidate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="candidateName")
	private String candidateName;
	
	@Column(name="contactNo")
	private String contactNo;
	
	@Column(name="technologyStack")
	private String technologyStack;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String experience) {
		this.contactNo = experience;
	}

	public String getTechnologyStack() {
		return technologyStack;
	}

	public void setTechnologyStack(String technologyStack) {
		this.technologyStack = technologyStack;
	}

	public Candidate(String candidateName, String contactNo, String technologyStack) {
		super();
		this.candidateName = candidateName;
		this.contactNo = contactNo;
		this.technologyStack = technologyStack;
	}

	public Candidate() {
		super();
	}
	
	
	
}
