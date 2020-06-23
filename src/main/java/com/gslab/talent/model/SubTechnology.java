package com.gslab.talent.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SubTechnology {
	
	long subTechnologyId;
	String subTechnologyName;
	int technologyId;
	
	
	public SubTechnology() {
		// TODO Auto-generated constructor stub
	}


	public SubTechnology(long subTechnologyId, String subTechnologyName, int technologyId) {
		super();
		this.subTechnologyId = subTechnologyId;
		this.subTechnologyName = subTechnologyName;
		this.technologyId = technologyId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getSubTechnologyId() {
		return subTechnologyId;
	}


	public void setSubTechnologyId(long subTechnologyId) {
		this.subTechnologyId = subTechnologyId;
	}


	public String getSubTechnologyName() {
		return subTechnologyName;
	}


	public void setSubTechnologyName(String subTechnologyName) {
		this.subTechnologyName = subTechnologyName;
	}


	public int getTechnologyId() {
		return technologyId;
	}


	public void setTechnologyId(int technologyId) {
		this.technologyId = technologyId;
	}


	@Override
	public String toString() {
		return "SubTechnology [subTechnologyId=" + subTechnologyId + ", subTechnologyName=" + subTechnologyName
				+ ", technologyId=" + technologyId + "]";
	}
	
	
	
	
}
