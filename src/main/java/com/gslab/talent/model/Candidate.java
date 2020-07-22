package com.gslab.talent.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@Column(name="email")
	private String email;
	
	@Column(name="technologyStack")
	private String technologyStack;
	
	@Column(name="reqMatchingPercent")
	private int reqMatchingPercent;
	
	@Column(name="technologyStackMatchingPercent")
	private int technologyStackMatchingPercent;
	
	@Column(name="shortSummaryMatchingPercent")
	private int shortSummaryMatchingPercent;
	
	//@Column(name="")
	//Boolean interview ;
	
	Integer yearOfExperience;
	
	String employmentStatus;
	
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

	public int getReqMatchingPercent() {
		return reqMatchingPercent;
	}

	public void setReqMatchingPercent(int reqMatchingPercent) {
		this.reqMatchingPercent = reqMatchingPercent;
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
	
	public int getTechnologyStackMatchingPercent() {
		return technologyStackMatchingPercent;
	}

	public void setTechnologyStackMatchingPercent(int technologyStackMatchingPercent) {
		this.technologyStackMatchingPercent = technologyStackMatchingPercent;
	}

	public int getShortSummaryMatchingPercent() {
		return shortSummaryMatchingPercent;
	}

	public void setShortSummaryMatchingPercent(int shortSummaryMatchingPercent) {
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
			int reqMatchingPercent, Integer yearOfExperience) {
		super();
		this.id = id;
		this.candidateName = candidateName;
		this.contactNo = contactNo;
		this.email = email;
		this.technologyStack = technologyStack;
		this.reqMatchingPercent = reqMatchingPercent;
		this.yearOfExperience = yearOfExperience;
	}
	
	public Candidate(long id, String candidateName, String contactNo, String email, String technologyStack,
			int reqMatchingPercent, int technologyStackMatchingPercent, int shortSummaryMatchingPercent,
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

	public Candidate() {
		super();
	}

	@Override
	public String toString() {
		return "Candidate [id=" + id + ", candidateName=" + candidateName + ", contactNo=" + contactNo + ", email="
				+ email + ", technologyStack=" + technologyStack + ", reqMatchingPercent=" + reqMatchingPercent
				+ ", technologyStackMatchingPercent=" + technologyStackMatchingPercent
				+ ", shortSummaryMatchingPercent=" + shortSummaryMatchingPercent + ", yearOfExperience="
				+ yearOfExperience + ", employmentStatus=" + employmentStatus + "]";
	}
	
}
