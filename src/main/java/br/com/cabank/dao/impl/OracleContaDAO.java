package br.com.cabank.dao.impl;

import br.com.cabank.bean.Conta;
import br.com.cabank.dao.ContaDAO;
import br.com.cabank.jdbc.FintechDBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class OracleContaDAO implements ContaDAO {

	private Connection conexao;

	@Override
	public void insert(Conta conta) {
		PreparedStatement stmt = null;

		try {
			conexao = FintechDBManager.obterConexao();
			String sql = "INSERT INTO T_CONTA(CD_CONTA,NM_BANCO,NR_AGENCIA,DT_CADASTRO, NR_CONTA, T_USUARIO_CD_USUARIO) VALUES (SQ_T_CONTA.NEXTVAL,?,?,?,?,?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, conta.getNomeBanco());
			stmt.setInt(2, conta.getNumeroAgencia());
			java.sql.Date data = new java.sql.Date(conta.getDataCadastro().getTimeInMillis());
			stmt.setDate(3, data);
			stmt.setInt(4, conta.getNumeroConta());
			stmt.setInt(5, conta.getCodigoUsuario());
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
	public void atualizar(Conta conta) {
		PreparedStatement stmt = null;

		try {
			conexao = FintechDBManager.obterConexao();
			String sql = "UPDATE T_CONTA SET NM_BANCO = ? ,NR_AGENCIA = ? ,DT_CADASTRO = ? , NR_CONTA = ? WHERE CD_CONTA = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1,conta.getNomeBanco());
			stmt.setInt(2,conta.getNumeroAgencia());
			java.sql.Date data = new java.sql.Date(conta.getDataCadastro().getTimeInMillis());
			stmt.setDate(3, data);
			stmt.setInt(4,conta.getNumeroConta());
			stmt.setInt(5,conta.getCodigoConta());
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
	public void remover(Conta conta) {
		PreparedStatement stmt = null;

		try {
			conexao = FintechDBManager.obterConexao();
			String sql = "DELETE FROM T_CONTA WHERE CD_CONTA = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1,conta.getCodigoConta());
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
	public Conta buscar(int id) {
		Conta conta = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {

			conexao = FintechDBManager.obterConexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_CONTA WHERE CD_CONTA = ?");
			stmt.setInt(1, id);		
			rs = stmt.executeQuery();

			if (rs.next()){
				int codigo = rs.getInt("CD_CONTA");
				String nome = rs.getString ("NM_BANCO");
				int agencia = rs.getInt("NR_AGENCIA");
				java.sql.Date data = rs.getDate("DT_CADASTRO");
				Calendar dataCadastro = Calendar.getInstance();
				dataCadastro.setTimeInMillis(data.getTime());
				int numeroConta = rs.getInt("NR_CONTA");
				int usuario = rs.getInt("T_USUARIO_CD_USUARIO");

				conta = new Conta ();
				conta.setCodigoConta(codigo);
				conta.setNomeBanco(nome);
				conta.setNumeroAgencia(agencia);
				conta.setDataCadastro(dataCadastro);
				conta.setNumeroConta(numeroConta);
				conta.setCodigoUsuario(usuario);
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
		return conta;

	}

	@Override
	public List<Conta> getAll() {
		//Criar uma lista de conta
		List<Conta> contas = new ArrayList<>();
		PreparedStatement stmt = null; //executar os comandos no banco de dados
		ResultSet rs = null;

		try {
			conexao = FintechDBManager.obterConexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_CONTA");
			rs = stmt.executeQuery();

			//Percorrendo todos os registros encontrados

			while (rs.next()) {
				int cd_conta = rs.getInt("cd_conta");
				String nm_banco = rs.getString("nm_banco");
				int nr_agencia = rs.getInt("nr_agencia");
				java.sql.Date dt_cadastro = rs.getDate("dt_cadastro");
				int nr_conta = rs.getInt("nr_conta");
				int t_usuario_cd_usuario = rs.getInt("t_usuario_cd_usuario");

				Calendar dataCadastro = Calendar.getInstance();
				dataCadastro.setTimeInMillis(dt_cadastro.getTime());

				//Criando um objeto Conta com as informações encontradas

				Conta conta = new Conta();
				conta.setCodigoConta(cd_conta);
				conta.setNomeBanco(nm_banco);
				conta.setNumeroAgencia(nr_agencia);
				conta.setDataCadastro(dataCadastro);
				conta.setNumeroConta(nr_conta);
				conta.setCodigoUsuario(t_usuario_cd_usuario);

				//Adicionar conta na lista
				contas.add(conta);
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
		return contas;
	}
}
