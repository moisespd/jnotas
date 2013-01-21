import static org.junit.Assert.*;
import java.io.IOException;
import org.junit.Test;

public class NotaTest {

	@Test
	public void testGuardarEnFichero() {
		// Vaciamos la base de datos de notas
		NotasDB.purge();
		Nota nota = new Nota();
		Nota nota2 = new Nota();
		
		nota.setId(100);
		nota.setTitulo("Título: Nota 100");
		nota.setDescripcion("Descripción: Nota 100");
		nota.setPrioridad(nota.getId());
		try {
			nota.save();
			nota2.get(100);

			if (! nota.equals(nota2))
				fail("testGuardarEnFichero");
		}
		catch (IOException e) {
			fail("testGuardarEnFichero: EXCEPCION!!!");
		}
	}


}
