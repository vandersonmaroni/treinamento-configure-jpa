package com.ibanheiz.model;

import java.io.Serializable;

import javax.persistence.*;

import com.ibanheiz.tenduf.model.TendUf;

import java.util.List;


/**
 * The persistent class for the tend_regiao database table.
 * 
 */
@Entity
@Table(name="tend_regiao")
@NamedQuery(name="TendRegiao.findAll", query="SELECT t FROM TendRegiao t")
public class TendRegiao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_regiao", unique=true, nullable=false)
	private int idRegiao;

	@Column(nullable=false, length=50)
	private String regiao;

	//bi-directional many-to-one association to TendCidade
	@OneToMany(mappedBy="tendRegiao")
	private List<TendCidade> tendCidades;

	//bi-directional many-to-one association to TendUf
	@ManyToOne
	@JoinColumn(name="uf", nullable=false)
	private TendUf tendUf;

	public TendRegiao() {
	}

	public int getIdRegiao() {
		return this.idRegiao;
	}

	public void setIdRegiao(int idRegiao) {
		this.idRegiao = idRegiao;
	}

	public String getRegiao() {
		return this.regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

	public List<TendCidade> getTendCidades() {
		return this.tendCidades;
	}

	public void setTendCidades(List<TendCidade> tendCidades) {
		this.tendCidades = tendCidades;
	}

	public TendCidade addTendCidade(TendCidade tendCidade) {
		getTendCidades().add(tendCidade);
		tendCidade.setTendRegiao(this);

		return tendCidade;
	}

	public TendCidade removeTendCidade(TendCidade tendCidade) {
		getTendCidades().remove(tendCidade);
		tendCidade.setTendRegiao(null);

		return tendCidade;
	}

	public TendUf getTendUf() {
		return this.tendUf;
	}

	public void setTendUf(TendUf tendUf) {
		this.tendUf = tendUf;
	}

}