package br.com.alura.dto;

import br.com.alura.model.Autor;
import br.com.alura.util.Constants;
import br.com.alura.util.Util;

public class AutorDTO {
	
	private String nome;
	private String email;
	private String dataNascimento;
	private String miniCurriculo;
	
	public AutorDTO (Autor autor) {
		this.nome = autor.getNome();
		this.email = autor.getEmail();
		this.dataNascimento = Util.parseDate(Constants.BR_DATE_FORMAT, autor.getDataNascimento());
		this.miniCurriculo = autor.getMiniCurriculo();
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public String getMiniCurriculo() {
		return miniCurriculo;
	}
	
	
}
