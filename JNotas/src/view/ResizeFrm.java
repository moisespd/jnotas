package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextArea;
import javax.swing.BoxLayout;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.border.BevelBorder;
import java.awt.GridLayout;


public class ResizeFrm extends JFrame {

	private JPanel contentPane;

	public ResizeFrm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 321, 121);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		
		this.setTitle("JFrame Test");
	    GridBagLayout gbl_contentPane = new GridBagLayout();
	    gbl_contentPane.columnWidths = new int[]{80, 215, 0};
	    gbl_contentPane.rowHeights = new int[]{27, 27, 26, 0};
	    gbl_contentPane.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
	    gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
	    contentPane.setLayout(gbl_contentPane);
	    
	    JLabel lblName = new JLabel("Name");
	    GridBagConstraints gbc_lblName = new GridBagConstraints();
	    gbc_lblName.fill = GridBagConstraints.BOTH;
	    gbc_lblName.insets = new Insets(0, 0, 5, 5);
	    gbc_lblName.gridx = 0;
	    gbc_lblName.gridy = 0;
	    contentPane.add(lblName, gbc_lblName);
	    JTextField textField = new JTextField();
	    GridBagConstraints gbc_textField = new GridBagConstraints();
	    gbc_textField.anchor = GridBagConstraints.NORTHEAST;
	    gbc_textField.fill = GridBagConstraints.BOTH;
	    gbc_textField.insets = new Insets(0, 0, 5, 0);
	    gbc_textField.gridx = 1;
	    gbc_textField.gridy = 0;
	    contentPane.add(textField, gbc_textField);
	    JLabel label_1 = new JLabel("Last Name:");
	    GridBagConstraints gbc_label_1 = new GridBagConstraints();
	    gbc_label_1.anchor = GridBagConstraints.WEST;
	    gbc_label_1.fill = GridBagConstraints.VERTICAL;
	    gbc_label_1.insets = new Insets(0, 0, 5, 5);
	    gbc_label_1.gridx = 0;
	    gbc_label_1.gridy = 1;
	    contentPane.add(label_1, gbc_label_1);
	    JTextField textField_1 = new JTextField();
	    GridBagConstraints gbc_textField_1 = new GridBagConstraints();
	    gbc_textField_1.fill = GridBagConstraints.BOTH;
	    gbc_textField_1.insets = new Insets(0, 0, 5, 0);
	    gbc_textField_1.gridx = 1;
	    gbc_textField_1.gridy = 1;
	    getContentPane().add(textField_1, gbc_textField_1);
	    JButton button = new JButton("Register");
	    GridBagConstraints gbc_button = new GridBagConstraints();
	    gbc_button.weightx = 1.0;
	    gbc_button.anchor = GridBagConstraints.NORTHEAST;
	    gbc_button.gridx = 1;
	    gbc_button.gridy = 2;
	    contentPane.add(button, gbc_button);
	    
	}
}
