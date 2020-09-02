package org.shortener.dong.service;

import java.util.List;
import org.shortener.dong.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.shortener.dong.dao.*;

@Service
public class URLServiceImpl implements URLService<Url> {

	@Autowired
	private Dao<Url> dao;
	
	public URLServiceImpl(Dao<Url> dao) {
		setDao(dao);
	}
	
	@Override
	public Url find(Long id) {
		return dao.find(id);
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
	public Long add(Url object) {
		return (Long)dao.add(object);
		
	}

	public Dao<Url> getDao() {
		return dao;
	}
	
	public void setDao(Dao<Url> dao) {
		this.dao = dao;
	}
	
}
