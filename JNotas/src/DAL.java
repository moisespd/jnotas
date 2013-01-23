import java.sql.*;

public class DAL {
	// ----------------------------------------------------------------------------------
	public static Connection devuelveConexionAbierta() {
		try {
			Connection conn = DriverManager.getConnection ("jdbc:mysql://localhost/jnotasdb","root", "teidetron");
			return conn;
		}
		catch (Exception e) {
			   e.printStackTrace();
		}
	   return null;
	}
	// ----------------------------------------------------------------------------------
	public static ResultSet executeQuery(Connection conn, String sql) throws Exception {
		ResultSet rs;
		
		Statement s = conn.createStatement();
		rs = s.executeQuery(sql);

		return rs;
	}
	// ----------------------------------------------------------------------------------
}
