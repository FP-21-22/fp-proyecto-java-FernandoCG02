package fp.vacunas.test;

import fp.vacunas.Vacunacion;

public class VacunacionTest {

	public static void main(String[] args) {
		Vacunacion nueva = Vacunacion.parse("04/01/2021;Andaluc�a;140295;0;0;0;0");
		System.out.println(nueva);

	}

}
