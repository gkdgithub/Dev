package com.quinnox.springandhibernateintegration.AbstractDao;

import java.io.Serializable;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractDao<PK extends Serializable, T>{
	
	private final Class<T> persistentClass;
	
	public AbstractDao(Class<T> classz) {
		this.persistentClass=classz;
	}
	
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public T getByKey(PK key){
		return (T) getSession().get(persistentClass, key);
	}
	
	public void persist(T entity){
		getSession().saveOrUpdate(entity);
	}

	
	public void delete(T entity){
		getSession().delete(entity);
	}
	
	@SuppressWarnings("deprecation")
	protected Criteria createEntityCriteria(){
		return getSession().createCriteria(persistentClass);
	}
	
}
