package pt.uc.dei.ar.ui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import pt.uc.dei.ar.Biblioteca;
import pt.uc.dei.ar.Emprestimo;
import pt.uc.dei.ar.Jornal;
import pt.uc.dei.ar.Livro;
import pt.uc.dei.ar.NaoPeriodico;
import pt.uc.dei.ar.Publicacao;
import pt.uc.dei.ar.Revista;
import pt.uc.dei.ar.Tese;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class PesquisarPublicacao extends JPanel implements ActionListener, FocusListener {
	private Janela janela;
	private JTextField txtPesquisa;
	private CardLayout layout;
	private JTable tabela;
	private JButton btnPesquisar;
	private JButton btnSair;
	private JButton btnVoltar;
	private Biblioteca biblioteca = Biblioteca.getInstance();
	private Publicacao pub;
	
	private JLabel lblMensagem;

	public PesquisarPublicacao(Janela j) {
		setLayout(null);

		this.janela = j;
		this.layout = new CardLayout(0, 0);


		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 480, 380);
		add(panel);
		panel.setLayout(null);


		JLabel lblNewLabel = new JLabel("Acerca da publicação");
		lblNewLabel.setBounds(189, 6, 135, 16);
		panel.add(lblNewLabel);


		txtPesquisa = new JTextField();
		txtPesquisa.addFocusListener(this);
		txtPesquisa.setText("pesquisar");
		txtPesquisa.setEditable(true);
		txtPesquisa.setForeground(Color.LIGHT_GRAY);
		txtPesquisa.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		txtPesquisa.setToolTipText("");
		txtPesquisa.setBounds(67, 34, 183, 26);
		panel.add(txtPesquisa);
		txtPesquisa.setColumns(10);

		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(312, 34, 126, 29);
		btnPesquisar.addActionListener(this);
		panel.add(btnPesquisar);

		btnSair = new JButton("Sair");
		btnSair.addActionListener(this);
		btnSair.setBounds(376, 297, 75, 40);
		panel.add(btnSair);

		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(this);
		btnVoltar.setBounds(283, 297, 81, 40);
		panel.add(btnVoltar);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(6, 71, 468, 199);
		panel.add(scrollPane_1);

		String[] colunas={"Código de barras", "Tipo", "Título", "Autor(es)", "Data Publicacao", "Data Receçao" , "Áreas", 
				"Periocidade" ,"Volume"," Nº Sequencial", "Nª Edição", "Orientador", "Tipo de Tese", "Editor", "ISBN",
				"Data Empréstimo", "Prazo máximo entrega"};

		Object [][] data = null;
		data = new Object[1][17];

		//cria tabela
		tabela = new JTable(data, colunas);
		tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabela.setFillsViewportHeight(true);
		scrollPane_1.setViewportView(tabela);
		
		lblMensagem = new JLabel("");
		lblMensagem.setBounds(16, 280, 435, 16);
		panel.add(lblMensagem);

	}

	private void preencheTabelaEmprestimo(){

		DefaultTableModel dtm = new DefaultTableModel(0, 0);
		// add header of the table
		String[] colunas={"Código de Barras", "Tipo Publicação", "Título", "Autor(es)", "Data Publicação", "Data Receçao" , "Área(s)", 
				"Periocidade" ,"Volume"," Nº Sequencial", "Nº Edição", "Orientador", "Tipo de Tese", "Editor", "ISBN",
				"Data Empréstimo", "Data máxima entrega"};

		// add header in table model     
		dtm.setColumnIdentifiers(colunas);

		Object[][] publicacao = obterUmaPublicacao();
		for (int i = 0; i < publicacao.length; i++) {

			dtm.addRow(publicacao[i]);
		}

		tabela.setModel(dtm);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == this.btnSair) {

			janela.sairOK();

		} else if (e.getSource() == this.btnVoltar) {

			janela.bibliotecarioChefeOK();

		}
		else if (e.getSource() == this.btnPesquisar) {

			this.preencheTabelaEmprestimo();
			txtPesquisa.setText("");
			
		}
	}

	private Object [][] obterUmaPublicacao(){
		//aloco a minha tabela vazia
		Object [][] data= new Object[1][17]; 

		String text = this.txtPesquisa.getText();
		try {
			int d = Integer.parseInt(text); 
		 pub = biblioteca.pesquisaPublicacaoPorCodBarras(d);
		} catch (NumberFormatException nfe) {
			pub = biblioteca.pesquisaPublicacao(txtPesquisa.getText());
		}

		//tento encontrar uma publicacao com o pesqusia, se nao encontro mando a tabela vazia
		if (pub == null) {
			this.lblMensagem.setText("Erro! Não existe essa publicação. Tente novamente.");
						return data;
			
			
		}
		
		

		data[0][0] = pub.getCodBarras();
		data[0][1] = pub.getClass().getSimpleName();
		data[0][2] = pub.getTitulo();
		if (pub instanceof Revista || pub instanceof Jornal){
			data[0][3] = "--";
		}
		else if (pub instanceof Livro || pub instanceof Tese){	
			data[0][3] = ((NaoPeriodico) pub).getListaDeAutores();	
		}
		data[0][4] = pub.getDataPublicacao();
		data[0][5] = pub.getDataReceçao();
		data[0][6] = pub.getListaDeAreas();
		if (pub instanceof Revista ){
			data[0][7] = ((Revista) pub).getPeriodicidade();
		} else if (pub instanceof Jornal ){
			data[0][7] = ((Jornal) pub).getPeriodicidade();
		}
		else if (pub instanceof Livro || pub instanceof Tese){	
			data[0][7] = "--";	
		}

		if (pub instanceof Revista){
			data[0][8] = ((Revista) pub).getVolume();
			data[0][9] = ((Revista) pub).getNumeroSequencial();
		}
		else if (pub instanceof Livro || pub instanceof Tese || pub instanceof Jornal){	
			data[0][8] = "--";	
			data[0][9] = "--";	
		}
		if (pub instanceof Livro){
			data[0][10] = ((Livro) pub).getNumEdicao();
		}
		else if(pub instanceof Jornal){
			data[0][10] = ((Jornal) pub).getNumEdicao();
		}
		else if (pub instanceof Revista || pub instanceof Tese){	
			data[0][10] = "--";	
		}
		if (pub instanceof Tese){
			data[0][11] = ((Tese) pub).getNomeDoOrientador();
			data[0][12] = ((Tese) pub).getTipoDeTese();
		}
		else if (pub instanceof Revista || pub instanceof Livro || pub instanceof Jornal){	
			data[0][11] = "--";	
			data[0][12] = "--";	
		}

		if (pub instanceof Livro ){
			data[0][13] = ((Livro) pub).getEditor();
			data[0][14] = ((Livro) pub).getISBN();
		}
		else if (pub instanceof Revista || pub instanceof Tese || pub instanceof Jornal){	
			data[0][13] = "--";	
			data[0][14] = "--";	
		}

		if(pub.isOcupado()){
			for(Emprestimo emp: biblioteca.getListaDeEmprestimo()){
				if(emp.getPublicacao().equals(pub )){
					data[0][15] = emp.getDataEmp();
					data[0][16] = emp.dataMaximaEntrega();
				}
			}
		}
		else if (!pub.isOcupado()){
			data[0][15] = "--";
			data[0][16] = "--";
		}

		return data;
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.txtPesquisa){
			txtPesquisa.setText("");
			txtPesquisa.setForeground(Color.BLACK);
			txtPesquisa.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		}
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
}





