package com.gslab.talent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gslab.talent.model.Feature;
import com.gslab.talent.model.Interview;

@Repository
public interface InterviewRepository extends JpaRepository<Interview, Long>{

}
