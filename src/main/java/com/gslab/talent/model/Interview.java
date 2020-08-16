package com.gslab.talent.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Interview {

	  Long InterviewId;
	
	  String panelEmail;
	  
	  String candidateEmail;
	  
	  String hrEmail;
	  
	  String scheduledOn;
	  
	  String scheduledEndTime;
	  
	  String level;
	  
	  String calEventId;
	  
	  String panelResponseStatus;
	  
	  String candidateResponseStatus;
	  
	  String interviewStatus;
	  	  
	  Long candidateId;
	  
	  Long vacancyId;
	  
	  public Interview() {}
	  

	public Interview(String panelEmail, String candidateEmail, String scheduledOn, String scheduledEndTime,
			String level, String hrEmail) {
		super();
		this.panelEmail = panelEmail;
		this.candidateEmail = candidateEmail;
		this.scheduledOn = scheduledOn;
		this.scheduledEndTime = scheduledEndTime;
		this.level = level;
		this.hrEmail = hrEmail;
	}
	
	
	

	
	public Interview(String panelEmail, String candidateEmail, String hrEmail, String scheduledOn,
			String scheduledEndTime, String level, Long candidateId, Long vacancyId) {
		super();
		this.panelEmail = panelEmail;
		this.candidateEmail = candidateEmail;
		this.hrEmail = hrEmail;
		this.scheduledOn = scheduledOn;
		this.scheduledEndTime = scheduledEndTime;
		this.level = level;
		this.candidateId = candidateId;
		this.vacancyId = vacancyId;
	}


	public Interview(Long interviewId, String panelEmail, String candidateEmail, String hrEmail, String scheduledOn,
			String scheduledEndTime, String level, String calEventId, String panelResponseStatus,
			String candidateResponseStatus, String interviewStatus, Long candidateId, Long vacancyId) {
		super();
		InterviewId = interviewId;
		this.panelEmail = panelEmail;
		this.candidateEmail = candidateEmail;
		this.hrEmail = hrEmail;
		this.scheduledOn = scheduledOn;
		this.scheduledEndTime = scheduledEndTime;
		this.level = level;
		this.calEventId = calEventId;
		this.panelResponseStatus = panelResponseStatus;
		this.candidateResponseStatus = candidateResponseStatus;
		this.interviewStatus = interviewStatus;
		this.candidateId = candidateId;
		this.vacancyId = vacancyId;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getInterviewId() {
		return InterviewId;
	}


	public void setInterviewId(Long interviewId) {
		InterviewId = interviewId;
	}	
	
	public String getCalEventId() {
		return calEventId;
	}

	public void setCalEventId(String calEventId) {
		this.calEventId = calEventId;
	}

	public String getPanelEmail() {
		return panelEmail;
	}

	public void setPanelEmail(String panelEmail) {
		this.panelEmail = panelEmail;
	}

	public String getCandidateEmail() {
		return candidateEmail;
	}

	public void setCandidateEmail(String candidateEmail) {
		this.candidateEmail = candidateEmail;
	}

	

	public String getScheduledEndTime() {
		return scheduledEndTime;
	}


	public void setScheduledEndTime(String scheduledEndTime) {
		this.scheduledEndTime = scheduledEndTime;
	}


	public String getScheduledOn() {
		return scheduledOn;
	}

	public void setScheduledOn(String scheduledOn) {
		this.scheduledOn = scheduledOn;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getHrEmail() {
		return hrEmail;
	}

	public void setHrEmail(String hrEmail) {
		this.hrEmail = hrEmail;
	}
	

	public String getPanelResponseStatus() {
		return panelResponseStatus;
	}


	public void setPanelResponseStatus(String panelResponseStatus) {
		this.panelResponseStatus = panelResponseStatus;
	}


	public String getCandidateResponseStatus() {
		return candidateResponseStatus;
	}


	public void setCandidateResponseStatus(String candidateResponseStatus) {
		this.candidateResponseStatus = candidateResponseStatus;
	}


	public String getInterviewStatus() {
		return interviewStatus;
	}


	public void setInterviewStatus(String interviewStatus) {
		this.interviewStatus = interviewStatus;
	}
	
	public Long getCandidateId() {
		return candidateId;
	}


	public void setCandidateId(Long candidateId) {
		this.candidateId = candidateId;
	}


	public Long getVacancyId() {
		return vacancyId;
	}


	public void setVacancyId(Long vacancyId) {
		this.vacancyId = vacancyId;
	}


	@Override
	public String toString() {
		return "Interview [InterviewId=" + InterviewId + ", panelEmail=" + panelEmail + ", candidateEmail="
				+ candidateEmail + ", hrEmail=" + hrEmail + ", scheduledOn=" + scheduledOn + ", scheduledEndTime="
				+ scheduledEndTime + ", level=" + level + ", calEventId=" + calEventId + ", panelResponseStatus="
				+ panelResponseStatus + ", candidateResponseStatus=" + candidateResponseStatus + ", interviewStatus="
				+ interviewStatus + ", candidateId=" + candidateId + ", vacancyId=" + vacancyId + "]";
	}


	    	
}
