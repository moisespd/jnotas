package model;
class BussinessObject {
	// ##################################################################################
	// ##################################################################################
	// ##################################################################################
	// ATRIBUTOS
	// ##################################################################################
	// ##################################################################################
	// ##################################################################################
	protected int id;
	
	protected boolean isValid;
	protected boolean isNew;
	protected boolean isDirty;
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
	// ----------------------------------------------------------------------------------
	protected void setPropertyChanged() {
		this.isDirty = true;
	}
	// ----------------------------------------------------------------------------------
	public boolean isValid() {
		return isValid;
	}
	// ----------------------------------------------------------------------------------
	public boolean isNew() {
		return isNew;
	}
	// ----------------------------------------------------------------------------------
	public boolean isDirty() {
		return isDirty;
	}

	// ##################################################################################
	// ##################################################################################
	// ##################################################################################
	// CONSTRUCTOR
	// ##################################################################################
	// ##################################################################################
	// ##################################################################################
	public BussinessObject() {
		this.isValid = false;
		this.isNew = true;
		this.isDirty = false;
	}
	// ##################################################################################
	// ##################################################################################
	// ##################################################################################
	// SOBRECARGA DE OBJECT
	// ##################################################################################
	// ##################################################################################
	// ##################################################################################
	// ##################################################################################
	public String toString() {
		return String.valueOf(this.id);
	}
	
	// ##################################################################################
	// ##################################################################################
	// ACCESO A DATOS
	// ##################################################################################
	// ##################################################################################
	// ##################################################################################

	public void save() throws Exception {
		throw new Exception("Método no implementado!");
	}
	// ----------------------------------------------------------------------------------
	public void get(int id) throws Exception {
		throw new Exception("Método no implementado!");
	}
	// ##################################################################################
	// ##################################################################################
	// ##################################################################################
	// ???
	// ##################################################################################
	// ##################################################################################
	// ##################################################################################
	
}