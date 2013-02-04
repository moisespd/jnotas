package controller;

import model.Nota;
import view.MainFrm;
import view.NotaSelPaneEvent;
import view.ToolbarEvent;
import view.ToolbarListener;


public class MainCCU implements ToolbarListener, SeleccionarNotaCCUListener {
	
	// #region Objetos de negocio
	
	
	// #endregion
	
	// #region Vista

	MainFrm miVista = new MainFrm();
	
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
		mostrarNotaCCU.iniciar(ev.getIdNota());
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
	public void buttonClick(ToolbarEvent ev) {
		if (ev.getButtonName().equals("Borrar")) {
			borrarSelectedNota();
		}
	}
	// #endregion
}

