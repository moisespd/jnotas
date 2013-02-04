package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.Nota;
import model.NotasList;
import view.NotaSelPane;
import view.NotaSelPaneEvent;
import view.NotaSelPaneListener;

public class SeleccionarNotaCCU implements NotaSelPaneListener {

	// #region Objetos de negocio

	NotasList notas = new NotasList();
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
	
	// #endregion

	// #region Métodos de controladoras

	public void reiniciar() {
		try {
			notas = new NotasList();
			notas.get();
			miVista.setList(notas);
		}
		catch (Exception e) {
		}
	}

	// ------------------------------------------------------------------------------------------
	public void iniciar() {
		try {
			notas.get();
			miVista.setList(notas);
		}
		catch (Exception e) {
		}
		
		miVista.setVisible(true);
		miVista.seleccionarFirstNota();
	}
	
	// #endregion

	// #region Gestión de eventos del panel
	
	public void buttonBuscarClick(NotaSelPaneEvent e) {
		try {
			notas = new NotasList();
			notas.get(e.getText());
		}
		catch (Exception ex) {
		}
		miVista.setList(notas);
	}
	
	public void notaClick(NotaSelPaneEvent e) {
		this.idSelectedNota = e.getIdNota();
		_raiseNotaClickEvent(idSelectedNota);
	}
	// #endregion

	// #region Generación de eventos

	private List _listeners = new ArrayList();
	
    public synchronized void addListener(SeleccionarNotaCCUListener l ) {
        _listeners.add(l);
    }
    
    public synchronized void removeListener(SeleccionarNotaCCUListener l ) {
        _listeners.remove(l);
    }
    
    
    private synchronized void _raiseNotaClickEvent(int idNota) {
        NotaSelPaneEvent ev = new NotaSelPaneEvent(this, idNota);
        Iterator listeners = _listeners.iterator();
        while( listeners.hasNext() ) {
            ((SeleccionarNotaCCUListener) listeners.next() ).notaClick(ev);
        }
    }
    
	// #endregion
	
}
