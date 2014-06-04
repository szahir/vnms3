package com.cbnl.dbabstractionlayer;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hsqldb.rights.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cbnl.util.HibernateUtil;




public class AlarmDaoImpl extends GenericDaoImpl<User> implements AlarmDao {
	
	@Autowired
	HibernateUtil hiberUtil;

	@Override
	public ArrayList showAllAlarm() {

		Session session = hiberUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		final Query query = session.getNamedQuery("showAllAlarms");
		List list = query.list();
		
		Iterator itr = list.iterator();

		while (itr.hasNext()) {
			AlarmObject alarmDetailObj = (AlarmObject) itr.next();
			alarmDetailObj.display();
		}
			
		return (ArrayList) list;
	}

	@Override
	public ArrayList filterBySource(String text) {
		
		Session session = hiberUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		final Query query = session.getNamedQuery("findbysource").setString("nodelabel", "%" + text + "%");
		List list = query.list();
		
		Iterator itr = list.iterator();
	
			while (itr.hasNext()) {
				AlarmObject alarmDetailObj = (AlarmObject) itr.next();
				alarmDetailObj.display();
		}
	
		return (ArrayList) list;
		
	}

	@Override
	public ArrayList filterByLogmsg(String text) {
		
		Session session = hiberUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		final Query query = session.getNamedQuery("findbylogmsg").setString("logmsg", "%" + text + "%");
		List list = query.list();
		
		Iterator itr = list.iterator();
	
			while (itr.hasNext()) {
				AlarmObject alarmDetailObj = (AlarmObject) itr.next();
				alarmDetailObj.display();
				// System.out.println(alarmDetailObj);
			}
		
		return (ArrayList) list;
	}


	@Override
	public ArrayList filterByDate(String startDate , String endDate) {

			java.util.Date start_date = null;
			java.util.Date end_date = null;
			Timestamp start_date_ts = null;
			Timestamp end_date_ts = null;
			try {
				start_date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(startDate);
				start_date_ts = new Timestamp(start_date.getTime());
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			
			try {
				end_date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(endDate);
				end_date_ts = new Timestamp(end_date.getTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
		
		Session session = hiberUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		final Query query = session.getNamedQuery("findbydate").setTimestamp("starttime",start_date_ts ).setTimestamp("lasttime", end_date_ts);
		
		List list = query.list();
		
		Iterator itr = list.iterator();
	
			while (itr.hasNext()) {
				AlarmObject alarmDetailObj = (AlarmObject) itr.next();
				alarmDetailObj.display();
				// System.out.println(alarmDetailObj);
		}

		return (ArrayList) list;
		
	}

	@Override
	public ArrayList filterBySeverity(int level) {
		
		Session session = hiberUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		final Query query = session.getNamedQuery("findbyseverity").setInteger("severity", level);
		
		List list = query.list();
		
		/*Iterator itr = list.iterator();
	
			while (itr.hasNext()) {
				AlarmObject alarmDetailObj = (AlarmObject) itr.next();
				alarmDetailObj.display();
				// System.out.println(alarmDetailObj);
	    }*/
				
		return (ArrayList) list;
		
	}

	@Override
	public User create(User t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User find(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User update(User t) {
		// TODO Auto-generated method stub
		return null;
	}

}
