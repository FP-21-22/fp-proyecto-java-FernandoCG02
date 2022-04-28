package fp.vacunas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class FactoriaVacunacion {
	public static List<Vacunacion> leeFichero(String nombreFichero) {
		List<Vacunacion> res = new ArrayList<>();
		List<String> aux;
		try {
			aux = Files.readAllLines(Paths.get(nombreFichero));
			int cont = 0;
			for(String e:aux) {
				if(cont>0) {
					Vacunacion v = Vacunacion.parse(e);
					res.add(v);
				}
				cont++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return res;
		
	}

}
