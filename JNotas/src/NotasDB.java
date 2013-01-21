import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class NotasDB {
	public static void save(String strNota) throws IOException {
		FileWriter f = new FileWriter("Notas.txt", true);
		f.write(strNota);
		f.close();
	}
	
	public static String[] get(int id) throws IOException {
		FileReader f = new FileReader("Notas.txt");
		Scanner s = new Scanner(f);
		String line;
		String[] campos;
		
		do {
			line = s.nextLine();
			campos = line.split(";");
		} while ((s.hasNext()) && (Integer.parseInt(campos[0]) != id));
		
		s.close();
		if (Integer.parseInt(campos[0]) != id)
			throw new IOException("getNota: id(" + id + ") not found!!!");
		
			
		return campos;
	}
}
