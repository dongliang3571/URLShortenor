package org.shortener.dong.dao;

import java.io.Serializable;
import java.util.List;

public interface Dao<T> {
	public T find(Object id);
	public T update(T object);
	public List<T> findAll();
	public void delete(int id);
	public Serializable add(T object);
}
