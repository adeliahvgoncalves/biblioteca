package pt.uc.dei.ar.ui;

import java.awt.CardLayout;
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

public class PesquisarPublicacao extends JPanel implements ActionListener {
	private Janela janela;
	private JTextField textFielPesquisa;
	private CardLayout layout;
	private JTable tabela;
	private JButton btnPesquisar;
	private JButton btnSair;
	private JButton btnVoltar;

	public PesquisarPublicacao(Janela j) {
		setLayout(null);

		this.janela = j;
		this.layout = new CardLayout(0, 0);


		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 480, 380);
		add(panel);
		panel.setLayout(null);


		JLabel lblNewLabel = new JLabel("Sobre a publicação");
		lblNewLabel.setBounds(157, 6, 125, 16);
		panel.add(lblNewLabel);

		textFielPesquisa = new JTextField();
		textFielPesquisa.setBounds(210, 33, 183, 26);
		panel.add(textFielPesquisa);
		textFielPesquisa.setColumns(10);

		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(55, 34, 117, 29);
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
		scrollPane_1.setBounds(6, 71, 454, 191);
		panel.add(scrollPane_1);

		//cria tabela

		tabela.setBounds(157, 155, 1, 1);
	//	tabela = new JTable(data, colunas);
		tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabela.setFillsViewportHeight(true);
		scrollPane_1.setViewportView(tabela);

		String[] colunas={"Código", "Tipo", "Título", "Autor(es)", "Data Publicacao", "Data Receçao" , "Áreas", 
				"Periocidade" ,"Volume"," Nº Sequencial", "Nª Edição", "Orientador", "Tipo de Tese", "Editor", "ISBN"
		};

		Object [][] data = null;


		data = new Object[1][17];


		tabela = new JTable(data, colunas);


	}

	public void preencheTabelaEmprestimo(){

		DefaultTableModel dtm = new DefaultTableModel(0, 0);
		// add header of the table
		String[] colunas={"Código de Barras", "Tipo Publicação", "Título", "Autor(es)", "Data Publicação", "Data Receçao" , "Área(s)", 
				"Periocidade" ,"Volume"," Nº Sequencial", "Nº Edição", "Orientador", "Tipo de Tese", "Editor", "ISBN",
		};
		//"Data Empréstimo", "Prazo máximo entrega"
		// add header in table model     
		dtm.setColumnIdentifiers(colunas);



		Object[][] emprestimos = obterUmaPublicacao(textFielPesquisa.getText());
		for (int i = 0; i < emprestimos.length; i++) {

			dtm.addRow(emprestimos[i]);
		}

		tabela.setModel(dtm);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == this.btnPesquisar) {

			preencheTabelaEmprestimo();

		} else if (e.getSource() == this.btnSair) {

			janela.sairOK();

		} else if (e.getSource() == this.btnVoltar) {

			janela.bibliotecarioChefeOK();

		}

	}

	public Object [][] obterUmaPublicacao(String nome){

		Publicacao pub = Biblioteca.getInstance().pesquisaPublicacao(nome);
		Object [][] data= new Object[1][17];

		for (int i = 0; i <= 15; i++) {
			data[i][0] = pub.getCodBarras();
			data[i][1] = pub.getClass();
			data[i][2] = pub.getTitulo();
			if (pub instanceof Revista || pub instanceof Jornal){
				data[i][3] = "--";
			}
			else if (pub instanceof Livro || pub instanceof Tese){	
				data[i][3] = ((NaoPeriodico) pub).getListaDeAutores();	
			}
			data[i][4] = pub.getDataPublicacao();
			data[i][5] = pub.getDataReceçao();
			data[i][6] = pub.getListaDeAreas();
			if (pub instanceof Revista ){
				data[i][7] = ((Revista) pub).getPeriodicidade();
			} else if (pub instanceof Jornal ){
				data[i][7] = ((Jornal) pub).getPeriodicidade();
			}
			else if (pub instanceof Livro || pub instanceof Tese){	
				data[i][7] = "--";	
			}

			if (pub instanceof Revista){
				data[i][8] = ((Revista) pub).getVolume();
			}
			else if (pub instanceof Livro || pub instanceof Tese || pub instanceof Jornal){	
				data[i][8] = "--";	
			}

			if (pub instanceof Revista){
				data[i][9] = ((Revista) pub).getNumeroSequencial();
			}
			else if (pub instanceof Livro || pub instanceof Tese || pub instanceof Jornal){	
				data[i][9] = "--";	
			}
			if (pub instanceof Livro){
				data[i][10] = ((Livro) pub).getNumEdicao();
			}
			else if(pub instanceof Jornal){
				data[i][10] = ((Jornal) pub).getNumEdicao();
			}
			else if (pub instanceof Revista || pub instanceof Tese){	
				data[i][10] = "--";	
			}
			if (pub instanceof Tese){
				data[i][11] = ((Tese) pub).getNomeDoOrientador();
			}
			else if (pub instanceof Revista || pub instanceof Livro || pub instanceof Jornal){	
				data[i][11] = "--";	
			}
			if (pub instanceof Tese){
				data[i][12] = ((Tese) pub).getTipoDeTese();
			}
			else if (pub instanceof Revista || pub instanceof Livro || pub instanceof Jornal){	
				data[i][12] = "--";	
			}
			if (pub instanceof Livro ){
				data[i][13] = ((Livro) pub).getEditor();
			}
			else if (pub instanceof Revista || pub instanceof Tese || pub instanceof Jornal){	
				data[i][13] = "--";	
			}
			if (pub instanceof Livro){
				data[i][14] = ((Livro) pub).getISBN();
			}
			else if (pub instanceof Revista || pub instanceof Tese || pub instanceof Jornal){	
				data[i][14] = "--";	
			}
			if(pub.isOcupado()){
				for(Emprestimo emp: Biblioteca.getInstance().getListaDeEmprestimo()){
					if(emp.getPublicacao().equals(nome)){
						data[i][15] = emp.getDataEmp();
					}
				}
			}
			else if (!pub.isOcupado()){
				data[i][15] = "--";
			}

			if(pub.isOcupado()){
				for(Emprestimo emp: Biblioteca.getInstance().getListaDeEmprestimo()){
					if(emp.getPublicacao().equals(nome)){
						data[i][16] = emp.dataMaximaEntrega();;
					}
				}
			}
			else if (!pub.isOcupado()){
				data[i][16] = "--";
			}


		}

		return data;
	}


}





