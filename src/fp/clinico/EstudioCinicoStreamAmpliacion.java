package fp.clinico;

import java.util.*;
import java.util.stream.*;


public class EstudioCinicoStreamAmpliacion extends EstudioClinicoStream implements EstudioClinicoAmpliacion {
	
	public EstudioCinicoStreamAmpliacion() {
		super();
	}

	public EstudioCinicoStreamAmpliacion(List<PacienteEstudio> lista) {
		super(lista);
	}

	
	public EstudioCinicoStreamAmpliacion(Stream<PacienteEstudio> st) {
		super(st);
	}

	@Override
	public Map<TipoResidencia, Integer> agruparNumeroPacientesPorTipoResidencia() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<TipoResidencia, Double> agruparNivelMedioGlucosaMedioPorTipoResidencia() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<TipoResidencia, PacienteEstudio> agruparNivelMedioGlucosaMaximoPorTipoResidencia() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, List<PacienteEstudio>> agrupaPacientesPorGenero() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Set<PacienteEstudio>> agrupaPacientesPorPorGeneroEnConjunto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, SortedSet<PacienteEstudio>> agrupaPacientesPorPorGeneroEnConjuntoOrdenado() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, PacienteEstudio> pacienteEdadMaximaPacientesPorGenero() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, List<Double>> listaEdadesPorGenero() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Double> edadMaximaPacientesPorGenero() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generoEdadMaximaPacientesPorGenero() {
		// TODO Auto-generated method stub
		return null;
	}

}
