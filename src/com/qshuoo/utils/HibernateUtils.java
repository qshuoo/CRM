package com.qshuoo.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static  SessionFactory sf;
	static {
		Configuration configuration = new Configuration().configure();
		sf = configuration.buildSessionFactory();
	}
	
	public static Session openSession() {
		return sf.openSession();
	}
	
	public static Session getCurrentSession() {
		return sf.getCurrentSession();
	}

}
