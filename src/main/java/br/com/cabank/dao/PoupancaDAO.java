package br.com.cabank.dao;

import java.util.List;

import br.com.cabank.bean.Poupanca;

public interface PoupancaDAO {
	void insert(Poupanca poupanca);
	void atualizar(Poupanca poupanca);
	void remover(Poupanca poupanca );
	Poupanca buscar( int id);
	List<Poupanca> getAll();
}
