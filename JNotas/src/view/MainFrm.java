package view;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JButton;

import javax.swing.*;
import java.awt.*;

import model.NotasList;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;

public class MainFrm extends JFrame {
	
	// #region Atributos del diseñador de formularios

	private static final long serialVersionUID = 0;
	
	ImageIcon imageHeader;

	// #endregion

	// #region Constructor
	
	public MainFrm() {
		setTitle("JNotas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 911, 393);
		
		JPanel contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		// panelTop
		
		JPanel panelTop = new JPanel();
		panelTop.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		contentPane.add(panelTop, BorderLayout.NORTH);
		GridBagLayout gbl_panelTop = new GridBagLayout();
		gbl_panelTop.columnWidths = new int[]{110, 85, 78, 76, 79, 0, 0, 0, 0};
		gbl_panelTop.rowHeights = new int[] {6};
		gbl_panelTop.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelTop.rowWeights = new double[]{0.0};
		panelTop.setLayout(gbl_panelTop);
		imageHeader = new ImageIcon(MainFrm.class.getResource("/images/headerMain.jpg"));
		Dimension buttonDimension = new Dimension(100, 60);
		
		JLabel lblSystemIcon = new JLabel("");
		lblSystemIcon.setIcon(imageHeader);
		
		GridBagConstraints gbc_lblSystemIcon = new GridBagConstraints();
		gbc_lblSystemIcon.gridwidth = 2;
		gbc_lblSystemIcon.insets = new Insets(0, 0, 0, 5);
		gbc_lblSystemIcon.gridx = 0;
		gbc_lblSystemIcon.gridy = 0;
		panelTop.add(lblSystemIcon, gbc_lblSystemIcon);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setMargin(new Insets(0, 0, 0, 0));
		btnNuevo.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNuevo.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNuevo.setIcon(new ImageIcon(MainFrm.class.getResource("/images/newFile_32x32.png")));
		btnNuevo.setPreferredSize(buttonDimension);
		GridBagConstraints gbc_btnNuevo = new GridBagConstraints();
		gbc_btnNuevo.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnNuevo.insets = new Insets(10, 5, 5, 0);
		gbc_btnNuevo.gridx = 2;
		gbc_btnNuevo.gridy = 0;
		panelTop.add(btnNuevo, gbc_btnNuevo);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setIcon(new ImageIcon(MainFrm.class.getResource("/images/editFile_32x32.png")));
		btnEditar.setMargin(new Insets(0, 0, 0, 0));
		btnEditar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnEditar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEditar.setPreferredSize(buttonDimension);
		GridBagConstraints gbc_btnEditar = new GridBagConstraints();
		gbc_btnEditar.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnEditar.insets = new Insets(10, 5, 5, 0);
		gbc_btnEditar.gridx = 3;
		gbc_btnEditar.gridy = 0;
		panelTop.add(btnEditar, gbc_btnEditar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setIcon(new ImageIcon(MainFrm.class.getResource("/images/dropFile_32x32.png")));
		btnBorrar.setMargin(new Insets(0, 0, 0, 0));
		btnBorrar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnBorrar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBorrar.setPreferredSize(buttonDimension);
		GridBagConstraints gbc_btnBorrar = new GridBagConstraints();
		gbc_btnBorrar.insets = new Insets(10, 5, 5, 0);
		gbc_btnBorrar.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnBorrar.gridx = 4;
		gbc_btnBorrar.gridy = 0;
		panelTop.add(btnBorrar, gbc_btnBorrar);
		
		// panelButton
		JPanel panelButton = new JPanel();
		FlowLayout fl_panelButton = (FlowLayout) panelButton.getLayout();
		fl_panelButton.setAlignment(FlowLayout.LEFT);
		contentPane.add(panelButton, BorderLayout.SOUTH);
		
		JLabel lblStatusBar = new JLabel("Status Bar");
		panelButton.add(lblStatusBar);
		
		JPanel panelCenter = new JPanel();
		contentPane.add(panelCenter, BorderLayout.CENTER);
		GridBagLayout gbl_panelCenter = new GridBagLayout();
		gbl_panelCenter.columnWidths = new int[]{718, 0};
		gbl_panelCenter.rowHeights = new int[]{283, 0};
		gbl_panelCenter.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelCenter.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelCenter.setLayout(gbl_panelCenter);
		
		NotaSelPane notaSelPane = new NotaSelPane();
		GridBagLayout gridBagLayout = (GridBagLayout) notaSelPane.getLayout();
		gridBagLayout.rowHeights = new int[]{0, 251};
		gridBagLayout.columnWidths = new int[]{197, 0};
		
		NotaDataPane notaDataPane = new NotaDataPane();
		GridBagLayout gridBagLayout_1 = (GridBagLayout) notaDataPane.getLayout();
		gridBagLayout_1.columnWidths = new int[]{0, 289};
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, notaSelPane, notaDataPane);
		
		GridBagConstraints gbc_splitPane = new GridBagConstraints();
		gbc_splitPane.weighty = 1.0;
		gbc_splitPane.weightx = 1.0;
		gbc_splitPane.fill = GridBagConstraints.BOTH;
		gbc_splitPane.anchor = GridBagConstraints.NORTHWEST;
		gbc_splitPane.gridx = 0;
		gbc_splitPane.gridy = 0;
		
		splitPane.setDividerLocation(imageHeader.getIconWidth());

		panelCenter.add(splitPane, gbc_splitPane);

		NotasList notas = new NotasList();
		
		try {
			notas.get();
		}
		catch (Exception e) {
		}
		notaSelPane.setList(notas);
	
	}
	
	// #endregion
}
