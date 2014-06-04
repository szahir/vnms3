package com.cbnl.dbabstractionlayer;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class AlarmCollection {
	@Autowired
	@Qualifier("daoimpl")
	AlarmDaoImpl dao_obj;
	
	
	public ArrayList getfilterBySeverity(int level) {
		
		ArrayList arr_col = dao_obj.filterBySeverity(level);
		return arr_col ;
	}
	
	public ArrayList filterByDate(String startDate , String endDate) {
	
		ArrayList arr_col = dao_obj.filterByDate(startDate , endDate);
		return arr_col ;
	
	}
	
	public ArrayList filterByLogmsg(String text) {
		
		ArrayList arr_col = dao_obj.filterByLogmsg(text);
		return arr_col ;
		
	}
	
	
	public ArrayList filterBySource(String text) {
		
		ArrayList arr_col = dao_obj.filterBySource(text);
		return arr_col ;
	}
	
	
	public ArrayList getAllAlarm(){
		
		ArrayList arr_col = dao_obj.showAllAlarm();
		return arr_col ;
		
	}
	
}
