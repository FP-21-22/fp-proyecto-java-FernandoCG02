package fp.farmaceutico.test;

import fp.farmaceutico.FactoriaMedicamento;
import fp.farmaceutico.Medicamento;

public class FactoriaMedicamentoTest {

	public static void main(String[] args) {
		Medicamento m1 = FactoriaMedicamento.parseaMedicamento("efavirenz,ANATOMICO,Y212XXA,Actavis Mid Atlantic LLC,90.0,1848,04/12/2019");
		System.out.println(m1);
		
	}

}
