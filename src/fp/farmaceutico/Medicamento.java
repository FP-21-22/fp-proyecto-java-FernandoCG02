package fp.farmaceutico;

import java.time.LocalDate;
import java.util.Objects;

import fp.utiles.Checkers;

public class Medicamento implements Comparable<Medicamento>{
	private String nombreMedicamento;
	private TipoMedicamento tipoMedicamento;
	private String codigoEnfermedad;
	private String farmaceutica;
	private Double puntuacion;
	private Integer indiceSomatico;
	private LocalDate fechaCatalogo;	
	
	public Boolean tratarEnfermedad(String codigo) {
		return codigoEnfermedad==codigo;
	}
	
	public Medicamento(String nombreMedicamento, TipoMedicamento tipoMedicamento, String codigoEnfermedad,
			String farmaceutica, Double puntuacion, Integer indiceSomatico, LocalDate fechaCatalogo) {
		Checkers.check("La puntación tiene que ser mayor estricta que cero", puntuacion > 0);
		Checkers.check("El índice somático tiene que ser mayor o igual que 1000", indiceSomatico >= 1000);
		Checkers.check("La fecha de catálogo tiene que ser posterior al 01/01/2015", 
				fechaCatalogo.isAfter(LocalDate.of(2015,01,01)));
		this.nombreMedicamento = nombreMedicamento;
		this.tipoMedicamento = tipoMedicamento;
		this.codigoEnfermedad = codigoEnfermedad;
		this.farmaceutica = farmaceutica;
		this.puntuacion = puntuacion;
		this.indiceSomatico = indiceSomatico;
		this.fechaCatalogo = fechaCatalogo;
	}




	public LocalDate getFechaCatalogo() {
		return fechaCatalogo;
	}


	public void setFechaCatalogo(LocalDate fechaCatalogo) {
		this.fechaCatalogo = fechaCatalogo;
	}


	public String getNombreMedicamento() {
		return nombreMedicamento;
	}


	public TipoMedicamento getTipoMedicamento() {
		return tipoMedicamento;
	}


	public String getCodigoEnfermedad() {
		return codigoEnfermedad;
	}


	public String getFarmaceutica() {
		return farmaceutica;
	}


	public Double getPuntuacion() {
		return puntuacion;
	}


	public Integer getIndiceSomatico() {
		return indiceSomatico;
	}

	@Override
	public String toString() {
		return "Medicamento [nombreMedicamento=" + nombreMedicamento + ", farmaceutica=" + farmaceutica + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(farmaceutica, nombreMedicamento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medicamento other = (Medicamento) obj;
		return Objects.equals(farmaceutica, other.farmaceutica)
				&& Objects.equals(nombreMedicamento, other.nombreMedicamento);
	}

	@Override
	public int compareTo(Medicamento o) {
		Integer res = nombreMedicamento.compareTo(o.nombreMedicamento);
		if (res == 0) {
			res = farmaceutica.compareTo(o.farmaceutica);
		}
		return res;
	}
	
	
	

}
