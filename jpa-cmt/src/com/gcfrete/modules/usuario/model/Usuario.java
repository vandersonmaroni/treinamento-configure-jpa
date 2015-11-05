package com.gcfrete.modules.usuario.model;

import java.io.Serializable;

import javax.persistence.*;

import com.gcfrete.modules.usuario.util.annotation.UsuarioQualifier;
import com.gcfrete.modules.usuario.util.annotation.UsuarioQualifier.TipoUsuario;

import java.sql.Timestamp;

/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table(name = "usuario")
@UsuarioQualifier(TipoUsuario.INSTANCE)
public class Usuario implements Serializable {
	private static final long serialVersionUID = -5806597989820006448L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "data_de_cadastro")
	private Timestamp dataDeCadastro;

	private String email;

	private String login;

	private String senha;

	private int status;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the dataDeCadastro
	 */
	public Timestamp getDataDeCadastro() {
		return dataDeCadastro;
	}

	/**
	 * @param dataDeCadastro the dataDeCadastro to set
	 */
	public void setDataDeCadastro(Timestamp dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
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
		result = prime * result + id;
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
		Usuario other = (Usuario) obj;
		if (id != other.id)
			return false;
		return true;
	}

}