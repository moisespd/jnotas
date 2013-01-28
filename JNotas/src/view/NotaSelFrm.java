package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;


import model.NotasList;

public class NotaSelFrm extends JFrame implements ButtonClickListener {

	// #region Objetos de negocio
	
	private NotasList list = new NotasList(); 
	
	// #endregion
	
	// #region Atributos del diseñador de formularios
	
	private NotaSelPane contentPane;
	private static final long serialVersionUID = 0;

	// #endregion
	
	// #region Constructor
	
	public NotaSelFrm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new NotaSelPane();
		contentPane.addListener(this);
		setContentPane(contentPane);
	}

	// #endregion
	
	// #region Getters/Setters
	
	public void setList(NotasList list) {
		this.list = list;
		contentPane.setList(this.list);
	}
	
	// #endregion
	
	// #region Gestión de eventos
	
	public void buttonClicked(ButtonClickEvent e) {
		try {
			list = new NotasList();
			list.get(e.getText());
		}
		catch (Exception ex) {
		}
		contentPane.setList(list);
	}
	// #endregion
}
