package br.com.alura.factory;

import br.com.alura.dao.AutorDAO;
import br.com.alura.dao.AutorDAOImpl;

public class AutorDAOFactory {
	
	public static AutorDAO getAutorDAO() {
		return new AutorDAOImpl(ConnectionFactory.getConnection());
	}
}
