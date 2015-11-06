package com.gcfrete.modules.main.util.interceptor;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

import com.gcfrete.modules.main.util.annotation.Transacional;
import com.gcfrete.modules.main.util.logger.GcLogger;

/**
 * Interceptor transacional
 * @author Marcos Toledo | 06/11/2015
 */
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
			entityManager.joinTransaction();
			resultado = ctx.proceed();
		} catch (Exception e) {
			logger.fatal("Erro no commit da transação", e);
		}
		return resultado;
	}
}
