package fp.farmaceutico;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class FactoriaMedicamento {
	public static Medicamento parseaMedicamento(String s) {
		String[] partes = s.split(",");
		String nombreMedicamento = partes[0].trim();
		TipoMedicamento tipoMedicamento = TipoMedicamento.valueOf(partes[1].trim());
		String codigoEnfermedad = partes[2].trim();
		String farmaceutica = partes[3].trim();
		Double puntuacion = Double.valueOf(partes[4].trim());
		Integer indiceSomatico = Integer.valueOf(partes[5].trim());
		LocalDate fechaCatalogo = LocalDate.parse(partes[6].trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		return new Medicamento(nombreMedicamento, tipoMedicamento, codigoEnfermedad, farmaceutica, puntuacion, indiceSomatico, fechaCatalogo);
	}
	
	public static List<Medicamento> leeFichero(String nombreFichero) {
		List<Medicamento> res = new ArrayList<>();
		try {
			List<String> aux = Files.readAllLines(Paths.get(nombreFichero));
			for(String e:aux) {
				Medicamento m = parseaMedicamento(e);
				res.add(m);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return res;
		
	}

}
