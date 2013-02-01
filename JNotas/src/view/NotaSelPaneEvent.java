package view;

import java.util.EventObject;

public class NotaSelPaneEvent extends EventObject {
	private static final long serialVersionUID = 0;
	
	String text = "";
	int idNota = -1;
	
	public String getText() {
		return text;
	}
	
	public int getIdNota() {
		return idNota;
	}
	
	public NotaSelPaneEvent(Object source, String text) {
		super(source);
		this.text = text;
	}

	public NotaSelPaneEvent(Object source, int idNota) {
		super(source);
		this.idNota = idNota;
	}

}
