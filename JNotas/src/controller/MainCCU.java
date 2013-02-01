package controller;

import view.MainFrm;
import view.NotaSelPaneEvent;


public class MainCCU implements SeleccionarNotaCCUListener {
	
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
	
	// #region gestión de eventos de las CCU incluidas
	
	public void notaClick(NotaSelPaneEvent ev) {
		mostrarNotaCCU.iniciar(ev.getIdNota());
	}
	// #endregion
}
