package br.com.cabank.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cabank.bean.Conta;
import br.com.cabank.bean.Transferencia;
import br.com.cabank.dao.ContaDAO;
import br.com.cabank.dao.TransferenciaDAO;
import br.com.cabank.factory.DAOFactory;


@WebServlet("/meusganhos")
public class MeusganhosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private TransferenciaDAO dao;
	private ContaDAO contadao;

    public MeusganhosServlet() {
    	contadao = DAOFactory.getContaDAO();
		dao = DAOFactory.getTransferenciaDAO();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");

		if("novoganho".equals(acao)){
			List<Conta> liste = contadao.getAll();
			request.setAttribute("contas", liste);

			request.getRequestDispatcher("MeusGanhos.jsp").forward(request, response);
		} else if("novogasto".equals(acao)){
			List<Conta> liste = contadao.getAll();
			request.setAttribute("contas", liste);

			request.getRequestDispatcher("MeusGastos.jsp").forward(request, response);
		} else {

			List<Transferencia> lista = dao.getAll();
			request.setAttribute("transferencia", lista);

			request.getRequestDispatcher("TabelaGanhos.jsp").forward(request, response);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double valor = Double.parseDouble(request.getParameter("valor"));
		int conta = Integer.parseInt(request.getParameter("conta"));
		int imagem = Integer.parseInt(request.getParameter("imagem"));
		String nome = request.getParameter("nome");
		String tipo = request.getParameter("tipo");
		
		try {

			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Calendar data = Calendar.getInstance();
			data.setTime(format.parse(request.getParameter("dataCadastro")));

			Transferencia transferencia = new Transferencia(nome, data, valor);
			transferencia.setCodigoConta(conta);
			transferencia.setTipoTransferencia(tipo);
			transferencia.setCodigoImagem(imagem);

			dao.insert(transferencia);
			doGet(request, response);
		}catch(Exception e){
			e.printStackTrace();
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		}
	}

}
