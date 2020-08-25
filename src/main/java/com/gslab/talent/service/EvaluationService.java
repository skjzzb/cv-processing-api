package com.gslab.talent.service;

import java.util.List;

import com.gslab.talent.model.Evaluation;

public interface EvaluationService {

	void createNewEvaluation(Evaluation evaluation);
	List<Evaluation> getEvaluationReport(int id);

}
