package com.gcfrete.modules.usuario.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.gcfrete.modules.usuario.dao.UsuarioDAO;
import com.gcfrete.modules.usuario.model.Usuario;

public class UsuarioService implements Serializable {
	private static final long serialVersionUID = 6603491537087239173L;
	
	@Inject
	private UsuarioDAO usuarioDAO;
	
	/**
	 * @author Marcos Toledo | 05/11/2015
	 * @param login
	 * @param senha
	 * @return Objeto Usuario encontrado por login e senha
	 */
	public Usuario buscarUsuarioPorLoginSenha(String login, String senha) {
		// TODO criptografar senha do usuário
		return usuarioDAO.buscarUsuarioPorLoginSenha(login, senha);
	}

	public void cadastrar(Usuario usuario) {
		usuarioDAO.save(usuario);
	}
}
