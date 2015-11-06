package com.gcfrete.modules.main.util.producer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@ApplicationScoped
public class JPAProducer {
	
	@PersistenceUnit
	private EntityManagerFactory factory;
	
	@Produces
	@SessionScoped
	public EntityManager criarEntityManager() {
		return factory.createEntityManager();
	}
	
	public void fecharEntityManager(@Disposes EntityManager entityManager) {
		entityManager.close();
	}
}
