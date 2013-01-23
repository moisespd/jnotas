// #region Imports

import java.util.Date;
import java.sql.*;

// #endregion

public class Nota extends BussinessObject {
	
	// #region Atributos
	
	private int idCarpeta;
	private String titulo;
	private String descripcion;
	private Date fechaCreacion;
	private Date fechaInicio;
	private Date fechaFin;
	private int prioridad;
	
	// #endregion

	// #region Getters/Setters
	
	public void setId(int id) {
		this.id = id;
	}
	// ----------------------------------------------------------------------------------
	public int getIdCarpeta() {
		return idCarpeta;
	}
	// ----------------------------------------------------------------------------------
	public void setIdCarpeta(int idCarpeta) {
		this.idCarpeta = idCarpeta;
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
	public String getDescripcion() {
		return descripcion;
	}
	// ----------------------------------------------------------------------------------
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	// ----------------------------------------------------------------------------------
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	// ----------------------------------------------------------------------------------
	public Date getFechaInicio() {
		return fechaInicio;
	}
	// ----------------------------------------------------------------------------------
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	// ----------------------------------------------------------------------------------
	public Date getFechaFin() {
		return fechaFin;
	}
	// ----------------------------------------------------------------------------------
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}	
	// ----------------------------------------------------------------------------------
	public int getPrioridad() {
		return prioridad;
	}
	// ----------------------------------------------------------------------------------
	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}
	
	
	// #endregion

	// #region Constructor

	public Nota() {
		super();
		this.id = NotasDB.newId();
		this.idCarpeta = -1;
		this.fechaCreacion = new Date();
		this.fechaInicio = new Date();
		this.fechaFin = new Date();
		this.titulo = new String("Nueva nota (" + String.valueOf(this.id) + ")");
		this.descripcion = new String("");
	}
	// ----------------------------------------------------------------------------------
	public Nota(int idCarpeta) {
		this();
		this.idCarpeta = idCarpeta;
	}
	
	// #endregion

	// #region Sobrecarga de object

	public String toString() {
		return 
				"[p." + String.valueOf(this.prioridad) + "] " +
				this.titulo + " (id." + String.valueOf(this.id) + ")";  
	
	}
	// ----------------------------------------------------------------------------------
	public boolean equals(Nota n) {
		if ((this.id != n.getId()) ||
			(! this.titulo.equals(n.getTitulo())) ||
			(! this.descripcion.equals(n.getDescripcion())) ||
			(this.prioridad != n.getPrioridad()))
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
		
		if (this.isNew) {
			sql = JNO_P_NotaInsert();
		}
		else {
			sql = JNO_P_NotaUpdate();
		}
		
		DAL.executeNonQuery(sql);
	}
	
	// ----------------------------------------------------------------------------------
	public void get(int id) throws Exception {
		Connection conn = DAL.devuelveConexionAbierta();
		String sql = JNO_P_NotaGet(id);
		ResultSet rs = DAL.executeQuery(conn, sql);
		cargarRecordset(rs);
		rs.close();
		conn.close();
		
		this.isNew = false;
	}
	// ----------------------------------------------------------------------------------
	private void cargarRecordset(ResultSet rs) throws SQLException {
		if (rs.next()) {
			this.id = rs.getInt("id");
			this.idCarpeta = rs.getInt("idCarpeta");
			this.titulo = rs.getString("titulo");
			this.descripcion = rs.getString("descripcion");
			this.prioridad = rs.getInt("prioridad");
		}
	}
	
	// #endregion

	// #region Procedimientos almacenados
	
	private String JNO_P_NotaInsert() {
		String sql;
		
		sql = 
				"insert into Notas (" +
				"	idCarpeta, " +
				"	titulo, " +
				"	descripcion, " +
				"	prioridad " +
				") " +
				"values (" +
					String.valueOf(this.idCarpeta) + ", " +
					"'" + this.titulo + "', " +
					"'" + this.descripcion + "', " +
					String.valueOf(this.prioridad) + 
				") ";
				
		return sql;
	}
	
	// ----------------------------------------------------------------------------------
	private String JNO_P_NotaUpdate() {
		String sql;
		
		sql = 
				"update Notas set " +
				"	idCarpeta = " + String.valueOf(this.idCarpeta) + ", " +
				"	titulo = '" + this.titulo + "', " +
				"	descripcion = '" + this.descripcion + "', " +
				"	prioridad = '" + this.prioridad + "' " +
				"where id = " + String.valueOf(this.id);
		return sql;
	}
	
	// ----------------------------------------------------------------------------------
	private String JNO_P_NotaGet(int id) {
		String sql;
		
		sql = new String(
				"select " +
				"	* " +
				"from Notas " + 
				"where id = " + String.valueOf(id));
				
		return sql;
	}
	
	// #endregion
}
