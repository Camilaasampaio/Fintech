package br.com.cabank.teste;

import br.com.cabank.bean.Imagem;
import br.com.cabank.dao.impl.OracleImagemDAO;

import java.util.List;

public class TesteImagem {

	public static void main(String[] args) {
		//Instaciar o DAO
		OracleImagemDAO dao = new OracleImagemDAO();


		//Instacia a Imagem
		Imagem imagem = new Imagem();
		imagem.setDescricaoImagem("mercado");
		imagem.setCodigoImagem(1);
		imagem.setDescricaoCaminho("mercado.png");
		//Cadastra no banco de dados
		dao.insert(imagem);

		System.out.println("Resgistrado!");

		Imagem imagem2 = new Imagem();
		imagem2.setDescricaoImagem("shopping");
		imagem2.setCodigoImagem(2);
		imagem2.setDescricaoCaminho("shopping.png");

		//Cadastra no banco de dados
		dao.insert(imagem2);

		System.out.println("Resgistrado!");

		Imagem imagem3 = new Imagem();
		imagem3.setDescricaoImagem("pix");
		imagem3.setCodigoImagem(3);
		imagem3.setDescricaoCaminho("pix.png");

		//Cadastra no banco de dados
		dao.insert(imagem3);

		System.out.println("Resgistrado!");

		Imagem imagem4 = new Imagem();
		imagem4.setDescricaoImagem("uber");
		imagem4.setCodigoImagem(4);
		imagem4.setDescricaoCaminho("uber.png");

		//Cadastra no banco de dados
		dao.insert(imagem4);

		System.out.println("Resgistrado!");

		Imagem imagem5 = new Imagem();
		imagem5.setDescricaoImagem("farmácia");
		imagem5.setCodigoImagem(5);
		imagem5.setDescricaoCaminho("farmácia.png");

		//Cadastra no banco de dados
		dao.insert(imagem5);

		System.out.println("Resgistrado!");

		List<Imagem> todosasimagens = dao.getALL();

		for (Imagem item : todosasimagens) {
			System.out.println(" Descricao da imagem: " + item.getDescricaoImagem() +
					" Codigo da imagem: " + item.getCodigoImagem() +
					" Descricao do caminho: " + item.getDescricaoCaminho());
		}
	}
}