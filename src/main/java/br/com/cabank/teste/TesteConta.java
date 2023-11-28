package br.com.cabank.teste;

import br.com.cabank.bean.Conta;
import br.com.cabank.dao.impl.OracleContaDAO;

import java.util.Calendar;
import java.util.List;

public class TesteConta {

	public static void main(String[] args) {
		//Instacia o DAO
		OracleContaDAO dao = new OracleContaDAO();

		//Instacia a conta
		Conta conta = new Conta();
		conta.setCodigoConta(2222);
		conta.setNomeBanco("Bradesco");
		conta.setNumeroAgencia(333333);
		conta.setDataCadastro(Calendar.getInstance());
		conta.setNumeroConta(8888);
		conta.setCodigoUsuario(123);

		//Cadastra no banco de dados
		dao.insert(conta);

		System.out.println("Registrado!");

		//Instacia a conta
		Conta conta2 = new Conta();
		conta2.setCodigoConta(3333);
		conta2.setNomeBanco("Bradesco");
		conta2.setNumeroAgencia(44444);
		conta2.setDataCadastro(Calendar.getInstance());
		conta2.setNumeroConta(7777);
		conta2.setCodigoUsuario(123);

		//Cadastra no banco de dados
		dao.insert(conta2);

		System.out.println("Registrado!");

		//Instacia a conta
		Conta conta3 = new Conta();
		conta3.setCodigoConta(44444);
		conta3.setNomeBanco("Banco do Brasil");
		conta3.setNumeroAgencia(55555);
		conta3.setDataCadastro(Calendar.getInstance());
		conta3.setNumeroConta(6666);
		conta3.setCodigoUsuario(123);

		//Cadastra no banco de dados
		dao.insert(conta3);

		System.out.println("Registrado!");

		//Instacia a conta
		Conta conta4 = new Conta();
		conta4.setCodigoConta(55555);
		conta4.setNomeBanco("Itaú");
		conta4.setNumeroAgencia(66666);
		conta4.setDataCadastro(Calendar.getInstance());
		conta4.setNumeroConta(5555);
		conta4.setCodigoUsuario(123);

		//Cadastra no banco de dados
		dao.insert(conta4);

		System.out.println("Registrado!");

		//Instacia a conta
		Conta conta5 = new Conta();
		conta5.setCodigoConta(66666);
		conta5.setNomeBanco("Bradesco");
		conta5.setNumeroAgencia(44444);
		conta5.setDataCadastro(Calendar.getInstance());
		conta5.setNumeroConta(4444);
		conta5.setCodigoUsuario(123);

		//Cadastra no banco de dados
		dao.insert(conta5);

		System.out.println("Registrado!");

		List<Conta> todasascontas = dao.getAll();

		for (Conta item : todasascontas) {
			System.out.println(" Codigo do usuario: " + item.getCodigoUsuario() +
					" Codigo da conta: " + item.getCodigoConta() +
					" Nome do banco: " + item.getNomeBanco() +
					" Numero da agencia: " + item.getNumeroAgencia() +
					" Data de cadastro: " + item.getDataCadastro().getTime().toString() +
					" Numero da conta: " + item.getNumeroConta());
		}
	}
}
