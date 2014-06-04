package com.cbnl.dbabstractionlayer;

import java.sql.Timestamp;

public class AlarmObject {

	private int _alarm_id;
	private int _alr_severity;
	private String _alr_source;
	private Timestamp _alr_date;
	private String _alr_logmsg;

	public AlarmObject() {
		
	}

	public AlarmObject(int alarmid , int alr_severity ,String alr_source ,Timestamp alr_date , String alr_logmsg) {
		
		this._alarm_id = alarmid;
		this._alr_severity = alr_severity;
		this._alr_source = alr_source;
		this._alr_date = alr_date;
		this._alr_logmsg = alr_logmsg;
	}

	
	public int getAlarm_id() {
		return _alarm_id;
	}

	public void setAlarm_id(int alarm_id) {
		this._alarm_id = alarm_id;
	}

	public int getAlr_severity() {
		return _alr_severity;
	}

	public void setAlr_severity(int alr_severity) {
		this._alr_severity = alr_severity;
	}

	public String getAlr_source() {
		return _alr_source;
	}

	public void setAlr_source(String alr_source) {
		this._alr_source = alr_source;
	}

	public Timestamp getAlr_date() {
		return _alr_date;
	}

	public void setAlr_date(Timestamp alr_date) {
		this._alr_date = alr_date;
	}

	public String getAlr_logmsg() {
		return _alr_logmsg;
	}

	public void setAlr_logmsg(String alr_logmsg) {
		this._alr_logmsg = alr_logmsg;
	}

	public void display() {
		StringBuffer sb = new StringBuffer();
		sb.append("\nAlarm Id : ").append(_alarm_id);
		sb.append(" , Severity : ").append(_alr_severity);
		sb.append(" , Source : ").append(_alr_source);
		sb.append(" , Date : ").append(_alr_date);
		sb.append(" , Log Message : ").append(_alr_logmsg);
		System.out.println(sb.toString());
	}
	
	public AlarmObject getAlarmObject() {
		
		AlarmObject obj = new AlarmObject();
		obj.setAlarm_id(_alarm_id);
		obj.setAlr_date(_alr_date);
		obj.setAlr_logmsg(_alr_logmsg);
		obj.setAlr_severity(_alr_severity);
		obj.setAlr_source(_alr_source);
		return obj;
	}
}
