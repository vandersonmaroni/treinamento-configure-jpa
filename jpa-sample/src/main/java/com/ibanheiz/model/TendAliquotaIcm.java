package com.ibanheiz.model;

import java.io.Serializable;

import javax.persistence.*;

import com.ibanheiz.tenduf.model.TendUf;


/**
 * The persistent class for the tend_aliquota_icms database table.
 * 
 */
@Entity
@Table(name="tend_aliquota_icms")
@NamedQuery(name="TendAliquotaIcm.findAll", query="SELECT t FROM TendAliquotaIcm t")
public class TendAliquotaIcm implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TendAliquotaIcmPK id;

	@Column(name="aliquota_icms", nullable=false)
	private double aliquotaIcms;

	//bi-directional many-to-one association to TendUf
	@ManyToOne
	@JoinColumn(name="uf_origem", nullable=false, insertable=false, updatable=false)
	private TendUf tendUf1;

	//bi-directional many-to-one association to TendUf
	@ManyToOne
	@JoinColumn(name="uf_destino", nullable=false, insertable=false, updatable=false)
	private TendUf tendUf2;

	public TendAliquotaIcm() {
	}

	public TendAliquotaIcmPK getId() {
		return this.id;
	}

	public void setId(TendAliquotaIcmPK id) {
		this.id = id;
	}

	public double getAliquotaIcms() {
		return this.aliquotaIcms;
	}

	public void setAliquotaIcms(double aliquotaIcms) {
		this.aliquotaIcms = aliquotaIcms;
	}

	public TendUf getTendUf1() {
		return this.tendUf1;
	}

	public void setTendUf1(TendUf tendUf1) {
		this.tendUf1 = tendUf1;
	}

	public TendUf getTendUf2() {
		return this.tendUf2;
	}

	public void setTendUf2(TendUf tendUf2) {
		this.tendUf2 = tendUf2;
	}

}