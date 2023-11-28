package br.com.cabank.dao.impl;

import br.com.cabank.bean.Poupanca;
import br.com.cabank.dao.PoupancaDAO;
import br.com.cabank.jdbc.FintechDBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class OraclePoupancaDAO implements PoupancaDAO{

	private Connection conexao;
@Override
	public void insert(Poupanca poupanca) {
		PreparedStatement stmt = null;

		try {
			conexao = FintechDBManager.obterConexao();
			String sql = "INSERT INTO T_POUPANCA(CD_POUPANCA, VL_POUPANCA, DT_ABERTURA, T_CONTA_CD_CONTA) VALUES (SQ_T_POUPANCA.NEXTVAL,?,?,?)";
			stmt = conexao.prepareStatement(sql);

			stmt.setDouble(1, poupanca.getValorPoupanca());

			java.sql.Date data = new java.sql.Date(poupanca.getDataAbertura().getTimeInMillis());
			stmt.setDate(2, data);

			stmt.setInt(3, poupanca.getCodigoConta());
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
	public void atualizar(Poupanca poupanca) {
		PreparedStatement stmt = null;
		try {
			conexao = FintechDBManager.obterConexao();
			String sql = "UPDATE T_POUPANCA SET VL_POUPANCA = ? , DT_ABERTURA = ?, T_CONTA_CD_CONTA = ? WHERE CD_POUPANCA = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setDouble (1,poupanca.getValorPoupanca());
			java.sql.Date data = new java.sql.Date(poupanca.getDataAbertura().getTimeInMillis());
			stmt.setDate(2, data);
			stmt.setDouble(3,poupanca.getCodigoConta());
			stmt.setInt(4,poupanca.getCodigoPoupanca());
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
	public void remover(Poupanca poupanca ) {
		PreparedStatement stmt = null;

		try {
			conexao = FintechDBManager.obterConexao();
			String sql = "DELETE FROM T_POUPANCA WHERE CD_POUPANCA = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1,poupanca.getCodigoPoupanca());
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
	public Poupanca buscar( int id) {
		Poupanca poupanca = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = FintechDBManager.obterConexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_POUPANCA WHERE CD_POUPANCA = ?");
			stmt.setInt(1, id);		
			rs = stmt.executeQuery();

			if (rs.next()){
				int codigo = rs.getInt("CD_POUPANCA");
				double valor = rs.getDouble ("VL_POUPANCA");
				java.sql.Date data = rs.getDate("DT_ABERTURA");
				Calendar dataAbertura = Calendar.getInstance();
				dataAbertura.setTimeInMillis(data.getTime());
				int CodigoConta = rs.getInt("T_CONTA_CD_CONTA");

				poupanca = new Poupanca ();
				poupanca.setCodigoPoupanca(codigo);
				poupanca.setValorPoupanca(valor);
				poupanca.setDataAbertura(dataAbertura);
				poupanca.setCodigoConta(CodigoConta);
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
		return poupanca;
	}
@Override
	public List<Poupanca> getAll() {
		//Criar uma lista de poupança
		List<Poupanca> poupancas = new ArrayList<>();
		PreparedStatement stmt = null; //Executando os comandos no banco de dados
		ResultSet rs = null;

		try {
			conexao = FintechDBManager.obterConexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_POUPANCA");
			rs = stmt.executeQuery();

			//Percorrendo todos os registros encontrados

			while (rs.next()) {
				int cd_poupanca = rs.getInt("cd_poupanca");
				double vl_poupanca = rs.getDouble("vl_poupanca");
				java.sql.Date dt_abertura = rs.getDate("dt_abertura");
				int t_conta_cd_conta = rs.getInt("t_conta_cd_conta");

				Calendar dataAbertura = Calendar.getInstance();
				dataAbertura.setTimeInMillis(dt_abertura.getTime());

				//Criando um objeto Poupanca com as informações encontradas

				Poupanca poupanca = new Poupanca();
				poupanca.setCodigoPoupanca(cd_poupanca);
				poupanca.setValorPoupanca(vl_poupanca);
				poupanca.setDataAbertura(dataAbertura);
				poupanca.setCodigoConta(t_conta_cd_conta);

				poupancas.add(poupanca);
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
		return poupancas;
	}
}