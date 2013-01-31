package controller;

import view.MainFrm;


public class MainCCU {
	
	// #region Objetos de negocio
	
	
	// #endregion
	
	// #region Vista

	MainFrm miVista = new MainFrm();
	
	// #endregion
	
	// #region Controladoras de inclusión
	
	SeleccionarNotaCCU seleccionarNotaCCU = new SeleccionarNotaCCU();
	MostrarNotaCCU mostrarNotaCCU = new MostrarNotaCCU(1);
	
	// #endregion
	
	// #region Métodos de CCU
	
	public void iniciar() {
		try {
			seleccionarNotaCCU.iniciar();
			mostrarNotaCCU.iniciar();
			miVista.setNotaSelPane(seleccionarNotaCCU.getVista());
			miVista.setNotaDataPane(mostrarNotaCCU.getVista());
			miVista.mostrar(true);
		} 
		catch (Exception e) {
		   e.printStackTrace();
		}
	}
	
	// #endregion
	
}
