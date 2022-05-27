package fp.vacunas;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;

public class Vacunaciones {
	private List<Vacunacion> lista;
	
	public Vacunaciones(Stream<Vacunacion> constructor) {
		this.lista=constructor.collect(Collectors.toList());
	}
	
	public void anyadeVacunacion (Vacunacion v){
		this.lista.add(v);
	}
	
	public List<Vacunacion> vacunacionesEntreFechas(LocalDate f1, LocalDate f2){
		return this.lista.stream()
				.filter(x->x.fecha().isAfter(f2) && x.fecha().isBefore(f1))
				.collect(Collectors.toList());
	}
	
	public Boolean existeNumPersonasPautaCompletaPorEncimaDe(String comunidad, Integer i) {
		return this.lista.stream()
				.anyMatch(x->x.numeroPersonas()>i);
	}
	
	public LocalDate diaMasVacunacionesEn(String comunidad) {
		return this.lista.stream().filter(x->x.comunidad().equals(comunidad)).
				max(Comparator.comparing(Vacunacion::numeroPersonas)).get().fecha();
	}
	
	public Map<LocalDate, List<Vacunacion>> vacunacionesPorFecha(){
		return this.lista.stream()
				.collect(Collectors.groupingBy(x->x.fecha(), Collectors.toList()));
		
	}
	
	public Map<String, Integer> maximoNumTotalVacunasporComunidad(){
		return this.lista.stream().
				collect(Collectors.groupingBy(x->x.comunidad(), Collectors.collectingAndThen(Collectors.toList(), x-> compara(x))));
	}
		
	private Integer compara(List<Vacunacion> l) {
		
		return l.stream().
				max(Comparator.comparing(Vacunacion::numeroTotal)).
				get().numeroTotal();
	}
	

}
