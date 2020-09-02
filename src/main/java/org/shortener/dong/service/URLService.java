package org.shortener.dong.service;

import java.util.List;

public interface URLService<T> {
	public T find(Long id);
	public T update(T object);
	public List<T> findAll();
	public void delete(int id);
	public Long add(T object);
}
