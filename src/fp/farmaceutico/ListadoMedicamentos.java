package fp.farmaceutico;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListadoMedicamentos {
	private List<Medicamento> lista;
	
	public ListadoMedicamentos(Stream<Medicamento> constructor) {
		this.lista=constructor.collect(Collectors.toList());
	}
	
	public Boolean existeMedicamentoSegunTipoAnteriorA(TipoMedicamento m, LocalDate f) {
		return this.lista.stream().
				filter(x->x.getTipoMedicamento().equals(m)).anyMatch(x->x.getFechaCatalogo().isAfter(f));
	}
	
	public List<String> nombreMedicamentosPuntuacionMayorA(Double puntuacion){
		return this.lista.stream().
				filter(x->x.getPuntuacion()>puntuacion)
				.collect(Collectors.mapping(Medicamento::getNombreMedicamento, Collectors.toList()));
	}
	
	public String nombreMedicamentoMayorIndiceSomaticoSegunTipoMedicamento(TipoMedicamento m) {
		String res = "";
		try {
			res = this.lista.stream().
					filter(x->x.getTipoMedicamento().equals(m))
					.max(Comparator.comparing(Medicamento::getIndiceSomatico))
					.get().getNombreMedicamento();
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		return res;
	
	}
	
	public Map<TipoMedicamento, Double> agrupaTipoMedicamentoSegunPuntuacionMedia(){
		return this.lista.stream().
				collect(Collectors.groupingBy(x->x.getTipoMedicamento(), Collectors.averagingDouble(x->x.getPuntuacion())));
	}
	
	public LocalDate fechaCatalogoMasFrecuente() {
		Map<LocalDate, Long> m= this.lista.stream().
				collect(Collectors.groupingBy(Medicamento::getFechaCatalogo, Collectors.counting()));
		
		return m.entrySet().stream().max(Comparator.comparing(x->x.getValue())).get().getKey(); 
	}

}
