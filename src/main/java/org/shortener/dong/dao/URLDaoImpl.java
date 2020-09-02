package org.shortener.dong.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.shortener.dong.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class URLDaoImpl implements Dao<Url> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public URLDaoImpl() {
		
	} 
	
	@Override
	public Url find(Object id) {
		return getSession().find(Url.class, id);
	}

	@Override
	public Url update(Url object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Url> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable add(Url object) {
		return getSession().save(object);
		
	}
	
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	public Session getSession() {
		return sessionFactory.openSession();
	}
}
