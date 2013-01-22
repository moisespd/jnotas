import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		Nota nota = new Nota();
		try {
			nota.save();
			System.out.println(nota.toString());
		} 
		catch (IOException e) {
			System.out.println("Error accediendo al fichero de notas (" + e.getMessage() + ")");
		}
	}
}
