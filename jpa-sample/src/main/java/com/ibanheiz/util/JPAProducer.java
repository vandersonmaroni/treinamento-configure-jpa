package com.ibanheiz.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAProducer {
	
	@Produces
	@ApplicationScoped
	public EntityManagerFactory criarFactory() {
		return Persistence.createEntityManagerFactory("nicogostoso");
	}

	@Produces
	@RequestScoped
	public EntityManager criarEntityManager(EntityManagerFactory factory) {
		return factory.createEntityManager();
	}
	
	public void fecharEntityManager(@Disposes EntityManager entityManager) {
		entityManager.close();
	}
}
