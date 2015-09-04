package model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ocorrencia_nota_fiscal")
public class OcorrenciaNotaFiscal {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_ocorrencia")
	private int idOcorrencia;

	private String descricao;

	/**
	 * @return the idOcorrencia
	 */
	public int getIdOcorrencia() {
		return idOcorrencia;
	}

	/**
	 * @param idOcorrencia the idOcorrencia to set
	 */
	public void setIdOcorrencia(int idOcorrencia) {
		this.idOcorrencia = idOcorrencia;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		result = prime * result + idOcorrencia;
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
		OcorrenciaNotaFiscal other = (OcorrenciaNotaFiscal) obj;
		if (idOcorrencia != other.idOcorrencia)
			return false;
		return true;
	}

}
