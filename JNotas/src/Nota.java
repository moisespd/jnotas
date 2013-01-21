import java.util.Date;
import java.io.IOException;

public class Nota extends BussinessObject {
	// ##################################################################################
	// ##################################################################################
	// ##################################################################################
	// ATRIBUTOS
	// ##################################################################################
	// ##################################################################################
	// ##################################################################################

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
	public void setId(int id) {
		this.id = id;
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
	public Nota() {
		super();
		this.id = -1;
		this.idCarpeta = -1;
		this.fechaCreacion = new Date();
		this.fechaInicio = new Date();
		this.fechaFin = new Date();
		this.titulo = new String("Nueva nota (" + String.valueOf(this.id) + ")");
		this.descripcion = new String("");
	}
	public Nota(int idCarpeta) {
		this();
		this.idCarpeta = idCarpeta;
	}
	// ##################################################################################
	// ##################################################################################
	// ##################################################################################
	// SOBRECARGA DE OBJECT
	// ##################################################################################
	// ##################################################################################
	// ##################################################################################
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
	// ##################################################################################
	// ##################################################################################
	// ##################################################################################
	// VALIDACIÓN
	// ##################################################################################
	// ##################################################################################
	// ##################################################################################
	
	// ##################################################################################
	// ##################################################################################
	// ##################################################################################
	// ACCESO A DATOS
	// ##################################################################################
	// ##################################################################################
	// ##################################################################################
	
	public void save() throws IOException {
		String strNota = JNO_P_NotaCreate();
		NotasDB.save(strNota);
	}
	
	// ----------------------------------------------------------------------------------
	public void get(int id) throws IOException {
		String[] rs = NotasDB.get(id);
		cargarRecordset(rs);
	}
	// ----------------------------------------------------------------------------------
	private void cargarRecordset(String[] rs) {
		this.id = Integer.parseInt(rs[0]);
		this.idCarpeta = Integer.parseInt(rs[1]);
		this.titulo = new String(rs[2]);
		this.descripcion = new String(rs[3]);
		this.prioridad = Integer.parseInt(rs[4]);
	}
	// ##################################################################################
	// ##################################################################################
	// ##################################################################################
	// PROCEDIMIENTOS ALMACENADOS
	// ##################################################################################
	// ##################################################################################
	// ##################################################################################
	private String JNO_P_NotaCreate() {
		String strNota;
		
		strNota = new String(
				String.valueOf(this.id) + ";" +
				String.valueOf(this.idCarpeta) + ";" + 
				this.titulo + ";" + 
				this.descripcion + ";" +
				String.valueOf(this.prioridad) + ";" +
				"\n");
		return strNota;
	}
	
	// ##################################################################################
}
