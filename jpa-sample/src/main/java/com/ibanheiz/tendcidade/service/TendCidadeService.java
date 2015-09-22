package com.ibanheiz.tendcidade.service;

import java.io.Serializable;
import java.util.List;

import com.ibanheiz.model.TendCidade;
import com.ibanheiz.tendcidade.dao.TendCidadeDAO;
import com.ibanheiz.tenduf.model.TendUf;

public class TendCidadeService implements Serializable {
	private static final long serialVersionUID = 4923540752264331949L;

	private TendCidadeDAO tendCidadeDAO;
	
	public TendCidadeService() {
		tendCidadeDAO = new TendCidadeDAO();
	}
	
	public List<TendCidade> buscarCidadePorUf(TendUf uf) {
		return tendCidadeDAO.buscarCidadePorUf(uf);
	}

}
