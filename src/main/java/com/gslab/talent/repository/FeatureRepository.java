package com.gslab.talent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gslab.talent.model.Feature;

@Repository
public interface FeatureRepository extends JpaRepository<Feature, Integer>{

}
