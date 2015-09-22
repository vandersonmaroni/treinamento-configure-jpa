package com.ibanheiz.main.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Geneŕicao
 * @author Nicolas Ibanheiz | 22/09/2015
 * @param <T>
 */
public class DAO<T> implements Serializable {
	private static final long serialVersionUID = 3042466744415667858L;
	
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("nicogostoso");
	protected EntityManager entityManager;
	
	/**
	 * @author Nicolas Ibanheiz | 22/09/2015
	 * @param objeto
	 */
	public void save(T objeto) {
		entityManager = criarEntityManager();
		entityManager.getTransaction().begin();
		try {
			entityManager.persist(objeto);
			entityManager.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		entityManager.close();
	}

	protected EntityManager criarEntityManager() {
		return entityManagerFactory.createEntityManager();
	}
}
