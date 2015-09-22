package com.ibanheiz.model;

import java.io.Serializable;

import javax.persistence.*;

import com.ibanheiz.tenduf.model.TendUf;

import java.util.List;

/**
 * The persistent class for the tend_cidade database table.
 * 
 */
@Entity
@Table(name = "tend_cidade")
@NamedQuery(name = "TendCidade.findAll", query = "SELECT t FROM TendCidade t")
public class TendCidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_cidade", unique = true, nullable = false)
	private int idCidade;

	@Column(name = "aliquota_iss", nullable = false)
	private double aliquotaIss;

	@Column(nullable = false, length = 100)
	private String cidade;

	@Column(name = "codigo_ibge", nullable = false)
	private int codigoIbge;

	@Column(name = "somente_nfs", nullable = false)
	private byte somenteNfs;

	// bi-directional many-to-one association to TendBairro
	@OneToMany(mappedBy = "tendCidade")
	private List<TendBairro> tendBairros;

	// bi-directional many-to-one association to TendRegiao
	@ManyToOne
	@JoinColumn(name = "id_regiao", nullable = false)
	private TendRegiao tendRegiao;

	// bi-directional many-to-one association to TendUf
	@ManyToOne
	@JoinColumn(name = "uf")
	private TendUf tendUf;

	// bi-directional many-to-one association to TendEndereco
	@OneToMany(mappedBy = "tendCidade")
	private List<TendEndereco> tendEnderecos;

	public TendCidade() {
	}

	public int getIdCidade() {
		return this.idCidade;
	}

	public void setIdCidade(int idCidade) {
		this.idCidade = idCidade;
	}

	public double getAliquotaIss() {
		return this.aliquotaIss;
	}

	public void setAliquotaIss(double aliquotaIss) {
		this.aliquotaIss = aliquotaIss;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public int getCodigoIbge() {
		return this.codigoIbge;
	}

	public void setCodigoIbge(int codigoIbge) {
		this.codigoIbge = codigoIbge;
	}

	public byte getSomenteNfs() {
		return this.somenteNfs;
	}

	public void setSomenteNfs(byte somenteNfs) {
		this.somenteNfs = somenteNfs;
	}

	public List<TendBairro> getTendBairros() {
		return this.tendBairros;
	}

	public void setTendBairros(List<TendBairro> tendBairros) {
		this.tendBairros = tendBairros;
	}

	public TendBairro addTendBairro(TendBairro tendBairro) {
		getTendBairros().add(tendBairro);
		tendBairro.setTendCidade(this);

		return tendBairro;
	}

	public TendBairro removeTendBairro(TendBairro tendBairro) {
		getTendBairros().remove(tendBairro);
		tendBairro.setTendCidade(null);

		return tendBairro;
	}

	public TendRegiao getTendRegiao() {
		return this.tendRegiao;
	}

	public void setTendRegiao(TendRegiao tendRegiao) {
		this.tendRegiao = tendRegiao;
	}

	public TendUf getTendUf() {
		return this.tendUf;
	}

	public void setTendUf(TendUf tendUf) {
		this.tendUf = tendUf;
	}

	public List<TendEndereco> getTendEnderecos() {
		return this.tendEnderecos;
	}

	public void setTendEnderecos(List<TendEndereco> tendEnderecos) {
		this.tendEnderecos = tendEnderecos;
	}

	public TendEndereco addTendEndereco(TendEndereco tendEndereco) {
		getTendEnderecos().add(tendEndereco);
		tendEndereco.setTendCidade(this);

		return tendEndereco;
	}

	public TendEndereco removeTendEndereco(TendEndereco tendEndereco) {
		getTendEnderecos().remove(tendEndereco);
		tendEndereco.setTendCidade(null);

		return tendEndereco;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCidade;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TendCidade other = (TendCidade) obj;
		if (idCidade != other.idCidade)
			return false;
		return true;
	}

}