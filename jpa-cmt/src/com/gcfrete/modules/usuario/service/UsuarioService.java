package com.gcfrete.modules.usuario.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.gcfrete.modules.usuario.dao.UsuarioDAO;
import com.gcfrete.modules.usuario.model.Usuario;

/**
 * @author Marcos Toledo | 06/11/2015
 */
public class UsuarioService implements Serializable {
	private static final long serialVersionUID = 6603491537087239173L;
	
	@Inject
	private UsuarioDAO usuarioDAO;

	public void cadastrar(Usuario usuario) {
		usuarioDAO.save(usuario);
	}
	
	public Usuario buscarUsuarioPorLoginSenha(String login, String senha) {
		return usuarioDAO.buscarUsuarioPorLoginSenha(login, senha);
	}
}
