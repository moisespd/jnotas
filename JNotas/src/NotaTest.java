import static org.junit.Assert.*;
import java.io.IOException;
import org.junit.Test;

public class NotaTest {

	@Test
	public void testGuardarEnFichero() {
		// Vaciamos la base de datos de notas
		Nota nota = new Nota();
		Nota nota2 = new Nota();
		
		nota.setId(100);
		nota.setTitulo("Título: Nota 100");
		nota.setDescripcion("Descripción: Nota 100");
		nota.setPrioridad(nota.getId());
		fail("testGuardarEnFichero");
	}


}
