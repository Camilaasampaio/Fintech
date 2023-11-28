package br.com.cabank.dao;

import java.util.List;

import br.com.cabank.bean.Conta;

public interface ContaDAO {
	void insert(Conta conta);
	void atualizar(Conta conta);
	void remover(Conta conta);
	Conta buscar(int id);
	List<Conta> getAll();
}
