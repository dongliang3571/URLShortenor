package org.shortener.dong.dao;

import java.util.List;

public interface Dao<T> {
	public T find(int id);
	public T update(T object);
	public List<T> findAll();
	public void delete(int id);
	public T add(T object);
}
