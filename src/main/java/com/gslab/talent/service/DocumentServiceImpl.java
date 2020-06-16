package com.gslab.talent.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gslab.talent.model.Document;
import com.gslab.talent.repository.DocumentRepository;


@Service
public class DocumentServiceImpl implements DocumentService {
	
	@Autowired
	DocumentRepository repoObj;

	@Override
	public void createDocument(Document obj) {
		this.repoObj.save(obj);

	}

	@Override
	public List<Document> getAllDocuments() {
		return this.repoObj.findAll();
	}

	@Override
	public Document update(Document obj) {
		return this.repoObj.save(obj);
	}

	@Override
	public void deleteDocumentById(long id) {
		this.repoObj.deleteById(id);
	}

	@Override
	public Document findById(long id) {
		Optional optObj =  this.repoObj.findById(id);
		return (Document) optObj.get();
	}

}
