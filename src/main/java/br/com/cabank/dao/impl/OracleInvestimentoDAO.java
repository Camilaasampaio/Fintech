package br.com.cabank.dao.impl;

import br.com.cabank.bean.Investimento;
import br.com.cabank.dao.InvestimentoDAO;
import br.com.cabank.jdbc.FintechDBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class OracleInvestimentoDAO implements InvestimentoDAO {

	private Connection conexao;

	@Override
	public void insert(Investimento investimento) {
		PreparedStatement stmt = null;

		try {
			conexao = FintechDBManager.obterConexao();
			String sql = "INSERT INTO T_INVESTIMENTO(CD_INVESTIMENTO, NM_INVESTIMENTO, DT_INVESTIMENTO, VL_INVESTIMENTO, T_CONTA_CD_CONTA) VALUES (SQ_T_INVESTIMENTO.NEXTVAL,?,?,?,?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, investimento.getNomeInvestimento());
			java.sql.Date data = new java.sql.Date(investimento.getDataInvestimento().getTimeInMillis());
			stmt.setDate(2, data);
			stmt.setDouble(3, investimento.getValorInvestimento());
			stmt.setInt(4, investimento.getCodigoConta());
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
	public void atualizar(Investimento investimento) {
		PreparedStatement stmt = null;
		try {
			conexao = FintechDBManager.obterConexao();
			String sql = "UPDATE T_INVESTIMENTO SET NM_INVESTIMENTO = ? , DT_INVESTIMENTO = ?, VL_INVESTIMENTO = ?, T_CONTA_CD_CONTA = ? WHERE CD_INVESTIMENTO = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString (1,investimento.getNomeInvestimento());
			java.sql.Date data = new java.sql.Date(investimento.getDataInvestimento().getTimeInMillis());
			stmt.setDate(2, data);
			stmt.setDouble(3, investimento.getValorInvestimento());
			stmt.setInt(4,investimento.getCodigoConta());
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
	public void remover(Investimento investimento ) {
		PreparedStatement stmt = null;

		try {
			conexao = FintechDBManager.obterConexao();
			String sql = "DELETE FROM T_INVESTIMENTO WHERE CD_INVESTIMENTO = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1,investimento.getCodigoInvestimento());
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
	public Investimento buscar( int id) {
		Investimento investimento = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = FintechDBManager.obterConexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_INVESTIMENTO WHERE CD_INVESTIMENTO = ?");
			stmt.setInt(1, id);		
			rs = stmt.executeQuery();

			if (rs.next()){
				int codigo = rs.getInt("CD_INVESTIMENTO");
				String nome = rs.getString ("NM_INVESTIMENTO");
				java.sql.Date data = rs.getDate("DT_INVESTIMENTO");
				Calendar dataInvestimento = Calendar.getInstance();
				dataInvestimento.setTimeInMillis(data.getTime());
				double valor = rs.getDouble("VL_INVESTIMENTO");
				int codigoConta = rs.getInt("T_CONTA_CD_CONTA");

				investimento = new Investimento ();
				investimento.setCodigoInvestimento(codigo);
				investimento.setNomeInvestimento(nome);
				investimento.setDataInvestimento(dataInvestimento);
				investimento.setValorInvestimento(valor);
				investimento.setCodigoConta(codigoConta);
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
		return investimento;
	}

	@Override
	public List<Investimento> getAll() {
		//Criando uma lista de investimento
		List<Investimento> invetimentos = new ArrayList<>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = FintechDBManager.obterConexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_INVESTIMENTO");
			rs = stmt.executeQuery();
			//Percorrendo todos os registros encontrados

			while (rs.next()) {
				int cd_investimento = rs.getInt("cd_investimento");
				String nm_investimento = rs.getString("nm_investimento");
				java.sql.Date dt_investimento = rs.getDate("dt_investimento");
				double vl_investimento = rs.getDouble("vl_investimento");
				int t_conta_cd_conta = rs.getInt("t_conta_cd_conta");

				Calendar dataInvestimento = Calendar.getInstance();
				dataInvestimento.setTimeInMillis(dt_investimento.getTime());

				//Criando um objeto Conta com as informações encontradas

				Investimento investimento = new Investimento();
				investimento.setCodigoInvestimento(cd_investimento);
				investimento.setNomeInvestimento(nm_investimento);
				investimento.setDataInvestimento(dataInvestimento);
				investimento.setValorInvestimento(vl_investimento);
				investimento.setCodigoConta(t_conta_cd_conta);

				invetimentos.add(investimento);
			}
		} catch (SQLException e) {
			e.printStackTrace(); //imprime o erro
		} finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return invetimentos;
	}
}