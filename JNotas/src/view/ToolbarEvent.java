package view;

import java.util.EventObject;

public class ToolbarEvent extends EventObject {
	private static final long serialVersionUID = 0;
	
	String buttonName = "";
	
	public String getButtonName() {
		return buttonName;
	}
	
	public ToolbarEvent(Object source, String buttonName) {
		super(source);
		this.buttonName= buttonName;
	}

}
