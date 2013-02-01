package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.NotasList;
import view.NotaSelPaneEvent;
import view.NotaSelPaneListener;
import view.NotaSelPane;

public class SeleccionarNotaCCU implements NotaSelPaneListener {

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
		_raiseNotaClickEvent(e.getIdNota());
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
