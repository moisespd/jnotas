package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.Nota;
import model.Util;

public class NotaDataPane extends JPanel {

	// #region Objetos de negocio
	
	Nota nota = new Nota();
	boolean readOnly = true;
	
	// #endregion
	
	// #region Objetos del diseñador de formularios
	
	private static final long serialVersionUID = 0;

	private JTextField txtId;
	private JTextField txtIdCarpeta;
	private JTextField txtTitulo;
	private JTextField txtFechaCreacion;
	private JTextField txtFechaInicio;
	private JTextField txtFechaFin;
	private JTextField txtPrioridad;
	private JLabel lblResuelta;
	private JCheckBox checkBoxResuelta;
	private JTextArea txtDescripcion;
	
	// #endregion
	
	// #region Constructor
	
	private void initComponents() {
		Insets insets = new Insets(5,5,5,5);

		setForeground(Color.LIGHT_GRAY);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{146, 262, 0};
		gridBagLayout.rowHeights = new int[]{19, 19, 19, 19, 19, 19, 19, 19, 112, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
				
		JLabel lblId = new JLabel("id:");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.NORTH;
		gbc_lblId.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblId.insets = insets;
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 0;
		this.add(lblId, gbc_lblId);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		GridBagConstraints gbc_txtId = new GridBagConstraints();
		gbc_txtId.anchor = GridBagConstraints.NORTH;
		gbc_txtId.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtId.insets = new Insets(5, 5, 5, 0);
		gbc_txtId.gridx = 1;
		gbc_txtId.gridy = 0;
		this.add(txtId, gbc_txtId);
		txtId.setColumns(10);
		
		JLabel lblIdcarpeta = new JLabel("idCarpeta:");
		lblIdcarpeta.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblIdcarpeta = new GridBagConstraints();
		gbc_lblIdcarpeta.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblIdcarpeta.insets = insets;
		gbc_lblIdcarpeta.gridx = 0;
		gbc_lblIdcarpeta.gridy = 1;
		this.add(lblIdcarpeta, gbc_lblIdcarpeta);
		
		txtIdCarpeta = new JTextField();
		txtIdCarpeta.setColumns(10);
		GridBagConstraints gbc_txtIdCarpeta = new GridBagConstraints();
		gbc_txtIdCarpeta.anchor = GridBagConstraints.NORTH;
		gbc_txtIdCarpeta.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtIdCarpeta.insets = new Insets(5, 5, 5, 0);
		gbc_txtIdCarpeta.gridx = 1;
		gbc_txtIdCarpeta.gridy = 1;
		this.add(txtIdCarpeta, gbc_txtIdCarpeta);
		
		JLabel lblNewLabel = new JLabel("Título:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.insets = insets;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		this.add(lblNewLabel, gbc_lblNewLabel);
		
		txtTitulo = new JTextField();
		txtTitulo.setColumns(10);
		GridBagConstraints gbc_txtTitulo = new GridBagConstraints();
		gbc_txtTitulo.weightx = 1.0;
		gbc_txtTitulo.anchor = GridBagConstraints.NORTH;
		gbc_txtTitulo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTitulo.insets = new Insets(5, 5, 5, 0);
		gbc_txtTitulo.gridx = 1;
		gbc_txtTitulo.gridy = 2;
		this.add(txtTitulo, gbc_txtTitulo);
		
		lblResuelta = new JLabel("Resuelta:");
		lblResuelta.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblResuelta = new GridBagConstraints();
		gbc_lblResuelta.anchor = GridBagConstraints.EAST;
		gbc_lblResuelta.insets = new Insets(0, 0, 5, 5);
		gbc_lblResuelta.gridx = 0;
		gbc_lblResuelta.gridy = 3;
		add(lblResuelta, gbc_lblResuelta);
		
		checkBoxResuelta = new JCheckBox("");
		GridBagConstraints gbc_checkBox = new GridBagConstraints();
		gbc_checkBox.anchor = GridBagConstraints.NORTHWEST;
		gbc_checkBox.insets = new Insets(0, 0, 5, 0);
		gbc_checkBox.gridx = 1;
		gbc_checkBox.gridy = 3;
		add(checkBoxResuelta, gbc_checkBox);
		
		JLabel lblFechaDeCreacin = new JLabel("Fecha de creación:");
		lblFechaDeCreacin.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblFechaDeCreacin = new GridBagConstraints();
		gbc_lblFechaDeCreacin.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblFechaDeCreacin.insets = insets;
		gbc_lblFechaDeCreacin.gridx = 0;
		gbc_lblFechaDeCreacin.gridy = 4;
		this.add(lblFechaDeCreacin, gbc_lblFechaDeCreacin);
		
		txtFechaCreacion = new JTextField();
		txtFechaCreacion.setColumns(10);
		GridBagConstraints gbc_txtFechaCreacion = new GridBagConstraints();
		gbc_txtFechaCreacion.anchor = GridBagConstraints.NORTH;
		gbc_txtFechaCreacion.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFechaCreacion.insets = new Insets(5, 5, 5, 0);
		gbc_txtFechaCreacion.gridx = 1;
		gbc_txtFechaCreacion.gridy = 4;
		this.add(txtFechaCreacion, gbc_txtFechaCreacion);
		
		JLabel lblFechaDeInicio = new JLabel("Fecha de inicio:");
		lblFechaDeInicio.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblFechaDeInicio = new GridBagConstraints();
		gbc_lblFechaDeInicio.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblFechaDeInicio.insets = insets;
		gbc_lblFechaDeInicio.gridx = 0;
		gbc_lblFechaDeInicio.gridy = 5;
		this.add(lblFechaDeInicio, gbc_lblFechaDeInicio);
		
		txtFechaInicio = new JTextField();
		txtFechaInicio.setColumns(10);
		GridBagConstraints gbc_txtFechaInicio = new GridBagConstraints();
		gbc_txtFechaInicio.anchor = GridBagConstraints.NORTH;
		gbc_txtFechaInicio.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFechaInicio.insets = new Insets(5, 5, 5, 0);
		gbc_txtFechaInicio.gridx = 1;
		gbc_txtFechaInicio.gridy = 5;
		this.add(txtFechaInicio, gbc_txtFechaInicio);
		
		JLabel lblFechaDeFinalizacin = new JLabel("Fecha de fin:");
		lblFechaDeFinalizacin.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblFechaDeFinalizacin = new GridBagConstraints();
		gbc_lblFechaDeFinalizacin.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblFechaDeFinalizacin.insets = insets;
		gbc_lblFechaDeFinalizacin.gridx = 0;
		gbc_lblFechaDeFinalizacin.gridy = 6;
		this.add(lblFechaDeFinalizacin, gbc_lblFechaDeFinalizacin);
		
		txtFechaFin = new JTextField();
		txtFechaFin.setColumns(10);
		GridBagConstraints gbc_txtFechaFin = new GridBagConstraints();
		gbc_txtFechaFin.anchor = GridBagConstraints.NORTH;
		gbc_txtFechaFin.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFechaFin.insets = new Insets(5, 5, 5, 0);
		gbc_txtFechaFin.gridx = 1;
		gbc_txtFechaFin.gridy = 6;
		this.add(txtFechaFin, gbc_txtFechaFin);
		
		JLabel lblPrioridad = new JLabel("Prioridad:");
		lblPrioridad.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblPrioridad = new GridBagConstraints();
		gbc_lblPrioridad.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPrioridad.insets = insets;
		gbc_lblPrioridad.gridx = 0;
		gbc_lblPrioridad.gridy = 7;
		this.add(lblPrioridad, gbc_lblPrioridad);
		
		txtPrioridad = new JTextField();
		txtPrioridad.setColumns(10);
		GridBagConstraints gbc_txtPrioridad = new GridBagConstraints();
		gbc_txtPrioridad.anchor = GridBagConstraints.NORTH;
		gbc_txtPrioridad.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPrioridad.insets = new Insets(5, 5, 5, 0);
		gbc_txtPrioridad.gridx = 1;
		gbc_txtPrioridad.gridy = 7;
		this.add(txtPrioridad, gbc_txtPrioridad);
		
		JLabel lblNewLabel_1 = new JLabel("Descripción:");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_1.insets = new Insets(5, 5, 0, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 8;
		this.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		txtDescripcion = new JTextArea();
		txtDescripcion.setBorder(txtTitulo.getBorder());
		GridBagConstraints gbc_txtDescripcion = new GridBagConstraints();
		gbc_txtDescripcion.insets = new Insets(5, 5, 5, 0);
		gbc_txtDescripcion.fill = GridBagConstraints.BOTH;
		gbc_txtDescripcion.gridx = 1;
		gbc_txtDescripcion.gridy = 8;
		add(txtDescripcion, gbc_txtDescripcion);
		
		
	}
	
	// -----------------------------------------------------------------------------
	public NotaDataPane() {
		initComponents();
	}
	// -----------------------------------------------------------------------------
	public NotaDataPane(boolean readOnly) {
		initComponents();
		this.readOnly = readOnly;
		
		setOnlyReadable(readOnly);
	}
	// -----------------------------------------------------------------------------

	// #endregion

	// #region Métodos auxiliares
	
	public void refresh() {
		this.txtId.setText(String.valueOf(nota.getId()));
		this.txtTitulo.setText(nota.getTitulo());
		this.txtDescripcion.setText(nota.getDescripcion());
		this.txtIdCarpeta.setText(String.valueOf(nota.getIdCarpeta()));
		this.txtFechaCreacion.setText(Util.datetime2String(nota.getFechaCreacion()));
		this.txtFechaInicio.setText(Util.date2String(nota.getFechaInicio()));
		this.txtFechaFin.setText(Util.date2String(nota.getFechaFin()));
		this.txtPrioridad.setText(String.valueOf(nota.getPrioridad()));
		this.checkBoxResuelta.setSelected(nota.getResuelta());
	}
	
	// -----------------------------------------------------------------------------
	public void reverseRefresh() {
		nota.setTitulo(this.txtTitulo.getText());
		nota.setDescripcion(this.txtDescripcion.getText());
		nota.setIdCarpeta(Integer.parseInt(this.txtIdCarpeta.getText()));
		nota.setFechaInicio(Util.string2date(this.txtFechaInicio.getText()));
		nota.setFechaFin(Util.string2date(this.txtFechaFin.getText()));
		nota.setPrioridad(Integer.parseInt(txtPrioridad.getText()));
		nota.setResuelta(checkBoxResuelta.isSelected());
	}
	// -----------------------------------------------------------------------------
	public void setOnlyReadable(boolean readOnly) {
		for (int i = 0; i < this.getComponentCount(); i++) {
			Component c = this.getComponent(i);
			
			if (c instanceof JTextField)
				((JTextField) c).setEditable(! readOnly);
			if (c instanceof JTextArea)
				((JTextArea) c).setEditable(! readOnly);
			
			if (c instanceof JCheckBox)
				((JCheckBox) c).setEnabled(! readOnly);
		}
	}
	// -----------------------------------------------------------------------------
	
	// #endregion
	
	// #region setters/getters
	
	public void setNota(Nota nota) {
		this.nota = nota;
		refresh();
	}
	
	// #endregion

	
}
