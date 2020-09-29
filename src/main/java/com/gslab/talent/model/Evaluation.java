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
@Table(name="Evaluation")
public class Evaluation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
	
	String question;

	String averageRating;
	
	String interviewLevel;
	
	int candidateId;
	
	String feedback;
	
	Evaluation(){
		
	}
	
	Evaluation(int id,String question,String averageRating,int candidateId,String feedback){
		this.id = id;
		this.question = question;
		this.averageRating = averageRating;
		this.candidateId = candidateId;
		this.feedback = feedback;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(String averageRating) {
		this.averageRating = averageRating;
	}
	
	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public String getInterviewLevel() {
		return interviewLevel;
	}

	public void setInterviewLevel(String interviewLevel) {
		this.interviewLevel = interviewLevel;
	}
	
	@Override
	public String toString() {
		return "Evaluation [id=" + id + ", question=" + question + ", averageRating=" + averageRating +" ]";
	}
}
