package com.cbnl.dbabstractionlayer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String args[]) {
				
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("DbBean.xml");
		AlarmCollection AlrObj = applicationContext.getBean(AlarmCollection.class);
		
		//AlrObj.showAllAlarm();  
		//AlrObj.filterBySource("VNMS");
        //AlrObj.filterByLogmsg("down");
		//AlrObj.filterByService("Access Point");
		//AlrObj.filterByDate("2014-05-27 10:30:54", "2014-05-27 17:30:54");
		//AlrObj.filterBySeverity(7);
		
		
		//collection calling
		AlrObj.getAllAlarm();
		//AlrObj.getfilterBySeverity(3);
		//AlrObj.filterByDate("2014-05-27 10:30:54", "2014-05-27 17:30:54");
		//AlrObj.filterBySource("R");
		//AlrObj.filterByLogmsg("down");
	
	}
}

