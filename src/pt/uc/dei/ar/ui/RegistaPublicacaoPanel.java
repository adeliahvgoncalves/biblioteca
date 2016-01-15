package pt.uc.dei.ar.ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

import pt.uc.dei.ar.Biblioteca;
import pt.uc.dei.ar.Periodicidade;
import pt.uc.dei.ar.TipoDeTese;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class RegistaPublicacaoPanel extends JPanel implements ActionListener{
	private JTextField txtTitulo;
	private JTextField txtAreas;
	private JTextField txtDataPublicacao;
	private JTextField txtDataRecepcao;
	private JTextField txtAutores;
	private JTextField txtNumEdicao;
	private JTextField txtEditor;
	private JTextField txtIsbn;
	private JTextField txtAutor;
	private JTextField txtOrientador;
	private JTextField txtVolume;
	private JTextField txtNumEdicaoJornal;
	
	private JLabel lblNumEdicaoJornal;
	private JLabel lblVolume;

	private JButton btnSair;
	private JButton btnVoltar;
	private JButton btnRegistar;

	private Janela janela;
	private CardLayout layout;

	private JPanel pnlTipoPublicacao;
	private JPanel pnlTese;
	private JPanel pnlLivro;
	private JPanel pnlPeriodico;

	private JComboBox comboBox;
	private JComboBox comboBoxTipoTese;
	private JComboBox comboBoxPeriodicidade;
	

	private Biblioteca biblioteca = Biblioteca.getInstance();
	private JLabel lblMensagem;

	/**
	 * Create the panel.
	 */
	public RegistaPublicacaoPanel(Janela j) {
		setLayout(null);

		this.janela = j;
		this.layout = new CardLayout(0, 0);

		JPanel pnlRegistaPublicacao = new JPanel();
		pnlRegistaPublicacao.setBounds(6, 6, 462, 369);
		add(pnlRegistaPublicacao);
		pnlRegistaPublicacao.setLayout(null);

		JLabel lblRegistarPublicaes = new JLabel("Registar Publicações");
		lblRegistarPublicaes.setBounds(165, 6, 129, 16);
		pnlRegistaPublicacao.add(lblRegistarPublicaes);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Livro", "Tese", "Revista", "Jornal" }));
		comboBox.addActionListener(this);
		comboBox.setBounds(336, 25, 101, 27);
		pnlRegistaPublicacao.add(comboBox);

		JLabel lblTipoDePublicao = new JLabel("Tipo de publicação");
		lblTipoDePublicao.setBounds(199, 29, 119, 16);
		pnlRegistaPublicacao.add(lblTipoDePublicao);

		JLabel lblTitulo = new JLabel("Título");
		lblTitulo.setBounds(39, 67, 61, 16);
		pnlRegistaPublicacao.add(lblTitulo);

		txtTitulo = new JTextField();
		txtTitulo.setBounds(151, 62, 286, 26);
		pnlRegistaPublicacao.add(txtTitulo);
		txtTitulo.setColumns(10);

		JLabel lblAreas = new JLabel("Áreas");
		lblAreas.setBounds(39, 95, 61, 16);
		pnlRegistaPublicacao.add(lblAreas);

		txtAreas = new JTextField();
		txtAreas.setBounds(151, 90, 286, 26);
		pnlRegistaPublicacao.add(txtAreas);
		txtAreas.setColumns(10);

		JLabel lblDataPublicacao = new JLabel("Data Publicação");
		lblDataPublicacao.setBounds(39, 123, 101, 16);
		pnlRegistaPublicacao.add(lblDataPublicacao);

		txtDataPublicacao = new JTextField();
		txtDataPublicacao.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				
				txtDataPublicacao.setText("");
				txtDataPublicacao.setForeground(Color.BLACK);
				txtDataPublicacao.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
				
			}
		});
		txtDataPublicacao.setText("DD/MM/AAAA");
		txtDataPublicacao.setForeground(Color.LIGHT_GRAY);
		txtDataPublicacao.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		txtDataPublicacao.setBounds(151, 118, 130, 26);
		pnlRegistaPublicacao.add(txtDataPublicacao);
		txtDataPublicacao.setColumns(10);

		JLabel lblDataRecepo = new JLabel("Data Recepção");
		lblDataRecepo.setBounds(39, 151, 101, 16);
		pnlRegistaPublicacao.add(lblDataRecepo);

		txtDataRecepcao = new JTextField();
		txtDataRecepcao.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtDataRecepcao.setForeground(Color.BLACK);
				txtDataRecepcao.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
				txtDataRecepcao.setText("");
			}
		});
		txtDataRecepcao.setText("DD/MM/AAAA");
		txtDataRecepcao.setForeground(Color.LIGHT_GRAY);
		txtDataRecepcao.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		txtDataRecepcao.setBounds(151, 146, 130, 26);
		pnlRegistaPublicacao.add(txtDataRecepcao);
		txtDataRecepcao.setColumns(10);

		// Painel conjunto

		this.pnlTipoPublicacao = new JPanel();
		pnlTipoPublicacao.setBounds(6, 172, 450, 115);
		pnlRegistaPublicacao.add(pnlTipoPublicacao);
		pnlTipoPublicacao.setLayout(layout);

		// Livro

		this.pnlLivro = new JPanel();
		pnlLivro.setBounds(6, 6, 438, 115);
		pnlTipoPublicacao.add(pnlLivro, "livro");
		pnlLivro.setLayout(null);

		JLabel lblAutores = new JLabel("Autor(es)");
		lblAutores.setBounds(36, 6, 61, 16);
		pnlLivro.add(lblAutores);

		txtAutores = new JTextField();
		txtAutores.setBounds(146, 1, 280, 26);
		pnlLivro.add(txtAutores);
		txtAutores.setColumns(10);

		JLabel lblNumEdicao = new JLabel("Nº Edição");
		lblNumEdicao.setBounds(36, 34, 61, 16);
		pnlLivro.add(lblNumEdicao);

		txtNumEdicao = new JTextField();
		txtNumEdicao.setBounds(146, 29, 130, 26);
		pnlLivro.add(txtNumEdicao);
		txtNumEdicao.setColumns(10);

		JLabel lblEditor = new JLabel("Editor");
		lblEditor.setBounds(36, 62, 61, 16);
		pnlLivro.add(lblEditor);

		txtEditor = new JTextField();
		txtEditor.setBounds(146, 57, 130, 26);
		pnlLivro.add(txtEditor);
		txtEditor.setColumns(10);

		JLabel lblIsbn = new JLabel("ISBN");
		lblIsbn.setBounds(36, 90, 61, 16);
		pnlLivro.add(lblIsbn);

		txtIsbn = new JTextField();
		txtIsbn.setBounds(146, 85, 130, 26);
		pnlLivro.add(txtIsbn);
		txtIsbn.setColumns(10);

		// Painel Periodicos

		pnlPeriodico = new JPanel();
		pnlTipoPublicacao.add(pnlPeriodico, "periodico");
		pnlPeriodico.setLayout(null);

		comboBoxPeriodicidade = new JComboBox();
		comboBoxPeriodicidade.setModel(new DefaultComboBoxModel(
				new String[] { "Diário", "Semanal", "Quinzenal", "Mensal", "Trimestral", "Semestral", "Anual" }));
		comboBoxPeriodicidade.setBounds(299, 6, 134, 27);
		pnlPeriodico.add(comboBoxPeriodicidade);

		JLabel lblPeriodicidade = new JLabel("Periodicidade");
		lblPeriodicidade.setBounds(196, 10, 84, 16);
		pnlPeriodico.add(lblPeriodicidade);

		lblVolume = new JLabel("Volume");
		lblVolume.setBounds(38, 46, 61, 16);
		pnlPeriodico.add(lblVolume);

		lblNumEdicaoJornal = new JLabel("Nº Edição");
		lblNumEdicaoJornal.setBounds(38, 79, 61, 16);
		pnlPeriodico.add(lblNumEdicaoJornal);

		txtVolume = new JTextField();
		txtVolume.setBounds(150, 38, 130, 26);
		pnlPeriodico.add(txtVolume);
		txtVolume.setColumns(10);

		txtNumEdicaoJornal = new JTextField();
		txtNumEdicaoJornal.setBounds(150, 74, 130, 26);
		pnlPeriodico.add(txtNumEdicaoJornal);
		txtNumEdicaoJornal.setColumns(10);

		// Tese

		this.pnlTese = new JPanel();
		pnlTese.setBounds(6, 6, 438, 115);
		pnlTipoPublicacao.add(pnlTese, "tese");
		pnlTese.setLayout(null);

		comboBoxTipoTese = new JComboBox();
		comboBoxTipoTese.setModel(new DefaultComboBoxModel(new String[] { "Mestrado", "Doutoramento" }));
		comboBoxTipoTese.setBounds(279, 6, 153, 27);
		pnlTese.add(comboBoxTipoTese);

		JLabel lblTipoTese = new JLabel("Tipo de tese");
		lblTipoTese.setBounds(171, 10, 96, 16);
		pnlTese.add(lblTipoTese);

		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setBounds(35, 36, 61, 16);
		pnlTese.add(lblAutor);

		txtAutor = new JTextField();
		txtAutor.setBounds(148, 31, 130, 26);
		pnlTese.add(txtAutor);
		txtAutor.setColumns(10);

		JLabel lblOrientador = new JLabel("Orientador");
		lblOrientador.setBounds(35, 64, 76, 16);
		pnlTese.add(lblOrientador);

		txtOrientador = new JTextField();
		txtOrientador.setBounds(148, 59, 130, 26);
		pnlTese.add(txtOrientador);
		txtOrientador.setColumns(10);

		// Butões

		btnSair = new JButton("Sair");
		btnSair.addActionListener(this);
		btnSair.setBounds(375, 323, 81, 40);
		pnlRegistaPublicacao.add(btnSair);

		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(this);
		btnVoltar.setBounds(282, 323, 81, 40);
		pnlRegistaPublicacao.add(btnVoltar);

		btnRegistar = new JButton("Registar");
		btnRegistar.addActionListener(this);
		btnRegistar.setBounds(27, 323, 95, 40);
		pnlRegistaPublicacao.add(btnRegistar);

		lblMensagem = new JLabel("");
		lblMensagem.setBounds(6, 295, 450, 16);
		pnlRegistaPublicacao.add(lblMensagem);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Falta Colocar o botao do registar e fazer os ultimos dois
		// paineis

		if (e.getSource() == this.btnSair) {

			janela.sairOK();
		}

		else if (e.getSource() == this.btnVoltar) {

			janela.bibliotecarioChefeOK();

		} else if (e.getSource() == this.comboBox) {

			String str = (String) this.comboBox.getSelectedItem();

			if (str.equals("Livro")) {

				abrePainelLivroOK();

			} else if (str.equals("Tese")) {

				abrePainelTeseOK();
				
			} else if (str.equals("Revista")) {

				txtVolume.setVisible(true);
				lblVolume.setVisible(true);
				txtNumEdicaoJornal.setVisible(false);
				lblNumEdicaoJornal.setVisible(false);
				abrePainelPeriodicoOK();

			} else if (str.equals("Jornal")) {

				txtNumEdicaoJornal.setVisible(true);
				lblNumEdicaoJornal.setVisible(true);
				txtVolume.setVisible(false);
				lblVolume.setVisible(false);
				abrePainelPeriodicoOK();

			}
		}

		else if (e.getSource() == this.btnRegistar) {

			registaPublicacao();

		}

	}

	public void registaPublicacao() {

		String str = (String) this.comboBox.getSelectedItem();
		String strTese = (String) this.comboBoxTipoTese.getSelectedItem();
		
		String[] auxAutor = this.txtAutor.getText().split(",");
		ArrayList<String> autores = new ArrayList<String>();
		
		String[] auxArea = this.txtAreas.getText().split(",");
		ArrayList<String> areas = new ArrayList<String>();
		
		for (int i = 0; i < auxAutor.length; i++) {
			autores.add(auxAutor[i]);
		}
		for (int i = 0; i < auxArea.length; i++) {
			areas.add(auxArea[i]);
		}

		if (str.equals("Livro")) {

			if (txtTitulo.getText().equals("") || txtAreas.getText().equals("")
					|| txtDataPublicacao.getText().equals("") || txtDataRecepcao.getText().equals("")
					|| txtNumEdicao.getText().equals("") || txtEditor.getText().equals("")
					|| txtIsbn.getText().equals("")) {

				enviaMensagem("ERRO: Não introduziu os campos todos para registar a publicação.");
				

			} else

			registaLivro(autores, areas);

		}

		if (str.equals("Tese")) {

			if (txtTitulo.getText().equals("") || txtAreas.getText().equals("")
					|| txtDataPublicacao.getText().equals("") || txtDataRecepcao.getText().equals("")
					|| txtOrientador.getText().equals("") || txtAutor.getText().equals("")) {

				enviaMensagem("ERRO: Não introduziu os campos todos para registar a publicação.");
				limpaPainel();
			}
			else 
				registaTese(autores, areas);
		}	
		if(str.equals("Revista")){
			
			if(txtTitulo.getText().equals("") || txtAreas.getText().equals("")
					|| txtDataPublicacao.getText().equals("") || txtDataRecepcao.getText().equals("") 
					|| txtVolume.getText().equals("")){
				
				enviaMensagem("ERRO: Não introduziu os campos todos para registar a publicação.");
				limpaPainel();
				
			}
			else
				registaPeriodico(areas, str);
		}
		if(str.equals("Jornal")){
			
			if(txtTitulo.getText().equals("") || txtAreas.getText().equals("")
					|| txtDataPublicacao.getText().equals("") || txtDataRecepcao.getText().equals("") 
					|| txtNumEdicaoJornal.getText().equals("")){
				
				enviaMensagem("ERRO: Não introduziu os campos todos para registar a publicação.");
				limpaPainel();
				
			}
			else
				registaPeriodico(areas, str);
		}
	}
	public void registaLivro(ArrayList<String> autores, ArrayList<String> areas){
		
		int codigoBarras;
		
		codigoBarras = biblioteca.criaLivro(txtTitulo.getText(), txtDataPublicacao.getText(),
				txtDataRecepcao.getText(), autores, areas, txtNumEdicao.getText(), txtIsbn.getText(),
				txtEditor.getText());

		limpaPainel();
		enviaMensagem("Livro inserido com sucesso. CODIGO DE BARRAS: " + codigoBarras);
		
	}
	
	public void registaTese(ArrayList<String> autores, ArrayList<String> areas){
		
		String strTese = (String) this.comboBoxTipoTese.getSelectedItem();
		int codigoBarras;
		
		if (strTese.equals("Mestrado")) {

			codigoBarras = biblioteca.criaTese(txtTitulo.getText(), txtDataPublicacao.getText(),
					txtDataRecepcao.getText(), autores, areas, txtOrientador.getText(), TipoDeTese.Mestrado);

			limpaPainel();
			enviaMensagem("Tese inserida com sucesso. CODIGO DE BARRAS: " + codigoBarras);
			
		} else
			codigoBarras = biblioteca.criaTese(txtTitulo.getText(), txtDataPublicacao.getText(),
					txtDataRecepcao.getText(), autores, areas, txtOrientador.getText(), TipoDeTese.Doutoramento);
		
			limpaPainel();
			enviaMensagem("Tese inserida com sucesso. CODIGO DE BARRAS: " + codigoBarras);
			
	}
	
	public void registaPeriodico(ArrayList<String> areas, String tipoPeriodico){
		
		String strPeriodicidade = (String) this.comboBoxPeriodicidade.getSelectedItem();
		int codigoBarras;
		
		Periodicidade p = null;
		
		if(strPeriodicidade.equals("Diária")){	
			p=Periodicidade.Diaria;	
		}
		else if(strPeriodicidade.equals("Semanal")){
			p=Periodicidade.Semanal;
		}
		else if(strPeriodicidade.equals("Quinzenal")){
			p=Periodicidade.Quinzenal;
		}	
		else if(strPeriodicidade.equals("Mensal")){
			p=Periodicidade.Mensal;
		}
		else if(strPeriodicidade.equals("Trimestral")){
			p=Periodicidade.Trimestral;
		}
		else if(strPeriodicidade.equals("Semestral")){
			p=Periodicidade.Semestral;
		}
		else if(strPeriodicidade.equals("Anual")) {
			p=Periodicidade.Anual;
		}
		
		
		if(tipoPeriodico.equals("Revista")){
			
			codigoBarras = biblioteca.criaRevista(txtTitulo.getText(), txtDataPublicacao.getText(),
					txtDataRecepcao.getText(), areas, p, Integer.parseInt(txtVolume.getText()));
		
			limpaPainel();
			enviaMensagem("Revista inserida com sucesso. CODIGO DE BARRAS: " + codigoBarras);
			
		}
		else if((tipoPeriodico.equals("Jornal"))){
			
			biblioteca.criaJornal(txtTitulo.getText(), txtDataPublicacao.getText(),
			txtDataRecepcao.getText(), areas, p, Integer.parseInt(txtNumEdicaoJornal.getText()));
		
			limpaPainel();
			enviaMensagem("Jornal inserido com sucesso.");
		}

	}

	public void limpaPainel(){
		
		txtTitulo.setText("");
		txtAreas.setText("");
		txtDataPublicacao.setText("");
		txtDataRecepcao.setText("");
		txtAutores.setText("");
		txtNumEdicao.setText("");
		txtEditor.setText("");
		txtIsbn.setText("");
		txtAutor.setText("");
		txtOrientador.setText("");
		txtVolume.setText("");
		txtNumEdicaoJornal.setText("");
		
	}	

	public void abrePainelLivroOK() {

		layout.show(pnlTipoPublicacao, "livro");

	}

	public void abrePainelTeseOK() {

		layout.show(pnlTipoPublicacao, "tese");

	}

	public void abrePainelPeriodicoOK() {

		layout.show(pnlTipoPublicacao, "periodico");

	}

	public void enviaMensagem(String s) {

		lblMensagem.setText(s);

	}
}
