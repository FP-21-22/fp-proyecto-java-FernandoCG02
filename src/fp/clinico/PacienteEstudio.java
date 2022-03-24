package fp.clinico;

import fp.utiles.Checkers;

public record PacienteEstudio(String id, String genero, Double edad, Boolean hipertension, Boolean enfermedadCorazon, TipoResidencia tipoResidencia, Double nivelMedioGlucosa) implements Comparable<PacienteEstudio> {
	
	public PacienteEstudio {
		Checkers.check("La edad tiene que ser mayor o igual que cero y menor o igual que 130", edad >= 0 && edad <= 130);
		Checkers.check("El nivel medio de glucosa tiene que ser mayor o igual que cero", nivelMedioGlucosa >= 0);
		
	}
	
	public Boolean factorRiesgo() {
		Boolean con1 = false;
		if (hipertension == true && edad > 40) {
			con1 = true;
		}
		return con1;
		
	}

	@Override
	public int compareTo(PacienteEstudio o) {
		Integer res = edad.compareTo(o.edad);
		if(res == 0){
			res = id.compareTo(o.id);
		}
		return res;	
	}
	
	public static PacienteEstudio of (String id, String genero, Double edad, Boolean hipertension, Boolean enfermedadCorazon, TipoResidencia tipoResidencia, Double nivelMedioGlucosa) {
		PacienteEstudio res = new PacienteEstudio(id, genero, edad, hipertension, enfermedadCorazon, tipoResidencia, nivelMedioGlucosa);
		return res;
	}
	
	public static PacienteEstudio parse(String s) {
		String[] partes = s.split(";");
		String id = partes[0].trim();
		String genero = partes[1].trim();
		Double edad = Double.valueOf(partes[2].trim());
		Boolean hipertension = Boolean.valueOf(partes[3].trim());
		Boolean enfermedadCorazon = Boolean.valueOf(partes[4].trim());
		TipoResidencia tipoResidencia = TipoResidencia.valueOf(partes[5].trim());
		Double nivelMedioGlucosa = Double.valueOf(partes[6].trim());
		return new PacienteEstudio(id, genero, edad, hipertension, enfermedadCorazon, tipoResidencia, nivelMedioGlucosa);
	}
	
	public String toString() {
		return "PacienteEstudio [id=" + id + ", edad=" + edad + "]";
	}
	

}
