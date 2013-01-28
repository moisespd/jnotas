package controller;

import view.NotaSelFrm;
import model.NotasList;

public class Main {
	public static void main(String[] args) {
		try {
			NotaSelFrm notaSelFrm = new NotaSelFrm();
			NotasList notas = new NotasList();
			
			notas.get();
			System.out.println(notas.toString());
			notaSelFrm.setList(notas);
			notaSelFrm.setVisible(true);
			
		} 
		catch (Exception e) {
		   e.printStackTrace();
		}
	}
}



