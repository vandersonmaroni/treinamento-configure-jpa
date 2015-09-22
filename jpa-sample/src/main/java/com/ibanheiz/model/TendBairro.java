package com.ibanheiz.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tend_bairro database table.
 * 
 */
@Entity
@Table(name="tend_bairro")
@NamedQuery(name="TendBairro.findAll", query="SELECT t FROM TendBairro t")
public class TendBairro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_bairro", unique=true, nullable=false)
	private int idBairro;

	@Column(nullable=false, length=50)
	private String bairro;

	//bi-directional many-to-one association to TendCidade
	@ManyToOne
	@JoinColumn(name="id_cidade", nullable=false)
	private TendCidade tendCidade;

	//bi-directional many-to-one association to TendEndereco
	@OneToMany(mappedBy="tendBairro")
	private List<TendEndereco> tendEnderecos;

	public TendBairro() {
	}

	public int getIdBairro() {
		return this.idBairro;
	}

	public void setIdBairro(int idBairro) {
		this.idBairro = idBairro;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public TendCidade getTendCidade() {
		return this.tendCidade;
	}

	public void setTendCidade(TendCidade tendCidade) {
		this.tendCidade = tendCidade;
	}

	public List<TendEndereco> getTendEnderecos() {
		return this.tendEnderecos;
	}

	public void setTendEnderecos(List<TendEndereco> tendEnderecos) {
		this.tendEnderecos = tendEnderecos;
	}

	public TendEndereco addTendEndereco(TendEndereco tendEndereco) {
		getTendEnderecos().add(tendEndereco);
		tendEndereco.setTendBairro(this);

		return tendEndereco;
	}

	public TendEndereco removeTendEndereco(TendEndereco tendEndereco) {
		getTendEnderecos().remove(tendEndereco);
		tendEndereco.setTendBairro(null);

		return tendEndereco;
	}

}