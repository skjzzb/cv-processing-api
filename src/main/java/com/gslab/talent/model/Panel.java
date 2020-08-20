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
@Table(name="panel")
public class Panel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
	
	String questions;
	String average;
	
	int candidateId;
	
	
	Panel(){
		super();
	}
	
	Panel(int id,String question,String average,int candidateId){
		super();
		this.id = id;
		this.questions = question;
		this.average = average;
		this.candidateId = candidateId;
		
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getQuestions() {
		return questions;
	}


	public void setQuestions(String questions) {
		this.questions = questions;
	}


	public String getAverage() {
		return average;
	}


	public void setAverage(String average) {
		this.average = average;
	}


	public int getCandidateId() {
		return candidateId;
		
	}


	public void setCandidate(int candidateId) {
		this.candidateId = candidateId;
	}
	
	
}
