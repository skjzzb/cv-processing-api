package com.gslab.talent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gslab.talent.model.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
	

}
