package fp.clinico.test;

import fp.clinico.PacienteEstudio;

public class PacienteEstudioTest {
	public static void main(String[] args) {
		PacienteEstudio nueva = PacienteEstudio.parse("6306;Male;80;false;false;URBANA;83.84");
		System.out.println(nueva);

	}

}
