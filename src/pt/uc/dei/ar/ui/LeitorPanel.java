package pt.uc.dei.ar.ui;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import pt.uc.dei.ar.Biblioteca;
import pt.uc.dei.ar.Leitor;
import pt.uc.dei.ar.Utilizador;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ScrollPaneConstants;

public class LeitorPanel extends JPanel implements ActionListener {

	private Janela janela;
	private Utilizador utilizador;
	private JTable table;
	private JTextField txtPesquisa;
	private JTable tabela;
	
	private Biblioteca biblioteca = Biblioteca.getInstance();
	private Leitor leitor;
	/**
	 * Create the panel.
	 */
	public LeitorPanel(Janela j, Utilizador utilizador) {
		setLayout(null);

		this.janela = j;
		this.utilizador=utilizador;
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 38, 488, 343);
		add(tabbedPane);
		
		Panel pnlListaPublicacoes = new Panel();
		tabbedPane.addTab("Lista Publicações", null, pnlListaPublicacoes, null);
		pnlListaPublicacoes.setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 48, 454, 191);
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
		btnSairPublicacoes.setBounds(385, 251, 75, 44);
		pnlListaPublicacoes.add(btnSairPublicacoes);
		
		JButton btnListaTotal = new JButton("Lista Total");
		btnListaTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		btnListaTotal.setBounds(6, 251,  88, 44);
		pnlListaPublicacoes.add(btnListaTotal);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Área ", "Autor", "Titulo"}));
		comboBox.setMaximumRowCount(3);
		comboBox.setBounds(6, 11, 88, 27);
		pnlListaPublicacoes.add(comboBox);
		
		Panel pnlListaEmprestimos = new Panel();
		tabbedPane.addTab("Lista Empréstimos", null, pnlListaEmprestimos, null);
		
		JButton btnSairEmprestimo = new JButton("SAIR");
		btnSairEmprestimo.setBounds(385, 251, 75, 44);
		btnSairEmprestimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				sairLeitorPanel();
				
			}
		});
		pnlListaEmprestimos.setLayout(null);
		pnlListaEmprestimos.add(btnSairEmprestimo);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(6, 48, 454, 191);
		pnlListaEmprestimos.add(scrollPane_1);
		

		//setLayout(new FlowLayout());
		
		String[] colunas={"Código", "Tipo", "Título", "Autor(es)", "Data Publicacao", "Data Receçao" , "Áreas", 
				"Periocidade" ,"Volume"," Nº Sequencial", "Nª Edição", "Orientador", "Tipo de Tese", "Editor", "ISBN"
				};
		
		Object [][] data= new Object[Biblioteca.getInstance().getListaDePublicacoes().size()][15];
		
		
		tabela=new JTable(data, colunas);
		tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabela.setFillsViewportHeight(true);
		
		scrollPane_1.setViewportView(tabela);
		
		JLabel lblLeitor = new JLabel("Bem vindo"+this.utilizador);
		lblLeitor.setBounds(172, 19, 155, 16);
		add(lblLeitor);

	}
	
	public void preencheTabela(){
		
		leitor.consultaEmprestimosLeitor();
			
	}
	
	public void limpaPainel(){
		
		
	}
	
	public void sairLeitorPanel(){
		
		janela.sairOK();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
