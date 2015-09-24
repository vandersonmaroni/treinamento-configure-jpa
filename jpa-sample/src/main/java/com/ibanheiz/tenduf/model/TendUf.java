package com.ibanheiz.tenduf.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ibanheiz.model.TendAliquotaIcm;
import com.ibanheiz.model.TendCidade;
import com.ibanheiz.model.TendRegiao;

/**
 * The persistent class for the tend_uf database table.
 * 
 */
@Entity
@Table(name = "tend_uf")
@NamedQuery(name = "TendUf.findAll", query = "SELECT t FROM TendUf t")
public class TendUf implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique = true, nullable = false, length = 2)
	private String uf;

	@Column(name = "codigo_ibge", nullable = false)
	private int codigoIbge;

	@Column(nullable = false, length = 20)
	private String estado;

	// bi-directional many-to-one association to TendAliquotaIcm
	@OneToMany(mappedBy = "tendUf1")
	private List<TendAliquotaIcm> tendAliquotaIcms1;

	// bi-directional many-to-one association to TendAliquotaIcm
	@OneToMany(mappedBy = "tendUf2")
	private List<TendAliquotaIcm> tendAliquotaIcms2;

	// bi-directional many-to-one association to TendCidade
	@OneToMany(mappedBy = "tendUf", fetch=FetchType.LAZY)
	private List<TendCidade> tendCidades;

	// bi-directional many-to-one association to TendRegiao
	@OneToMany(mappedBy = "tendUf")
	private List<TendRegiao> tendRegiaos;
	
	public TendUf() {
	}

	public String getUf() {
		return this.uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public int getCodigoIbge() {
		return this.codigoIbge;
	}

	public void setCodigoIbge(int codigoIbge) {
		this.codigoIbge = codigoIbge;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<TendAliquotaIcm> getTendAliquotaIcms1() {
		return this.tendAliquotaIcms1;
	}

	public void setTendAliquotaIcms1(List<TendAliquotaIcm> tendAliquotaIcms1) {
		this.tendAliquotaIcms1 = tendAliquotaIcms1;
	}

	public TendAliquotaIcm addTendAliquotaIcms1(TendAliquotaIcm tendAliquotaIcms1) {
		getTendAliquotaIcms1().add(tendAliquotaIcms1);
		tendAliquotaIcms1.setTendUf1(this);

		return tendAliquotaIcms1;
	}

	public TendAliquotaIcm removeTendAliquotaIcms1(TendAliquotaIcm tendAliquotaIcms1) {
		getTendAliquotaIcms1().remove(tendAliquotaIcms1);
		tendAliquotaIcms1.setTendUf1(null);

		return tendAliquotaIcms1;
	}

	public List<TendAliquotaIcm> getTendAliquotaIcms2() {
		return this.tendAliquotaIcms2;
	}

	public void setTendAliquotaIcms2(List<TendAliquotaIcm> tendAliquotaIcms2) {
		this.tendAliquotaIcms2 = tendAliquotaIcms2;
	}

	public TendAliquotaIcm addTendAliquotaIcms2(TendAliquotaIcm tendAliquotaIcms2) {
		getTendAliquotaIcms2().add(tendAliquotaIcms2);
		tendAliquotaIcms2.setTendUf2(this);

		return tendAliquotaIcms2;
	}

	public TendAliquotaIcm removeTendAliquotaIcms2(TendAliquotaIcm tendAliquotaIcms2) {
		getTendAliquotaIcms2().remove(tendAliquotaIcms2);
		tendAliquotaIcms2.setTendUf2(null);

		return tendAliquotaIcms2;
	}

	public List<TendCidade> getTendCidades() {
//		if (tendCidades instanceof PersistentBag) {
//			TendCidadeService service = BeanInjector.getBean(TendCidadeService.class);
//			tendCidades = service.buscarCidadePorUf(this);
//		}
		return this.tendCidades;
	}

	public void setTendCidades(List<TendCidade> tendCidades) {
		this.tendCidades = tendCidades;
	}

	public TendCidade addTendCidade(TendCidade tendCidade) {
		getTendCidades().add(tendCidade);
		tendCidade.setTendUf(this);

		return tendCidade;
	}

	public TendCidade removeTendCidade(TendCidade tendCidade) {
		getTendCidades().remove(tendCidade);
		tendCidade.setTendUf(null);

		return tendCidade;
	}

	public List<TendRegiao> getTendRegiaos() {
		return this.tendRegiaos;
	}

	public void setTendRegiaos(List<TendRegiao> tendRegiaos) {
		this.tendRegiaos = tendRegiaos;
	}

	public TendRegiao addTendRegiao(TendRegiao tendRegiao) {
		getTendRegiaos().add(tendRegiao);
		tendRegiao.setTendUf(this);

		return tendRegiao;
	}

	public TendRegiao removeTendRegiao(TendRegiao tendRegiao) {
		getTendRegiaos().remove(tendRegiao);
		tendRegiao.setTendUf(null);

		return tendRegiao;
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
		result = prime * result + ((uf == null) ? 0 : uf.hashCode());
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
		TendUf other = (TendUf) obj;
		if (uf == null) {
			if (other.uf != null)
				return false;
		} else if (!uf.equals(other.uf))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "OI GOKU, EU SOU UMA UF NORMAL";
	}

}