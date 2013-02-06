import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import view.NotaSelPaneEvent.TipoAccion;


public class PruebaList extends JFrame {

	private JList<String> jList1; 
	DefaultListModel<String> listModel = new DefaultListModel<String>();
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PruebaList frame = new PruebaList();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PruebaList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		listModel.addElement("value1");
		listModel.addElement("value2");
		listModel.addElement("value3");
		listModel.addElement("value4");
		listModel.addElement("value1");
		listModel.addElement("value1");
		listModel.addElement("value1");

		jList1 = new JList<String>(listModel);

		jList1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("index = " + jList1.getSelectedIndex());
			}
		});
		jList1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jList1.setSelectedIndex(3);
		jList1.setVisibleRowCount(5);
		jList1.setAutoscrolls(true);
		jList1.setDebugGraphicsOptions(0);
		jList1.setMaximumSize(new Dimension(5, 5));
		jList1.setOpaque(true);
		jList1.setPreferredSize(new Dimension(0, 0));
		jList1.setRequestFocusEnabled(true);
		jList1.setBounds(new Rectangle(88, 119, 93, 114));
//		JScrollPane listScrollPane = new JScrollPane(jList1);



		contentPane.add(jList1, BorderLayout.CENTER);
	}

}
