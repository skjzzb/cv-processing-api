package com.gslab.talent.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name  = "position")
public class Position {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer posId;
	String name;
	public Position(Integer posId, String name) {
		super();
		this.posId = posId;
		this.name = name;
	}
	public Position () {
		
	}
	public Integer getPosId() {
		return posId;
	}
	public void setPosId(Integer posId) {
		this.posId = posId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Position [posId=" + posId + ", name=" + name + "]";
	}
	
	

}
