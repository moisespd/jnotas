package controller;

import model.Nota;
import view.NotaDataPane;

public class MostrarNotaCCU {

	// #region Objetos de negocio

	Nota nota = new Nota();
	
	// #endregion
	
	// #region Vista
	
	private NotaDataPane miVista = new NotaDataPane();
	
	public NotaDataPane getVista() {
		return miVista;
	}
	
	// #endregion
	
	// #region Constructor
	
	public MostrarNotaCCU(int idNota) {
		try {
			nota.get(idNota);
		}
		catch (Exception e) {
		}
	}
	
	// #endregion
	
	// #region Métodos de controladoras

	public void iniciar() {
		try {
			miVista.setNota(nota);
		}
		catch (Exception e) {
		}
		miVista.setVisible(true);
	}
	
	// #endregion

}
