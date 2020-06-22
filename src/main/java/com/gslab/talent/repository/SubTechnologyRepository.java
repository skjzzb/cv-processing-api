package com.gslab.talent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gslab.talent.model.SubTechnology;

@Repository
public interface SubTechnologyRepository extends JpaRepository<SubTechnology, Long> {

}
