package pt.uc.dei.ar.ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Panel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

import com.michaelbaranov.microba.calendar.DatePicker;

import pt.uc.dei.ar.Biblioteca;
import pt.uc.dei.ar.BibliotecaSerializer;
import pt.uc.dei.ar.BibliotecarioChefe;
import pt.uc.dei.ar.Colaborador;
import pt.uc.dei.ar.Utilizador;

import java.awt.CardLayout;
import javax.swing.JFormattedTextField;
import java.awt.Color;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.SimpleDateFormat;

/**
 * @author Adelia Goncalves (2000014546) e Maria Joao Dias da Silva (2001009566)
 * Interface do RegistaUtilizadorPanel para registar Utilizador na Biblioteca.
 * Regista os diversos tipos de Utilizadores na Biblioteca.
 * @author Adelia Goncalves e Maria Joao Silva
 */
public class RegistaUtilizadorPanel extends JPanel implements ActionListener{

	/**
	 *Janela e atributo da RegistaUtilizadorPanel
	 */
	private Janela janela;
	/**
	 * pnlBiblioColaborador e atributo da RegistaUtilizadorPanel
	 */
	private JPanel pnlBiblioColaborador;
	/**
	 * pnlLeitor e atributo da RegistaUtilizadorPanel
	 */
	private JPanel pnlLeitor;
	/**
	 *pnlUtilizadores e atributo da RegistaUtilizadorPanel
	 */
	private JPanel pnlUtilizadores;
	/**
	 *txtNome e atributo da RegistaUtilizadorPanel
	 */
	private JTextField txtNome;
	/**
	 * txtUserName e atributo da RegistaUtilizadorPanel
	 */
	private JTextField txtUsername;
	/**
	 *txtNumFuncionario e atributo da RegistaUtilizadorPanel
	 */
	private JTextField txtNumFuncionario;
	/**
	 *txtCC e atributo da RegistaUtilizadorPanel
	 */
	private JTextField txtCC;
	/**
	 *txtMorada e atributo da RegistaUtilizadorPanel
	 */
	private JTextField txtMorada;
	/**
	 *txtEmail e atributo da RegistaUtilizadorPanel
	 */
	private JTextField txtEmail;
	/**
	 *txtContactoTelefonico e atributo da RegistaUtilizadorPanel
	 */
	private JTextField txtContactoTelefonico;
	/**
	 * lblMensagem e atributo da RegistaUtilizadorPanel
	 */
	private JLabel lblMensagem;
	/**
	 *lblMensagemLeitor e atributo da RegistaUtilizadorPanel
	 */
	private JLabel lblMensagemLeitor;
	/**
	 * btnRegistaUtilizador e atributo da RegistaUtilizadorPanel
	 */
	private JButton btnRegistaUtilizador;
	/**
	 * btnSair e atributo da RegistaUtilizadorPanel
	 */
	private JButton btnSair;
	/**
	 * btnVoltar e atributo da RegistaUtilizadorPanel
	 */
	private JButton btnVoltar;
	/**
	 *comboBox e atributo da RegistaUtilizadorPanel 
	 */
	private JComboBox<String> comboBox;
	/**
	 *layout e atributo da RegistaUtilizadorPanel 
	 */
	private CardLayout layout;
	
	/**
	 * datePickerDataNascimento e atributo da RegistaUtilizadorPanel
	 */
	private DatePicker datePickerDataNascimento;

	/**
	 * Instanciar o objeto biblioteca
	 */
	Biblioteca biblioteca = Biblioteca.getInstance();

	/**
	 * Create the panel RegistaUtilizadorPanel.
	 * @param j
	 */
	public RegistaUtilizadorPanel(Janela j) {
		setLayout(null);

		this.janela = j;
		this.layout = new CardLayout(0, 0);

		Panel panel = new Panel();
		panel.setBounds(10, 10, 480, 380);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Regista Utilizador");
		lblNewLabel.setBounds(182, 5, 116, 16);
		panel.add(lblNewLabel);

		comboBox = new JComboBox<String>();
		comboBox.addActionListener(this);
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "Leitor", "Colaborador", "Biblio Chefe" }));
		comboBox.setBounds(98, 33, 133, 27);
		panel.add(comboBox);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(98, 60, 125, 16);
		panel.add(lblNome);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(98, 88, 125, 16);
		panel.add(lblUsername);

		txtNome = new JTextField();
		txtNome.setBounds(257, 55, 130, 26);
		panel.add(txtNome);
		txtNome.setColumns(10);

		txtUsername = new JTextField();
		txtUsername.setBounds(257, 83, 130, 26);
		panel.add(txtUsername);
		txtUsername.setColumns(10);

		// Painel dos Utilizadores

		this.pnlUtilizadores = new JPanel();

		pnlUtilizadores.setBounds(20, 107, 433, 149);
		panel.add(pnlUtilizadores);
		pnlUtilizadores.setLayout(layout);

		// Leitor

		this.pnlLeitor = new JPanel();
		pnlUtilizadores.add(pnlLeitor, "leitor");
		pnlLeitor.setLayout(null);

		JLabel lblDataNascimento = new JLabel("Data Nascimento");
		lblDataNascimento.setBounds(78, 10, 108, 16);
		pnlLeitor.add(lblDataNascimento);

		JLabel lblCartoCidadao = new JLabel("Cartão Cidadao");
		lblCartoCidadao.setBounds(78, 38, 96, 16);
		pnlLeitor.add(lblCartoCidadao);

		txtCC = new JTextField();
		txtCC.setBounds(235, 33, 130, 26);
		pnlLeitor.add(txtCC);
		txtCC.setColumns(10);

		JLabel lblMorada = new JLabel("Morada");
		lblMorada.setBounds(78, 66, 46, 16);
		pnlLeitor.add(lblMorada);

		txtMorada = new JTextField();
		txtMorada.setBounds(235, 61, 130, 26);
		pnlLeitor.add(txtMorada);
		txtMorada.setColumns(10);

		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(78, 94, 42, 16);
		pnlLeitor.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(235, 89, 130, 26);
		pnlLeitor.add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblContactoTelefnico = new JLabel("Contacto Telefónico");
		lblContactoTelefnico.setBounds(78, 122, 127, 16);
		pnlLeitor.add(lblContactoTelefnico);

		txtContactoTelefonico = new JTextField();
		txtContactoTelefonico.setBounds(235, 117, 130, 26);
		pnlLeitor.add(txtContactoTelefonico);
		txtContactoTelefonico.setColumns(10);
		
		datePickerDataNascimento = new DatePicker();
		datePickerDataNascimento.setBounds(235, 6, 130, 28);
		pnlLeitor.add(datePickerDataNascimento);

		// Bibliotecario Chefe e Colaborador

		this.pnlBiblioColaborador = new JPanel();
		pnlBiblioColaborador.setSize(420, 157);
		pnlBiblioColaborador.setLocation(6, 6);
		pnlUtilizadores.add(pnlBiblioColaborador, "biblioColaborador");
		pnlBiblioColaborador.setLayout(null);

		JLabel lblNumeroDeFuncionario = new JLabel("Número de Funcionario");
		lblNumeroDeFuncionario.setBounds(79, 22, 147, 16);
		pnlBiblioColaborador.add(lblNumeroDeFuncionario);

		txtNumFuncionario = new JTextField();
		txtNumFuncionario.setBounds(234, 17, 130, 26);
		pnlBiblioColaborador.add(txtNumFuncionario);
		txtNumFuncionario.setColumns(10);

		// Botões

		btnRegistaUtilizador = new JButton("Regista");
		btnRegistaUtilizador.addActionListener(this);
		btnRegistaUtilizador.setBounds(20, 315, 81, 40);
		panel.add(btnRegistaUtilizador);

		btnSair = new JButton("Sair");
		btnSair.addActionListener(this);
		btnSair.setBounds(378, 315, 75, 40);
		panel.add(btnSair);

		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(this);
		btnVoltar.setBounds(282, 315, 81, 40);
		panel.add(btnVoltar);

		this.lblMensagem = new JLabel("");
		lblMensagem.setBounds(30, 268, 407, 16);
		panel.add(lblMensagem);

		this.lblMensagemLeitor = new JLabel("");
		lblMensagemLeitor.setBounds(30, 287, 407, 16);
		panel.add(lblMensagemLeitor);
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

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		String str = (String) this.comboBox.getSelectedItem();

		if (e.getSource() == this.btnRegistaUtilizador) {

			if (str.equals("Leitor")) {

				registaUtilizadorLeitor();

			} else

				registaUtilizadorColaboradorBiblioChefe();

		} else if (e.getSource() == this.btnSair) {

			limpaPainelRegistaUtilizador();
			Biblioteca biblioteca = Biblioteca.getInstance();
			BibliotecaSerializer.getInstance().gravaBiblioteca(biblioteca);
			janela.sairOK();

		} else if (e.getSource() == this.btnVoltar) {

			limpaPainelRegistaUtilizador();
			janela.bibliotecarioChefeOK();

		} else if (e.getSource() == this.comboBox) {

			if (str.equals("Leitor")) {

				abrePainelLeitorOK();
				limpaPainelRegistaUtilizador();
				// abrePainelLeitorOK();

			} else

			abrePainelBibliotecarioColaboradorOK();
			limpaPainelRegistaUtilizador();

		}

	}

	/**
	 * Mostra o Jpanel pnlLeitor
	 */
	private void abrePainelLeitorOK() {

		layout.show(pnlUtilizadores, "leitor");

	}

	/**
	 * Mostra o Jpanel pnlBiblioColaborador
	 */
	private void abrePainelBibliotecarioColaboradorOK() {

		layout.show(pnlUtilizadores, "biblioColaborador");

	}

	/**
	 * Regista os Utilizadores do Tipo Bibliotecario Chefe e Colaborador na Biblioteca
	 */
	private void registaUtilizadorColaboradorBiblioChefe() {

		String str = (String) this.comboBox.getSelectedItem();

		if (txtUsername.getText().equals("") || txtNome.getText().equals("")
				|| txtNumFuncionario.getText().equals("")) {

			enviaMensagemParaValidar("Erro: não inseriu os campos necessários para validar o registo.",
					"Por favor introduza o nome, username e numero de funcionario correctamente.");

		}

		else if (biblioteca.pesquisaUtilizadorPorUsername(txtUsername.getText()) != null) {

			enviaMensagemParaValidar("Erro! O username indicado já se encontra atribuido.",
					"Por favor introduza outro username.");
		}

		else if (biblioteca.pesquisaUtilizadorPorNumColaborador(Integer.parseInt(txtNumFuncionario.getText())) != null) {

			enviaMensagemParaValidar(" Erro! Já existe um funcionário com o mesmo número. Insira",
					"novamente e se persistir o erro dirija-se aos Recurso Humanos. ");
		}
		else{
			
			int numFuncionario = Integer.parseInt(txtNumFuncionario.getText());
			
			if (str.equals("Colaborador")) {
				
				Colaborador colaborador = biblioteca.criaColaborador(txtUsername.getText(), txtNome.getText(), numFuncionario);

				limpaPainelSimples();
				enviaMensagemParaValidar(" O Colaborador foi registado correctamente",
						"O username é: " + txtUsername.getText() + ". A password é: " + colaborador.getHashedPassword());

			}
			if (str.equals("Biblio Chefe")) {

				BibliotecarioChefe chefe = biblioteca.criaBibliotecarioChefe(txtUsername.getText(), txtNome.getText(), numFuncionario);
				
				limpaPainelSimples();
				enviaMensagemParaValidar(" O Bibliotecario foi registado correctamente",
						"O username é: " + txtUsername.getText() + ". A password é: " + chefe.getHashedPassword());
			} 
		}
	}

	/**
	 *Regista Utilizadores de tipo Leitor na Biblioteca 
	 */
	private void registaUtilizadorLeitor() {

		if (txtUsername.getText().equals("") || txtNome.getText().equals("") || txtCC.getText().equals("")) {

			enviaMensagemParaValidar("Erro! não inseriu os campos necessários para validar o registo.",
					"Por favor introduza os dados correctamente.");

		} else if (biblioteca.pesquisaUtilizadorPorUsername(txtUsername.getText()) != null) {

			enviaMensagemParaValidar("Erro! O username indicado já se encontra atribuido.",
					"Por favor introduza outro username.");
		} else if (biblioteca.pesquisaUtilizadorPorCartaoCidadao(txtCC.getText()) == null) {

			int numLeitor = 0;

			numLeitor = biblioteca.criaLeitor(txtUsername.getText(), txtNome.getText(),
					transformaDatePickerEmString(datePickerDataNascimento), txtCC.getText(), txtMorada.getText(), txtEmail.getText(),
					txtContactoTelefonico.getText());
      
			BibliotecaSerializer.getInstance().gravaBiblioteca(biblioteca);
			enviaMensagemParaValidar("O Leitor foi introduzido com sucesso!",
					"Leitor nº " + numLeitor + ". Username: " + txtUsername.getText() + ". Password :" + 
			biblioteca.pesquisaUtilizadorPorNumLeitor(numLeitor).getHashedPassword());
			limpaPainelSimples();

		} else{

			enviaMensagemParaValidar("Erro! o Leitor que inseriu já existe.", "");
		}
	}

	/**
	 *  Limpa os JTextFields e Jlabels do pnlRegistaUtilizador
	 */
	private void limpaPainelRegistaUtilizador() {

		// TODO melhorar a limpeza dos campos

		this.txtUsername.setText("");
		this.txtNome.setText("");
		this.txtCC.setText("");
		this.txtNumFuncionario.setText("");
		this.txtMorada.setText("");
		this.txtEmail.setText("");
		this.txtContactoTelefonico.setText("");
		this.lblMensagem.setText("");
		this.lblMensagemLeitor.setText("");

	}

	/**
	 * Metodo generico para enviar mensagens ao utilizador
	 * @param string
	 * @param stringDois
	 */
	private void enviaMensagemParaValidar(String string, String stringDois) {

		lblMensagem.setText(string);
		lblMensagemLeitor.setText(stringDois);

	}

	/**
	 * Limpa os JTextFields e Jlabels do pnlRegistaUtilizador, metodo simplificado
	 */
	private void limpaPainelSimples() {

		this.txtUsername.setText("");
		this.txtNome.setText("");
		this.txtCC.setText("");
		this.txtNumFuncionario.setText("");
		this.txtMorada.setText("");
		this.txtEmail.setText("");
		this.txtContactoTelefonico.setText("");

	}
}
