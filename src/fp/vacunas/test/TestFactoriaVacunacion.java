package fp.vacunas.test;

import java.util.List;

import fp.vacunas.FactoriaVacunacion;
import fp.vacunas.Vacunacion;

public class TestFactoriaVacunacion {

	public static void main(String[] args) {
		// 
//		System.out.println(FactoriaVacunacion.leeFichero("data/ccaa_vacunas_3.csv"));
		String ruta = "data/ccaa_vacunas_3.csv";
		List<Vacunacion> lista = FactoriaVacunacion.leeFichero(ruta);
		for(Vacunacion v:lista) {
			System.out.println(v);
		}

	}

}
