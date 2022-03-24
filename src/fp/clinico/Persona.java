package fp.clinico;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import fp.utiles.Checkers;

public record Persona(String nombre, String apellido, String dni, LocalDate fechaNacimiento) 
implements Comparable<Persona>{
	public Boolean DNI(String dni) {
		Boolean con1 = dni.length()==9;
		Boolean con2 = true;
		for (int i=0; i<=dni.length()-1; i++) {
			Boolean aux = true;
			if (i < 8) {
				aux = Character.isDigit(dni.charAt(i));
			}
			else {
				aux = Character.isAlphabetic(dni.charAt(i));
			}
			if (!aux) {
				con2 = false;
			}
		}
		
		return con1 && con2;
		
	}
	
	
	public Persona {
		Checkers.check("La fecha de nacimiento debe ser anterior a la fecha actual ", 
				fechaNacimiento.isBefore(LocalDate.now()));
		Checkers.check("El dni debe ser una cadena con ocho dígitos y seguidos de una letra ", 
				DNI(dni)==true);
	}
	
	public Integer edad() {
		Integer res = Period.between(fechaNacimiento, LocalDate.now()).getYears();
		return res;
		
	}

	public static Persona of (String nombre, String apellido, String dni, LocalDate fechaNacimiento) {
		Persona res = new Persona(nombre, apellido, dni, fechaNacimiento);
		return res;
	}
	
	public static Persona parse(String s) {
		String[] partes = s.split(",");
		String nombre = partes[0].trim();
		String apellido = partes[1].trim();
		String dni = partes[2].trim();
		LocalDate fechaNacimiento = LocalDate.parse(partes[3].trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		return new Persona(nombre, apellido, dni, fechaNacimiento);
	}
	
	


	@Override
	public int compareTo(Persona o) {
		Integer i = this.dni.compareTo(o.dni);
		return i;
	}
	

}
