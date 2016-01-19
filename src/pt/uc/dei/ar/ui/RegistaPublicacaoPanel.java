package pt.uc.dei.ar.ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

import pt.uc.dei.ar.Biblioteca;
import pt.uc.dei.ar.BibliotecaSerializer;
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
import java.awt.event.FocusListener;
import java.text.SimpleDateFormat;

import com.michaelbaranov.microba.calendar.DatePicker;


/**
 * Interface do RegistaPublicacaoPanel para registar uma publicação na Biblioteca.
 * Regista os diversos tipos de publicações na Biblioteca.
 * @author Adelia Goncalves e Maria Joao Silva
 *
 */
public class RegistaPublicacaoPanel extends JPanel implements ActionListener, FocusListener {
	
	/**
	 *A janela é atributo da RegistaPublicacaoPanel
	 */
	private Janela janela;
	/**
	 *pnlTipoPublicacao é atributo da RegistaPublicacaoPanel
	 */
	private JPanel pnlTipoPublicacao;
	/**
	 *pnlTese é atributo da RegistaPublicacaoPanel
	 */
	private JPanel pnlTese;
	/**
	 *pnlLivro é atributo da RegistaPublicacaoPanel
	 */
	private JPanel pnlLivro;
	/**
	 *pnlPeriodico é atributo da RegistaPublicacaoPanel
	 */
	private JPanel pnlPeriodico;
	/**
	 *txtTitulo é atributo da RegistaPublicacaoPanel
	 */
	private JTextField txtTitulo;
	/**
	 *txtAreas é atributo da RegistaPublicacaoPanel
	 */
	private JTextField txtAreas;
	/**
	 *txtAutores é atributo da RegistaPublicacaoPanel
	 */
	private JTextField txtAutores;
	/**
	 *txtNumEdicao é atributo da RegistaPublicacaoPanel
	 */
	private JTextField txtNumEdicao;
	/**
	 *txtEditor é atributo da RegistaPublicacaoPanel
	 */
	private JTextField txtEditor;
	/**
	 *txtIsbn é atributo da RegistaPublicacaoPanel
	 */
	private JTextField txtIsbn;
	/**
	 *txtAutor é atributo da RegistaPublicacaoPanel
	 */
	private JTextField txtAutor;
	/**
	 *txtOrientador é atributo da RegistaPublicacaoPanel
	 */
	private JTextField txtOrientador;
	/**
	 *txtVolume é atributo da RegistaPublicacaoPanel
	 */
	private JTextField txtVolume;
	/**
	 *txtNumEdicaoJornal é atributo da RegistaPublicacaoPanel
	 */
	private JTextField txtNumEdicaoJornal;
	/**
	 *lblNumEdicaoJornal é atributo da RegistaPublicacaoPanel
	 */
	private JLabel lblNumEdicaoJornal;
	/**
	 *lblVolume é atributo da RegistaPublicacaoPanel
	 */
	private JLabel lblVolume;
	/**
	 *lblMensagem é atributo da RegistaPublicacaoPanel
	 */
	private JLabel lblMensagem;
	/**
	 *btnSair é atributo da RegistaPublicacaoPanel
	 */
	private JButton btnSair;
	/**
	 *btnVoltar é atributo da RegistaPublicacaoPanel
	 */
	private JButton btnVoltar;
	/**
	 *btnRegistar é atributo da RegistaPublicacaoPanel
	 */
	private JButton btnRegistar;
	/**
	 *layout é atributo da RegistaPublicacaoPanel
	 */
	private CardLayout layout;
	/**
	 *comboBox é atributo da RegistaPublicacaoPanel
	 */
	private JComboBox comboBox;
	/**
	 *comboBoxTipoTese é atributo da RegistaPublicacaoPanel
	 */
	private JComboBox comboBoxTipoTese;
	/**
	 *comboBoxPeriodicidade é atributo da RegistaPublicacaoPanel
	 */
	private JComboBox comboBoxPeriodicidade;
	
	private DatePicker datePickerDataPub;
	
	private DatePicker datePickerDataRecepcao;
	
	/**
	 * Instanciar o objeto biblioteca
	 */
	private Biblioteca biblioteca = Biblioteca.getInstance();
	
	/**
	 * Create the panel RegistaPublicacaoPanel.
	 * @param j
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
		txtTitulo.addFocusListener(this);
		pnlRegistaPublicacao.add(txtTitulo);
		txtTitulo.setColumns(10);

		JLabel lblAreas = new JLabel("Áreas");
		lblAreas.setBounds(39, 95, 61, 16);
		pnlRegistaPublicacao.add(lblAreas);

		txtAreas = new JTextField();
		txtAreas.addFocusListener(this);
		txtAreas.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		txtAreas.setForeground(Color.LIGHT_GRAY);
		txtAreas.setText("área , área , área");
		txtAreas.setBounds(151, 90, 286, 26);
		pnlRegistaPublicacao.add(txtAreas);
		txtAreas.setColumns(10);

		JLabel lblDataPublicacao = new JLabel("Data Publicação");
		lblDataPublicacao.setBounds(39, 123, 101, 16);
		pnlRegistaPublicacao.add(lblDataPublicacao);

		JLabel lblDataRecepo = new JLabel("Data Recepção");
		lblDataRecepo.setBounds(39, 151, 101, 16);
		pnlRegistaPublicacao.add(lblDataRecepo);

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
		txtAutores.addFocusListener(this); 
		txtAutores.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		txtAutores.setForeground(Color.LIGHT_GRAY);
		txtAutores.setText("autor , autor , autor");
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
		txtAutor.setBounds(148, 31, 284, 26);
		pnlTese.add(txtAutor);
		txtAutor.setColumns(10);

		JLabel lblOrientador = new JLabel("Orientador");
		lblOrientador.setBounds(35, 64, 76, 16);
		pnlTese.add(lblOrientador);

		txtOrientador = new JTextField();
		txtOrientador.setBounds(148, 59, 284, 26);
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
		
		datePickerDataPub = new DatePicker();
		datePickerDataPub.setBounds(151, 111, 117, 28);
		pnlRegistaPublicacao.add(datePickerDataPub);
		
		datePickerDataRecepcao = new DatePicker();
		datePickerDataRecepcao.setBounds(151, 139, 117, 28);
		pnlRegistaPublicacao.add(datePickerDataRecepcao);
		
	}
	
	/**
	 * Transforma um DatePicker em String
	 * @param datepicker
	 * @return data em formato String
	 */
	private String transformaDatePickerEmString(DatePicker datepicker){
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(datepicker.getDate());
	}

	/**
	 * actionPerformed dos botões à disposição no Jpanel
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == this.btnSair) {

			Biblioteca biblioteca = Biblioteca.getInstance();
			BibliotecaSerializer.getInstance().gravaBiblioteca(biblioteca);
			lblMensagem.setText("");
			limpaPainel();
			janela.sairOK();
			
		}

		else if (e.getSource() == this.btnVoltar) {
			
			lblMensagem.setText("");
			limpaPainel();
			janela.bibliotecarioChefeOK();

		} else if (e.getSource() == this.comboBox) {

			String str = (String) this.comboBox.getSelectedItem();
			lblMensagem.setText("");

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

			verificaRegistoPublicacao();

		}
	}

	/**
	 * Verifica se se pode registar a Publicacao conforme os parametros do construtor de cada Publicacao
	 */
	private void verificaRegistoPublicacao() {

		String str = (String) this.comboBox.getSelectedItem();
		
		//Coloca a String do txtAutores em ArrayList<String>(parametro da contrucao do objecto Livro)
		String[] auxAutores = this.txtAutores.getText().split(",");
		ArrayList<String> autores = new ArrayList<String>();
		String auxTrimAutor;
		for (int i = 0; i < auxAutores.length; i++) {
			auxTrimAutor=auxAutores[i].trim();
			autores.add(auxTrimAutor);
		}
		
		//Coloca a String do txtAreas em ArrayList<String>(parametro da contrucao do objecto Publicacao)
		String[] auxArea = this.txtAreas.getText().split(",");
		ArrayList<String> areas = new ArrayList<String>();
		String auxTrimArea;
		for (int i = 0; i < auxArea.length; i++) {
			auxTrimArea=auxArea[i].trim();
			areas.add(auxTrimArea);
		}
		
		//Coloca a String do txtAutor em ArrayList<String>(parametro da contrucao do objecto Tese)
		ArrayList<String> autor=new ArrayList<>();
		autor.add(txtAutor.getText());
		
		if (str.equals("Livro")) {

			if (txtTitulo.getText().equals("") || txtAreas.getText().equals("")
					//|| txtDataRecepcao.getText().equals("")
					//|| txtDataPublicacao.getText().equals("") || txtDataRecepcao.getText().equals("")
					|| txtNumEdicao.getText().equals("") || txtEditor.getText().equals("")
					|| txtIsbn.getText().equals("") || txtAutores.getText().equals("")) {

				enviaMensagem("ERRO: Não introduziu os campos todos para registar a publicação.");
				
			} else
	
			registaLivro(autores, areas);

		}

		if (str.equals("Tese")) {

			if (txtTitulo.getText().equals("") || txtAreas.getText().equals("")
				//	|| txtDataRecepcao.getText().equals("")
				//	|| txtDataPublicacao.getText().equals("") || txtDataRecepcao.getText().equals("")
					|| txtOrientador.getText().equals("") || txtAutor.getText().equals("")) {

				enviaMensagem("ERRO: Não introduziu os campos todos para registar a publicação.");
				limpaPainel();
				
			}
			else {
				
				registaTese(autor, areas);
				
			}
		}	
		if(str.equals("Revista")){
			
			if(txtTitulo.getText().equals("") || txtAreas.getText().equals("")
					//|| txtDataPublicacao.getText().equals("") || txtDataRecepcao.getText().equals("") 
					|| txtVolume.getText().equals("")){
				
				enviaMensagem("ERRO: Não introduziu os campos todos para registar a publicação.");
				limpaPainel();
				
			}
			else{
				registaPeriodico(areas, str);
			}
		}
		if(str.equals("Jornal")){
			
			if(txtTitulo.getText().equals("") || txtAreas.getText().equals("")
					//|| txtDataPublicacao.getText().equals("") || txtDataRecepcao.getText().equals("") 
					|| txtNumEdicaoJornal.getText().equals("")){
				
				enviaMensagem("ERRO: Não introduziu os campos todos para registar a publicação.");
				limpaPainel();
				
			}
			else{
				
				registaPeriodico(areas, str);
			}
		}
	}
	
	/**
	 * Regista uma Publicacão do tipo Livro na Biblioteca
	 * @param autores
	 * @param areas
	 */
	private void registaLivro(ArrayList<String> autores, ArrayList<String> areas){
		
		int codigoBarras;
		
		codigoBarras = biblioteca.criaLivro(txtTitulo.getText(), 
				transformaDatePickerEmString(datePickerDataPub),
				transformaDatePickerEmString(datePickerDataRecepcao), autores, areas, txtNumEdicao.getText(), txtIsbn.getText(),
				txtEditor.getText());

		limpaPainel();
		Biblioteca biblioteca = Biblioteca.getInstance();
		BibliotecaSerializer.getInstance().gravaBiblioteca(biblioteca);
		enviaMensagem("Livro inserido com sucesso. CÓDIGO DE BARRAS: " + codigoBarras);
		
	}
	
	/**
	 * Regista uma Publicacao do tipo Tese na Biblioteca
	 * @param autores
	 * @param areas
	 */
	private void registaTese(ArrayList<String> autores, ArrayList<String> areas){
		
		String strTese = (String) this.comboBoxTipoTese.getSelectedItem();
		int codigoBarras;
		
		if (strTese.equals("Mestrado")) {

			codigoBarras = biblioteca.criaTese(txtTitulo.getText(),
					transformaDatePickerEmString(datePickerDataPub),
					transformaDatePickerEmString(datePickerDataRecepcao), autores, areas, txtOrientador.getText(), TipoDeTese.Mestrado);

			limpaPainel();
			Biblioteca biblioteca = Biblioteca.getInstance();
			BibliotecaSerializer.getInstance().gravaBiblioteca(biblioteca);
		//	enviaMensagem("Tese inserida com sucesso. CODIGO DE BARRAS: " + codigoBarras);
			
		} else{
			
			//codigoBarras = biblioteca.criaTese(txtTitulo.getText(), txtDataPublicacao.getText(),
			//		txtDataRecepcao.getText(), autores, areas, txtOrientador.getText(), TipoDeTese.Doutoramento);
		
			limpaPainel();
			Biblioteca biblioteca = Biblioteca.getInstance();
			BibliotecaSerializer.getInstance().gravaBiblioteca(biblioteca);
		//	enviaMensagem("Tese inserida com sucesso. CODIGO DE BARRAS: " + codigoBarras);
			
		}
	}
	
	/**
	 * Regista uma Publicacao do tipo Periodico (Revista ou Jornal na Biblioteca)
	 * @param areas
	 * @param tipoPeriodico
	 */
	private void registaPeriodico(ArrayList<String> areas, String tipoPeriodico){
		
		String strPeriodicidade = (String) this.comboBoxPeriodicidade.getSelectedItem();
		int codigoBarras;
		
		Periodicidade periodicidade = null;
		
		if(strPeriodicidade.equals("Diária")){	
			periodicidade=Periodicidade.Diaria;	
		}
		else if(strPeriodicidade.equals("Semanal")){
			periodicidade=Periodicidade.Semanal;
		}
		else if(strPeriodicidade.equals("Quinzenal")){
			periodicidade=Periodicidade.Quinzenal;
		}	
		else if(strPeriodicidade.equals("Mensal")){
			periodicidade=Periodicidade.Mensal;
		}
		else if(strPeriodicidade.equals("Trimestral")){
			periodicidade=Periodicidade.Trimestral;
		}
		else if(strPeriodicidade.equals("Semestral")){
			periodicidade=Periodicidade.Semestral;
		}
		else if(strPeriodicidade.equals("Anual")) {
			periodicidade=Periodicidade.Anual;
		}
		
		if(tipoPeriodico.equals("Revista")){
			
			codigoBarras = biblioteca.criaRevista(txtTitulo.getText(), transformaDatePickerEmString(datePickerDataPub),
					transformaDatePickerEmString(datePickerDataRecepcao), areas, periodicidade, Integer.parseInt(txtVolume.getText()));
		
			limpaPainel();
			Biblioteca biblioteca = Biblioteca.getInstance();
			BibliotecaSerializer.getInstance().gravaBiblioteca(biblioteca);
			enviaMensagem("Revista inserida com sucesso. CÓDIGO DE BARRAS: " + codigoBarras);
			
		}
		else if((tipoPeriodico.equals("Jornal"))){
			
			codigoBarras =biblioteca.criaJornal(txtTitulo.getText(), transformaDatePickerEmString(datePickerDataPub),
					transformaDatePickerEmString(datePickerDataRecepcao), areas, periodicidade, Integer.parseInt(txtNumEdicaoJornal.getText()));
		
			limpaPainel();
			Biblioteca biblioteca = Biblioteca.getInstance();
			BibliotecaSerializer.getInstance().gravaBiblioteca(biblioteca);
			enviaMensagem("Jornal inserido com sucesso.CÓDIGO DE BARRAS: " + codigoBarras);
			
		}
	}

	/**
	 * Limpa os JTextFields do RegistaPublicacao
	 */
	private void limpaPainel(){
		
		//txtDataRecepcao.setText("DD/MM/AAAA");
	//	txtDataRecepcao.setForeground(Color.LIGHT_GRAY);
	//	txtDataRecepcao.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		//txtDataPublicacao.setText("DD/MM/AAAA");
		//txtDataPublicacao.setForeground(Color.LIGHT_GRAY);
		//txtDataPublicacao.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		txtAreas.setText("área , área , área");
		txtAreas.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		txtAreas.setForeground(Color.LIGHT_GRAY);
		txtAutores.setText("autor , autor , autor");
		txtAutores.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		txtAutores.setForeground(Color.LIGHT_GRAY);
		txtTitulo.setText("");
		txtNumEdicao.setText("");
		txtEditor.setText("");
		txtIsbn.setText("");
		txtAutor.setText("");
		txtOrientador.setText("");
		txtVolume.setText("");
		txtNumEdicaoJornal.setText("");
			
	}	

	/**
	 * Mostra o painel pnlLivro
	 */
	private void abrePainelLivroOK() {

		layout.show(pnlTipoPublicacao, "livro");

	}

	/**
	 * Mostra o painel pnlTese
	 */
	private void abrePainelTeseOK() {

		layout.show(pnlTipoPublicacao, "tese");

	}
	/**
	 * Mostra o painel pnlPeriodico
	 */
	private void abrePainelPeriodicoOK() {

		layout.show(pnlTipoPublicacao, "periodico");

	}

	/**
	 * Método genérico para enviar mensagens ao utilizador
	 * @param string
	 */
	private void enviaMensagem(String string) {

		lblMensagem.setText(string);

	}

	/**
	 * focusGained
	 */
	/* (non-Javadoc)
	 * @see java.awt.event.FocusListener#focusGained(java.awt.event.FocusEvent)
	 */
	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == this.txtAutores){
		txtAutores.setText("");
		txtAutores.setForeground(Color.BLACK);
		txtAutores.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		}
		else if( e.getSource() == this.txtTitulo){
			lblMensagem.setText("");
		}
		else if(e.getSource() == this.txtAreas){
			txtAreas.setText("");
			txtAreas.setForeground(Color.BLACK);
			txtAreas.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		}
//		else if(e.getSource() == this.txtDataPublicacao){
//			txtDataPublicacao.setText("");
//			txtDataPublicacao.setForeground(Color.BLACK);
//			txtDataPublicacao.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
//		}
	//	else if(e.getSource() == this.txtDataRecepcao){
		//	txtDataRecepcao.setForeground(Color.BLACK);
			//txtDataRecepcao.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		//	txtDataRecepcao.setText("");
	//	}
	}

	/**
	 * focusLost
	 */
	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
}
