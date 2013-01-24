package controller;
import view.MainFrm;

public class Main {
	public static void main(String[] args) {
		try {
		   MainFrm mainFrm = new MainFrm();
		   
		   mainFrm.setVisible(true);
		} 
		catch (Exception e) {
		   e.printStackTrace();
		}
	}
}



