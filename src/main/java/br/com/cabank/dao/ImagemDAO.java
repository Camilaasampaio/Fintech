package br.com.cabank.dao;

import java.util.List;

import br.com.cabank.bean.Imagem;

public interface ImagemDAO {

	void insert(Imagem imagem);
	void atualizar (Imagem imagem);
	void remover (Imagem imagem);
	Imagem buscar(int id);
	List<Imagem> getALL();
	
}
