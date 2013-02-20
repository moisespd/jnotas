package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class NotasList {

	// #region Atributos
	
	ArrayList<Nota> list = new ArrayList<Nota>();
	
	// #endregion

	// #region Sobrecarga de Object

	// ---------------------------------------------------------------------------------------------------
	public int size() {
		return list.size();
	}
	// ---------------------------------------------------------------------------------------------------
	public String toString() {
		Nota n;
		String result;
		
		result = "";
		
		for (int i = 0; i < list.size(); i++) {
			n = list.get(i);
			result += n.toString() + "\n";
		}
		
		return result;
	}
	// ---------------------------------------------------------------------------------------------------
	public Nota getNota(int i) {
		return list.get(i);
	}
	
	// ---------------------------------------------------------------------------------------------------
	
	// #endregion

	// #region Acceso a datos
	
	// ---------------------------------------------------------------------------------------------------
	// Carga absolutamente todas las notas de la base de datos, sin tener en cuenta la carpeta contenedora
	// ---------------------------------------------------------------------------------------------------
	public void get() throws Exception {
		this.get(-1);
	}
	
	// ---------------------------------------------------------------------------------------------------
	public void get(int idCarpeta) throws Exception {
		Connection conn = DAL.devuelveConexionAbierta();
		String sql = JNO_P_NotasGet(idCarpeta);
		ResultSet rs = DAL.executeQuery(conn, sql);
		cargarRecordset(rs);
		rs.close();
		conn.close();
	}
	// ---------------------------------------------------------------------------------------------------
	public void get(String texto) throws Exception {
		Connection conn = DAL.devuelveConexionAbierta();
		String sql = JNO_P_NotasGet_byTexto(texto);
		ResultSet rs = DAL.executeQuery(conn, sql);
		cargarRecordset(rs);
		rs.close();
		conn.close();
	}
	// ---------------------------------------------------------------------------------------------------
	private void cargarRecordset(ResultSet rs) throws Exception {
		while (rs.next()) {
			Nota n = new Nota();
			n.cargarRecordset(rs);
			
			this.list.add(n);
		}
		
	}
	// ---------------------------------------------------------------------------------------------------
	
	// #endregion
	
	// #region Procedimientos almacenados
	
	private String JNO_P_NotasGet(int idCarpeta) {
		String sql;
		
		sql =  new String(
				"select " +
				"	* " +
				"from Notas ");
				
		if (idCarpeta > 0)
			sql.concat("where idCarpeta = " + idCarpeta + " ");
		
		sql.concat("order by id ");
				
		return sql;
	}

	// ----------------------------------------------------------------------------
	private String JNO_P_NotasGet_byTexto(String texto) {
		String sql;
		
		sql =  new String(
				"select " +
				"	* " +
				"from Notas " +
				"where " +
				"	titulo like '%" + texto + "%' " +
				"	or descripcion like '%" + texto + "%' ");
				
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

