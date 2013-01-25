package view;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;

import model.Nota;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


public class NotaFrm extends JFrame implements ActionListener {
	
	// #region Atributos
	
	Nota nota;
	
	// #endregion
	
	// #region Atributos del diseñador de formularios
	
	private JPanel contentPane;
	private static final long serialVersionUID = 0;
	private JTextField txtId;
	private JTextField txtIdCarpeta;
	private JTextField txtTitulo;
	private JTextField txtDescripcion;
	private JTextField txtFechaCreacion;
	private JTextField txtFechaInicio;
	private JTextField txtFechaFin;
	private JTextField txtPrioridad;
	private JButton btnGuardar;
	private JTextField textBuscar;
	
	// #endregion
	
	// #region Getters/setters
	
	public void setNota(Nota n) {
		this.nota = n;
		
		this.txtId.setText(String.valueOf(n.getId()));
		this.txtIdCarpeta.setText(String.valueOf(n.getIdCarpeta()));
		this.txtTitulo.setText(n.getTitulo());
		this.txtDescripcion.setText(n.getDescripcion());
		this.txtPrioridad.setText(String.valueOf(n.getPrioridad()));
		this.txtFechaCreacion.setText(String.valueOf(n.getFechaCreacion().toString()));
		this.repaint();
	}
	
	// #endregion
	
	// #region Constructor

	public NotaFrm() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
			}
		});

		setTitle("Nota");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 462, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("id:");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setBounds(24, 54, 146, 15);
		contentPane.add(lblId);
		
		JLabel lblIdcarpeta = new JLabel("idCarpeta:");
		lblIdcarpeta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdcarpeta.setBounds(24, 81, 146, 15);
		contentPane.add(lblIdcarpeta);
		
		JLabel lblNewLabel = new JLabel("Título:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(24, 108, 146, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Descripción:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(24, 135, 146, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblFechaDeCreacin = new JLabel("Fecha de creación:");
		lblFechaDeCreacin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFechaDeCreacin.setBounds(24, 162, 146, 15);
		contentPane.add(lblFechaDeCreacin);
		
		JLabel lblFechaDeInicio = new JLabel("Fecha de inicio:");
		lblFechaDeInicio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFechaDeInicio.setBounds(24, 189, 146, 15);
		contentPane.add(lblFechaDeInicio);
		
		JLabel lblFechaDeFinalizacin = new JLabel("Fecha de fin:");
		lblFechaDeFinalizacin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFechaDeFinalizacin.setBounds(24, 216, 146, 15);
		contentPane.add(lblFechaDeFinalizacin);
		
		JLabel lblPrioridad = new JLabel("Prioridad:");
		lblPrioridad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrioridad.setBounds(24, 243, 146, 15);
		contentPane.add(lblPrioridad);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(188, 54, 262, 19);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		txtIdCarpeta = new JTextField();
		txtIdCarpeta.setColumns(10);
		txtIdCarpeta.setBounds(188, 79, 262, 19);
		contentPane.add(txtIdCarpeta);
		
		txtTitulo = new JTextField();
		txtTitulo.setColumns(10);
		txtTitulo.setBounds(188, 106, 262, 19);
		contentPane.add(txtTitulo);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(188, 133, 262, 19);
		contentPane.add(txtDescripcion);
		
		txtFechaCreacion = new JTextField();
		txtFechaCreacion.setColumns(10);
		txtFechaCreacion.setBounds(188, 160, 262, 19);
		contentPane.add(txtFechaCreacion);
		
		txtFechaInicio = new JTextField();
		txtFechaInicio.setColumns(10);
		txtFechaInicio.setBounds(188, 187, 262, 19);
		contentPane.add(txtFechaInicio);
		
		txtFechaFin = new JTextField();
		txtFechaFin.setColumns(10);
		txtFechaFin.setBounds(188, 214, 262, 19);
		contentPane.add(txtFechaFin);
		
		txtPrioridad = new JTextField();
		txtPrioridad.setColumns(10);
		txtPrioridad.setBounds(188, 241, 262, 19);
		contentPane.add(txtPrioridad);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setActionCommand("btnGuardar_click");
		btnGuardar.addActionListener(this);
		btnGuardar.setBounds(333, 278, 117, 25);
		contentPane.add(btnGuardar);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setBounds(6, 6, 448, 32);
		contentPane.add(toolBar);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setActionCommand("btnNuevo_click");
		btnNuevo.addActionListener(this);
		toolBar.add(btnNuevo);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setActionCommand("btnEliminar_click");
		btnEliminar.addActionListener(this);
		toolBar.add(btnEliminar);
		
		textBuscar = new JTextField();
		toolBar.add(textBuscar);
		textBuscar.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setActionCommand("btnBuscar_click");
		toolBar.add(btnBuscar);
	}
	
	// #endregion

	// #region Gestión de eventos
	
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
			case "btnGuardar_click":
				btnGuardar_click(e);
				break;
			case "btnNuevo_click":
				btnNuevo_click(e);
				break;
			case "btnEliminar_click":
				btnEliminar_click(e);
				break;
			case "btnBuscar_click":
				btnBuscar_click(e);
				break;
		}
	}
	
	// ------------------------------------------------------------------------------
	private void btnNuevo_click(ActionEvent e) {
		this.nota = new Nota();
		try {
			this.nota.save();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		this.setNota(nota);
	}
	// ------------------------------------------------------------------------------
	private void btnEliminar_click(ActionEvent e) {
		try {
			this.nota.delete();
			this.nota.getLast();
			this.setNota(nota);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}		
	// ------------------------------------------------------------------------------
	private void btnBuscar_click(ActionEvent e) {
		int id = Integer.parseInt(textBuscar.getText());
		try {
			nota.get(id);
			this.setNota(nota);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	// ------------------------------------------------------------------------------
	private void btnGuardar_click(ActionEvent e) {
		this.nota.setTitulo(txtTitulo.getText());
		this.nota.setDescripcion(txtDescripcion.getText());
		
		try {
			this.nota.save();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	// #endregion
}
