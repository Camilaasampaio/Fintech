package br.com.cabank.teste;

import br.com.cabank.bean.Poupanca;
import br.com.cabank.dao.impl.OraclePoupancaDAO;

import java.util.Calendar;
import java.util.List;

public class TestePoupanca {

	public static void main(String[] args) {

		OraclePoupancaDAO dao = new OraclePoupancaDAO();

		//Instancia a poupança
		Poupanca poupanca = new Poupanca();
		poupanca.setCodigoPoupanca(1);
		poupanca.setValorPoupanca(500.0);
		poupanca.setDataAbertura(Calendar.getInstance());
		poupanca.setCodigoConta(5234);

		dao.insert(poupanca);

		System.out.println("Registrado!");

		Poupanca poupanca2 = new Poupanca();
		poupanca2.setCodigoPoupanca(2);
		poupanca2.setValorPoupanca(220.0);
		poupanca2.setDataAbertura(Calendar.getInstance());
		poupanca2.setCodigoConta(5234);

		dao.insert(poupanca2);

		System.out.println("Registrado!");

		Poupanca poupanca3 = new Poupanca();
		poupanca3.setCodigoPoupanca(3);
		poupanca3.setValorPoupanca(300.0);
		poupanca3.setDataAbertura(Calendar.getInstance());
		poupanca3.setCodigoConta(5234);

		dao.insert(poupanca3);

		System.out.println("Registrado!");

		Poupanca poupanca4 = new Poupanca();
		poupanca4.setCodigoPoupanca(4);
		poupanca4.setValorPoupanca(80.0);
		poupanca4.setDataAbertura(Calendar.getInstance());
		poupanca4.setCodigoConta(5234);

		dao.insert(poupanca4);

		System.out.println("Registrado!");

		Poupanca poupanca5 = new Poupanca();
		poupanca5.setCodigoPoupanca(5);
		poupanca5.setValorPoupanca(700.0);
		poupanca5.setDataAbertura(Calendar.getInstance());
		poupanca5.setCodigoConta(5234);

		dao.insert(poupanca5);

		System.out.println("Registrado!");

		List<Poupanca> todasaspoupancas = dao.getAll();

		for (Poupanca item : todasaspoupancas) {
			System.out.println("Codigo da Poupanca: " + item.getCodigoPoupanca() +
					" Valor Poupanca: " + item.getValorPoupanca() +
					" Data Abertura: " + item.getDataAbertura().getTime() +
					" Codigo Conta: " + item.getCodigoConta());
		}
	}
}
