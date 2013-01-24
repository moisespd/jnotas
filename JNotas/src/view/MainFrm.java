package view;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

public class MainFrm extends JFrame {
	
	// #region Atributos del diseñador de formularios
	
	private NotaSelPane notaSelPane;
	private NotaDataPane notaPane;
	private JSplitPane jsplitPane;
	private static final long serialVersionUID = 0;
	
	// #endregion

	// #region Constructor
	
	public MainFrm() {
		setTitle("JNotas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 330);

		
		notaSelPane = new NotaSelPane();
		notaPane = new NotaDataPane();
		jsplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, notaSelPane, notaPane);
		jsplitPane.setDividerLocation(450);
		
		setContentPane(jsplitPane);
	}

	// #endregion
}
