package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CarpetasList {

	// #region Atributos
	
	ArrayList<Carpeta> list = new ArrayList<Carpeta>();
	
	// #endregion

	// #region Sobrecarga de Object

	// ---------------------------------------------------------------------------------------------------
	public int size() {
		return list.size();
	}
	// ---------------------------------------------------------------------------------------------------
	public String toString() {
		Carpeta n;
		String result;
		
		result = "";
		
		for (int i = 0; i < list.size(); i++) {
			n = list.get(i);
			result += n.toString() + "\n";
		}
		
		return result;
	}
	// ---------------------------------------------------------------------------------------------------
	public Carpeta getCarpeta(int i) {
		return list.get(i);
	}
	
	// ---------------------------------------------------------------------------------------------------
	
	// #endregion

	// #region Acceso a datos
	
	// ---------------------------------------------------------------------------------------------------
	// Carga absolutamente todas las Carpetas de la base de datos, sin tener en cuenta la carpeta contenedora
	// ---------------------------------------------------------------------------------------------------
	public void get() throws Exception {
		Connection conn = DAL.devuelveConexionAbierta();
		String sql = JNO_P_CarpetasGet();
		ResultSet rs = DAL.executeQuery(conn, sql);
		cargarRecordset(rs);
		rs.close();
		conn.close();
	}
	
	// ---------------------------------------------------------------------------------------------------
	public void get(String texto) throws Exception {
		Connection conn = DAL.devuelveConexionAbierta();
		String sql = JNO_P_CarpetasGet_byTexto(texto);
		ResultSet rs = DAL.executeQuery(conn, sql);
		cargarRecordset(rs);
		rs.close();
		conn.close();
	}
	// ---------------------------------------------------------------------------------------------------
	private void cargarRecordset(ResultSet rs) throws Exception {
		while (rs.next()) {
			Carpeta n = new Carpeta();
			n.cargarRecordset(rs);
			
			this.list.add(n);
		}
		
	}
	// ---------------------------------------------------------------------------------------------------
	
	// #endregion
	
	// #region Procedimientos almacenados
	
	private String JNO_P_CarpetasGet() {
		String sql;
		
		sql =  new String(
				"select " +
				"	* " +
				"from Carpetas " +
				"order by id ");
				
		return sql;
	}

	// ----------------------------------------------------------------------------
	private String JNO_P_CarpetasGet_byTexto(String texto) {
		String sql;
		
		sql =  new String(
				"select " +
				"	* " +
				"from Carpetas " +
				"where " +
				"	titulo like '%" + texto + "%' ");
				
		if (Util.isInteger(texto))
			sql += 
				"	or id = " + String.valueOf(texto) + " ";
				
		sql +=
				"order by titulo ";
				
		return sql;
	}
	// ----------------------------------------------------------------------------
	
	// #endregion
	
}

