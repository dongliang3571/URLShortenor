package org.shortener.dong.service;

import java.util.List;
import org.shortener.dong.model.*;
import org.shortener.dong.dao.*;

public class URLService implements Service<Url> {

	private Dao<Url> dao;
	
	public URLService(Dao<Url> dao) {
		setDao(dao);
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
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Url add(Url object) {
		return dao.add(object);
		
	}

	public Dao<Url> getDao() {
		return dao;
	}
	
	public void setDao(Dao<Url> dao) {
		this.dao = dao;
	}
	
}
