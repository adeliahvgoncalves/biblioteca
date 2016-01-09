package ui;

import javax.swing.JPanel;
import java.awt.Panel;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JButton;

public class LoginMediaQuerie extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	public LoginMediaQuerie() {
		setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(10, 10, 480, 384);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		Panel panel_1 = new Panel();
		panel.add(panel_1, BorderLayout.CENTER);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);
		
		JLabel lblUser = new JLabel("Username");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblUser, 40, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblUser, 49, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblUser, 75, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblUser, 184, SpringLayout.WEST, panel_1);
		panel_1.add(lblUser);
		
		textField = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.NORTH, textField, 40, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, textField, 6, SpringLayout.EAST, lblUser);
		sl_panel_1.putConstraint(SpringLayout.EAST, textField, 245, SpringLayout.EAST, lblUser);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JButton btnEntrar = new JButton("ENTRAR");
		sl_panel_1.putConstraint(SpringLayout.NORTH, btnEntrar, -72, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, btnEntrar, -27, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, btnEntrar, -51, SpringLayout.EAST, panel_1);
		panel_1.add(btnEntrar);
		
		JLabel lblPassword = new JLabel("Password");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblPassword, 25, SpringLayout.SOUTH, lblUser);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblPassword, 0, SpringLayout.WEST, lblUser);
		panel_1.add(lblPassword);
		
		textField_1 = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.NORTH, textField_1, 29, SpringLayout.SOUTH, textField);
		sl_panel_1.putConstraint(SpringLayout.WEST, textField_1, 0, SpringLayout.WEST, textField);
		sl_panel_1.putConstraint(SpringLayout.EAST, textField_1, 0, SpringLayout.EAST, textField);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		Panel panel_2 = new Panel();
		panel.add(panel_2, BorderLayout.NORTH);
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_2, 0, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_2, 0, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_2, 10, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_2, 480, SpringLayout.WEST, panel_1);
		panel_2.setLayout(new BorderLayout(0, 0));
		
	}
}
