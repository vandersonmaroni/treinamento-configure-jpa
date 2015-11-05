package com.gcfrete.modules.usuario.model;

import com.gcfrete.modules.usuario.util.annotation.UsuarioQualifier;
import com.gcfrete.modules.usuario.util.annotation.UsuarioQualifier.TipoUsuario;

@UsuarioQualifier(TipoUsuario.NULL)
public class UsuarioNull extends Usuario {
	private static final long serialVersionUID = 8175399490927694096L;

	@Override
	public String getLogin() {
		return "";
	}
	
	@Override
	public String getSenha() {
		return "";
	}
}
