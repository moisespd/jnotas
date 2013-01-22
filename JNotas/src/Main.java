public class Main {
	public static void main(String[] args) {
		Nota nota;
		try {
			FrmNota frame = new FrmNota();
			frame.setVisible(true);
			nota = new Nota();
			nota.get(100);
			frame.setNota(nota);
		} 
		catch (Exception e) {
			System.out.println("Error!!!");
		}
	}
}
