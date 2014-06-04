package com.cbnl.dbabstractionlayer;

import java.util.List;

public interface GenericDao<T> {

	T create(T t);

	void delete(Object id);

	T find(Object id);

	T update(T t);

	T find(Integer id);

	void save(T obj);

	List<T> findAll();

}