package com.cbnl.util;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;


public class HibernateUtil extends HibernateTemplate {

	@Autowired(required = true)
	private SessionFactory sessionFactory;

	@Override
	public void afterPropertiesSet() {
		// System.out.println("Checking if properties set..."+this.sessionFactory);
		setSessionFactory(sessionFactory);
		super.afterPropertiesSet();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		super.setSessionFactory(sessionFactory);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;

	}

}
