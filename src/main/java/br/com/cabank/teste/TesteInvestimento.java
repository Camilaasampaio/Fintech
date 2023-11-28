package br.com.cabank.teste;

import br.com.cabank.bean.Investimento;
import br.com.cabank.dao.impl.OracleInvestimentoDAO;

import java.util.Calendar;
import java.util.List;

public class TesteInvestimento {

	public static void main(String[] args) {
		//Instacia o DAO
		OracleInvestimentoDAO dao = new OracleInvestimentoDAO();

		//Instacia o investimento
		Investimento investimento = new Investimento();
		investimento.setValorInvestimento(300.00);
		investimento.setCodigoInvestimento(123);
		investimento.setCodigoConta(5234);
		investimento.setDataInvestimento(Calendar.getInstance());
		investimento.setNomeInvestimento("Carro");

		dao.insert(investimento);
		System.out.println("Registrado!");

		Investimento investimento2 = new Investimento();
		investimento2.setValorInvestimento(20.00);
		investimento2.setCodigoInvestimento(456);
		investimento2.setCodigoConta(5234);
		investimento2.setDataInvestimento(Calendar.getInstance());
		investimento2.setNomeInvestimento("Bolsa");

		dao.insert(investimento2);
		System.out.println("Registrado!");

		Investimento investimento3 = new Investimento();
		investimento3.setValorInvestimento(50.00);
		investimento3.setCodigoInvestimento(222);
		investimento3.setCodigoConta(5234);
		investimento3.setDataInvestimento(Calendar.getInstance());
		investimento3.setNomeInvestimento("Bicicleta");

		dao.insert(investimento3);
		System.out.println("Registrado!");

		Investimento investimento4 = new Investimento();
		investimento4.setValorInvestimento(300.00);
		investimento4.setCodigoInvestimento(333);
		investimento4.setCodigoConta(5234);
		investimento4.setDataInvestimento(Calendar.getInstance());
		investimento4.setNomeInvestimento("Celular");

		dao.insert(investimento4);
		System.out.println("Registrado!");

		Investimento investimento5 = new Investimento();
		investimento5.setValorInvestimento(500.00);
		investimento5.setCodigoInvestimento(4444);
		investimento5.setCodigoConta(5234);
		investimento5.setDataInvestimento(Calendar.getInstance());
		investimento5.setNomeInvestimento("Notbook");

		dao.insert(investimento5);
		System.out.println("Registrou!");

		List<Investimento> todososInvestimentos = dao.getAll();

		for (Investimento item : todososInvestimentos) {
			System.out.println("Valor do investimento: " + item.getValorInvestimento() +
					" Codigo do investimento: " + item.getCodigoInvestimento() +
					" Codigo da conta: " + item.getCodigoConta() +
					" Data do investimento: " + item.getDataInvestimento().getTime() +
					" Nome do investimento: " + item.getNomeInvestimento());
		}
	}
}