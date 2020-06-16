package com.gslab.talent.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gslab.talent.model.Document;


public interface DocumentService {

	public void createDocument(Document Obj);
	public  List<Document> getAllDocuments();
	public  Document update(Document Obj);
	public Document findById(long id);
	public void deleteDocumentById(long id);
	
}
