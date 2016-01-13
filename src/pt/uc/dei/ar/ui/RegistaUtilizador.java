package pt.uc.dei.ar.ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Panel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.CardLayout;
import javax.swing.JFormattedTextField;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistaUtilizador extends JPanel implements ActionListener {
	private JTextField txtNome;
	private JTextField txtUsername;
	private JTextField txtNumFuncionario;
	private JTextField txtCC;
	private JTextField txtMorada;
	private JTextField txtEmail;
	private JTextField txtContactoTelefonico;

	private JPanel pnlBiblioColaborador;
	private JPanel pnlMensagem;
	private JPanel pnlLeitor;

	private JPanel pnlUtilizadores;
	
	private JButton btnRegista;
	private JButton btnSair;
	private JButton btnVoltar;
	private JButton btnNovoRegisto;

	private JComboBox comboBox;

	private CardLayout layout;

	private Janela janela;

	public RegistaUtilizador(Janela j) {
		setLayout(null);

		this.janela = j;
		this.layout = new CardLayout(0, 0);

		Panel panel = new Panel();
		panel.setBounds(10, 10, 480, 380);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(207, 6, 66, 16);
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

		JLabel lblMensagem = new JLabel("");
		lblMensagem.setBounds(6, 44, 421, 16);
		pnlMensagem.add(lblMensagem);

		// pnlUtilizadores.setLayout(new CardLayout(0, 0));

		// Leitor

		this.pnlLeitor = new JPanel();
		pnlLeitor.setBounds(6, 6, 420, 157);
		pnlUtilizadores.add(pnlLeitor, "leitor");
		pnlLeitor.setLayout(null);

		JLabel lblDataNascimento = new JLabel("Data Nascimento");
		lblDataNascimento.setBounds(71, 10, 108, 16);
		pnlLeitor.add(lblDataNascimento);

		JFormattedTextField formattedTextFieldData = new JFormattedTextField();
		formattedTextFieldData.setForeground(Color.LIGHT_GRAY);
		formattedTextFieldData.setText("DD/MM/AAAA");
		formattedTextFieldData.setBounds(235, 5, 130, 26);
		pnlLeitor.add(formattedTextFieldData);

		JLabel lblCartoCidadao = new JLabel("Cartão Cidadao");
		lblCartoCidadao.setBounds(71, 38, 96, 16);
		pnlLeitor.add(lblCartoCidadao);

		txtCC = new JTextField();
		txtCC.setBounds(235, 33, 130, 26);
		pnlLeitor.add(txtCC);
		txtCC.setColumns(10);

		JLabel lblMorada = new JLabel("Morada");
		lblMorada.setBounds(71, 66, 46, 16);
		pnlLeitor.add(lblMorada);

		txtMorada = new JTextField();
		txtMorada.setBounds(235, 61, 130, 26);
		pnlLeitor.add(txtMorada);
		txtMorada.setColumns(10);

		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(71, 94, 42, 16);
		pnlLeitor.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(235, 89, 130, 26);
		pnlLeitor.add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblContactoTelefnico = new JLabel("Contacto Telefónico");
		lblContactoTelefnico.setBounds(71, 122, 127, 16);
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
				lblNumeroDeFuncionario.setBounds(72, 22, 147, 16);
				pnlBiblioColaborador.add(lblNumeroDeFuncionario);
				
						txtNumFuncionario = new JTextField();
						txtNumFuncionario.setBounds(234, 17, 130, 26);
						pnlBiblioColaborador.add(txtNumFuncionario);
						txtNumFuncionario.setColumns(10);

		// Botões

		btnRegista = new JButton("Regista");
		btnRegista.addActionListener(this);
		btnRegista.setBounds(20, 297, 81, 40);
		panel.add(btnRegista);

		btnSair = new JButton("Sair");
		btnSair.addActionListener(this);
		btnSair.setBounds(376, 297, 75, 40);
		panel.add(btnSair);

		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(this);
		btnVoltar.setBounds(283, 297, 81, 40);
		panel.add(btnVoltar);

		btnNovoRegisto = new JButton("Novo Registo");
		btnNovoRegisto.addActionListener(this);
		btnNovoRegisto.setBounds(113, 297, 99, 40);
		panel.add(btnNovoRegisto);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == this.btnRegista) {

		} else if (e.getSource() == this.btnSair) {

			janela.sairOK();

		} else if (e.getSource() == this.btnVoltar) {

			janela.bibliotecarioChefeOK();

		} else if (e.getSource() == this.btnNovoRegisto) {

		} else if (e.getSource() == this.comboBox) {

			String str = (String) this.comboBox.getSelectedItem();

			if (str.equals("Leitor")) {

				abrePainelLeitorOK();
				
			}
			else 
				abrePainelBibliotecarioColaboradorOK();
				
			}
		

	}

	public void abrePainelLeitorOK() {

		layout.show(pnlUtilizadores, "leitor");

	}
	public void abrePainelBibliotecarioColaboradorOK(){
		
		
		layout.show(pnlUtilizadores, "biblioColaborador");
		
	}

	public void registaUtilizador() {

	}

	public void mostraPainelLeitor() {

		// Object pnlBiblioColaborador;
		// layout.show(getContentPane(pnlMensagem, "mensagem"));

	}

}
