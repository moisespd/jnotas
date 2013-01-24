package model;
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
	public static void executeNonQuery(Connection conn, String sql) throws Exception {
		Statement s = conn.createStatement();
		s.executeUpdate(sql);
	}
	// ----------------------------------------------------------------------------------
	public static void executeNonQuery(String sql) throws Exception {
		Connection conn = DAL.devuelveConexionAbierta();
		DAL.executeNonQuery(conn, sql);
		conn.close();
	}
	// ----------------------------------------------------------------------------------
}
