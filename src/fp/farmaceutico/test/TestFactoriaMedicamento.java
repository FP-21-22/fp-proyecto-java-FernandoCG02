package fp.farmaceutico.test;

import java.util.List;

import fp.farmaceutico.FactoriaMedicamento;
import fp.farmaceutico.Medicamento;

public class TestFactoriaMedicamento {

	public static void main(String[] args) {
		// 
//		System.out.println(FactoriaMedicamento.leeFichero("data/medicamentos.csv"));
		String ruta = "data/medicamentos.csv";
		List<Medicamento> lista = FactoriaMedicamento.leeFichero(ruta);
		for(Medicamento m:lista) {
			System.out.println(m);
		}

	}

}
