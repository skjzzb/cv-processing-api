package com.gslab.talent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gslab.talent.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer>{


}
