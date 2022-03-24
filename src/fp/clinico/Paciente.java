package fp.clinico;

import java.time.LocalDate;
import java.time.LocalDateTime;
import fp.utiles.Checkers;

public record Paciente(Persona persona, String codigoIngreso, LocalDateTime fechaHora) {
	public LocalDate fecha() {
		LocalDate res = fechaHora.toLocalDate();
		return res;
	}
	public String hora() {
		String res = fechaHora.toLocalTime().toString();
		return res;
	}
	
	public Paciente {
		Checkers.check("La fecha y hora de ingreso debe ser anterior o igual a la fecha actual", !fechaHora.isAfter(LocalDateTime.now()));
	}
	
	public static Paciente of (String nombre, String apellido, String dni, LocalDate fechaNacimiento, String codigoIngreso, LocalDateTime fechaHora) {
		Persona persona = Persona.of(nombre, apellido, dni, fechaNacimiento);
		Paciente res = new Paciente(persona, codigoIngreso, fechaHora);
		return res;
	}
	
	public static Paciente of (Persona persona, String codigoIngreso, LocalDateTime fechaHora) {
		Paciente res = new Paciente(persona, codigoIngreso, fechaHora);
		return res;
	}

}
