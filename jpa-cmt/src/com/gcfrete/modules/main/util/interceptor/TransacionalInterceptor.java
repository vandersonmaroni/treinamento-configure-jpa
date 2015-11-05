package com.gcfrete.modules.main.util.interceptor;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

import com.gcfrete.modules.main.util.annotation.Transacional;
import com.gcfrete.modules.main.util.logger.GcLogger;

@Interceptor
@Transacional
public class TransacionalInterceptor {
	
	@Inject
	private EntityManager entityManager;
	
	@Inject
	private GcLogger logger;

	@AroundInvoke
	public Object intercept(InvocationContext ctx) {
		Object resultado = null;
		try {
			entityManager.getTransaction().begin();
			resultado = ctx.proceed();
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			logger.fatal("Erro no commit da transação", e);
		}
		
		return resultado;
	}
}
