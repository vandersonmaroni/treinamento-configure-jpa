package com.ibanheiz.tenduf.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.ibanheiz.model.TendCidade;
import com.ibanheiz.tenduf.dao.TendUfDAO;
import com.ibanheiz.tenduf.model.TendUf;

public class TendUfService implements Serializable {
	private static final long serialVersionUID = -2445642361095220408L;

	@Inject
	private TendUfDAO tendUfDAO;
	
	public void save(TendUf uf) {
		tendUfDAO.save(uf);
	}

	public TendUf buscarTendUfPorCidade(TendCidade cidade) {
		return tendUfDAO.buscarTendUfPorCidade(cidade);
	}

	@SuppressWarnings("unchecked")
	public List<TendUf> buscarTodas() {
		return tendUfDAO.buscarTodos();
	}
}
