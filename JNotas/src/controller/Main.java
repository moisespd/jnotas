package controller;
import view.ResizeFrm;

public class Main {
	public static void main(String[] args) {
		try {
		   ResizeFrm mainFrm = new ResizeFrm();
		   
		   mainFrm.setVisible(true);
		} 
		catch (Exception e) {
		   e.printStackTrace();
		}
	}
}



