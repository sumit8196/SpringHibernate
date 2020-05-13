package com.commons.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.org.entity.Student;

public class  SessionUtils {
	private static SessionFactory sessionFactory = null;
	private  SessionFactory factory = null;
	
	
	Session session = null;

	public static Session getSession() {
		if(sessionFactory==null) {
			SessionFactory factory = new Configuration()
					.configure("hibernate.cfg.xml")
					.buildSessionFactory();
			sessionFactory=factory;

		}
		return  sessionFactory.openSession();
	}
	public static  void closeSession(Session session,boolean isLocalSession) {
		if(isLocalSession) {
			session.close();
		}
	}
}
