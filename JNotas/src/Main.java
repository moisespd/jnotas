import java.sql.*;

public class Main {
	public static void main(String[] args) {
		try {
		   Class.forName("com.mysql.jdbc.Driver");
		   
		   Connection conn = DriverManager.getConnection ("jdbc:mysql://localhost/jnotasdb","root", "teidetron");
		   Statement s = conn.createStatement(); 
		   ResultSet rs = s.executeQuery ("select * from Notas");
		   while (rs.next()) 
		   { 
		       System.out.println (rs.getInt (1) + " " + rs.getString (2)+ " " + rs.getDate(3)); 
		   }
		   s.close();
		   rs.close();
		   conn.close();
		   System.out.println("Funciona el driver!!!");
		} 
		catch (Exception e) {
		   e.printStackTrace();
		}
	}
}
