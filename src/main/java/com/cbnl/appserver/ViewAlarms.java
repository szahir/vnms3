package com.cbnl.appserver;

import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ch.qos.logback.classic.Logger;

import com.cbnl.dbabstractionlayer.AlarmCollection;
import com.cbnl.dbabstractionlayer.AlarmObject;
import com.cbnl.log.VNMS2LoggerInstance;
import com.cbnl.util.HibernateUtil;
import com.cbnl.util.VNMS2LoggerUtils;

/**
 * @author gur32782
 *
 */
@Controller
@RequestMapping("/")

public class ViewAlarms {
	static private Logger appServerLogger = VNMS2LoggerInstance.getLoggerInstance("appserver_logger");
	@RequestMapping(value="/viewalarms", method = RequestMethod.GET)
	public String welcome(ModelMap model) {
 
		model.addAttribute("message", "View Alarms - welcome()");
		VNMS2LoggerUtils.debug(appServerLogger, (String)model.get("message"));
		System.out.println("model attr = "+model.get("message"));
		//Spring uses InternalResourceViewResolver and return back index.jsp
		return "ViewAlarmsDB";
 
	}
 
	@RequestMapping(value="/viewalarms/{name}", method = RequestMethod.GET)
	public String welcomeName(@PathVariable String name, ModelMap model) {
 
		model.addAttribute("message", "View Alarms - " + name);
		VNMS2LoggerUtils.debug(appServerLogger, (String)model.get("message"));
		return "index";
 
	}
	
	@RequestMapping(value="/alarms", method = RequestMethod.GET)
	@ResponseBody
	public void getAlarms(ModelMap model,HttpServletRequest request,HttpServletResponse response) {
		PrintWriter out = null;
		try{
			out=response.getWriter();}
		catch(Exception e){}
		System.out.println("I am in Database part");
		model.addAttribute("message", "View Alarms - ");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("DbBean.xml");
		AlarmCollection AlrObj = applicationContext.getBean(AlarmCollection.class);
		ArrayList list = AlrObj.getAllAlarm();
		Iterator itr = list.iterator();
		int AlarmId = 0;
		int Severity = 0;
		String Source = null;
		Timestamp Dateee;
		String Message = null;
		String tosend="";
		JSONObject json = new JSONObject();
		while (itr.hasNext()) {
			AlarmObject alarmDetailObj = (AlarmObject) itr.next();
			AlarmId=alarmDetailObj.getAlarm_id();
			Severity=alarmDetailObj.getAlr_severity();
			Source =alarmDetailObj.getAlr_source();
			Dateee=alarmDetailObj.getAlr_date();
			Message=alarmDetailObj.getAlr_logmsg();
			
			tosend=tosend+"~"+AlarmId+"~"+Severity+"~"+Source+"~"+Dateee+"~"+Message;
//			alarmDetailObj.display();
		}
		try{
			System.out.println(tosend);
			json.put("longkey",tosend);
			out.print(json);
			
		}catch(Exception e){
			
		}
		
		
		//VNMS2LoggerUtils.debug(appServerLogger, (String)model.get("message"));
		
 
	}
	
	
}
