package br.com.alura.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import br.com.alura.model.Autor;

public class AutorDAOImpl implements AutorDAO {
	
	private Connection connection;

	public AutorDAOImpl(Connection connection) {
		this.connection = connection;
	}
	
	public List<Autor> getAll(){
		
		try {
			List<Autor> autores = new ArrayList<>();
			
			String query = "select * from autores";
			PreparedStatement prepareStatement = connection.prepareStatement(query);
			ResultSet rs = prepareStatement.executeQuery();
			
			while(rs.next()) {
				
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				
				System.out.println(rs.getDate("data_nascimento").toLocalDate().format(formatter));
				LocalDate dataNascimento = LocalDate.parse(rs.getDate("data_nascimento").toLocalDate().format(formatter),DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				String miniCurriculo = rs.getString("mini_curriculo");
				
				Autor autor = new Autor(nome, email, dataNascimento, miniCurriculo);
				autores.add(autor);
			}
			
			return autores;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void save(Autor autor) {
		try {
			
			String insert = "insert into autores (nome,email,data_nascimento,mini_curriculo) values (?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(insert);
			ps.setString(1, autor.getNome());
			ps.setString(2, autor.getEmail());
			ps.setDate(3,  Date.valueOf(autor.getDataNascimento()));
			ps.setString(4, autor.getMiniCurriculo());
			
			ps.execute();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
}
