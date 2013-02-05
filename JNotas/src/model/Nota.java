package model;

// #region Imports


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;



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
	private boolean resuelta;
	
	// #endregion

	// #region Getters/Setters
	
	// ----------------------------------------------------------------------------------
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
	// ----------------------------------------------------------------------------------
	public boolean getResuelta() {
		return this.resuelta;
	}
	// ----------------------------------------------------------------------------------
	public void setResuelta(boolean value) {
		resuelta = value;
	}
	// ----------------------------------------------------------------------------------
	
	// #endregion

	// #region Constructor

	public Nota() {
		super();
		this.id = -1;
		this.idCarpeta = -1;
		this.fechaCreacion = new Date();
		this.fechaInicio = new Date();
		this.fechaFin = new Date();
		this.titulo = new String();
		this.descripcion = new String();
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
			(this.prioridad != n.getPrioridad()) ||
			(this.fechaCreacion.compareTo(n.getFechaCreacion()) != 0) || 
			(this.fechaInicio.compareTo(n.getFechaInicio()) != 0) ||
			(this.fechaFin.compareTo(n.getFechaFin()) != 0) ||
			(this.idCarpeta != n.getIdCarpeta()))
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
			sql = JNO_P_NotaInsert();
		}
		else {
			sql = JNO_P_NotaUpdate();
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
		
		sql = JNO_P_NotaDelete();
		DAL.executeNonQuery(sql);
	}
	// ----------------------------------------------------------------------------------
	public void getLast() throws Exception {
		Connection conn = DAL.devuelveConexionAbierta();
		String sql = JNO_P_NotaGetLast();
		ResultSet rs = DAL.executeQuery(conn, sql);
		cargarRecordset(rs);
		rs.close();
		conn.close();
		
		this.isNew = false;
	}		
	// ----------------------------------------------------------------------------------
	public void get(int id) throws Exception {
		Connection conn = DAL.devuelveConexionAbierta();
		String sql = JNO_P_NotaGet(id);
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
		this.idCarpeta = rs.getInt("idCarpeta");
		this.titulo = rs.getString("titulo");
		this.descripcion = rs.getString("descripcion");
		this.prioridad = rs.getInt("prioridad");
		this.resuelta = rs.getBoolean("resuelta");
	}
	
	// #endregion

	// #region Procedimientos almacenados
	
	private String JNO_P_NotaInsert() {
		String sql;
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		sql = 
				"insert into Notas (" +
				"	idCarpeta, " +
				"	titulo, " +
				"	descripcion, " +
				"	prioridad, " +
				"	fechaCreacion, " +
				"	fechaInicio, " +
				"	fechaFin, " +
				"	resuelta " +
				") " +
				"values (" +
					String.valueOf(this.idCarpeta) + ", " +
					"'" + this.titulo + "', " +
					"'" + this.descripcion + "', " +
					String.valueOf(this.prioridad) + ", " +
					"'" + formato.format(fechaCreacion) + "', " +
					"'" + formato.format(fechaInicio) + "', " +
					"'" + formato.format(fechaFin) + "', " +
					this.resuelta + " " +
				"); ";
				
		return sql;
	}
	
	// ----------------------------------------------------------------------------------
	private String JNO_P_NotaUpdate() {
		String sql;
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		sql = 
				"update Notas set " +
				"	idCarpeta = " + String.valueOf(this.idCarpeta) + ", " +
				"	titulo = '" + this.titulo + "', " +
				"	descripcion = '" + this.descripcion + "', " +
				"	prioridad = '" + this.prioridad + "', " +
				"	fechaCreacion = '" + formato.format(fechaCreacion) + "', " +  
				"	fechaInicio = '" + formato.format(fechaInicio) + "', " +  
				"	fechaFin = '" + formato.format(fechaFin) + "', " +
				"	resuelta = " + this.resuelta + " " +
				"where id = " + String.valueOf(this.id) + "; ";
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
	// ----------------------------------------------------------------------------------
	private String JNO_P_NotaGetLast() {
		String sql;
		
		sql =
				"select " +
				"	* " +
				"from Notas " + 
				"order by id desc " +
				"limit 0, 1";
		
		return sql;
	}
	// ----------------------------------------------------------------------------------
	private String JNO_P_NotaDelete() {
		String sql;
		
		sql = new String("delete from Notas where id = " + String.valueOf(id));
		return sql;
	}
	// ----------------------------------------------------------------------------------
	
	// #endregion
}
