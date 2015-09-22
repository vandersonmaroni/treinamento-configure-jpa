package com.ibanheiz.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tend_endereco database table.
 * 
 */
@Entity
@Table(name="tend_endereco")
@NamedQuery(name="TendEndereco.findAll", query="SELECT t FROM TendEndereco t")
public class TendEndereco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false, length=10)
	private String cep;

	@Column(nullable=false, length=200)
	private String endereco;

	//bi-directional many-to-one association to TendCidade
	@ManyToOne
	@JoinColumn(name="id_cidade", nullable=false)
	private TendCidade tendCidade;

	//bi-directional many-to-one association to TendBairro
	@ManyToOne
	@JoinColumn(name="id_bairro", nullable=false)
	private TendBairro tendBairro;

	public TendEndereco() {
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public TendCidade getTendCidade() {
		return this.tendCidade;
	}

	public void setTendCidade(TendCidade tendCidade) {
		this.tendCidade = tendCidade;
	}

	public TendBairro getTendBairro() {
		return this.tendBairro;
	}

	public void setTendBairro(TendBairro tendBairro) {
		this.tendBairro = tendBairro;
	}

}