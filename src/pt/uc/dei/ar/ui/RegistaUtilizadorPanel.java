package pt.uc.dei.ar.ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Panel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

import pt.uc.dei.ar.Biblioteca;

import javax.swing.JPasswordField;
import java.awt.CardLayout;
import javax.swing.JFormattedTextField;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class RegistaUtilizadorPanel extends JPanel implements ActionListener, FocusListener {

	private JTextField txtNome;
	private JTextField txtUsername;
	private JTextField txtNumFuncionario;
	private JTextField txtCC;
	private JTextField txtMorada;
	private JTextField txtEmail;
	private JTextField txtContactoTelefonico;
	private JLabel lblMensagem;
	private JLabel lblMensagemLeitor;

	private JFormattedTextField formattedTextFieldData;

	private JPanel pnlBiblioColaborador;
	private JPanel pnlMensagem;
	private JPanel pnlLeitor;

	private JPanel pnlUtilizadores;

	private JButton btnRegistaUtilizador;
	private JButton btnSair;
	private JButton btnVoltar;

	private JComboBox comboBox;

	private CardLayout layout;

	private Janela janela;
	Biblioteca biblioteca = Biblioteca.getInstance();

	public RegistaUtilizadorPanel(Janela j) {
		setLayout(null);

		this.janela = j;
		this.layout = new CardLayout(0, 0);

		Panel panel = new Panel();
		panel.setBounds(10, 10, 480, 380);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Bibliotecario x");
		lblNewLabel.setBounds(85, 5, 309, 16);
		panel.add(lblNewLabel);

		comboBox = new JComboBox();
		comboBox.addActionListener(this);
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Leitor", "Colaborador", "Biblio Chefe" }));
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

		pnlUtilizadores.setBounds(20, 116, 433, 169);
		panel.add(pnlUtilizadores);
		pnlUtilizadores.setLayout(layout);

		// Mensagem de users

		this.pnlMensagem = new JPanel();
		pnlMensagem.setSize(420, 157);
		pnlMensagem.setLocation(6, 6);
		pnlUtilizadores.add(pnlMensagem, "mensagem");
		pnlMensagem.setLayout(null);

		this.lblMensagem = new JLabel("");
		lblMensagem.setBounds(20, 44, 407, 16);
		pnlMensagem.add(lblMensagem);

		this.lblMensagemLeitor = new JLabel("");
		lblMensagemLeitor.setBounds(20, 72, 407, 16);
		pnlMensagem.add(lblMensagemLeitor);

		// Leitor

		this.pnlLeitor = new JPanel();
		pnlLeitor.setBounds(6, 6, 420, 157);
		pnlUtilizadores.add(pnlLeitor, "leitor");
		pnlLeitor.setLayout(null);

		JLabel lblDataNascimento = new JLabel("Data Nascimento");
		lblDataNascimento.setBounds(78, 10, 108, 16);
		pnlLeitor.add(lblDataNascimento);

		formattedTextFieldData = new JFormattedTextField();
		formattedTextFieldData.addFocusListener(this);
		formattedTextFieldData.setFocusLostBehavior(JFormattedTextField.REVERT);
		formattedTextFieldData.setForeground(Color.LIGHT_GRAY);
		formattedTextFieldData.setText("DD/MM/AAAA");
		formattedTextFieldData.setBounds(235, 5, 130, 26);
		pnlLeitor.add(formattedTextFieldData);

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
		btnRegistaUtilizador.setBounds(20, 297, 81, 40);
		panel.add(btnRegistaUtilizador);

		btnSair = new JButton("Sair");
		btnSair.addActionListener(this);
		btnSair.setBounds(376, 297, 75, 40);
		panel.add(btnSair);

		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(this);
		btnVoltar.setBounds(283, 297, 81, 40);
		panel.add(btnVoltar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//TODO Verificar as entradas do Leitor e o colaborador biblio para adicionar à biblioteca, bloquear e enviar erro
		//TODO Simplificar este método

		String str = (String) this.comboBox.getSelectedItem();

		if (e.getSource() == this.btnRegistaUtilizador) {

			if (str.equals("Leitor")) {
			
					registaUtilizadorLeitor();
					
			} else
				
				registaUtilizadorColaboradorBiblioChefe();

		} else if (e.getSource() == this.btnSair) {

			limpaPainelRegistaUtilizador();
			janela.sairOK();

		} else if (e.getSource() == this.btnVoltar) {

			limpaPainelRegistaUtilizador();
			janela.bibliotecarioChefeOK();

		} else if (e.getSource() == this.comboBox) {

			if (str.equals("Leitor")) {
				
				abrePainelLeitorOK();
				limpaPainelRegistaUtilizador();

			} else
		
				abrePainelBibliotecarioColaboradorOK();
				limpaPainelRegistaUtilizador();

		}

	}

	public void focusGained(FocusEvent e) {

		formattedTextFieldData.setText("");
		formattedTextFieldData.setForeground(Color.BLACK);

	}

	private void abrePainelLeitorOK() {

		layout.show(pnlUtilizadores, "leitor");

	}

	private void abrePainelBibliotecarioColaboradorOK() {

		layout.show(pnlUtilizadores, "biblioColaborador");

	}

	private void registaUtilizadorColaboradorBiblioChefe() {

		// TODO Não está a funcionar o pesquisar o numero, erro na linha 311 da
		// biblio e 268 e 209 na classe RegistaUtilizador
		// TODO fazer o metodo random para a password e user name
		// TODO fazer a troca desse metodo quando se cria o utilizador, estão por default
		

		String str = (String) this.comboBox.getSelectedItem();

		if (biblioteca.pesquisaUtilizadorPorNumColaborador(Integer.parseInt(txtNumFuncionario.getText())) == null) {

			if (str.equals("Colaborador")) {

				biblioteca.criaColaborador(txtUsername.getText(), "123", txtNome.getText(),
						Integer.parseInt(txtNumFuncionario.getText()));
				// TODO refazer a mensagem
				enviaMensagemParaValidar(" Qualquer coisa", "");

			} else if (str.equals("Biblio Chefe")) {

				biblioteca.criaBibliotecarioChefe(txtUsername.getText(), "123", txtNome.getText(),
						Integer.parseInt(txtNumFuncionario.getText()));

			}
		}

	}

	private void registaUtilizadorLeitor() {

		// TODO devolver o numero de leitor do utilizador, username e password, colocar na segunda parte da string.

		if(txtUsername.getText().equals("") || txtNome.getText().equals("") || txtCC.getText().equals("") ){
			
			enviaMensagemParaValidar("Erro: não inseriu os campos necessários para validar o registo.",
					"Por favor introduza o CC, nome e username correctamente.");
			
		}
		
		else if (biblioteca.pesquisaUtilizadorPorCartaoCidadao(txtCC.getText()) == null) {

			biblioteca.criaLeitor(txtUsername.getText(), "123", txtNome.getText(), formattedTextFieldData.getText(),
					txtCC.getText(), txtMorada.getText(), txtEmail.getText(), txtContactoTelefonico.getText());

			enviaMensagemParaValidar("O Leitor foi introduzido com sucesso!", "Leitor nº ");
			
			
		} else
			
			enviaMensagemParaValidar("Erro: o Leitor que inseriu já existe.", "");

	}

	private void limpaPainelRegistaUtilizador() {

		// TODO melhorar a limpeza dos campos

		this.txtUsername.setText("");
		this.txtNome.setText("");
		this.txtCC.setText("");
		this.txtNumFuncionario.setText("");
		this.txtMorada.setText("");
		this.txtEmail.setText("");
		this.txtContactoTelefonico.setText("");
		this.formattedTextFieldData.setText("");
		this.lblMensagem.setText("");
		this.lblMensagemLeitor.setText("");

	}

	private void enviaMensagemParaValidar(String s, String st) {

		lblMensagem.setText(s);
		lblMensagemLeitor.setText(st);
		layout.show(pnlUtilizadores, "mensagem");

	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub

	}
}