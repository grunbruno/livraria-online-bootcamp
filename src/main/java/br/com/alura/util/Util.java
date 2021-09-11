package br.com.alura.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Util {
	
	public static String parseDate(String formatExpected ,LocalDate date) {
		return DateTimeFormatter.ofPattern(formatExpected).format(date);
	}
	
}
