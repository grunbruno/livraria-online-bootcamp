package br.com.alura.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.dto.AutorDTO;
import br.com.alura.model.Autor;

public class Util {
	
	public static String parseDate(String formatExpected ,LocalDate date) {
		return DateTimeFormatter.ofPattern(formatExpected).format(date);
	}
	
	public static List<AutorDTO> convertAutorToDTO(List<Autor> autores){
		List<AutorDTO> list = new ArrayList<>();
		
		autores.forEach( a -> 
			list.add(new AutorDTO(a))
				);
		
		return list;
	}
}
