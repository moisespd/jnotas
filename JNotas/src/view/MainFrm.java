package view;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JButton;

public class MainFrm extends JFrame {
	
	// #region Atributos del diseñador de formularios
	private JPanel mainPanel;
	private NotaSelPane notaSelPane;
	private NotaDataPane notaPane;
	private JSplitPane jsplitPane;
	private static final long serialVersionUID = 0;
	
	// #endregion

	// #region Constructor
	
	public MainFrm() {
		setTitle("JNotas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 427);
		
		mainPanel = new JPanel();

		
		notaSelPane = new NotaSelPane();
		notaPane = new NotaDataPane();
		jsplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, notaSelPane, notaPane);
		jsplitPane.setBounds(0, 0, 950, 300);
		jsplitPane.setDividerLocation(450);
		
		setContentPane(mainPanel);
		mainPanel.setLayout(null);
		
		JPanel panelBotton = new JPanel();
		panelBotton.setBounds(0, 370, 956, 30);
		mainPanel.add(panelBotton);
		panelBotton.setLayout(null);
		
		JPanel panelCenter = new JPanel();
		panelCenter.setBounds(0, 48, 956, 305);
		mainPanel.add(panelCenter);
		panelCenter.setLayout(null);
		
		panelCenter.add(jsplitPane);
		
		JPanel iconPanel = new JPanel();
		iconPanel.setBounds(12, 1, 441, 45);
		mainPanel.add(iconPanel);
		iconPanel.setLayout(null);
		
		JLabel lblIconoDelSubsistema = new JLabel("Icono del subsistema");
		lblIconoDelSubsistema.setBounds(0, 0, 429, 45);
		iconPanel.add(lblIconoDelSubsistema);
		
		JPanel toolBarPane = new JPanel();
		toolBarPane.setBounds(455, 1, 501, 35);
		mainPanel.add(toolBarPane);
		toolBarPane.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JButton btnNuevo = new JButton("Nuevo");
		toolBarPane.add(btnNuevo);
		
		JButton btnEditar = new JButton("Editar");
		toolBarPane.add(btnEditar);
		
		JButton btnBorrar = new JButton("Borrar");
		toolBarPane.add(btnBorrar);
	}
}
