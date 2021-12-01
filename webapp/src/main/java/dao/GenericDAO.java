package main.java.dao;

import java.util.List;

public interface GenericDAO<T> {
	public List<T> getAll();
	public void update(T t);


}
