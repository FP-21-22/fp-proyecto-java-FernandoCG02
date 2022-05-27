package fp.clinico;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EstudioClinicoStream implements EstudioClinico {

List<PacienteEstudio> lista;
	
	public EstudioClinicoStream() {
		lista = new ArrayList<>();
	}
	
	public EstudioClinicoStream(List<PacienteEstudio> lista) {
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
		return this.lista.stream()
				.allMatch(x->x.tipoResidencia().equals(tipo));
	}

	@Override
	public Boolean existeAlgunPacienteDelTipo(TipoResidencia tipo) {
		// 
		return this.lista.stream()
				.anyMatch(x->x.tipoResidencia().equals(tipo));
	}

	@Override
	public Integer numeroPacientesFactorRiesgo() {
		// 
		return this.lista.stream()
				.filter(x->x.factorRiesgo())
				.collect(Collectors.collectingAndThen(Collectors.counting(), Long::intValue));
	}

	@Override
	public Double edadMediaPacientesConFactorRiesgo() {
		// 
		return this.lista.stream()
				.filter(x->x.factorRiesgo())
				.mapToDouble(x->x.edad()).average().orElse(0.);
	}

	@Override
	public List<PacienteEstudio> filtraPacientesPorEdad(Double edad) {
		//
		return this.lista.stream().
				filter(x->x.edad().equals(edad)).
				collect(Collectors.toList());
	}

	@Override
	public Map<String, List<PacienteEstudio>> agruparPacientesEdadMayorQuePorGenero(Double edad) {
		// 
		return this.lista.stream().
				filter(x->x.edad()>edad)
						.collect(Collectors.groupingBy(x->x.genero(), Collectors.toList()));
	}

	@Override
	public Map<String, Long> numeroPacientesPorGenero() {
		// 
		return this.lista.stream()
				.collect(Collectors.groupingBy(PacienteEstudio::genero , Collectors.counting()));
	}

	@Override
	public Map<String, Double> edadMediaPacientesPorPorGenero() {
		// 
		return this.lista.stream()
				.collect(Collectors.groupingBy(x->x.genero(), Collectors.averagingDouble(x->x.edad())));
	}

}
