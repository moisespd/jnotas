public class Main {
	public static void main(String[] args) {
		try {
		   Nota n = new Nota();
		   n.get(1);
		   System.out.println(n.toString());
		} 
		catch (Exception e) {
		   e.printStackTrace();
		}
	}
}



