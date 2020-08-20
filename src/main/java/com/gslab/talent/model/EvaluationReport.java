package com.gslab.talent.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Evaluation")
public class EvaluationReport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
	
	String question;

	String averageRating;
	
	int candidateId;
	
	EvaluationReport(){
		
	}
	
	EvaluationReport(int id,String question,String averageRating,int cacandidateId){
		this.id = id;
		this.question = question;
		this.averageRating = averageRating;
		this.candidateId = candidateId;
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
	
	@Override
	public String toString() {
		return "Evaluation [id=" + id + ", question=" + question + ", averageRating=" + averageRating +" ]";
	}
}
