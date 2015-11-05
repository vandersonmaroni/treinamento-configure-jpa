package com.gcfrete.modules.main.util.producer;

import java.lang.reflect.ParameterizedType;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.gcfrete.modules.main.dao.DAO;

public class DAOProducer {

	@Inject
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Produces
	public <T> DAO<T> create(InjectionPoint injectionPoint) {
		ParameterizedType type = (ParameterizedType) injectionPoint.getType();
		Class<T> classe = (Class<T>) type.getActualTypeArguments()[0];
		return new DAO<T>(classe, entityManager);
	}
}