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
@Table(name="question")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
	
	@Column(name="concept")
	String concept;
	
	@Column(name="question")
	String question;

	Question(){
		super();
	}
	
	@ManyToOne
	@JoinColumn(name = "technologyId")
	private Technology Technology;
	
	
	public Technology getTechnology() {
		return Technology;
	}

	public void setTechnology(Technology technology) {
		Technology = technology;
	}

	Question(int id,String concept,String question){
		super();
		this.id=id;
		this.concept=concept;
		this.question=question;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getConcept() {
		return concept;
	}

	public void setConcept(String concept) {
		this.concept = concept;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	
	@Override
	public String toString() {
		return "Question [id=" + id + ", concept=" + concept + ", question=" + question + "]";
	}
	
}