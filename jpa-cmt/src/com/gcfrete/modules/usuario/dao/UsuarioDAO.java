package com.gcfrete.modules.usuario.dao;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.gcfrete.modules.main.dao.DAO;
import com.gcfrete.modules.usuario.model.Usuario;
import com.gcfrete.modules.usuario.model.UsuarioNull;

@Stateless
public class UsuarioDAO extends DAO<Usuario> implements Serializable {
	private static final long serialVersionUID = 6781763194725497891L;
	
	public UsuarioDAO() {
		super(Usuario.class);
	}

	/**
	 * @author Marcos Toledo | 05/11/2015
	 * @param login
	 * @param senha
	 * @return Objeto Usuario encontrado por login e senha
	 */
	public Usuario buscarUsuarioPorLoginSenha(String login, String senha) {
		Usuario usuario = new Usuario();
		try {
			String jpql = "SELECT u FROM Usuario u WHERE u.login = :login AND u.senha = :senha";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("login", login);
			query.setParameter("senha", senha);
			usuario = (Usuario) query.getSingleResult();
		} catch (NoResultException e) {
			usuario = new UsuarioNull();
		} catch (Exception e) {
			logger.fatal("Erro ao buscar usuário por login e senha", e);
		}
		return usuario;
	}
}
