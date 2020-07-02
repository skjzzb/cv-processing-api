package com.gslab.talent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gslab.talent.model.Vacancy;

@Repository
public interface VacancyRepository extends JpaRepository<Vacancy, Integer> {

	List<Vacancy> findAll();
}
