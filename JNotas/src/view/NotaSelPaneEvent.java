package view;

import java.util.EventObject;

public class NotaSelPaneEvent extends EventObject {
	private static final long serialVersionUID = 0;
	public enum TipoAccion{SIMPLE_CLICK, DOUBLE_CLICK, SUPRIMIR, INTRO};
	
	String text = "";
	int idNota = -1;
	TipoAccion accion = TipoAccion.SIMPLE_CLICK;
	
	public String getText() {
		return text;
	}
	
	public int getIdNota() {
		return idNota;
	}
	
	public TipoAccion getTipoAccion() {
		return accion;
	}
	
	public NotaSelPaneEvent(Object source, String text) {
		super(source);
		this.text = text;
	}

	public NotaSelPaneEvent(Object source, int idNota, TipoAccion accion) {
		super(source);
		this.idNota = idNota;
		this.accion = accion;
	}

}
