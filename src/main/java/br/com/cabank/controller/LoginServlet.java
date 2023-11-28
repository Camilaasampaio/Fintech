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


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    private UsuarioDAO dao;
  
	public LoginServlet() {
        dao = DAOFactory.getUsuarioDAO();       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		request.getRequestDispatcher("Inicio.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setSenha(senha);
		
		if (dao.validarUsuario(usuario)) {
			HttpSession session = request.getSession();
			session.setAttribute("user", email);
			request.getRequestDispatcher("Inicio.jsp").forward(request, response);
		}else {
			request.setAttribute("erro", "Usuário e/ou senha inválidos");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}		
	}
}
