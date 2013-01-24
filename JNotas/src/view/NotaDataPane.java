package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;

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
		setForeground(Color.LIGHT_GRAY);
		setLayout(null);

		JLabel lblId = new JLabel("id:");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setBounds(24, 54, 146, 15);
		this.add(lblId);
		
		JLabel lblIdcarpeta = new JLabel("idCarpeta:");
		lblIdcarpeta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdcarpeta.setBounds(24, 81, 146, 15);
		this.add(lblIdcarpeta);
		
		JLabel lblNewLabel = new JLabel("Título:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(24, 108, 146, 15);
		this.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Descripción:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(24, 135, 146, 15);
		this.add(lblNewLabel_1);
		
		JLabel lblFechaDeCreacin = new JLabel("Fecha de creación:");
		lblFechaDeCreacin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFechaDeCreacin.setBounds(24, 162, 146, 15);
		this.add(lblFechaDeCreacin);
		
		JLabel lblFechaDeInicio = new JLabel("Fecha de inicio:");
		lblFechaDeInicio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFechaDeInicio.setBounds(24, 189, 146, 15);
		this.add(lblFechaDeInicio);
		
		JLabel lblFechaDeFinalizacin = new JLabel("Fecha de fin:");
		lblFechaDeFinalizacin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFechaDeFinalizacin.setBounds(24, 216, 146, 15);
		this.add(lblFechaDeFinalizacin);
		
		JLabel lblPrioridad = new JLabel("Prioridad:");
		lblPrioridad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrioridad.setBounds(24, 243, 146, 15);
		this.add(lblPrioridad);

		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(188, 54, 262, 19);
		this.add(txtId);
		txtId.setColumns(10);
		
		txtIdCarpeta = new JTextField();
		txtIdCarpeta.setColumns(10);
		txtIdCarpeta.setBounds(188, 79, 262, 19);
		this.add(txtIdCarpeta);
		
		txtTitulo = new JTextField();
		txtTitulo.setColumns(10);
		txtTitulo.setBounds(188, 106, 262, 19);
		this.add(txtTitulo);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(188, 133, 262, 19);
		this.add(txtDescripcion);
		
		txtFechaCreacion = new JTextField();
		txtFechaCreacion.setColumns(10);
		txtFechaCreacion.setBounds(188, 160, 262, 19);
		this.add(txtFechaCreacion);
		
		txtFechaInicio = new JTextField();
		txtFechaInicio.setColumns(10);
		txtFechaInicio.setBounds(188, 187, 262, 19);
		this.add(txtFechaInicio);
		
		txtFechaFin = new JTextField();
		txtFechaFin.setColumns(10);
		txtFechaFin.setBounds(188, 214, 262, 19);
		this.add(txtFechaFin);
		
		txtPrioridad = new JTextField();
		txtPrioridad.setColumns(10);
		txtPrioridad.setBounds(188, 241, 262, 19);
		this.add(txtPrioridad);
	
	}

	// #endregion
	
}
