package com.cbnl.dbabstractionlayer;

import java.util.ArrayList;

import org.hsqldb.rights.User;



public interface AlarmDao extends GenericDao<User>{
	
	//Showing all alarms : Default scenario
	public ArrayList showAllAlarm();
	
	//Source is nodelabel in node table
	public ArrayList filterBySource(String text);
	
	//search by logmsg
	public ArrayList filterByLogmsg(String text);
	
	//Searching by time duration given by user
	public ArrayList filterByDate(String startDate , String endDate);
	
	//Filter data by severity level
	public ArrayList filterBySeverity(int level);
	
	


}
