package ui;

import javax.swing.JPanel;
import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LeitorPanel extends JPanel {
	private JTable table;
	private JTextField textField;

	private Janela janela;

	/**
	 * Create the panel.
	 */
	public LeitorPanel(Janela j) {
		setLayout(null);

		this.janela = j;
		JLabel lblLeitor = new JLabel("");
		lblLeitor.setBounds(194, 21, 61, 16);
		add(lblLeitor);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 87, 351, 156);
		add(scrollPane);

		table = new JTable();
		scrollPane.setRowHeaderView(table);

		textField = new JTextField();
		textField.setBounds(270, 54, 130, 26);
		add(textField);
		textField.setColumns(10);

		JLabel lblPesquisa = new JLabel("Pesquisa");
		lblPesquisa.setBounds(200, 59, 61, 16);
		add(lblPesquisa);

		JButton btnPesquisaArea = new JButton("Area");
		btnPesquisaArea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPesquisaArea.setBounds(49, 255, 82, 29);
		add(btnPesquisaArea);

		JButton btnPesquisaAutor = new JButton("Autor");
		btnPesquisaAutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPesquisaAutor.setBounds(130, 255, 79, 29);
		add(btnPesquisaAutor);

		JButton btnLogout = new JButton("SAIR");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				janela.sairOK();
			}
		});
		btnLogout.setBounds(341, 255, 90, 29);
		add(btnLogout);

		JButton btnListaEmprestimo = new JButton("Emprestimos");
		btnListaEmprestimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnListaEmprestimo.setBounds(212, 255, 117, 29);
		add(btnListaEmprestimo);

	}

}
