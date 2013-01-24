import model.Nota;
import static org.junit.Assert.*;

import org.junit.Test;

public class NotaTest {

	// ------------------------------------------------------------------------------------
	@Test
	public void testGuardarNotaEnBD() {
		Nota nota = new Nota();
		Nota nota2 = new Nota();
		
		nota.setTitulo("TEST: titulo");
		nota.setDescripcion("TEST: descripcion");
		nota.setPrioridad(-99);
		
		try {
			nota.save();
			nota2.get(nota.getId());
			
			if (! nota.equals(nota2))
				fail("testSave(): al recuperar la nota de BD algunos campos NO se guardaron bien");
		}
		catch (Exception e) {
			fail("testSave(): Excepción!!!");
		}
	}
	// ------------------------------------------------------------------------------------


}
