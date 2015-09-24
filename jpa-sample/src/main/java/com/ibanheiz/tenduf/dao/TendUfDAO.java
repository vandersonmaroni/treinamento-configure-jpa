package com.ibanheiz.tenduf.dao;

import javax.persistence.Query;

import com.ibanheiz.main.dao.DAO;
import com.ibanheiz.model.TendCidade;
import com.ibanheiz.tenduf.model.TendUf;

public class TendUfDAO extends DAO<TendUf> {
	private static final long serialVersionUID = -6904110571603744941L;
	
	public TendUf buscarTendUfPorCidade(TendCidade cidade) {
		Query query = entityManager.createQuery("SELECT uf FROM TendUf uf JOIN uf.tendCidades cidades where :cidade in cidades");
		query.setParameter("cidade", cidade);
		TendUf uf = (TendUf) query.getSingleResult();
		return uf;
	}
}
