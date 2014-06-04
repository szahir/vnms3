/**
 * Title:       VNMS2LoggerInstance
 * Description: This class is written for logback logger.
 * 				Using Logback Logger we can set the logging level at run time.
 *
 * @author      Nancy Chauhan 
 */

package com.cbnl.log;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;


public class VNMS2LoggerInstance {

	public void setDebugLevel(Logger logInstance, String logginglevel) {
//		Logger root = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
		logInstance.setLevel(Level.toLevel(logginglevel));
	}
	
	public static Logger getLoggerInstance(String loggerName){
		Logger logInstance = (Logger) LoggerFactory.getLogger(loggerName);
		
		return logInstance;
		
	}
}
