package com.gslab.talent.service;

import java.util.List;

import com.gslab.talent.model.EvaluationReport;

public interface EvaluationService {

	void createNewEvaluation(EvaluationReport evaluation);
	List<EvaluationReport> getEvaluationReport(int id);

}
