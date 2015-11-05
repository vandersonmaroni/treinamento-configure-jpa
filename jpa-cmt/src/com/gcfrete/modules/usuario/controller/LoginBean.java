package com.gcfrete.modules.usuario.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.gcfrete.modules.usuario.model.Usuario;
import com.gcfrete.modules.usuario.service.UsuarioService;
import com.gcfrete.modules.usuario.util.annotation.UsuarioQualifier;
import com.gcfrete.modules.usuario.util.annotation.UsuarioQualifier.TipoUsuario;

@Named
@ViewScoped
public class LoginBean implements Serializable {
	private static final long serialVersionUID = -2617532768834344956L;

	@Inject
	private UsuarioService usuarioService;
	@Inject @UsuarioQualifier(TipoUsuario.INSTANCE)
	private Usuario usuario;
	
	@PostConstruct
	public void init() {
		usuario.setLogin("marcos");
		usuario.setSenha("123");
		usuario.setEmail("sdasdas");
		usuarioService.cadastrar(usuario);
	}

	public void logar() {
		Usuario usuarioEncontrado = usuarioService.buscarUsuarioPorLoginSenha(usuario.getLogin(), usuario.getSenha());
		System.out.println("Login: " + usuarioEncontrado.getLogin()); 
		System.out.println("Senha: " + usuarioEncontrado.getSenha()); 
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() { 
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
