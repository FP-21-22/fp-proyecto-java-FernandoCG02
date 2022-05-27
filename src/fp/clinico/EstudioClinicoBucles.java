package fp.clinico;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EstudioClinicoBucles implements EstudioClinico {
	
	List<PacienteEstudio> lista;
	
	public EstudioClinicoBucles() {
		lista = new ArrayList<>();
	}
	
	public EstudioClinicoBucles(List<PacienteEstudio> lista) {
		this.lista = lista;	
		
	}

	@Override
	public Integer numeroPacientes() {
		// 
		Integer res;
		res = lista.size();
		return res;
	}

	@Override
	public void incluyePaciente(PacienteEstudio paciente) {
		// 
		lista.add(paciente);

	}

	@Override
	public void incluyePacientes(Collection<PacienteEstudio> pacientes) {
		// 
		lista.addAll(pacientes);

	}

	@Override
	public void eliminaPaciente(PacienteEstudio paciente) {
		// 
		lista.remove(paciente);

	}

	@Override
	public Boolean estaPaciente(PacienteEstudio paciente) {
		// 
		return lista.contains(paciente);
		
	}

	@Override
	public void borraEstudio() {
		// 
		lista.clear();

	}
	

	@Override
	public String toString() {
		return "EstudioClinicoBucles [lista=" + lista + "]";
	}


	@Override
	public EstudioClinico of(String nombreFichero) {
		// 
		return new EstudioClinicoBucles(this.leeFichero(nombreFichero));
		
	}

	@Override
	public List<PacienteEstudio> leeFichero(String nombreFichero) {
		// 
		List<PacienteEstudio> res = new ArrayList<>();
		List<String> aux;
		try {
			aux = Files.readAllLines(Paths.get(nombreFichero));
			for(String e:aux) {
				PacienteEstudio pe = PacienteEstudio.parse(e);
				res.add(pe);
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return res;
	}

	@Override
	public Boolean todosPacienteSonDelTipo(TipoResidencia tipo) {
		// 
		Boolean res = false;
		Integer cont = 0;
		for(PacienteEstudio Pe : this.lista) {
			if(Pe.tipoResidencia().equals(tipo)) {
				cont++;
				if(cont==this.lista.size()) {
					res = true;
					
				}
				
			}
			
		}
		return res;
	}

	@Override
	public Boolean existeAlgunPacienteDelTipo(TipoResidencia tipo) {
		// 
		Boolean res = false;
		for(PacienteEstudio Pe : this.lista) {
			if (Pe.tipoResidencia().equals(tipo)) {
				res = true;
				break;
			}
				
		}
		
		return res;
	}

	@Override
	public Integer numeroPacientesFactorRiesgo() {
		//
		
		Integer num = 0;
		for (PacienteEstudio Pe : this.lista) {
			if (Pe.factorRiesgo().equals(true)) {
				num++;
			}
		}
		return num;

	}

	@Override
	public Double edadMediaPacientesConFactorRiesgo() {
		// 
		Double media = 0.;
		Integer cont = 0;
		Double edad = 0.;
		for(PacienteEstudio Pe : this.lista) {
			if(Pe.factorRiesgo().equals(true)) {
				cont++;
				edad = edad+Pe.edad();
				
			}
		}
		media = edad/cont;
		return media;
	}

	@Override
	public List<PacienteEstudio> filtraPacientesPorEdad(Double edad) {
		//
		List<PacienteEstudio> res = new ArrayList<>();
		for(PacienteEstudio Pe : this.lista) {
			if(Pe.edad().equals(edad)) {
				res.add(Pe);
				
			}
			
		}
				
		return res;
	}

	@Override
	public Map<String, List<PacienteEstudio>> agruparPacientesEdadMayorQuePorGenero(Double edad) {
		// 
		Map<String, List<PacienteEstudio>> res = new HashMap<String, List<PacienteEstudio>>();
		for(PacienteEstudio Pe : this.lista) {
			if(Pe.edad()>edad) {
				String clave = Pe.genero();
				if(!res.containsKey(clave)) {
					List<PacienteEstudio> valor = new ArrayList<>();
					valor.add(Pe);
					res.put(clave, valor);
				}else {
					res.get(clave).add(Pe);
				}
				
			}
			
		}
		
		return res;
	}

	@Override
	public Map<String, Long> numeroPacientesPorGenero() {
		// 
		Map<String, Long> res = new HashMap<>();
		Long contF = 2L;
		Long contM = 2L;
		for(PacienteEstudio Pe : this.lista) {
			String clave = Pe.genero();
			if(!res.containsKey(clave)) {
				res.put(clave, 1L);
			}else {
				if(clave=="Male") {
					res.put(clave, contM);
					contM++;
				}else {
					res.put(clave, contF);
					contF++;
				}
				
			}
				
		}
		return res;
	}

	@Override
	public Map<String, Double> edadMediaPacientesPorPorGenero() {
		// 
		Map<String, Double> res = new HashMap<>();
		Integer contM = 1;
		Integer contF = 1;
		for (PacienteEstudio Pe : this.lista) {
			String clave = Pe.genero();
			if(!res.containsKey(clave)) {
				res.put(clave, Pe.edad());
			}else {
				if(clave == "Male") {
					contM++;
					Double sumaM = res.get(clave)+Pe.edad();
					res.put(clave, sumaM/contM);
					
				}else {
					contF++;
					Double sumaF = res.get(clave)+Pe.edad();
					res.put(clave, sumaF/contF);
				}
			}
		}
		
		return res;
	}
	

}
