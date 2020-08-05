package com.gslab.talent.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name="level")
public class Level {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
	
	@Column(name="level")
	String level;
	
	@Column(name="description")
	String description;

	Level(){
		
	}
	
	Level(int id,String level,String description){
		this.id=id;
		this.level=level;
		this.description=description;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Level [id=" + id + ", level=" + level + ", description=" + description + "]";
	}
	
}
