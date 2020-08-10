package com.gslab.talent.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gslab.talent.model.Question;

public interface QuestionService {

	void createQuestion(Question question);

	List<Question> getAllConceptByTechName(String technologyName);

	Question getQuestionById(Integer questionId);


	

}
