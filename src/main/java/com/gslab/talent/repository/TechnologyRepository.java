package com.gslab.talent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gslab.talent.model.Technology;

@Repository
public interface TechnologyRepository extends JpaRepository<Technology, Integer> {

	Technology findByTechnologyName(String technologyName);

}
