package br.com.cabank.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.cabank.bean.Usuario;
import br.com.cabank.dao.UsuarioDAO;
import br.com.cabank.factory.DAOFactory;


@WebServlet("/usuario")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UsuarioDAO dao;
	
    public UsuarioServlet() {
    	dao = DAOFactory.getUsuarioDAO();         
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("Usuario.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String nome = request.getParameter("nome");
		
		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setSenha(senha);
		usuario.setNomeUsuario(nome);
		
		try {
			dao.insert(usuario);
			HttpSession session = request.getSession();
			session.setAttribute("user", email);
			request.getRequestDispatcher("Inicio.jsp").forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		}
			
	}

}
