package controller;

import javax.swing.JFrame;

import model.Nota;
import view.ButtonEvent;
import view.ButtonListener;
import view.CrearEditarNotaFrm;

public class CrearEditarNotaCCU implements ButtonListener {

	// #region Objetos de negocio

	Nota nota = new Nota();
	
	// #endregion
	
	// #region Vista
	
	private CrearEditarNotaFrm miVista;
	
	// #endregion
	
	// #region Constructor
	
	public CrearEditarNotaCCU(JFrame parentFrame) {
		miVista = new CrearEditarNotaFrm(parentFrame, true);
		miVista.addListener(this);
	}
	
	// #endregion

	// #region Getters/Setters

	public Nota getNota() {
		return nota;
	}
	
	public void setNota(Nota nota) {
		this.nota = nota;
	}
	
	// #endregion

	// #region Métodos de controladoras

	// ------------------------------------------------------------------------------------------
	public void iniciar() {
		miVista.setNota(nota);
		miVista.setVisible(true);
	}
	
	// #endregion

	// #region Gestión de eventos de la vista
	
	public void buttonClick(ButtonEvent ev) {
		if (ev.getButtonName().equals("Aceptar")) {
			try {
				nota.save();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		miVista.setVisible(false);
	}
	
	// #endregion
	
}
