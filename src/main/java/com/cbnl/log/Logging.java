/**
 * Title:       Logger
 * Description: This is Logger used for logging task.
 * 				The Logging class is an aspect defined and the constructor is kept private 
 * 				as not to allow the instantiation of this class.This can be done only using
 * 				bean of logger class created in loggingContext.xml
 *
 * @author  Nancy Chauhan 
 */

package com.cbnl.log;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;


@Aspect
public class Logging {

	private static final String LOGGER_KEY = "serone_log_key";
	private static final String CONFIG_PROP_PATH = "src/com/cbnl/log/serviceone/config.properties";

	private String flag = "true";

	Properties prop = new Properties();
	FileOutputStream fos = null;

	/*
	 * Making constructor private to ensure that , the class can not be
	 * instantiated.Intantiated only through bean creation.
	 */
	private Logging() {

	}

	@Pointcut("execution(* com.cbnl.test.*.*(..)) && " + "args(packageInfo,..)")
	private void selectAll(String packageInfo) {
	}

	@Before("selectAll(packageInfo)")
	public void beforeAdvice(String packageInfo) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("loggingContext.xml");
		Logging loggingObject = applicationContext.getBean(Logging.class);
		if (loggingObject.getLogFlag().equals(flag)) {
			final Logger logger = loggingObject.getLogger();
			logger.info("{} Logging service one Before Method execution" , packageInfo);
		}
	}

	@After("selectAll(packageInfo)")
	public void afterAdvice(String packageInfo) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("loggingContext.xml");
		Logging loggingObject = applicationContext.getBean(Logging.class);
		if (loggingObject.getLogFlag().equals(flag)) {
			final Logger logger = loggingObject.getLogger();
			logger.info("{} Logging service one After Method execution", packageInfo);
		}
	}

	@AfterReturning(pointcut = "selectAll(packageInfo)", returning = "retVal")
	public void afterReturningAdvice(Object retVal , String packageInfo) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("loggingContext.xml");
		Logging loggingObject = applicationContext.getBean(Logging.class);
		if (loggingObject.getLogFlag().equals(flag)) {
			final Logger logger = loggingObject.getLogger();
			logger.info("{} Logging service one Returning from {}", packageInfo , retVal);

		}
	}
	
	 @AfterThrowing(pointcut = "selectAll(packageInfo)", throwing = "ex")
	   public void AfterThrowingAdvice(IllegalArgumentException ex , String packageInfo){
		 ApplicationContext applicationContext = new ClassPathXmlApplicationContext("loggingContext.xml");
			Logging loggingObject = applicationContext.getBean(Logging.class);
			if (loggingObject.getLogFlag().equals(flag)) {
				final Logger logger = loggingObject.getLogger();
				logger.info("Exception Occurs {} : {} " , packageInfo , ex );

			}
	   }

	// Return the SLF4J logger
	public Logger getLogger() {
		final Logger slf4jLogger = LoggerFactory.getLogger(Logger.class);
		return slf4jLogger;
	}

	// This Flag is get regarding the task of starting or stopping the logging
	// for any service
	public String getLogFlag() {
		try {
			FileInputStream fis = new FileInputStream(CONFIG_PROP_PATH);
			prop.load(fis);
			this.flag = prop.getProperty(LOGGER_KEY);
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return flag;
	}

	// This Flag is set to start or stop the logging for any service
	public void setLogFlag(String value) {

		try {

			fos = new FileOutputStream(CONFIG_PROP_PATH);
			FileInputStream fis = new FileInputStream(CONFIG_PROP_PATH);
			prop.load(fis);
			prop.setProperty(LOGGER_KEY, value);
			prop.store(fos, "Logger Key Setting");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	// Setting the application/service name
	public void setAppName(String appName) {

		LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
		JoranConfigurator jc = new JoranConfigurator();
		jc.setContext(context);

		// override default configuration
		context.reset();

		// inject the name of the current application as "application-name"
		// property of the LoggerContext
		context.putProperty("application-name", appName);
		try {
			jc.doConfigure("src/logback.xml");
		} catch (JoranException e) {
			e.printStackTrace();
		}

	}

}
