package com.bin.hibernate.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private HibernateUtils(){}
	
	private static HibernateUtils instance = new HibernateUtils() ;
	
	public static HibernateUtils getInstance(){
		return instance ;
	}
	
	private SessionFactory sessionFactory ;
	
	public SessionFactory getSessionFactory(){
		if (sessionFactory == null) {
			Configuration configuration = new Configuration().configure() ;
			StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build() ;
			sessionFactory = configuration.buildSessionFactory(serviceRegistry) ;
			
		}
		
		return sessionFactory ;
	}
	
	public Session getSession(){
		return instance.getSessionFactory().getCurrentSession() ;
	}

}
