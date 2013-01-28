package view;

import java.util.EventObject;

public class ButtonClickEvent extends EventObject {
	private static final long serialVersionUID = 0;
	
	String text = "";
	
	public String getText() {
		return text;
	}
	
	public ButtonClickEvent(Object source, String text) {
		super(source);
		this.text = text;
	}
}
