public class Main {
	public static void main(String[] args) {
		Nota nota = new Nota();
		nota.setTitulo("Nota de prueba");
		nota.setDescripcion("Esto es simplemente una nota de prueba");
		nota.setPrioridad(100);
		System.out.println(nota.toString());
		
	}
}
