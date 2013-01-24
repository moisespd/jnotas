import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;

import model.Nota;
import java.awt.Color;


public class NotaMostrarFrm extends JPanel {

	// #region Atributos
	
	Nota nota;
	
	// #endregion
	
	// #region Atributos del diseñador de formularios
	
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
	
	public NotaMostrarFrm() {
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
	}
	
	// #endregion

}
