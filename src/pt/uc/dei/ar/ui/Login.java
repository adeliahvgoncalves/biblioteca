package pt.uc.dei.ar.ui;

import javax.swing.JPanel;
import javax.swing.JLabel;

import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import pt.uc.dei.ar.Biblioteca;
import pt.uc.dei.ar.BibliotecarioChefe;
import pt.uc.dei.ar.Colaborador;
import pt.uc.dei.ar.Leitor;
import pt.uc.dei.ar.Utilizador;

import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Login extends JPanel implements ActionListener {

	private JTextField txtUser;
	private JPasswordField pwdText;
	private JLabel lblMensagem;

	private Janela janela;

	private JButton btnLogin;

	public Login(Janela j) {

		this.janela = j;

		setLayout(null);

		JLabel lblLogin = new JLabel("BIBLIOTECA SUPER");
		lblLogin.setBounds(189, 23, 122, 16);
		add(lblLogin);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(135, 84, 78, 16);
		add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(135, 135, 78, 16);
		add(lblPassword);

		txtUser = new JTextField();
		txtUser.setBounds(280, 79, 130, 26);
		txtUser.setColumns(10);
		add(txtUser);

		pwdText = new JPasswordField();
		pwdText.setBounds(280, 130, 130, 26);
		add(pwdText);

		this.lblMensagem = new JLabel("");
		lblMensagem.setBounds(92, 195, 332, 16);
		add(lblMensagem);

		btnLogin = new JButton("ENTRAR");
		btnLogin.setBounds(191, 277, 117, 38);
		btnLogin.addActionListener(this);
		add(btnLogin);

	}
	
	public void actionPerformed(ActionEvent e) {

		Biblioteca biblioteca = Biblioteca.getInstance();
		

		if (leUser().equals("") || lePass().equals("")) {

			lblMensagem.setText("Não inseriu dados nos campos.");

		} else if (biblioteca.login(leUser(), lePass()) != null) {

			verificaTipoUtilizadorParaAvancarPainel(biblioteca.login(leUser(), lePass()));
			
		} else {

			lblMensagem.setText("O username ou a password não estão correctos");
		}
	}

	public String leUser() {

		return txtUser.getText();

	}

	@SuppressWarnings("deprecation")
	public String lePass() {

		return pwdText.getText();

	}

	public void limpaCampos() {

		lblMensagem.setText("");
		txtUser.setText("");
		pwdText.setText("");

	}

	public void verificaTipoUtilizadorParaAvancarPainel(Utilizador utilizador) {

		if (utilizador instanceof Leitor) {

			limpaCampos();
			janela.loginOK(utilizador);

		}

		if (utilizador instanceof Colaborador) {

			limpaCampos();
			janela.colaboradorOK();

		}

		if (utilizador instanceof BibliotecarioChefe) {

			limpaCampos();
			janela.bibliotecarioChefeOK();
		}

	}
	

}
