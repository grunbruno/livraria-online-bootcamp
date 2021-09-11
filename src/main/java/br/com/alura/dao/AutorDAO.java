package br.com.alura.dao;

import java.util.List;

import br.com.alura.model.Autor;

public interface AutorDAO {
	public void save(Autor autor);
	public List<Autor> getAll();
}
