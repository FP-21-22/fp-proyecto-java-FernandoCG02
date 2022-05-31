package fp.clinico;

import java.util.*;

public interface EstudioClinicoAmpliacion {

	Map<TipoResidencia, Integer> agruparNumeroPacientesPorTipoResidencia();

	Map<TipoResidencia, Double> agruparNivelMedioGlucosaMedioPorTipoResidencia();

	Map<TipoResidencia, PacienteEstudio> agruparNivelMedioGlucosaMaximoPorTipoResidencia();

	Map<String, List<PacienteEstudio>> agrupaPacientesPorGenero();

	Map<String, Set<PacienteEstudio>> agrupaPacientesPorPorGeneroEnConjunto();

	Map<String, SortedSet<PacienteEstudio>> agrupaPacientesPorPorGeneroEnConjuntoOrdenado();

	Map<String, PacienteEstudio> pacienteEdadMaximaPacientesPorGenero();

	Map<String, List<Double>> listaEdadesPorGenero();

	Map<String, Double> edadMaximaPacientesPorGenero();

	String generoEdadMaximaPacientesPorGenero();
}