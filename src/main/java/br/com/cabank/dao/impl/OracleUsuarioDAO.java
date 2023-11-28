package br.com.cabank.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.cabank.bean.Usuario;
import br.com.cabank.dao.UsuarioDAO;
import br.com.cabank.jdbc.FintechDBManager;

public class OracleUsuarioDAO implements UsuarioDAO{

	private Connection conexao;
	
	@Override
	public void insert(Usuario usuario) {
		PreparedStatement stmt = null;

		try {
			conexao = FintechDBManager.obterConexao();
			String sql = "INSERT INTO T_USUARIO(CD_USUARIO,NM_USUARIO,TX_EMAIL,TX_SENHA) VALUES (SQ_T_USUARIO.NEXTVAL,?,?,?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, usuario.getNomeUsuario());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getSenha());
			

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean validarUsuario(Usuario usuario) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = FintechDBManager.obterConexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_USUARIO WHERE TX_EMAIL = ? AND TX_SENHA = ?");
			stmt.setString(1, usuario.getEmail());
			stmt.setString(2, usuario.getSenha());
			rs = stmt.executeQuery();

			if (rs.next()){
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

}
