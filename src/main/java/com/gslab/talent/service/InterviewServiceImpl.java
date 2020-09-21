package com.gslab.talent.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.api.client.util.DateTime;
import com.gslab.talent.model.Candidate;
import com.gslab.talent.model.Interview;
import com.gslab.talent.model.Level;
import com.gslab.talent.model.Vacancy;
import com.gslab.talent.repository.CandidateRepository;
import com.gslab.talent.repository.InterviewRepository;
import com.gslab.talent.repository.VacancyRepository;

@Service
public class InterviewServiceImpl implements InterviewService{

	@Autowired
	InterviewRepository interviewRepoObj;
	
	@Autowired
	CandidateRepository candidateRepoObj;
	
	@Autowired
	VacancyRepository vacancyRepoObj;
	
	@Autowired
	CandidateServiceImpl candidateServiceObj;
	
	@Autowired
	VacancyServiceImpl vacancyServiceObj;
	
	@Override
	public List getTodaysInterview() {
		ArrayList<String> list = new ArrayList<String>();
		LocalDateTime now = LocalDateTime.now();
		String today = now.toString().substring(0,10);
		System.out.println("today is :"+today);
		
		
		List<Interview> interviewList = interviewRepoObj.findAll();
		for(Interview interview : interviewList){
			String date = interview.getScheduledOn();
			if(date.contains(today)) {
				Long id = interview.getCandidateId();
				System.out.println("candidate id  is :"+id);
				Optional<Candidate> candidate= candidateRepoObj.findById(id);
				list.add(candidate.get().getCandidateName());
				
			}
		}
		System.out.println("candidate list is "+list);
		return list;
		
	}


	@Override
	public String getInterviewStatus() {
		int rejected1=0,scheduled1=0,waiting1=0;
		
		List<Interview> interviewList = interviewRepoObj.findAll();
		for(Interview interview : interviewList){
			String interviewStatus = interview.getInterviewStatus();
			if(interviewStatus.equalsIgnoreCase("rejected")) {
				rejected1++;
			}
			else if(interviewStatus.equalsIgnoreCase("scheduled")) {
				scheduled1++;
			}
			else if(interviewStatus.equalsIgnoreCase("waiting")) {
				waiting1++;
			}
				
		}
		return "waiting : "+waiting1+" rejected : "+rejected1+" scheduled : "+scheduled1 ;
	}

	@Override
	public TreeMap<Integer, Integer> getRejectedMonthly() {
		List<Interview> listOfInterview = interviewRepoObj.findAll();
		TreeMap<Integer, Integer> applicationDetail = new TreeMap<>();
		applicationDetail.put(1, 0);
		applicationDetail.put(2, 0);
		applicationDetail.put(3, 0);
		applicationDetail.put(4, 0);
		applicationDetail.put(5, 0);
		applicationDetail.put(6, 0);
		applicationDetail.put(7, 0);
		applicationDetail.put(8, 0);
		applicationDetail.put(9, 0);
		applicationDetail.put(10, 0);
		applicationDetail.put(11, 0);
		applicationDetail.put(12, 0);

		for (Interview interview : listOfInterview) {
			//Long candidateId = candidate.getId();
			String interviewStatus = interview.getInterviewStatus();

			if (interviewStatus.equals("rejected")) {
				//Optional<Interview> interview = interviewRepoObj.findByCandidateId(candidateId);
				String date = interview.getScheduledOn();
				String rejectedDate = date.toString().substring(5, 7);
				int i = Integer.parseInt(rejectedDate);

				switch (i) {
				case 1:
					if (applicationDetail.get(1) != null) {
						applicationDetail.put(1, applicationDetail.get(1) + 1);
					} else {
						applicationDetail.put(1, 1);
					}

					break;
				case 2:
					if (applicationDetail.get(2) != null) {
						applicationDetail.put(2, applicationDetail.get(2) + 1);
					} else {
						applicationDetail.put(2, 1);
					}

					break;
				case 3:
					if (applicationDetail.get(3) != null) {
						applicationDetail.put(3, applicationDetail.get(3) + 1);
					} else {
						applicationDetail.put(3, 1);
					}

					break;
				case 4:
					if (applicationDetail.get(4) != null) {
						applicationDetail.put(4, applicationDetail.get(4) + 1);
					} else {
						applicationDetail.put(4, 1);
					}

					break;
				case 5:
					if (applicationDetail.get(5) != null) {
						applicationDetail.put(5, applicationDetail.get(5) + 1);
					} else {
						applicationDetail.put(5, 1);
					}

					break;
				case 6:
					if (applicationDetail.get(6) != null) {
						applicationDetail.put(6, applicationDetail.get(6) + 1);
					} else {
						applicationDetail.put(6, 1);
					}

					break;
				case 7:
					if (applicationDetail.get(7) != null) {
						applicationDetail.put(7, applicationDetail.get(7) + 1);
					} else {
						applicationDetail.put(7, 1);
					}

					break;
				case 8:
					if (applicationDetail.get(8) != null) {
						applicationDetail.put(8, applicationDetail.get(8) + 1);
					} else {
						applicationDetail.put(8, 1);
					}

					break;
				case 9:
					if (applicationDetail.get(9) != null) {
						applicationDetail.put(9, applicationDetail.get(9) + 1);
					} else {
						applicationDetail.put(9, 1);
					}

					break;
				case 10:
					if (applicationDetail.get(10) != null) {
						applicationDetail.put(10, applicationDetail.get(10) + 1);
					} else {
						applicationDetail.put(10, 1);
					}

					break;
				case 11:
					if (applicationDetail.get(11) != null) {
						applicationDetail.put(11, applicationDetail.get(11) + 1);
					} else {
						applicationDetail.put(11, 1);
					}

					break;
				case 12:
					if (applicationDetail.get(12) != null) {
						applicationDetail.put(12, applicationDetail.get(12) + 1);
					} else {
						applicationDetail.put(12, 1);
					}

					break;

				default:
					break;
				}
			}

		}
		return applicationDetail;
	}
	
	
	
	
	@Override
	 public TreeMap<String, TreeMap<String, Integer>> getCountOfInterviewLevelForProject() {
	/*	List<Interview> listOfInterview = interviewRepoObj.findAll();
		
		TreeMap<String, Integer> hashmap = new TreeMap<>();
		TreeMap<String, Integer> hashmap3 = new TreeMap<>();
		TreeMap<String, TreeMap<String, Integer>> hashmap1 = new TreeMap<>();
		
		for(Interview interview : listOfInterview) {
			int vacancyId = interview.getVacancyId();
			Vacancy vacancy = vacancyRepoObj.findById(vacancyId).orElse(null);
			String projectName = vacancy.getProjectName();
			String levelName = interview.getLevel();

			if(hashmap1.containsKey(projectName)) {
		
				if (hashmap3.containsKey(levelName)) {
					hashmap3.put(levelName, hashmap3.get(levelName) + 1);
					hashmap1.put(projectName, hashmap3);
				} 
				else {
					hashmap3.put(levelName, 1);
					hashmap3.putAll(hashmap);
					if(hashmap1.containsKey(projectName)) {
						hashmap1.put(projectName,hashmap3);
					}
				}
				}
			else {
				hashmap1.put(projectName, null);
				if (hashmap1.containsValue(levelName)) {
					hashmap.put(levelName, hashmap.get(levelName) + 1);
					hashmap1.replace(projectName, hashmap);
				} 
				else {
					hashmap.put(levelName, 1);
					hashmap1.put(projectName, hashmap);
				}
			}
			
		}*/
		
		return null;
		
	
}

	@Override
	public TreeMap<Integer, Integer> getTotalInterviewMonthly() {
		List<Interview> listOfInterview = interviewRepoObj.findAll();
		System.out.println("listOfInterview : "+listOfInterview);
		TreeMap<Integer, Integer> applicationDetail = new TreeMap<>();
		applicationDetail.put(1, 0);
		applicationDetail.put(2, 0);
		applicationDetail.put(3, 0);
		applicationDetail.put(4, 0);
		applicationDetail.put(5, 0);
		applicationDetail.put(6, 0);
		applicationDetail.put(7, 0);
		applicationDetail.put(8, 0);
		applicationDetail.put(9, 0);
		applicationDetail.put(10, 0);
		applicationDetail.put(11, 0);
		applicationDetail.put(12, 0);

		for (Interview interview : listOfInterview) {
				String date = interview.getScheduledOn();
				System.out.println("date : "+date);
				String rejectedDate = date.toString().substring(5, 7);
				int i = Integer.parseInt(rejectedDate);
				System.out.println("i : "+i);
				
				switch (i) {
				case 1:
					if (applicationDetail.get(1) != null) {
						applicationDetail.put(1, applicationDetail.get(1) + 1);
					} else {
						applicationDetail.put(1, 1);
					}

					break;
				case 2:
					if (applicationDetail.get(2) != null) {
						applicationDetail.put(2, applicationDetail.get(2) + 1);
					} else {
						applicationDetail.put(2, 1);
					}

					break;
				case 3:
					if (applicationDetail.get(3) != null) {
						applicationDetail.put(3, applicationDetail.get(3) + 1);
					} else {
						applicationDetail.put(3, 1);
					}

					break;
				case 4:
					if (applicationDetail.get(4) != null) {
						applicationDetail.put(4, applicationDetail.get(4) + 1);
					} else {
						applicationDetail.put(4, 1);
					}

					break;
				case 5:
					if (applicationDetail.get(5) != null) {
						applicationDetail.put(5, applicationDetail.get(5) + 1);
					} else {
						applicationDetail.put(5, 1);
					}

					break;
				case 6:
					if (applicationDetail.get(6) != null) {
						applicationDetail.put(6, applicationDetail.get(6) + 1);
					} else {
						applicationDetail.put(6, 1);
					}

					break;
				case 7:
					if (applicationDetail.get(7) != null) {
						applicationDetail.put(7, applicationDetail.get(7) + 1);
					} else {
						applicationDetail.put(7, 1);
					}

					break;
				case 8:
					if (applicationDetail.get(8) != null) {
						applicationDetail.put(8, applicationDetail.get(8) + 1);
					} else {
						applicationDetail.put(8, 1);
					}

					break;
				case 9:
					if (applicationDetail.get(9) != null) {
						applicationDetail.put(9, applicationDetail.get(9) + 1);
					} else {
						applicationDetail.put(9, 1);
					}

					break;
				case 10:
					if (applicationDetail.get(10) != null) {
						applicationDetail.put(10, applicationDetail.get(10) + 1);
					} else {
						applicationDetail.put(10, 1);
					}

					break;
				case 11:
					if (applicationDetail.get(11) != null) {
						applicationDetail.put(11, applicationDetail.get(11) + 1);
					} else {
						applicationDetail.put(11, 1);
					}

					break;
				case 12:
					if (applicationDetail.get(12) != null) {
						applicationDetail.put(12, applicationDetail.get(12) + 1);
					} else {
						applicationDetail.put(12, 1);
					}

					break;

				default:
					break;
				}
			}
		System.out.println("applicationDetail : "+applicationDetail);
		return applicationDetail;
	}



}
	
