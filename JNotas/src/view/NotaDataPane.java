package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class NotaDataPane extends JPanel {

	// #region Objetos del diseñador de formularios
	
	private static final long serialVersionUID = 0;

	private JTextField txtId;
	private JTextField txtIdCarpeta;
	private JTextField txtTitulo;
	private JTextField txtDescripcion;
	private JTextField txtFechaCreacion;
	private JTextField txtFechaInicio;
	private JTextField txtFechaFin;
	private JTextField txtPrioridad;
	
	// #endregion
	
	// #region Constructor
	
	public NotaDataPane() {
		Insets insets = new Insets(5,5,5,5);

		setForeground(Color.LIGHT_GRAY);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{146, 262, 0};
		gridBagLayout.rowHeights = new int[]{19, 19, 19, 19, 19, 19, 19, 19, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		gbc_txtId.insets = insets;
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
		gbc_txtIdCarpeta.insets = insets;
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
		gbc_txtTitulo.insets = insets;
		gbc_txtTitulo.gridx = 1;
		gbc_txtTitulo.gridy = 2;
		this.add(txtTitulo, gbc_txtTitulo);
		
		JLabel lblNewLabel_1 = new JLabel("Descripción:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_1.insets = insets;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 3;
		this.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		GridBagConstraints gbc_txtDescripcion = new GridBagConstraints();
		gbc_txtDescripcion.anchor = GridBagConstraints.NORTH;
		gbc_txtDescripcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDescripcion.insets = insets;
		gbc_txtDescripcion.gridx = 1;
		gbc_txtDescripcion.gridy = 3;
		this.add(txtDescripcion, gbc_txtDescripcion);
		
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
		gbc_txtFechaCreacion.insets = insets;
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
		gbc_txtFechaInicio.insets = insets;
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
		gbc_txtFechaFin.insets = insets;
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
		gbc_txtPrioridad.insets = insets;
		gbc_txtPrioridad.gridx = 1;
		gbc_txtPrioridad.gridy = 7;
		this.add(txtPrioridad, gbc_txtPrioridad);
	
	}

	// #endregion
	
}
