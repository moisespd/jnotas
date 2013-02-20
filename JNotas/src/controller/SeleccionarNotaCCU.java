package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.CarpetasList;
import model.NotasList;
import view.NotaSelPane;
import view.NotaSelPaneEvent;
import view.NotaSelPaneEvent.TipoAccion;
import view.NotaSelPaneListener;

public class SeleccionarNotaCCU implements NotaSelPaneListener {

	// #region Objetos de negocio

	CarpetasList carpetas = new CarpetasList();
	int idSelectedNota = -1;
	
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

	// #region Getters/Setters
	
	public int getIdSelectedNota() {
		return this.idSelectedNota;
	}

	public void setIdSelectedNota(int value) {
		miVista.setIdSelectedNota(value);
	}
	
	// #endregion

	// #region Métodos de controladoras

	public void reiniciar() {
		try {
			carpetas = new CarpetasList();
			
			carpetas.get();
			
			miVista.setCarpetasList(carpetas);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ------------------------------------------------------------------------------------------
	public void iniciar() {
		try {
			carpetas.get();
			miVista.setCarpetasList(carpetas);
		}
		catch (Exception e) {
		}
		
		miVista.setVisible(true);
		miVista.seleccionarFirstNota();
	}
	
	// #endregion

	// #region Gestión de eventos del panel
	
	public void buttonBuscarClick(NotaSelPaneEvent e) {
		NotasList notas = new NotasList();
		
		try {
			notas.get(e.getText());
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		miVista.setList(notas);
		miVista.setCarpetasList(carpetas);
	}
	
	public void notaClick(NotaSelPaneEvent e) {
		this.idSelectedNota = e.getIdNota();
		_raiseNotaClickEvent(idSelectedNota, e.getTipoAccion());
	}
	// #endregion

	// #region Generación de eventos

	private List<SeleccionarNotaCCUListener> _listeners = new ArrayList<SeleccionarNotaCCUListener>();
	
    public synchronized void addListener(SeleccionarNotaCCUListener l ) {
        _listeners.add(l);
    }
    
    public synchronized void removeListener(SeleccionarNotaCCUListener l ) {
        _listeners.remove(l);
    }
    
    
    private synchronized void _raiseNotaClickEvent(int idNota, TipoAccion accion) {
        NotaSelPaneEvent ev = new NotaSelPaneEvent(this, idNota, accion);
        Iterator<SeleccionarNotaCCUListener> listeners = _listeners.iterator();
        while( listeners.hasNext() ) {
            ((SeleccionarNotaCCUListener) listeners.next() ).notaClick(ev);
        }
    }
    
	// #endregion
	
}
