package com.gslab.talent.service;

import java.util.Date;
import java.util.List;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gslab.talent.model.Vacancy;
import com.gslab.talent.repository.VacancyDetailRepo;

@Service
public class VacancyDetailServiceImpl implements VacancyDetailService {
	
	
	@Autowired
	VacancyDetailRepo vacancyDetailRepoObj;

	@Override
	public TreeMap<Integer, Integer> getAllVacancy() {
	List<Vacancy> listOfVacancy =	vacancyDetailRepoObj.findAll();
	
	TreeMap<Integer, Integer> vacancyDetail=new TreeMap<>();
	
	System.out.println(listOfVacancy.size());
		for(Vacancy vacancy : listOfVacancy) {
			Date posDate=vacancy.getPosOpenDate();
			//Calendar posOpeningDate=null;
			//posOpeningDate.setTime(posDate);
			//int date=posOpeningDate.DAY_OF_MONTH;
			Integer date1=posDate.getMonth();
			
	switch (date1) {
			case 1:
				if(vacancyDetail.get(1)!=null) {
				vacancyDetail.put(1,vacancyDetail.get(1)+1);
				}else {
					vacancyDetail.put(1, 1);
				}
				
				break;
			case 2:
				if(vacancyDetail.get(2)!=null) {
					vacancyDetail.put(2,vacancyDetail.get(2)+1);
					}else {
						vacancyDetail.put(2, 1);
					}
					
					break;
			case 3:
				if(vacancyDetail.get(3)!=null) {
					vacancyDetail.put(3,vacancyDetail.get(3)+1);
					}else {
						vacancyDetail.put(3, 1);
					}
				
				break;
			case 4:
				if(vacancyDetail.get(4)!=null) {
					vacancyDetail.put(4,vacancyDetail.get(4)+1);
					}else {
						vacancyDetail.put(4, 1);
					}
				
				break;
			case 5:
				if(vacancyDetail.get(5)!=null) {
					vacancyDetail.put(5,vacancyDetail.get(5)+1);
					}else {
						vacancyDetail.put(5, 1);
					}
				break;
			case 6:
				if(vacancyDetail.get(6)!=null) {
					vacancyDetail.put(6,vacancyDetail.get(6)+1);
					}else {
						vacancyDetail.put(6, 1);
					}
				break;
			case 7:
				if(vacancyDetail.get(7)!=null) {
					vacancyDetail.put(7,vacancyDetail.get(7)+1);
					}else {
						vacancyDetail.put(7, 1);
					}
				break;
			case 8:
				if(vacancyDetail.get(8)!=null) {
					vacancyDetail.put(8,vacancyDetail.get(8)+1);
					}else {
						vacancyDetail.put(8, 1);
					}
				break;
			case 9:
				if(vacancyDetail.get(9)!=null) {
					vacancyDetail.put(9,vacancyDetail.get(9)+1);
					}else {
						vacancyDetail.put(9, 1);
					}
				
				break;
			case 10:
				if(vacancyDetail.get(10)!=null) {
					vacancyDetail.put(10,vacancyDetail.get(10)+1);
					}else {
						vacancyDetail.put(10, 1);
					}
				
				break;
			case 11:
				if(vacancyDetail.get(11)!=null) {
					vacancyDetail.put(11,vacancyDetail.get(11)+1);
					}else {
						vacancyDetail.put(11, 1);
					}
				
				break;
			case 12:
				if(vacancyDetail.get(12)!=null) {
					vacancyDetail.put(12,vacancyDetail.get(12)+1);
					}else {
						vacancyDetail.put(12, 1);
					}
				
				break;
		
			default:
				break;
			}
		}	 
		return vacancyDetail;
	}

	@Override
	public TreeMap<Integer, Integer> getTotalApplicationInMonth() {
		TreeMap<Integer,Integer> monthApplication =new TreeMap<>();
		monthApplication.put(1, 200);
		monthApplication.put(2, 300);
		monthApplication.put(3, 150);
		monthApplication.put(4, 175);
		monthApplication.put(5, 225);
		monthApplication.put(6, 250);
		monthApplication.put(7, 300);
		monthApplication.put(8, 200);
		monthApplication.put(9, 350);
		monthApplication.put(10, 290);
		monthApplication.put(11, 190);
		monthApplication.put(12, 350);
		
		return monthApplication;
	}

	@Override
	public TreeMap<Integer, Integer> getAllSelected() {
		TreeMap<Integer,Integer> monthSelected =new TreeMap<>();
		monthSelected.put(1, 30);
		monthSelected.put(2, 40);
		monthSelected.put(3, 50);
		monthSelected.put(4, 25);
		monthSelected.put(5, 31);
		monthSelected.put(6, 10);
		monthSelected.put(7, 15);
		monthSelected.put(8, 35);
		monthSelected.put(9, 40);
		monthSelected.put(10, 20);
		monthSelected.put(11, 22);
		monthSelected.put(12, 33);
		
		
		return monthSelected;
	}

	@Override
	public TreeMap<Integer, Integer> getAllRejected() {
		TreeMap<Integer,Integer> monthRejected =new TreeMap<>();
        monthRejected.put(1, 170);
        monthRejected.put(2, 260);
        monthRejected.put(3, 100);
        monthRejected.put(4, 150);
        monthRejected.put(5, 194);
        monthRejected.put(6, 240);
        monthRejected.put(7, 285);
        monthRejected.put(8, 165);
        monthRejected.put(9, 310);
        monthRejected.put(10, 270);
        monthRejected.put(11, 168);
        monthRejected.put(12, 317);
		return monthRejected;
	}

}
