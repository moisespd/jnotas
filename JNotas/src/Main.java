import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		Nota nota = new Nota();
		nota.setTitulo("Nota de prueba");
		nota.setDescripcion("Esto es simplemente una nota de prueba");
		nota.setPrioridad(100);
		System.out.println(nota.toString());
		try {
			nota.Save();
		} 
		catch (IOException e) {
			System.out.println("Error guardando la nota");
		}
	}
}
