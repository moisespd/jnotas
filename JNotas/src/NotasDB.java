import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class NotasDB {
	static String dbFileName = "Notas.txt";
	
	// ----------------------------------------------------------------------------
	public static int newId() {
		String[] campos;
		int maxId = 0;
		int id;
		try {
			FileReader f = new FileReader(NotasDB.dbFileName);
			Scanner s = new Scanner(f);
			String line;

			
			do {
				line = s.nextLine();
				campos = line.split(";");
				id = Integer.parseInt(campos[0]); 
				if (id > maxId)
					maxId = id; 
			} while (s.hasNext());
			
			s.close();
		}
		catch (IOException e) {
		}
		
		return maxId + 1;
		
	}
	// ----------------------------------------------------------------------------------
	public static void purge() {
		File f = new File(dbFileName);
		f.delete();
	}
	// ----------------------------------------------------------------------------------
	public static void save(String strNota) throws IOException {
		FileWriter f = new FileWriter(NotasDB.dbFileName, true);
		f.write(strNota);
		f.close();
	}
	// ----------------------------------------------------------------------------------
	public static String[] get(int id) throws IOException {
		FileReader f = new FileReader(NotasDB.dbFileName);
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
	// ----------------------------------------------------------------------------------
}