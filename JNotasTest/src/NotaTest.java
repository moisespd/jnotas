import model.Nota;

import org.junit.Test;

public class NotaTest {

	@Test
	public void testGuardarEnFichero() {
		// Vaciamos la base de datos de notas
		Nota nota = new Nota();
		
		nota.setId(100);
		nota.setTitulo("Título: Nota 100");
		nota.setDescripcion("Descripción: Nota 100");
		nota.setPrioridad(nota.getId());
	}


}
