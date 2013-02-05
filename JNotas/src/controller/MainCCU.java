package controller;

import model.Nota;
import view.ButtonEvent;
import view.ButtonListener;
import view.MainFrm;
import view.NotaSelPaneEvent;
import view.NotaSelPaneEvent.TipoAccion;


public class MainCCU implements ButtonListener, SeleccionarNotaCCUListener {
	
	// #region Objetos de negocio
	
	// #endregion
	
	// #region Vista

	MainFrm miVista = new MainFrm();
	
	// #endregion

	// #region Controladoras de extensión
	
	CrearEditarNotaCCU crearEditarNotaCCU;
	
	// #endregion
	
	// #region Controladoras de inclusión
	
	SeleccionarNotaCCU seleccionarNotaCCU = new SeleccionarNotaCCU();
	MostrarNotaCCU mostrarNotaCCU = new MostrarNotaCCU();
	
	// #endregion
	
	// #region Constructor
	
	public MainCCU() {
		seleccionarNotaCCU.addListener(this);
		miVista.addListener(this);
	}
	
	// #endregion
	
	// #region Métodos de CCU
	
	public void iniciar() {
		try {
			seleccionarNotaCCU.iniciar();
			miVista.setNotaSelPane(seleccionarNotaCCU.getVista());
			miVista.setNotaDataPane(mostrarNotaCCU.getVista());
			miVista.mostrar(true);
		} 
		catch (Exception e) {
		   e.printStackTrace();
		}
	}
	
	// #endregion
	
	// #region Gestión de eventos de las CCU incluidas
	
	public void notaClick(NotaSelPaneEvent ev) {
		if (ev.getTipoAccion() == TipoAccion.SIMPLE_CLICK)
			mostrarNotaCCU.iniciar(ev.getIdNota());
		else if (ev.getTipoAccion() == TipoAccion.DOUBLE_CLICK)
			editarNota();
	}

	// #endregion

	// #region Gestión de eventos de su vista

	private void borrarSelectedNota() { 
		Nota n = new Nota();
		try {
			n.get(seleccionarNotaCCU.getIdSelectedNota());
			n.delete();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		seleccionarNotaCCU.reiniciar();
	}
	// -------------------------------------------------------------------------------------
	private void crearNuevaNota() {
		crearEditarNotaCCU = new CrearEditarNotaCCU(this.miVista);
		crearEditarNotaCCU.iniciar();
		
		// Cuando termine la controladora anterior, refrescamos la de seleccionar 
		// para que aparezca la nueva
		seleccionarNotaCCU.reiniciar();
	}
	// -------------------------------------------------------------------------------------
	private void editarNota() {
		Nota nota = new Nota();
		try {
			nota.get(seleccionarNotaCCU.getIdSelectedNota());
			
			crearEditarNotaCCU = new CrearEditarNotaCCU(this.miVista);
			crearEditarNotaCCU.setNota(nota);
			crearEditarNotaCCU.iniciar();
			
			// Cuando termine la controladora anterior, refrescamos la de seleccionar 
			// para que aparezca la nueva
			seleccionarNotaCCU.reiniciar();
		}
		catch (Exception e) {
		}
	}
	// -------------------------------------------------------------------------------------
	public void buttonClick(ButtonEvent ev) {
		switch (ev.getButtonName()) {
			case "Borrar":
				borrarSelectedNota();
				break;
			case "Nuevo":
				crearNuevaNota();
				break;
			case "Editar":
				editarNota();
				break;
		}
	}
	// #endregion
}

