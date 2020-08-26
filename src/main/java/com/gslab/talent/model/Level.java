package com.gslab.talent.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="level")
public class Level {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
	
	@Column(name="description")
	String description;

	Level(){
		
	}
	
	Level(int id,String description){
		this.id=id;
		this.description=description;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Level [id=" + id + ", description=" + description + "]";
	}
	
}
