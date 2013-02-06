package view;

// #region Imports


// #region Objetos de presentación 

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.NotasList;
import view.NotaSelPaneEvent.TipoAccion;
// #endregion
// #region Objetos de negocio
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
		gridBagLayout.rowHeights = new int[] { 25, 89, 85, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
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
		gbc_btnBuscar.insets = new Insets(5, 5, 5, 0);
		gbc_btnBuscar.gridx = 1;
		gbc_btnBuscar.gridy = 0;
		add(btnBuscar, gbc_btnBuscar);

		
		// ------------------------------------
		recargarListNotas();
	}

	// #endregion

	// #region Getters/Setters

	public void setList(NotasList list) {
		this.list = list;
		refresh();
	}

	// #endregion

	// #region Métodos auxiliares

	private void recargarListNotas() {
		listNotas = new JList<String>(datos);
		listNotas.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				_raiseNotaClickEvent(listNotas.getSelectedIndex(), TipoAccion.SIMPLE_CLICK);
			}
		});
		
		MouseListener mouseListener = new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int index;
				
				if (e.getClickCount() == 1) {
					index = listNotas.getSelectedIndex();
					System.out.println("index = " + index);
					
					listNotas.setSelectedIndex(index);
					_raiseNotaClickEvent(index, TipoAccion.SIMPLE_CLICK);
				}

				if (e.getClickCount() == 2) {
					index = listNotas.locationToIndex(e.getPoint());
					_raiseNotaClickEvent(index, TipoAccion.DOUBLE_CLICK);
				}
			}
		};

		
		listNotas.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int index = listNotas.getSelectedIndex();
				
				switch ((int) e.getKeyChar()) {
					case 10:
						_raiseNotaClickEvent(index, TipoAccion.INTRO);
						break;
					case 127:
						_raiseNotaClickEvent(index, TipoAccion.SUPRIMIR);
				}
			}
		});
		
		listNotas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listNotas.addMouseListener(mouseListener);
		listNotas.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_listNotas = new GridBagConstraints();
		gbc_listNotas.gridheight = 2;
		gbc_listNotas.insets = new Insets(5, 5, 5, 0);
		gbc_listNotas.weighty = 1.0;
		gbc_listNotas.weightx = 1.0;
		gbc_listNotas.anchor = GridBagConstraints.NORTHEAST;
		gbc_listNotas.fill = GridBagConstraints.BOTH;
		gbc_listNotas.gridwidth = 2;
		gbc_listNotas.gridx = 0;
		gbc_listNotas.gridy = 1;
		add(listNotas, gbc_listNotas);
	}
	
	private void refresh() {
		datos.removeAllElements();
		for (int i = 0; i < list.size(); i++) {
			datos.addElement("[" + String.valueOf(list.getNota(i).getId()) + "] " + list.getNota(i).getTitulo());
		}

		// ----------------------------------
		//recargarListNotas();
		// ----------------------------------
		seleccionarFirstNota();
		this.repaint();
	}

	// #endregion

	// #region Métodos públicos
	
	public void seleccionarFirstNota() {
		listNotas.setSelectedIndex(0);
		_raiseNotaClickEvent(0, TipoAccion.SIMPLE_CLICK);
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

	private synchronized void _raiseNotaClickEvent(int index, TipoAccion accion) {
		String str = datos.getElementAt(index);
		
		int idNota = Integer.parseInt(str.substring(1, str.indexOf("]")));
		NotaSelPaneEvent ev = new NotaSelPaneEvent(this, idNota, accion);
		Iterator<NotaSelPaneListener> listeners = _listeners.iterator();
		while (listeners.hasNext()) {
			((NotaSelPaneListener) listeners.next()).notaClick(ev);
		}
	}

	// #endregion

}
