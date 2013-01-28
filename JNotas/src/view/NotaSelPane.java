package view;

// #region Imports

// #region Objetos de presentación 
import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

// #endregion

// #region Objetos de negocio

import model.NotasList;
import model.Nota;

// #endregion

// #endregion

public class NotaSelPane extends JPanel {
	
	// #region Objetos de negocio
	
	NotasList list = new NotasList();
	
	// #endregion
	
	// #region Objetos del diseñador de formularios
	
	private static final long serialVersionUID = 0;
	
	private JTextField textBuscar;
	JList<String> listNotas;
	DefaultListModel<String> datos = new DefaultListModel<String>();
	
	// #endregion
	
	// #region Constructor

	public NotaSelPane() {
		setForeground(Color.LIGHT_GRAY);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{315, 99, 0};
		gridBagLayout.rowHeights = new int[]{25, 241, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		textBuscar = new JTextField();
		GridBagConstraints gbc_textBuscar = new GridBagConstraints();
		gbc_textBuscar.weightx = 1.0;
		gbc_textBuscar.fill = GridBagConstraints.BOTH;
		gbc_textBuscar.insets = new Insets(0, 0, 5, 5);
		gbc_textBuscar.gridx = 0;
		gbc_textBuscar.gridy = 0;
		add(textBuscar, gbc_textBuscar);
		textBuscar.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.anchor = GridBagConstraints.NORTH;
		gbc_btnBuscar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBuscar.insets = new Insets(0, 0, 5, 0);
		gbc_btnBuscar.gridx = 1;
		gbc_btnBuscar.gridy = 0;
		add(btnBuscar, gbc_btnBuscar);
		
		listNotas = new JList<String>(datos);
		GridBagConstraints gbc_listNotas = new GridBagConstraints();
		gbc_listNotas.weighty = 1.0;
		gbc_listNotas.weightx = 1.0;
		gbc_listNotas.anchor = GridBagConstraints.NORTHEAST;
		gbc_listNotas.fill = GridBagConstraints.BOTH;
		gbc_listNotas.gridwidth = 2;
		gbc_listNotas.gridx = 0;
		gbc_listNotas.gridy = 1;
		add(listNotas, gbc_listNotas);

	}
	
	// #endregion

	// #region Getters/Setters
	
	public void setList(NotasList list) {
		this.list = list;
		refresh();
	}
	
	// #endregion
	
	// #region Métodos auxiliares
	
	private void refresh() {
		for (int i = 0; i < list.size(); i++) {
			datos.addElement(list.getNota(i).getTitulo());
		}
		
		listNotas = new JList<String>(datos);
		this.repaint();
	}
	
	// #endregion
	
}
