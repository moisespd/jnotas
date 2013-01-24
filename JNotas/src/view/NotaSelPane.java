package view;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;

public class NotaSelPane extends JPanel {
	
	// #region Objetos del diseñador de formularios
	
	private static final long serialVersionUID = 0;
	
	private JTextField textBuscar;
	
	// #endregion
	
	// #region Constructor

	public NotaSelPane() {
		setForeground(Color.LIGHT_GRAY);
		setLayout(null);
		
		JList listNotas = new JList();
		listNotas.setBounds(12, 47, 426, 241);
		add(listNotas);
		
		textBuscar = new JTextField();
		textBuscar.setBounds(12, 12, 315, 23);
		add(textBuscar);
		textBuscar.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(339, 10, 99, 25);
		add(btnBuscar);

	}
	
	// #endregion

}
