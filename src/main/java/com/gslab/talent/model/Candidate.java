package com.gslab.talent.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
	
	@Column(name="email")
	private String email;
	
	@Column(name="technologyStack")
	private String technologyStack;
	
	@Column(name="reqMatchingPercent")
	private Integer reqMatchingPercent;
	
	private Integer technologyStackMatchingPercent;
	
	private Integer shortSummaryMatchingPercent;
	
	@Column(name="interviewStatus")
	private String interviewStatus;
	
	Integer yearOfExperience;
	
	String employmentStatus;
	
	String finalStatus;
	
	
	
	

	public String getFinalStatus() {
		return finalStatus;
	}

	public void setFinalStatus(String finalStatus) {
		this.finalStatus = finalStatus;
	}

	

	@ManyToOne
	@JoinColumn(name = "vacancyId")
	private Vacancy vacancy;
	
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

	public Vacancy getVacancy() {
		return vacancy;
	}

	public void setVacancy(Vacancy vacancy) {
		this.vacancy = vacancy;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Integer getYearOfExperience() {
		return yearOfExperience;
	}

	public void setYearOfExperience(Integer yearOfExperience) {
		this.yearOfExperience = yearOfExperience;
	}
	
	public String getEmploymentStatus() {
		return employmentStatus;
	}

	public void setEmploymentStatus(String employmentStatus) {
		this.employmentStatus = employmentStatus;
	}
		
	public String getInterviewStatus() {
		return interviewStatus;
	}

	public void setInterviewStatus(String interviewStatus) {
		this.interviewStatus = interviewStatus;
	}

	public Integer getReqMatchingPercent() {
		return reqMatchingPercent;
	}

	public void setReqMatchingPercent(Integer reqMatchingPercent) {
		this.reqMatchingPercent = reqMatchingPercent;
	}

	public Integer getTechnologyStackMatchingPercent() {
		return technologyStackMatchingPercent;
	}

	public void setTechnologyStackMatchingPercent(Integer technologyStackMatchingPercent) {
		this.technologyStackMatchingPercent = technologyStackMatchingPercent;
	}

	public Integer getShortSummaryMatchingPercent() {
		return shortSummaryMatchingPercent;
	}

	public void setShortSummaryMatchingPercent(Integer shortSummaryMatchingPercent) {
		this.shortSummaryMatchingPercent = shortSummaryMatchingPercent;
	}

	public Candidate(long id, String candidateName, String contactNo, String email, String employmentStatus) {
		super();
		this.id = id;
		this.candidateName = candidateName;
		this.contactNo = contactNo;
		this.email = email;
		this.employmentStatus = employmentStatus;
	}
	
	
	
	

	public Candidate(long id, String candidateName, String contactNo, String email, String technologyStack,
			Integer reqMatchingPercent, Integer technologyStackMatchingPercent, Integer shortSummaryMatchingPercent,
			Integer yearOfExperience) {
		super();
		this.id = id;
		this.candidateName = candidateName;
		this.contactNo = contactNo;
		this.email = email;
		this.technologyStack = technologyStack;
		this.reqMatchingPercent = reqMatchingPercent;
		this.technologyStackMatchingPercent = technologyStackMatchingPercent;
		this.shortSummaryMatchingPercent = shortSummaryMatchingPercent;
		this.yearOfExperience = yearOfExperience;
	}

	public Candidate(long id, String candidateName, String contactNo, String email, String technologyStack,
			Integer reqMatchingPercent, Integer technologyStackMatchingPercent, Integer shortSummaryMatchingPercent,
			String interviewStatus, Integer yearOfExperience, String employmentStatus) {
		super();
		this.id = id;
		this.candidateName = candidateName;
		this.contactNo = contactNo;
		this.email = email;
		this.technologyStack = technologyStack;
		this.reqMatchingPercent = reqMatchingPercent;
		this.technologyStackMatchingPercent = technologyStackMatchingPercent;
		this.shortSummaryMatchingPercent = shortSummaryMatchingPercent;
		this.interviewStatus = interviewStatus;
		this.yearOfExperience = yearOfExperience;
		this.employmentStatus = employmentStatus;
	}
	
	

	public Candidate(long id, String candidateName, String contactNo, String email, String technologyStack,
			Integer reqMatchingPercent, Integer technologyStackMatchingPercent, Integer shortSummaryMatchingPercent,
			String interviewStatus, Integer yearOfExperience, String employmentStatus, String finalStatus,Vacancy vacancy) {
		super();
		this.id = id;
		this.candidateName = candidateName;
		this.contactNo = contactNo;
		this.email = email;
		this.technologyStack = technologyStack;
		this.reqMatchingPercent = reqMatchingPercent;
		this.technologyStackMatchingPercent = technologyStackMatchingPercent;
		this.shortSummaryMatchingPercent = shortSummaryMatchingPercent;
		this.interviewStatus = interviewStatus;
		this.yearOfExperience = yearOfExperience;
		this.employmentStatus = employmentStatus;
		this.finalStatus = finalStatus;
		this.vacancy = vacancy;
	}

	public Candidate() {
		super();
	}

	@Override
	public String toString() {
		return "Candidate [id=" + id + ", candidateName=" + candidateName + ", contactNo=" + contactNo + ", email="
				+ email + ", technologyStack=" + technologyStack + ", reqMatchingPercent=" + reqMatchingPercent
				+ ", technologyStackMatchingPercent=" + technologyStackMatchingPercent
				+ ", shortSummaryMatchingPercent=" + shortSummaryMatchingPercent + ", interviewStatus="
				+ interviewStatus + ", yearOfExperience=" + yearOfExperience + ", employmentStatus=" + employmentStatus
				+ "]";
	}

}