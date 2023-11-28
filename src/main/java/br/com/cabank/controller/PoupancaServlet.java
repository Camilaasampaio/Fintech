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
import br.com.cabank.bean.Poupanca;
import br.com.cabank.dao.ContaDAO;
import br.com.cabank.dao.PoupancaDAO;
import br.com.cabank.factory.DAOFactory;


@WebServlet("/poupanca")
public class PoupancaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PoupancaDAO dao;
	private ContaDAO contadao;

	public PoupancaServlet() {
		contadao = DAOFactory.getContaDAO();
		dao = DAOFactory.getPoupancaDAO();

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");

		if("novo".equals(acao)){
			List<Conta> liste = contadao.getAll();
			request.setAttribute("contas", liste);

			request.getRequestDispatcher("Poupanca.jsp").forward(request, response);
		}else {

			List<Poupanca> lista = dao.getAll();
			request.setAttribute("poupancas", lista);

			request.getRequestDispatcher("TabelaPoupanca.jsp").forward(request, response);}
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double valor = Double.parseDouble(request.getParameter("valor"));
		int conta = Integer.parseInt(request.getParameter("conta"));

		try {

			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Calendar dataAbertura = Calendar.getInstance();
			dataAbertura.setTime(format.parse(request.getParameter("dataAbertura")));

			Poupanca poupanca = new Poupanca();
			poupanca.setValorPoupanca(valor);
			poupanca.setDataAbertura(dataAbertura);
			poupanca.setCodigoConta(conta);


			dao.insert(poupanca);
			doGet(request, response);
		}catch(Exception e){
			e.printStackTrace();
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		}
	}

}
