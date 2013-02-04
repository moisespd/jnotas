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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;
// #endregion

// #endregion

public class NotaSelPane extends JPanel implements ActionListener {

	// #region Objetos de negocio

	NotasList list = new NotasList();

	// #endregion

	// #region Objetos del diseñador de formularios

	private static final long serialVersionUID = 0;

	private JTextField textBuscar;
	JList<String> listNotas;
	DefaultListModel<String> datos = new DefaultListModel<String>();
	JButton btnBuscar;

	// #endregion

	// #region Constructor

	public NotaSelPane() {
		setForeground(Color.LIGHT_GRAY);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 315, 99, 0 };
		gridBagLayout.rowHeights = new int[] { 25, 241, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		textBuscar = new JTextField();
		GridBagConstraints gbc_textBuscar = new GridBagConstraints();
		gbc_textBuscar.weightx = 1.0;
		gbc_textBuscar.fill = GridBagConstraints.BOTH;
		gbc_textBuscar.insets = new Insets(5, 5, 5, 5);
		gbc_textBuscar.gridx = 0;
		gbc_textBuscar.gridy = 0;
		add(textBuscar, gbc_textBuscar);
		textBuscar.setColumns(10);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.anchor = GridBagConstraints.NORTH;
		gbc_btnBuscar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBuscar.insets = new Insets(5, 5, 5, 5);
		gbc_btnBuscar.gridx = 1;
		gbc_btnBuscar.gridy = 0;
		add(btnBuscar, gbc_btnBuscar);

		listNotas = new JList<String>(datos);
		listNotas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		MouseListener mouseListener = new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) {
					int index = listNotas.locationToIndex(e.getPoint());
					_raiseNotaClickEvent(index);
				}
			}
		};
		
		listNotas.addMouseListener(mouseListener);
		listNotas.setBorder(new LineBorder(new Color(0, 0, 0)));
		listNotas.setVisibleRowCount(0);
		GridBagConstraints gbc_listNotas = new GridBagConstraints();
		gbc_listNotas.insets = new Insets(5, 5, 5, 5);
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
		datos.removeAllElements();
		for (int i = 0; i < list.size(); i++) {
			datos.addElement("[" + String.valueOf(list.getNota(i).getId()) + "] " + list.getNota(i).getTitulo());
		}

		listNotas = new JList<String>(datos);
		seleccionarFirstNota();
		this.repaint();
	}

	// #endregion

	// #region Métodos públicos
	
	public void seleccionarFirstNota() {
		listNotas.setSelectedIndex(0);
		_raiseNotaClickEvent(0);
	}
	
	// #endregion
	
	// #region Gestión de eventos de elementos gráficos

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscar) {
			_raiseButtonBuscarClickEvent(btnBuscar);
		}
	}

	// #endregion

	// #region Generación de eventos

	private List<NotaSelPaneListener> _listeners = new ArrayList<NotaSelPaneListener>();

	public synchronized void addListener(NotaSelPaneListener l) {
		_listeners.add(l);
	}

	public synchronized void removeListener(NotaSelPaneListener l) {
		_listeners.remove(l);
	}

	private synchronized void _raiseButtonBuscarClickEvent(Object source) {
		NotaSelPaneEvent ev = new NotaSelPaneEvent(source, textBuscar.getText());
		Iterator<NotaSelPaneListener> listeners = _listeners.iterator();
		while (listeners.hasNext()) {
			((NotaSelPaneListener) listeners.next()).buttonBuscarClick(ev);
		}
	}

	private synchronized void _raiseNotaClickEvent(int index) {
		String str = datos.getElementAt(index);
		
		int idNota = Integer.parseInt(str.substring(1, str.indexOf("]")));
		NotaSelPaneEvent ev = new NotaSelPaneEvent(this, idNota);
		Iterator<NotaSelPaneListener> listeners = _listeners.iterator();
		while (listeners.hasNext()) {
			((NotaSelPaneListener) listeners.next()).notaClick(ev);
		}
	}

	// #endregion

}
