package controller;

import model.NotasList;
import view.ButtonClickEvent;
import view.ButtonClickListener;
import view.NotaSelPane;

public class SeleccionarNotaCCU implements ButtonClickListener {

	// #region Objetos de negocio

	NotasList notas = new NotasList();
	
	// #endregion
	
	// #region Vista
	
	private NotaSelPane miVista = new NotaSelPane();
	
	public NotaSelPane getVista() {
		return miVista;
	}
	
	// #endregion
	
	// #region Constructor
	
	public SeleccionarNotaCCU() {
		miVista.addListener(this);
	}
	
	// #endregion
	
	// #region Métodos de controladoras

	public void iniciar() {
		try {
			notas.get();
			miVista.setList(notas);
		}
		catch (Exception e) {
		}
		miVista.setVisible(true);
	}
	
	// #endregion

	// #region Gestión de eventos
	
	public void buttonClicked(ButtonClickEvent e) {
		try {
			notas = new NotasList();
			notas.get(e.getText());
		}
		catch (Exception ex) {
		}
		miVista.setList(notas);
	}
	
	// #endregion
	
}
