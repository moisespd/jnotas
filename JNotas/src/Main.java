public class Main {
	public static void main(String[] args) {
		try {
		   Nota n = new Nota();
		   
		   n.get(3);
		   n.setTitulo(n.getTitulo() + "b");
		   n.setDescripcion(n.getDescripcion() + "b");
		   n.save();
		} 
		catch (Exception e) {
		   e.printStackTrace();
		}
	}
}



