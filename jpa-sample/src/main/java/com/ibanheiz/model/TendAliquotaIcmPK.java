package com.ibanheiz.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the tend_aliquota_icms database table.
 * 
 */
@Embeddable
public class TendAliquotaIcmPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="uf_origem", insertable=false, updatable=false, unique=true, nullable=false, length=2)
	private String ufOrigem;

	@Column(name="uf_destino", insertable=false, updatable=false, unique=true, nullable=false, length=2)
	private String ufDestino;

	public TendAliquotaIcmPK() {
	}
	public String getUfOrigem() {
		return this.ufOrigem;
	}
	public void setUfOrigem(String ufOrigem) {
		this.ufOrigem = ufOrigem;
	}
	public String getUfDestino() {
		return this.ufDestino;
	}
	public void setUfDestino(String ufDestino) {
		this.ufDestino = ufDestino;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TendAliquotaIcmPK)) {
			return false;
		}
		TendAliquotaIcmPK castOther = (TendAliquotaIcmPK)other;
		return 
			this.ufOrigem.equals(castOther.ufOrigem)
			&& this.ufDestino.equals(castOther.ufDestino);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.ufOrigem.hashCode();
		hash = hash * prime + this.ufDestino.hashCode();
		
		return hash;
	}
}