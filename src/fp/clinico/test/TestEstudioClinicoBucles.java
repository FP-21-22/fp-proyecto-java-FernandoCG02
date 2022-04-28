package fp.clinico.test;

import fp.clinico.EstudioClinicoBucles;

public class TestEstudioClinicoBucles {

	public static void main(String[] args) {
		EstudioClinicoBucles e = new EstudioClinicoBucles();
		Prueba(e);
//		Prueba2(e);

	}
	private static void Prueba(EstudioClinicoBucles estudio) {
		System.out.println(estudio.leeFichero("data/estudio_clinico.csv"));
	}
	private static void Prueba2(EstudioClinicoBucles estudio2) {
		System.out.println(estudio2.of("data/estudio_clinico.csv"));
	}

}
