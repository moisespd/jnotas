package controller;

import model.Nota;
import view.NotaDataPane;

public class MostrarNotaCCU {

	// #region Objetos de negocio

	Nota nota = new Nota();
	
	// #endregion
	
	// #region Vista
	
	private NotaDataPane miVista = new NotaDataPane(true);
	
	public NotaDataPane getVista() {
		return miVista;
	}
	
	// #endregion
	
	// #region Getters/Setters
	
	public void setIdNota(int idNota) {
		try {
			nota.get(idNota);
		}
		catch (Exception e) {
		}
		
		miVista.setNota(nota);
	}
	
	// #endregion
	
	// #region Constructor
	
	public MostrarNotaCCU() {
	}
	
	// #endregion
	
	// #region Métodos de controladoras

	public void iniciar(int idNota) {
		try {
			nota.get(idNota);
			miVista.setNota(nota);
		}
		catch (Exception e) {
		}
		miVista.setVisible(true);
	}
	
	// #endregion

}
