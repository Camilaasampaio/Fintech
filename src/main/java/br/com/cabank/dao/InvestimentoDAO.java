package br.com.cabank.dao;

import java.util.List;

import br.com.cabank.bean.Investimento;

public interface InvestimentoDAO {
	
	void insert(Investimento investimento);
	void atualizar(Investimento investimento);
	void remover(Investimento investimento);
	Investimento buscar( int id);
	List<Investimento> getAll();
}
