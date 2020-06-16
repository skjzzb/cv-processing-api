package com.gslab.talent.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Document")
public class Document {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="folderName")
	private String folderName;
	
	@Column(name="noCV")
	private long noCV;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	public long getNoCV() {
		return noCV;
	}

	public void setNoCV(long noCV) {
		this.noCV = noCV;
	}

	public Document(String folderName, long noCV) {
		super();
		this.folderName = folderName;
		this.noCV = noCV;
	}

	public Document() {
		super();
	}
	
	
	

}
