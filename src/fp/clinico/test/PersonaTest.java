package fp.clinico.test;


import fp.clinico.Persona;

public class PersonaTest {
	public static void main(String[] args) {
		Persona nueva = Persona.parse("Juan, Garc�a Rodr�guez, 12755078Z, 20/03/1965");
		System.out.println(nueva);

	}

}
