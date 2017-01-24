package com.gk.study.java.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateHelper {
	
	private static final ThreadLocal<Session> session = new ThreadLocal<>();
	private static final ThreadLocal<Transaction> transaction = new ThreadLocal<>();
	private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	private HibernateHelper(){
	}
	
	public static Session getSession(){
		Session session = HibernateHelper.session.get();
		if(session==null){
			session = sessionFactory.openSession();
			HibernateHelper.session.set(session);
		}
		return session;
	}
	
	

}
