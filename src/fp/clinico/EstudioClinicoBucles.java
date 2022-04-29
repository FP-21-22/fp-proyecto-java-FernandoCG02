package fp.clinico;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean existeAlgunPacienteDelTipo(TipoResidencia tipo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer numeroPacientesFactorRiesgo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double edadMediaPacientesConFactorRiesgo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PacienteEstudio> filtraPacientesPorEdad(Double edad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, List<PacienteEstudio>> agruparPacientesEdadMayorQuePorGenero(Double edad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Long> numeroPacientesPorGenero() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Double> edadMediaPacientesPorPorGenero() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
