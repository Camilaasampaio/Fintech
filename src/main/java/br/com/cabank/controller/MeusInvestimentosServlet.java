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
import br.com.cabank.bean.Investimento;
import br.com.cabank.dao.ContaDAO;
import br.com.cabank.dao.InvestimentoDAO;
import br.com.cabank.factory.DAOFactory;


@WebServlet("/meusinvestimentos")
public class MeusInvestimentosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	private InvestimentoDAO dao;
	private ContaDAO contadao;
    
    public MeusInvestimentosServlet() {
    	contadao = DAOFactory.getContaDAO();
		dao = DAOFactory.getInvestimentoDAO();      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");

		if("novo".equals(acao)){
			List<Conta> liste = contadao.getAll();
			request.setAttribute("contas", liste);

			request.getRequestDispatcher("Investimento.jsp").forward(request, response);
		}else {

			List<Investimento> lista = dao.getAll();
			request.setAttribute("investimentos", lista);

			request.getRequestDispatcher("TabelaInvestimento.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double valor = Double.parseDouble(request.getParameter("valor"));
		int conta = Integer.parseInt(request.getParameter("conta"));
		String nome = request.getParameter("nome");
		try {

			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Calendar data = Calendar.getInstance();
			data.setTime(format.parse(request.getParameter("dataInvestimento")));

			Investimento investimento = new Investimento();
			investimento.setValorInvestimento(valor);
			investimento.setDataInvestimento(data);
			investimento.setCodigoConta(conta);
			investimento.setNomeInvestimento(nome);


			dao.insert(investimento);
			doGet(request, response);
		}catch(Exception e){
			e.printStackTrace();
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		}
	}

}
