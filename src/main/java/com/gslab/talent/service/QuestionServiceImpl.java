package com.gslab.talent.service;

import org.springframework.stereotype.Service;

import com.gslab.talent.model.Level;
import com.gslab.talent.model.Question;
import com.gslab.talent.repository.QuestionRepository;

@Service
public class QuestionServiceImpl implements QuestionService{

	QuestionRepository questionRepoObj;
	
	@Override
	public void createQuestion(Question question) {
			questionRepoObj.save(question);

		}
}
