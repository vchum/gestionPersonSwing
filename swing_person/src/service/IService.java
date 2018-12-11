package service;

import java.util.List;

import Persistence.exception.DaoException;

public interface IService <T> {
	
	public abstract List<T> list() throws DaoException;
	
	public void add(T pdto) throws DaoException;
	
	public void update(T pdto) throws DaoException;
	
	
	public T getById(String id) throws NumberFormatException, DaoException;
	
	public void delete(String id) throws Exception;

}
