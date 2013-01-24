public class Main {
	public static void main(String[] args) {
		try {
		   Nota n = new Nota();
		   NotaFrm notafrm = new NotaFrm();
		   
		   n.getLast();
		   notafrm.setNota(n);
		   notafrm.setVisible(true);
		} 
		catch (Exception e) {
		   e.printStackTrace();
		}
	}
}



