import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;


public class NotaFrm extends JFrame {
	// ##################################################################################
	// ##################################################################################
	// ##################################################################################
	// ATRIBUTOS
	// ##################################################################################
	// ##################################################################################
	// ##################################################################################
	Nota nota;
	// ##################################################################################
	// ##################################################################################
	// ##################################################################################
	// ATRIBUTOS DEL DISEÑADOR DE FORMULARIOS
	// ##################################################################################
	// ##################################################################################
	// ##################################################################################
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
	// ##################################################################################
	// ##################################################################################
	// ##################################################################################
	// GETTERS/SETTERS
	// ##################################################################################
	// ##################################################################################
	// ##################################################################################
	public void setNota(Nota n) {
		this.nota = n;
		
		this.txtId.setText(String.valueOf(n.getId()));
		this.txtIdCarpeta.setText(String.valueOf(n.getIdCarpeta()));
		this.txtTitulo.setText(n.getTitulo());
		this.txtDescripcion.setText(n.getDescripcion());
		this.txtPrioridad.setText(String.valueOf(n.getPrioridad()));
		this.txtFechaCreacion.setText(String.valueOf(n.getFechaCreacion().toString()));
	}
	// ##################################################################################
	// ##################################################################################
	// ##################################################################################
	// CONSTRUCTOR
	// ##################################################################################
	// ##################################################################################
	// ##################################################################################

	public NotaFrm() {

		setTitle("Nota");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("id:");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setBounds(12, 12, 146, 15);
		contentPane.add(lblId);
		
		JLabel lblIdcarpeta = new JLabel("idCarpeta:");
		lblIdcarpeta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdcarpeta.setBounds(12, 39, 146, 15);
		contentPane.add(lblIdcarpeta);
		
		JLabel lblNewLabel = new JLabel("Título:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(12, 66, 146, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Descripción:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(12, 93, 146, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblFechaDeCreacin = new JLabel("Fecha de creación:");
		lblFechaDeCreacin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFechaDeCreacin.setBounds(12, 120, 146, 15);
		contentPane.add(lblFechaDeCreacin);
		
		JLabel lblFechaDeInicio = new JLabel("Fecha de inicio:");
		lblFechaDeInicio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFechaDeInicio.setBounds(12, 147, 146, 15);
		contentPane.add(lblFechaDeInicio);
		
		JLabel lblFechaDeFinalizacin = new JLabel("Fecha de fin:");
		lblFechaDeFinalizacin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFechaDeFinalizacin.setBounds(12, 174, 146, 15);
		contentPane.add(lblFechaDeFinalizacin);
		
		JLabel lblPrioridad = new JLabel("Prioridad:");
		lblPrioridad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrioridad.setBounds(12, 201, 146, 15);
		contentPane.add(lblPrioridad);
		
		txtId = new JTextField();
		txtId.setBounds(176, 12, 262, 19);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		txtIdCarpeta = new JTextField();
		txtIdCarpeta.setColumns(10);
		txtIdCarpeta.setBounds(176, 37, 262, 19);
		contentPane.add(txtIdCarpeta);
		
		txtTitulo = new JTextField();
		txtTitulo.setColumns(10);
		txtTitulo.setBounds(176, 64, 262, 19);
		contentPane.add(txtTitulo);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(176, 91, 262, 19);
		contentPane.add(txtDescripcion);
		
		txtFechaCreacion = new JTextField();
		txtFechaCreacion.setColumns(10);
		txtFechaCreacion.setBounds(176, 118, 262, 19);
		contentPane.add(txtFechaCreacion);
		
		txtFechaInicio = new JTextField();
		txtFechaInicio.setColumns(10);
		txtFechaInicio.setBounds(176, 145, 262, 19);
		contentPane.add(txtFechaInicio);
		
		txtFechaFin = new JTextField();
		txtFechaFin.setColumns(10);
		txtFechaFin.setBounds(176, 172, 262, 19);
		contentPane.add(txtFechaFin);
		
		txtPrioridad = new JTextField();
		txtPrioridad.setColumns(10);
		txtPrioridad.setBounds(176, 199, 262, 19);
		contentPane.add(txtPrioridad);
	}
}
