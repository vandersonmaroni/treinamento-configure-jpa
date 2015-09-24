package com.ibanheiz.tendcidade.dao;

import java.util.List;

import javax.persistence.Query;

import com.ibanheiz.main.dao.DAO;
import com.ibanheiz.model.TendCidade;
import com.ibanheiz.tenduf.model.TendUf;

public class TendCidadeDAO extends DAO<TendCidade> {
	private static final long serialVersionUID = 9076920338132966993L;

	@SuppressWarnings("unchecked")
	public List<TendCidade> buscarCidadePorUf(TendUf uf) {
		Query query = entityManager.createQuery("SELECT cidades FROM TendCidade cidades WHERE cidades.tendUf = :uf");
		query.setParameter("uf", uf);
		return query.getResultList();
	}
}
