package controller;

import model.Nota;
import view.MainFrm;
import view.NotaSelPaneEvent;
import view.NuevaNotaFrm;
import view.ButtonEvent;
import view.ButtonListener;


public class MainCCU implements ButtonListener, SeleccionarNotaCCUListener {
	
	// #region Objetos de negocio
	
	// #endregion
	
	// #region Vista

	MainFrm miVista = new MainFrm();
	NuevaNotaFrm nuevaNotaFrm;
	
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
	private void crearNuevaNota() {
		nuevaNotaFrm = new NuevaNotaFrm(this.miVista, true);
		nuevaNotaFrm.addListener(this);
		
		Nota nota = new Nota();
		nuevaNotaFrm.setNota(nota);
		nuevaNotaFrm.setVisible(true);
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
			default:
				System.out.println("MainCCU: pulsado botón " + ev.getButtonName());
				break;
		}
	}
	// #endregion
}

