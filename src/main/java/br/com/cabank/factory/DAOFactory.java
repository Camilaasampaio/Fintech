package br.com.cabank.factory;

import br.com.cabank.dao.ContaDAO;
import br.com.cabank.dao.ImagemDAO;
import br.com.cabank.dao.InvestimentoDAO;
import br.com.cabank.dao.PoupancaDAO;
import br.com.cabank.dao.TransferenciaDAO;
import br.com.cabank.dao.UsuarioDAO;
import br.com.cabank.dao.impl.OracleContaDAO;
import br.com.cabank.dao.impl.OracleImagemDAO;
import br.com.cabank.dao.impl.OracleInvestimentoDAO;
import br.com.cabank.dao.impl.OraclePoupancaDAO;
import br.com.cabank.dao.impl.OracleTransferenciaDAO;
import br.com.cabank.dao.impl.OracleUsuarioDAO;

public class DAOFactory {
	
	public static ContaDAO getContaDAO() {
		return new OracleContaDAO();
	}
	public static ImagemDAO getImagemDAO() {
		return new OracleImagemDAO();
	}
	public static InvestimentoDAO getInvestimentoDAO() {
		return new OracleInvestimentoDAO();
	}
	public static PoupancaDAO getPoupancaDAO() {
		return new OraclePoupancaDAO();
	}
	public static TransferenciaDAO getTransferenciaDAO() {
		return new OracleTransferenciaDAO();
	}
	public static UsuarioDAO getUsuarioDAO() {
		return new OracleUsuarioDAO();
	}
}

