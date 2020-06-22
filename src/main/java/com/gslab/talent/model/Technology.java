package com.gslab.talent.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Technology {
	
	int technologyId;
	String technologyName;
	
	
	public Technology() {
		// TODO Auto-generated constructor stub
	}
	
	public Technology(int technologyId, String technologyName) {
		super();
		this.technologyId = technologyId;
		this.technologyName = technologyName;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getTechnologyId() {
		return technologyId;
	}
	public void setTechnologyId(int technologyId) {
		this.technologyId = technologyId;
	}
	public String getTechnologyName() {
		return technologyName;
	}
	public void setTechnologyName(String technologyName) {
		this.technologyName = technologyName;
	}

	@Override
	public String toString() {
		return "Technology [technologyId=" + technologyId + ", technologyName=" + technologyName + "]";
	}
	
}
