package org.shortener.dong.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.shortener.dong.model.*;
import org.springframework.stereotype.Service;

@Service
public class URLDaoImpl implements Dao<Url> {
	
	private Session session;
	
	
	public URLDaoImpl(Session session) {
		this.setFactory(session);
	}
	
	@Override
	public Url find(int id) {
		// TODO Auto-generated method stub
		return null;
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
	public Url add(Url object) {
		return (Url)getSession().save(object);
		
	}
	
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	public Session getSession() {
		return session;
	}

	public void setFactory(Session session) {
		this.session = session;
	}
}
