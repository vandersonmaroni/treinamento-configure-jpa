package com.ibanheiz.main;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Event;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.ibanheiz.model.TendCidade;
import com.ibanheiz.tenduf.model.TendUf;
import com.ibanheiz.tenduf.service.TendUfService;
import com.ibanheiz.util.PilantraOlhudu;
import com.ibanheiz.util.TipoUf;
import com.ibanheiz.util.TipoUf.TipoUfEnum;

@Named
@ViewScoped
public class MainBean implements Serializable {
	private static final long serialVersionUID = -5939057974744203012L;

	private String mensagem;
	
	@Inject
	@PilantraOlhudu
	private Event<String> evento;
	
	@Inject @TipoUf(TipoUfEnum.BAHEA)
	private TendUf uf;
	@Inject
	private TendCidade cidade;
	@Inject
	private TendUfService service;
	private List<TendUf> ufEncontrada;

	@PostConstruct
	public void init() {
		uf.setUf("WQ");
		uf.setCodigoIbge(45345);
		uf.setEstado("Cuzinho do marcos");
		cidade.setIdCidade(500);

		ufEncontrada = service.buscarTodas();
		for (TendUf tendUf : ufEncontrada) {
			System.out.println(tendUf.getUf());
		}
		
		buscarCidadesDaUf();
	}

	public void buscarCidadesDaUf() {
		for (TendUf tendUf : ufEncontrada) {
			List<TendCidade> cidades = tendUf.getTendCidades();
			for (TendCidade tendCidade : cidades) {
				System.out.println(tendCidade.getCidade());
			}
		}
		evento.fire("Eita porra tao buscando as ufs");
	}

	/**
	 * @return the mensagem
	 */
	public String getMensagem() {
		return mensagem;
	}

	/**
	 * @param mensagem the mensagem to set
	 */
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
