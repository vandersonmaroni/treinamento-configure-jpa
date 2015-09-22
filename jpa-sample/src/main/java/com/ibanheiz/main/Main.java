package com.ibanheiz.main;

import java.util.List;

import com.ibanheiz.model.TendCidade;
import com.ibanheiz.tenduf.model.TendUf;
import com.ibanheiz.tenduf.service.TendUfService;


public class Main {

	public static void main(String[] args) {
		TendUfService service = new TendUfService();
		
		TendUf uf = new TendUf();
		uf.setUf("WQ");
		uf.setCodigoIbge(45345);
		uf.setEstado("Cuzinho do marcos");
		
		service.save(uf);
		
		TendCidade cidade = new TendCidade();
		cidade.setIdCidade(500);
		
		TendUf ufEncontrada = service.buscarTendUfPorCidade(cidade);
		System.out.println(ufEncontrada.getUf());
		
		List<TendCidade> cidades = ufEncontrada.getTendCidades();
		for (TendCidade tendCidade : cidades) {
			System.out.println(tendCidade.getCidade());
		}
	}
}
