package br.com.cabank.dao;

import br.com.cabank.bean.Usuario;

public interface UsuarioDAO {
	void insert(Usuario usuario);
	boolean validarUsuario(Usuario usuario);
}
