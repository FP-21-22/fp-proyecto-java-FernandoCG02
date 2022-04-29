package fp.clinico.test;

import fp.clinico.EstudioClinicoBucles;

public class TestEstudioClinicoBucles {

	public static void main(String[] args) {
		EstudioClinicoBucles e = new EstudioClinicoBucles();
		System.out.println(e.leeFichero("data/estudio_clinico.csv"));
//		System.out.println(e.of("data/estudio_clinico.csv"));
	}

}
