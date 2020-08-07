package com.gslab.talent.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name="vacancy")
public class Vacancy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer vacancyId;
	String jobTitle;
	String projectName;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="IST")
	Date posOpenDate;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="IST")
	Date posOnBoardDate;
	
	String jd;
	Integer noOfVacancy;
	String shortSummary;
	Integer experienceRequired;
	
    String levelList;

	@JsonBackReference
	//@JsonIgnore
	@OneToMany(mappedBy = "vacancy", orphanRemoval = true)
	List<Candidate> candidateList = new ArrayList<>();
	
	public Vacancy() {
		// TODO Auto-generated constructor stub
	}

	public Vacancy(Integer vacancyId, String jobTitle, String projectName, Date posOpenDate, Date posOnBoardDate,
			String jd, Integer noOfVacancy,String shortSummary) {
		super();
		this.vacancyId = vacancyId;
		this.jobTitle = jobTitle;
		this.projectName = projectName;
		this.posOpenDate = posOpenDate;
		this.posOnBoardDate = posOnBoardDate;
		this.jd = jd;
		this.noOfVacancy = noOfVacancy;
		this.shortSummary=shortSummary;
	}
	
	public Vacancy(Integer vacancyId, String jobTitle, String projectName, Date posOpenDate, Date posOnBoardDate,
			String jd, Integer noOfVacancy, String shortSummary, Integer experienceRequired,String levelList) {
		super();
		this.vacancyId = vacancyId;
		this.jobTitle = jobTitle;
		this.projectName = projectName;
		this.posOpenDate = posOpenDate;
		this.posOnBoardDate = posOnBoardDate;
		this.jd = jd;
		this.noOfVacancy = noOfVacancy;
		this.shortSummary = shortSummary;
		this.experienceRequired = experienceRequired;
		this.levelList = levelList;
	}

	public Integer getNoOfVacancy() {
		return noOfVacancy;
	}

	public void setNoOfVacancy(Integer noOfVacancy) {
		this.noOfVacancy = noOfVacancy;
	}

	public Integer getVacancyId() {
		return vacancyId;
	}

	public void setVacancyId(Integer vacancyId) {
		this.vacancyId = vacancyId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Date getPosOpenDate() {
		return posOpenDate;
	}

	public void setPosOpenDate(Date posOpenDate) {
		this.posOpenDate = posOpenDate;
	}

	public Date getPosOnBoardDate() {
		return posOnBoardDate;
	}

	public void setPosOnBoardDate(Date posOnBoardDate) {
		this.posOnBoardDate = posOnBoardDate;
	}

	public String getJd() {
		return jd;
	}

	public void setJd(String jd) {
		this.jd = jd;
	}
	
	public String getShortSummary() {
		return shortSummary;
	}

	public void setShortSummary(String shortSummary) {
		this.shortSummary = shortSummary;
	}
	
	public Integer getExperienceRequired() {
		return experienceRequired;
	}

	public void setExperienceRequired(Integer experienceRequired) {
		this.experienceRequired = experienceRequired;
	}

	public List<Candidate> getCandidateList() {
		return candidateList;
	}
	public void setCandidateList(List<Candidate> candidateList) {
		this.candidateList = candidateList;
	}
	
	public String getlevelList() {
		return levelList;
	}

	public void setlevelList(String levelList) {
		this.levelList = levelList;
	}
	
	
	//helper methods
	public void addCandidate(Candidate candidate) {
		this.candidateList.add(candidate);
		candidate.setVacancy(this);
	}

	public void removeCandidate(Candidate candidate )
	{
		candidateList.remove(candidate);
		candidate.setVacancy(null);
	}
	

	@Override
	public String toString() {
		
		return "Vacancy [vacancyId=" + vacancyId + ", jobTitle=" + jobTitle + ", projectName=" + projectName
				+ ", posOpenDate=" + posOpenDate + ", posOnBoardDate=" + posOnBoardDate + ", jd=" + jd
				+ ", noOfVacancy=" + noOfVacancy + ", shortSummary=" + shortSummary + ", experienceRequired="
				+ experienceRequired + "]";
	}

		
}
