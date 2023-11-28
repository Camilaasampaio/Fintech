package br.com.cabank.dao.impl;

import br.com.cabank.bean.Transferencia;
import br.com.cabank.dao.TransferenciaDAO;
import br.com.cabank.jdbc.FintechDBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class OracleTransferenciaDAO implements TransferenciaDAO {

	private Connection conexao;
	@Override
	public void insert(Transferencia transferencia) {
		PreparedStatement stmt = null;

		try {
			conexao = FintechDBManager.obterConexao();
			String sql = "INSERT INTO T_TRANSFERENCIA(CD_TRANSF, NM_TRANSF, DT_TRANSF, VL_TRANSF, DS_TIPO, T_CONTA_CD_CONTA, T_IMAGEM_CD_IMAGEM) VALUES (SQ_T_TRANSFERENCIA.NEXTVAL,?,?,?,?,?,?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, transferencia.getNomeTransferencia());
			java.sql.Date data = new java.sql.Date(transferencia.getDataTransferencia().getTimeInMillis());
			stmt.setDate(2, data);
			stmt.setDouble(3, transferencia.getValorTransferencia());
			stmt.setString(4, transferencia.getTipoTransferencia());
			stmt.setInt(5, transferencia.getCodigoConta());
			stmt.setInt(6, transferencia.getCodigoImagem());
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
	public void atualizar(Transferencia transferencia) {
		PreparedStatement stmt = null;
		try {
			conexao = FintechDBManager.obterConexao();
			String sql = "UPDATE T_TRANSFERENCIA SET NM_TRANSF = ? , DT_TRANSF = ?, VL_TRANSF = ?, DS_TIPO = ?, T_CONTA_CD_CONTA = ?, T_IMAGEM_CD_IMAGEM = ? WHERE CD_TRANSF = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString (1,transferencia.getNomeTransferencia());
			java.sql.Date data = new java.sql.Date(transferencia.getDataTransferencia().getTimeInMillis());
			stmt.setDate(2, data);
			stmt.setDouble(3, transferencia.getValorTransferencia());
			stmt.setString(4,transferencia.getTipoTransferencia());
			stmt.setInt(5,transferencia.getCodigoConta());
			stmt.setInt(6,transferencia.getCodigoImagem());
			stmt.setInt(7, transferencia.getCodigoTransferencia());
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
	public void remover(Transferencia transferencia ) {
		PreparedStatement stmt = null;

		try {
			conexao = FintechDBManager.obterConexao();
			String sql = "DELETE FROM T_TRANSFERENCIA WHERE CD_TRANSF= ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1,transferencia.getCodigoTransferencia());
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
	public Transferencia buscar(int id) {
		Transferencia transferencia = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = FintechDBManager.obterConexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_TRANSFERENCIA WHERE CD_TRANSFERENCIA = ?");
			stmt.setInt(1, id);		
			rs = stmt.executeQuery();

			if (rs.next()){
				int codigo = rs.getInt("CD_TRANSF");
				String nome = rs.getString ("NM_TRANSF");
				java.sql.Date data = rs.getDate("DT_TRANSF");
				Calendar dataTransferencia = Calendar.getInstance();
				dataTransferencia.setTimeInMillis(data.getTime());
				double valorTransferencia =rs.getDouble("VL_TRANSF");
				String descricaoTipo = rs.getString("DS_TIPO");
				int codigoConta = rs.getInt("T_CONTA_CD_CONTA");
				int codigoImagem = rs.getInt("T_IMAGEM_CD_IMAGEM");

				transferencia = new Transferencia(codigo, nome, dataTransferencia, valorTransferencia, descricaoTipo, codigoConta, codigoImagem);
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
		return transferencia;
	}
	@Override
	public List<Transferencia> getAll() {
		List<Transferencia> transferencias = new ArrayList<>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = FintechDBManager.obterConexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_TRANSFERENCIA");
			rs = stmt.executeQuery();

			while (rs.next()) {
				int cd_transf = rs.getInt("cd_transf");
				String nm_transf = rs.getString("nm_transf");
				java.sql.Date dt_transf = rs.getDate("dt_transf");
				double vl_transf = rs.getDouble("vl_transf");
				String ds_tipo = rs.getString("ds_tipo");
				int t_conta_cd_conta = rs.getInt("t_conta_cd_conta");
				int t_imagem_cd_imagem = rs.getInt("t_imagem_cd_imagem");

				Calendar dataTransferencia = Calendar.getInstance();
				dataTransferencia.setTimeInMillis(dt_transf.getTime());

				Transferencia transferencia = new Transferencia(
						cd_transf,
						nm_transf,
						dataTransferencia,
						vl_transf,
						ds_tipo,
						t_conta_cd_conta,
						t_imagem_cd_imagem
						);

				transferencias.add(transferencia);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return transferencias;
	}
}