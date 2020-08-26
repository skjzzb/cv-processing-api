package com.gslab.talent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gslab.talent.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer>  {

}
