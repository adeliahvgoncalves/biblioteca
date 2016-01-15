package pt.uc.dei.ar.ui;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import pt.uc.dei.ar.Biblioteca;
import pt.uc.dei.ar.Emprestimo;
import pt.uc.dei.ar.Jornal;
import pt.uc.dei.ar.Leitor;
import pt.uc.dei.ar.Livro;
import pt.uc.dei.ar.NaoPeriodico;
import pt.uc.dei.ar.Publicacao;
import pt.uc.dei.ar.Revista;
import pt.uc.dei.ar.Tese;
import pt.uc.dei.ar.Utilizador;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
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
	private JTable tabelaPubTotal;
	private JTextField txtPesquisa;
	private JTable tabela;
	private JLabel lblLeitor;

	private JComboBox comboBox;

	private Biblioteca biblioteca = Biblioteca.getInstance();

	private JButton btnPesquisa;
	private JButton btnSairEmprestimo;
	private JButton btnSairPublicacoes;


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

		//Lista de Publicacoes

		Panel pnlListaPublicacoes = new Panel();
		tabbedPane.addTab("Lista Publicações", null, pnlListaPublicacoes, null);
		pnlListaPublicacoes.setLayout(null);

		txtPesquisa = new JTextField();
		txtPesquisa.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {

				txtPesquisa.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
				txtPesquisa.setForeground(Color.BLACK);
				txtPesquisa.setText("");
			}
		});
		txtPesquisa.setText("Pesquisa");
		txtPesquisa.setBounds(330, 10, 130, 26);
		txtPesquisa.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		txtPesquisa.setForeground(Color.LIGHT_GRAY);
		pnlListaPublicacoes.add(txtPesquisa);
		txtPesquisa.setColumns(10);

		btnSairPublicacoes = new JButton("SAIR");
		btnSairPublicacoes.addActionListener(this); 
		btnSairPublicacoes.setBounds(385, 251, 75, 44);
		pnlListaPublicacoes.add(btnSairPublicacoes);

		btnPesquisa = new JButton("Pesquisar");
		btnPesquisa.addActionListener(this);
		btnPesquisa.setBounds(6, 251,  88, 44);
		pnlListaPublicacoes.add(btnPesquisa);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Total","Área", "Autor", "Titulo"}));
		comboBox.setMaximumRowCount(3);
		comboBox.addActionListener(this);
		comboBox.setBounds(6, 11, 88, 27);
		pnlListaPublicacoes.add(comboBox);

		//Lista Emprestimos

		Panel pnlListaEmprestimos = new Panel();
		tabbedPane.addTab("Lista Empréstimos", null, pnlListaEmprestimos, null);
		pnlListaEmprestimos.setLayout(null);

		btnSairEmprestimo = new JButton("SAIR");
		btnSairEmprestimo.setBounds(385, 251, 75, 44);
		btnSairEmprestimo.addActionListener(this);
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



		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(6, 48, 454, 191);
		pnlListaPublicacoes.add(scrollPane);


		String[] colunasPublicacao={"Código", "Tipo", "Título", "Autor(es)", "Data Publicacao", "Data Receçao" , "Áreas", 
				"Periocidade" ,"Volume"," Nº Sequencial", "Nª Edição", "Orientador", "Tipo de Tese", "Editor", "ISBN",
		"Emprestado"};


		Object [][] dataPublicacao = null;


		dataPublicacao = geraDadosDaTabelaPublicacaoTotal(biblioteca.getListaDePublicacoes());

		tabelaPubTotal = new JTable(dataPublicacao, colunasPublicacao);
		tabelaPubTotal.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabela.setFillsViewportHeight(true);
		scrollPane.setViewportView(tabelaPubTotal);


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
			data[i][4] = pub.getDataPublicacao();
			data[i][5] = pub.getDataReceçao();
			data[i][6] = pub.getListaDeAreas();

			if (pub instanceof Revista){
				data[i][3] = "--";
				data[i][7] = ((Revista) pub).getPeriodicidade();
				data[i][8] = ((Revista) pub).getVolume();
				data[i][9] = ((Revista) pub).getNumeroSequencial();
				data[i][10] = "--";	
				data[i][11] = "--";	
				data[i][12] = "--";	
				data[i][13] = "--";	
				data[i][14] = "--";				
			}else  if (pub instanceof Livro){
				data[i][3] = ((NaoPeriodico) pub).getListaDeAutores();	
				data[i][7] = "--";	
				data[i][8] = "--";	
				data[i][9] = "--";		
				data[i][10] = ((Livro) pub).getNumEdicao();
				data[i][11] = "--";	
				data[i][12] = "--";	
				data[i][13] = ((Livro) pub).getEditor();
				data[i][14] = ((Livro) pub).getISBN();

			}	else if ( pub instanceof Tese){	
				data[i][3] = ((NaoPeriodico) pub).getListaDeAutores();	
				data[i][7] = "--";	
				data[i][8] = "--";	
				data[i][9] = "--";	
				data[i][10] = "--";	
				data[i][11] = ((Tese) pub).getNomeDoOrientador();
				data[i][12] = ((Tese) pub).getTipoDeTese();
				data[i][13] = "--";	
				data[i][14] = "--";	

			}

			data[i][15] = emp.getDataEmp();
			data[i][16] = emp.dataMaximaEntrega();
		}

		return data;
	}


	public void preencheTabelaListaPublicacaoTotal(ArrayList<Publicacao> pubs){

		DefaultTableModel dtm = new DefaultTableModel(0, 0);
		// add header of the table
		String[] colunas={"Código de Barras", "Tipo Publicação", "Título", "Autor(es)", "Data Publicação", "Data Receçao" , "Área(s)", 
				"Periocidade" ,"Volume"," Nº Sequencial", "Nº Edição", "Orientador", "Tipo de Tese", "Editor", "ISBN","Emprestada"
		};

		// add header in table model     
		dtm.setColumnIdentifiers(colunas);

		Object[][] publicacoes =geraDadosDaTabelaPublicacaoTotal(pubs);
		for (int i = 0; i < publicacoes.length; i++) {

			dtm.addRow(publicacoes[i]);
		}

		tabelaPubTotal.setModel(dtm);

		//apagar  linhas
		//dtm.setRowCount(0);
	}

	public Object [][] geraDadosDaTabelaPublicacaoTotal(ArrayList<Publicacao> pubs){


		Object [][] data= new Object[pubs.size()][16];

		for (int i = 0; i < pubs.size(); i++) {
			Publicacao pub = pubs.get(i);

			data[i][0] = pub.getCodBarras();
			data[i][1] = pub.getClass().getSimpleName();
			data[i][2] = pub.getTitulo();
			data[i][4] = pub.getDataPublicacao();
			data[i][5] = pub.getDataReceçao();
			data[i][6] = pub.getListaDeAreas();
			if (pub instanceof Revista ){
				data[i][3] = "--";
				data[i][7] = ((Revista) pub).getPeriodicidade();
				data[i][8] = ((Revista) pub).getVolume();
				data[i][9] = ((Revista) pub).getNumeroSequencial();
				data[i][10] = "--";	
				data[i][11] = "--";	
				data[i][12] = "--";	
				data[i][13] = "--";	
				data[i][14] = "--";	
			}
			else if (pub instanceof Jornal){
				data[i][3] = "--";
				data[i][7] = ((Jornal) pub).getPeriodicidade();	
				data[i][8] = "--";	
				data[i][9] = "--";
				data[i][10] = "--";	
				data[i][11] = "--";	
				data[i][12] = "--";	
				data[i][13] = "--";	
				data[i][14] = "--";	
			} else if (pub instanceof Livro){
				data[i][3] = ((NaoPeriodico) pub).getListaDeAutores();	
				data[i][7] = "--";	
				data[i][8] = "--";	
				data[i][9] = "--";	
				data[i][10] = ((Livro) pub).getNumEdicao();	
				data[i][11] = "--";	
				data[i][12] = "--";	
				data[i][13] = ((Livro) pub).getEditor();
				data[i][14] = ((Livro) pub).getISBN();

			}else if (pub instanceof Tese){

				data[i][3] = ((NaoPeriodico) pub).getListaDeAutores();	
				data[i][7] = "--";	
				data[i][8] = "--";	
				data[i][9] = "--";	
				data[i][10] = "--";	
				data[i][11] = ((Tese) pub).getNomeDoOrientador();
				data[i][12] = ((Tese) pub).getTipoDeTese();
				data[i][13] = "--";	
				data[i][14] = "--";	
			}
			if(pub.isOcupado()){
				data[i][15] = "Sim";
			} else {
				data[i][15] = "Não";
			}
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

		String str = (String) this.comboBox.getSelectedItem();

		if(e.getSource() == this.comboBox){

			if(str.equals("Total")){
				txtPesquisa.setText("");
				txtPesquisa.setEditable(false);
				preencheTabelaListaPublicacaoTotal(biblioteca.getListaDePublicacoes());
			}
			if(str.equals("Área") || str.equals("Titulo") || str.equals("Autor") ){

				txtPesquisa.setText("");
				txtPesquisa.setEditable(true);

			}
		}

		if (e.getSource() == this.btnPesquisa) {


			if(str.equals("Total")){

				preencheTabelaListaPublicacaoTotal(biblioteca.getListaDePublicacoes());

			}
			else if(str.equals("Área")){

				ArrayList<Publicacao> pubsArea=biblioteca.pesquisaPorArea(txtPesquisa.getText());

				preencheTabelaListaPublicacaoTotal(pubsArea);



			}
			else if(str.equals("Autor")){
				ArrayList<Publicacao> pubsAutor=biblioteca.pesquisaPublicacaoComParteNomeAutor(txtPesquisa.getText());
				preencheTabelaListaPublicacaoTotal(pubsAutor);

			}
			else if(str.equals("Titulo")){
				ArrayList<Publicacao> pubsParteNome=biblioteca.pesquisaPublicacaoComParteNome(txtPesquisa.getText());
				preencheTabelaListaPublicacaoTotal(pubsParteNome);


			}
		}	
		else if(e.getSource()==this.btnSairEmprestimo){

			sairLeitorPanel();

		}
		else if(e.getSource()==this.btnSairPublicacoes){

			sairLeitorPanel();

		}
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
