package view;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class MainFrm extends JFrame {
	
	// #region Atributos del diseñador de formularios
	private static final long serialVersionUID = 0;

	// #endregion

	// #region Constructor
	
	public MainFrm() {
		setTitle("JNotas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 679, 432);
		
		JPanel contentPane = new JPanel();
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[] {50, 278, 50, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
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
		gbc_splitPane.gridy = 1;
		contentPane.add(splitPane, gbc_splitPane);
	}
}
