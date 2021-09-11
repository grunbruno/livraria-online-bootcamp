package br.com.alura.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.dao.AutorDAO;
import br.com.alura.factory.AutorDAOFactory;
import br.com.alura.model.Autor;
import br.com.alura.util.Util;

@WebServlet("/autores")
public class AutorServlet extends HttpServlet{
	
	private AutorDAO autorDAO;
	
	public AutorServlet() {
		this.autorDAO = AutorDAOFactory.getAutorDAO();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setAttribute("autores", autorDAO.getAll());
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/jsp/autores.jsp");
		requestDispatcher.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String dataNascimento = req.getParameter("dataNascimento");
		String miniCurriculo = req.getParameter("miniCurriculo");
		
		Autor autor = new Autor(nome, email, LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("dd/MM/yyyy")), miniCurriculo);
		autorDAO.save(autor);
		
		resp.sendRedirect("autores");
	
	}
}
