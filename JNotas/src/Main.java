public class Main {
	public static void main(String[] args) {
		try {
		   Nota n = new Nota();
		   NotaFrm notaFrame = new NotaFrm();
		   
		   n.get(2);
		   notaFrame.setNota(n);
		   notaFrame.setVisible(true);
		} 
		catch (Exception e) {
		   e.printStackTrace();
		}
	}
}



