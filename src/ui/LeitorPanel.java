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
import javax.swing.JTabbedPane;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class LeitorPanel extends JPanel {

	private Janela janela;
	private JTable table;
	private JTextField txtPesquisa;
	private JTable table_1;

	/**
	 * Create the panel.
	 */
	public LeitorPanel(Janela j) {
		setLayout(null);

		this.janela = j;
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 38, 487, 356);
		add(tabbedPane);
		
		Panel pnlListaPublicacoes = new Panel();
		tabbedPane.addTab("Lista Publicações", null, pnlListaPublicacoes, null);
		pnlListaPublicacoes.setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 48, 454, 202);
		pnlListaPublicacoes.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		txtPesquisa = new JTextField();
		txtPesquisa.setText("pesquisar");
		txtPesquisa.setEditable(false);
		txtPesquisa.setToolTipText("");
		txtPesquisa.setBounds(330, 10, 130, 26);
		pnlListaPublicacoes.add(txtPesquisa);
		txtPesquisa.setColumns(10);
		
		JButton btnSairPublicacoes = new JButton("SAIR");
		btnSairPublicacoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				sairLeitorPanel();
				
			}
		});
		btnSairPublicacoes.setBounds(354, 262, 75, 44);
		pnlListaPublicacoes.add(btnSairPublicacoes);
		
		JButton btnListaTotal = new JButton("Lista Total");
		btnListaTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		btnListaTotal.setBounds(6, 262,  88, 44);
		pnlListaPublicacoes.add(btnListaTotal);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Área ", "Autor", "Titulo"}));
		comboBox.setMaximumRowCount(3);
		comboBox.setBounds(6, 11, 88, 27);
		pnlListaPublicacoes.add(comboBox);
		
		Panel pnlListaEmprestimos = new Panel();
		tabbedPane.addTab("Lista Empréstimos", null, pnlListaEmprestimos, null);
		
		JButton btnSairEmprestimo = new JButton("SAIR");
		btnSairEmprestimo.setBounds(354, 262, 75, 44);
		btnSairEmprestimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				sairLeitorPanel();
				
			}
		});
		pnlListaEmprestimos.setLayout(null);
		pnlListaEmprestimos.add(btnSairEmprestimo);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(6, 55, 454, 195);
		pnlListaEmprestimos.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblLeitor = new JLabel("");
		lblLeitor.setBounds(172, 19, 155, 16);
		add(lblLeitor);

	}
	
	public void limpaPainel(){
		
		
	}
	
	public void sairLeitorPanel(){
		
		janela.sairOK();
	}
}
