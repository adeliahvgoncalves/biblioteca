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
import pt.uc.dei.ar.Emprestimo;
import pt.uc.dei.ar.Leitor;
import pt.uc.dei.ar.Livro;
import pt.uc.dei.ar.NaoPeriodico;
import pt.uc.dei.ar.Publicacao;
import pt.uc.dei.ar.Revista;
import pt.uc.dei.ar.Tese;
import pt.uc.dei.ar.Utilizador;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class LeitorPanel extends JPanel implements ActionListener {

	private Janela janela;
	private Utilizador utilizador;
	private JTable table;
	private JTextField txtPesquisa;
	private JTable tabela;
	private JLabel lblLeitor;
	private Biblioteca biblioteca = Biblioteca.getInstance();

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
		
		
		String[] colunas={"Código", "Tipo", "Título", "Autor(es)", "Data Publicacao", "Data Receçao" , "Áreas", 
				"Periocidade" ,"Volume"," Nº Sequencial", "Nª Edição", "Orientador", "Tipo de Tese", "Editor", "ISBN",
				"Data Empréstimo", "Prazo máximo entrega"};
		
		Object [][] data = null;
		if (utilizador != null) {
			
			data = geraDadosDaTabelaLeitorEmprestimos();
		} else{
			
			data = new Object[Biblioteca.getInstance().getListaDePublicacoes().size()][17];
		}
		
		tabela = new JTable(data, colunas);
		tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabela.setFillsViewportHeight(true);
		scrollPane_1.setViewportView(tabela);
		lblLeitor = new JLabel("");
		lblLeitor.setBounds(110, 19, 310, 16);
		add(lblLeitor);

	}
	
	public void preencheTabelaEmprestimo(){
		
		DefaultTableModel dtm = new DefaultTableModel(0, 0);
		// add header of the table
		String[] colunas={"Código de Barras", "Tipo Publicação", "Título", "Autor(es)", "Data Publicação", "Data Receçao" , "Área(s)", 
				"Periocidade" ,"Volume"," Nº Sequencial", "Nº Edição", "Orientador", "Tipo de Tese", "Editor", "ISBN",
				"Data Empréstimo", "Data máxima entrega"};

		// add header in table model     
		 dtm.setColumnIdentifiers(colunas);
		 

	
		Object[][] emprestimos = geraDadosDaTabelaLeitorEmprestimos();
		 for (int i = 0; i < emprestimos.length; i++) {

			 dtm.addRow(emprestimos[i]);
		 }
		 
		 tabela.setModel(dtm);
	}
	
	
	
	public Object [][] geraDadosDaTabelaLeitorEmprestimos(){
	
		ArrayList<Emprestimo> emprestimos = ((Leitor)utilizador).consultaEmprestimosLeitor();
		Object [][] data= new Object[emprestimos.size()][17];

		for (int i = 0; i < emprestimos.size(); i++) {

			Emprestimo emp = emprestimos.get(i);
			Publicacao pub = (Publicacao) emp.getPublicacao();
			
			data[i][0] = pub.getCodBarras();
			data[i][1] = pub.getClass().getSimpleName();
			data[i][2] = pub.getTitulo();
			if (pub instanceof Revista){
			data[i][3] = "--";
			}
			else if (pub instanceof Livro || pub instanceof Tese){	
				data[i][3] = ((NaoPeriodico) pub).getListaDeAutores();	
			}
			data[i][4] = pub.getDataPublicacao();
			data[i][5] = pub.getDataReceçao();
			data[i][6] = pub.getListaDeAreas();
			if (pub instanceof Revista){
				data[i][7] = ((Revista) pub).getPeriodicidade();
				}
				else if (pub instanceof Livro || pub instanceof Tese){	
					data[i][7] = "--";	
				}
			
			if (pub instanceof Revista){
				data[i][8] = ((Revista) pub).getVolume();
				}
				else if (pub instanceof Livro || pub instanceof Tese){	
					data[i][8] = "--";	
				}
			
			if (pub instanceof Revista){
				data[i][9] = ((Revista) pub).getNumeroSequencial();
				}
				else if (pub instanceof Livro || pub instanceof Tese){	
					data[i][9] = "--";	
				}
			if (pub instanceof Livro){
				data[i][10] = ((Livro) pub).getNumEdicao();
				}
				else if (pub instanceof Revista || pub instanceof Tese){	
					data[i][10] = "--";	
				}
			if (pub instanceof Tese){
				data[i][11] = ((Tese) pub).getNomeDoOrientador();
				}
				else if (pub instanceof Revista || pub instanceof Livro){	
					data[i][11] = "--";	
				}
			if (pub instanceof Tese){
				data[i][12] = ((Tese) pub).getTipoDeTese();
				}
				else if (pub instanceof Revista || pub instanceof Livro){	
					data[i][12] = "--";	
				}
			if (pub instanceof Livro){
				data[i][13] = ((Livro) pub).getEditor();
				}
				else if (pub instanceof Revista || pub instanceof Tese){	
					data[i][13] = "--";	
				}
			if (pub instanceof Livro){
				data[i][14] = ((Livro) pub).getISBN();
				}
				else if (pub instanceof Revista || pub instanceof Tese){	
					data[i][14] = "--";	
				}
			data[i][15] = emp.getDataEmp();
			data[i][16] = emp.dataMaximaEntrega();
		}
		
	return data;
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

	/**
	 * @param utilizador the utilizador to set
	 */
	public void setUtilizador(Utilizador utilizador) {
		this.utilizador = utilizador;
		
		lblLeitor.setText("Bem vindo " + utilizador.getNome());
		
		this.preencheTabelaEmprestimo();
	}
}
