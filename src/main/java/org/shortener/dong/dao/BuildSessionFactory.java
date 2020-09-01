package org.shortener.dong.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BuildSessionFactory {
	public static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
}
