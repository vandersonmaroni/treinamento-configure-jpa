package com.ibanheiz.tenduf.service;

import java.io.Serializable;

import com.ibanheiz.model.TendCidade;
import com.ibanheiz.tenduf.dao.TendUfDAO;
import com.ibanheiz.tenduf.model.TendUf;

public class TendUfService implements Serializable {
	private static final long serialVersionUID = -2445642361095220408L;

	private TendUfDAO tendUfDAO;
	
	public TendUfService() {
		tendUfDAO = new TendUfDAO();
	}
	
	public void save(TendUf uf) {
		tendUfDAO.save(uf);
	}

	public TendUf buscarTendUfPorCidade(TendCidade cidade) {
		return tendUfDAO.buscarTendUfPorCidade(cidade);
	}
}
