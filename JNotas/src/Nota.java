import java.util.Date;

public class Nota {
	// ##################################################################################
	// ##################################################################################
	// ##################################################################################
	// ATRIBUTOS
	// ##################################################################################
	// ##################################################################################
	// ##################################################################################

	private int id;
	private int idCarpeta;
	private String titulo;
	private String descripcion;
	private Date fechaCreacion;
	private Date fechaInicio;
	private Date fechaFin;
	private int prioridad;

	// ##################################################################################
	// ##################################################################################
	// ##################################################################################
	// GETTERS/SETTERS
	// ##################################################################################
	// ##################################################################################
	// ##################################################################################
	public int getId() {
		return id;
	}

	public int getIdCarpeta() {
		return idCarpeta;
	}
	
	public void setIdCarpeta(int idCarpeta) {
		this.idCarpeta = idCarpeta;
	}

	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
		
	public Date getFechaInicio() {
		return fechaInicio;
	}
	
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	public Date getFechaFin() {
		return fechaFin;
	}
	
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}	

	public int getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}
	// ##################################################################################
	// ##################################################################################
	// ##################################################################################
	// CONSTRUCTOR
	// ##################################################################################
	// ##################################################################################
	// ##################################################################################
	public Nota(int idCarpeta) {
		this.id = -1;
		this.idCarpeta = idCarpeta;
		this.fechaCreacion = new Date();
	}
	// ##################################################################################
	// ##################################################################################
	// ##################################################################################
	// ???
	// ##################################################################################
	// ##################################################################################
	// ##################################################################################
}
