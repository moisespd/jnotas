package model;

// #region Imports


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;



// #endregion

public class Carpeta extends BussinessObject {
	
	// #region Atributos
	
	private int idCarpetaPadre;
	private String titulo;
	
	// #endregion

	// #region Getters/Setters
	
	// ----------------------------------------------------------------------------------
	public void setId(int id) {
		this.id = id;
	}
	// ----------------------------------------------------------------------------------
	public int getIdCarpetaPadre() {
		return idCarpetaPadre;
	}
	// ----------------------------------------------------------------------------------
	public void setIdCarpetaPadre(int idCarpetaPadre) {
		this.idCarpetaPadre = idCarpetaPadre;
	}
	// ----------------------------------------------------------------------------------
	public String getTitulo() {
		return titulo;
	}
	// ----------------------------------------------------------------------------------
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	// ----------------------------------------------------------------------------------
	
	// #endregion

	// #region Constructor

	public Carpeta() {
		super();
		this.id = -1;
		this.idCarpetaPadre = -1;
		this.titulo = new String();
	}
	// ----------------------------------------------------------------------------------
	public Carpeta(int idCarpetaPadre) {
		this();
		this.idCarpetaPadre = idCarpetaPadre;
	}
	
	// #endregion

	// #region Sobrecarga de object

	public String toString() {
		return this.titulo + " (id." + String.valueOf(this.id) + ")";  
	
	}
	// ----------------------------------------------------------------------------------
	public boolean equals(Carpeta c) {
		if ((this.id != c.getId()) ||
			(! this.titulo.equals(c.getTitulo())) ||
			(this.idCarpetaPadre != c.getIdCarpetaPadre()))
			return false;
		
		return true;
	}
	
	// #endregion

	// #region Métodos auxiliares
	
	// #endregion
	
	// #region Métodos públicos
	
	// #endregion 
	
	// #region Reglas de validación
	
	// #endregion
	
	// #region Acceso a datos
	
	public void save() throws Exception {
		String sql;
		ResultSet rs;
		Connection conn;
		
		if (this.isNew) {
			sql = JNO_P_CarpetaInsert();
		}
		else {
			sql = JNO_P_CarpetaUpdate();
		}
		
		conn = DAL.devuelveConexionAbierta();
		DAL.executeNonQuery(conn, sql);
		
		if (this.isNew) {
			rs = DAL.executeQuery(conn, "select LAST_INSERT_ID()");
			if (rs.next()) {
				this.id = rs.getInt(1);
			}
			rs.close();
		}
		conn.close();
		this.isNew = false;
	}
	
	// ----------------------------------------------------------------------------------
	public void delete() throws Exception {
		String sql;
		
		sql = JNO_P_CarpetaDelete();
		DAL.executeNonQuery(sql);
	}
	// ----------------------------------------------------------------------------------
	public void get(int id) throws Exception {
		Connection conn = DAL.devuelveConexionAbierta();
		String sql = JNO_P_CarpetaGet(id);
		ResultSet rs = DAL.executeQuery(conn, sql);
		if (rs.next()) {
			cargarRecordset(rs);
		}
		rs.close();
		conn.close();
		
		this.isNew = false;
	}
	// ----------------------------------------------------------------------------------
	public void cargarRecordset(ResultSet rs) throws SQLException {
		this.id = rs.getInt("id");
		this.idCarpetaPadre = rs.getInt("idCarpetaPadre");
		this.titulo = rs.getString("titulo");
	}
	
	// #endregion

	// #region Procedimientos almacenados
	
	private String JNO_P_CarpetaInsert() {
		String sql;
		
		sql = 
				"insert into Carpetas (" +
				"	idCarpetaPadre, " +
				"	titulo " +
				") " +
				"values (" +
					String.valueOf(this.idCarpetaPadre) + ", " +
					"'" + this.titulo + "' " +
				"); ";
				
		return sql;
	}
	
	// ----------------------------------------------------------------------------------
	private String JNO_P_CarpetaUpdate() {
		String sql;
		
		sql = 
				"update Carpetas set " +
				"	idCarpetaPadre = " + String.valueOf(this.idCarpetaPadre) + ", " +
				"	titulo = '" + this.titulo + "' " +
				"where id = " + String.valueOf(this.id) + "; ";
		return sql;
	}
	
	// ----------------------------------------------------------------------------------
	private String JNO_P_CarpetaGet(int id) {
		String sql;
		
		sql = new String(
				"select " +
				"	* " +
				"from Carpetas " + 
				"where id = " + String.valueOf(id));
				
		return sql;
	}
	// ----------------------------------------------------------------------------------
	private String JNO_P_CarpetaDelete() {
		String sql;
		
		sql = new String("delete from Carpetas where id = " + String.valueOf(id));
		return sql;
	}
	// ----------------------------------------------------------------------------------
	
	// #endregion
}
