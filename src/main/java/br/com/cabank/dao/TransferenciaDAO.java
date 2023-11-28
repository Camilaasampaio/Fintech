package br.com.cabank.dao;

import java.util.List;

import br.com.cabank.bean.Transferencia;

public interface TransferenciaDAO {
	 void insert(Transferencia transferencia);
	 void atualizar(Transferencia transferencia);
	 void remover(Transferencia transferencia );
	 Transferencia buscar(int id);
	 List<Transferencia> getAll();
}
