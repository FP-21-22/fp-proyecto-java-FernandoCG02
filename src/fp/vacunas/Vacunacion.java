package fp.vacunas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import fp.utiles.Checkers;

public record Vacunacion(LocalDate fecha, String comunidad, Integer pfizer, Integer moderna, Integer astrazeneca, Integer janssen, Integer numeroPersonas) implements Comparable<Vacunacion>{
	
	public Vacunacion {
		Checkers.check("La fecha de debe ser posterior al 01/02/2021", fecha.isAfter(LocalDate.of(2021, 02, 01)));
	}
	
	public Integer numeroTotal() {
		Integer numeroTotal = pfizer+moderna+astrazeneca+janssen;
		return numeroTotal;
		
	}
	
	public static Vacunacion of(LocalDate fecha, String comunidad, Integer pfizer, Integer moderna, Integer astrazeneca, Integer janssen, Integer numeroPersonas) {
		Vacunacion res = new Vacunacion(fecha, comunidad, pfizer, moderna, astrazeneca, janssen, numeroPersonas);
		return res;
		
	}
	
	public static Vacunacion parse(String s) {
		String[] partes = s.split(";");
		LocalDate fecha = LocalDate.parse(partes[0].trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String comunidad = partes[1].trim();
		Integer pfizer = Integer.valueOf(partes[2].trim());
		Integer moderna = Integer.valueOf(partes[3].trim());
		Integer astrazeneca = Integer.valueOf(partes[4].trim());
		Integer janssen = Integer.valueOf(partes[5].trim());
		Integer numeroPersonas = Integer.valueOf(partes[6].trim());
		return new Vacunacion(fecha, comunidad, pfizer, moderna, astrazeneca, janssen, numeroPersonas);
	}
	
	

	@Override
	public int compareTo(Vacunacion o) {
		Integer res = comunidad.compareTo(o.comunidad);
		if(res == 0) {
			res = fecha.compareTo(o.fecha);			
		}
		return res;
	}
	
	
	

}
