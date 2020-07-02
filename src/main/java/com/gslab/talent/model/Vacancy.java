package com.gslab.talent.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	
	//@JsonBackReference
	//@JsonIgnore
	public List<Candidate> candidateList=new ArrayList<>();
	
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
	
	@OneToMany(targetEntity=Candidate.class, mappedBy ="vacancy", cascade = CascadeType.ALL,orphanRemoval=true)
	public List<Candidate> getCandidateList() {
	return candidateList;
		}

	public void setCandidateList(List<Candidate> candidateList) {
	this.candidateList = candidateList;
		}	


	  public void addCandidate(Candidate c) {
			candidateList.add(c);
			c.setVacancy(this);
		
		}

		public void removeCandidate(Candidate c) {
			candidateList.remove(c);
			c.setVacancy(null);
		}
	
	
	@Override
	public String toString() {
		return "Vacancy [vacancyId=" + vacancyId + ", jobTitle=" + jobTitle + ", projectName=" + projectName
				+ ", posOpenDate=" + posOpenDate + ", posOnBoardDate=" + posOnBoardDate + ", jd=" + jd
				+ ", noOfVacancy=" + noOfVacancy + ", shortSummary=" + shortSummary + "]";
	}

	
}
