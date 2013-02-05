package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;

import model.Nota;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CrearEditarNotaFrm extends JDialog implements ActionListener {

	// #region Objetos de negocio
	
	Nota nota = new Nota();
	
	// #endregion
	
	// #region Atributos del diseñador de formularios
	
	private static final long serialVersionUID = 0;
	
//	private final JPanel contentPanel = new JPanel();
	private NotaDataPane notaDataPane = new NotaDataPane();

	// #endregion
	
	// #region Constructor 
	
	private void initComponents() {
		setBounds(100, 100, 450, 307);
		getContentPane().setLayout(new BorderLayout());
//		contentPanel.setLayout(new FlowLayout());
//		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPanel.add(notaDataPane);
		getContentPane().add(notaDataPane, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Aceptar");
				okButton.addActionListener(this);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(this);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public CrearEditarNotaFrm(JFrame parent, boolean modal) {
		super(parent, modal);
		initComponents();
	}
	
	public CrearEditarNotaFrm() {
		initComponents();
	}
	
	// #endregion
	
	// #region Getters/Setters

	public Nota getNota() {
		return this.nota;
	}
	
	// ------------------------------------------------------------
	
	public void setNota(Nota nota) {
		this.nota = nota;
		notaDataPane.setNota(nota);
	}
	
	// #endregion
	
	// #region Captura de eventos del formulario

	public void actionPerformed(ActionEvent ev) {
		notaDataPane.reverseRefresh();
		_raiseButtonClickEvent(((JButton)ev.getSource()).getText());
	}
	// #endregion
	
	// #region Generación de eventos

	private List<ButtonListener> _listeners = new ArrayList<ButtonListener>();

	public synchronized void addListener(ButtonListener l) {
		_listeners.add(l);
	}

	public synchronized void removeListener(ButtonListener l) {
		_listeners.remove(l);
	}

	private synchronized void _raiseButtonClickEvent(String buttonName) {
		ButtonEvent ev = new ButtonEvent(this, buttonName);
		Iterator<ButtonListener> listeners = _listeners.iterator();
		while (listeners.hasNext()) {
			((ButtonListener) listeners.next()).buttonClick(ev);
		}
	}

	// #endregion

}
