package com.gslab.talent.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="project")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer projId;
	String name;
	String status;
	public Project(Integer projId, String name, String status) {
		super();
		this.projId = projId;
		this.name = name;
		this.status = status;
	}
	public Project() {
		
	}
	public Integer getProjId() {
		return projId;
	}
	public void setProjId(Integer projId) {
		this.projId = projId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Project [projId=" + projId + ", name=" + name + ", status=" + status + "]";
	}
	
	

}
