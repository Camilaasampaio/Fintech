package br.com.cabank.dao.impl;

import br.com.cabank.bean.Imagem;
import br.com.cabank.dao.ImagemDAO;
import br.com.cabank.jdbc.FintechDBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OracleImagemDAO implements ImagemDAO {

	private Connection conexao;
	
	@Override
	public void insert(Imagem imagem) {
		PreparedStatement stmt = null;

		try {
			conexao = FintechDBManager.obterConexao();
			String sql = "INSERT INTO T_IMAGEM (CD_IMAGEM, DS_IMAGEM, DS_CAMINHO) VALUES (SQ_T_IMAGEM.NEXTVAL,?,?) ";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, imagem.getDescricaoImagem());
			stmt.setString(2, imagem.getDescricaoCaminho());
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
	public void atualizar (Imagem imagem) {
		PreparedStatement stmt = null;
		try {
			conexao = FintechDBManager.obterConexao();
			String sql = "UPDATE T_IMAGEM SET DS_IMAGEM = ? , DS_CAMINHO = ? WHERE CD_IMAGEM = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString (1,imagem.getDescricaoImagem());
			stmt.setString(2, imagem.getDescricaoCaminho());
			stmt.setInt(3, imagem.getCodigoImagem());
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
	public void remover (Imagem imagem) {
		PreparedStatement stmt = null;

		try {
			conexao = FintechDBManager.obterConexao();
			String sql = "DELETE FROM T_IMAGEM WHERE CD_IMAGEM = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1,imagem.getCodigoImagem());
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
	public Imagem buscar(int id) {
		Imagem imagem = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = FintechDBManager.obterConexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_IMAGEM WHERE CD_IMAGEM = ?");
			stmt.setInt(1, id);		
			rs = stmt.executeQuery();

			if (rs.next()){
				int codigo = rs.getInt("CD_IMAGEM");
				String descricao = rs.getString ("DS_IMAGEM");
				String caminho = rs.getString("DS_CAMINHO");

				imagem = new Imagem ();
				imagem.setCodigoImagem(codigo);
				imagem.setDescricaoImagem(descricao);
				imagem.setDescricaoCaminho(caminho);
			}
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
		return imagem;


	}
	@Override
	public List<Imagem> getALL() {
		//Criar uma lista de imagem
		List<Imagem> imagens = new ArrayList<>();
		PreparedStatement stmt = null; //executar os comandos no banco de dados
		ResultSet rs = null;

		try {
			conexao = FintechDBManager.obterConexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_IMAGEM");
			rs = stmt.executeQuery();

			//Percorrendo todos os registros encontrados

			while (rs.next()) {
				int cd_imagem = rs.getInt("cd_imagem");
				String ds_imagem = rs.getString(("ds_imagem"));
				String ds_caminho = rs.getString("ds_imagem");

				Imagem imagem = new Imagem();
				imagem.setCodigoImagem(cd_imagem);
				imagem.setDescricaoImagem(ds_imagem);
				imagem.setDescricaoCaminho(ds_caminho);

				imagens.add(imagem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conexao.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return imagens;
	}
}