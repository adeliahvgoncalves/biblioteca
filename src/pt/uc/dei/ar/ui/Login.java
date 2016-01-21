package pt.uc.dei.ar.ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import pt.uc.dei.ar.Biblioteca;
import pt.uc.dei.ar.BibliotecarioChefe;
import pt.uc.dei.ar.Colaborador;
import pt.uc.dei.ar.Leitor;
import pt.uc.dei.ar.Utilizador;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 * @author Adelia Goncalves (2000014546) e Maria Joao Dias da Silva (2001009566)
 * Interface do login
 */
public class Login extends JPanel implements ActionListener, KeyEventDispatcher {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 3060091237699583333L;

	/**
	 * txtUser e atributo do Login
	 */
	private JTextField txtUser;
	
	/**
	 * pwdText e atributo do Login
	 */
	private JPasswordField pwdText;
	
	/**
	 * lblMensagem e atributo do Login
	 */
	private JLabel lblMensagem;
	
	/**
	 * janela e atributo do Login
	 */
	private Janela janela;
	
	/**
	 * btnLogin e atributo do Login
	 */
	private JButton btnLogin;

	/**
	 * Create the Panel
	 * @param janela
	 */
	public Login(Janela j) {

		this.janela = j;

		setLayout(null);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(135, 84, 78, 16);
		add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(135, 135, 78, 16);
		add(lblPassword);

		txtUser = new JTextField();

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(this);

		txtUser.setBounds(280, 79, 130, 26);
		txtUser.setColumns(10);
		add(txtUser);
		txtUser.addActionListener(this);

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

	/**
	 * actionPerformed dos botoes da classe
	 */
	public void actionPerformed(ActionEvent e) {

		Biblioteca biblioteca = Biblioteca.getInstance();

		if (e.getSource() == this.btnLogin) {
			if (leUser().equals("") || lePass().equals("")) {

				lblMensagem.setText("Não inseriu dados nos campos.");

			} else if (biblioteca.login(leUser(), lePass()) != null) {

				verificaTipoUtilizadorParaAvancarPainel(biblioteca.login(leUser(), lePass()));

			} else {

				lblMensagem.setText("O username ou a password não estão correctos");
			}
		}
	}

	// metodo que le o user do campo do user
	private String leUser() {

		return txtUser.getText();
	}

	//ler o conteudo da JtextField password
	@SuppressWarnings("deprecation")
	public String lePass() {

		return pwdText.getText();
	}

	//metodo para limpar os campos de textField e mensagem
	private void limpaCampos() {

		lblMensagem.setText("");
		txtUser.setText("");
		pwdText.setText("");
	}

//Verifica o tipo de utilizador que acede ao programa para lhe mostrar o
//painel de operacoes que lhe estao permitidas
	private void verificaTipoUtilizadorParaAvancarPainel(Utilizador utilizador) {

		if (utilizador instanceof Leitor) {

			limpaCampos();
			janela.loginOK((Leitor) utilizador);

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

	/* (non-Javadoc)
	 * @see java.awt.KeyEventDispatcher#dispatchKeyEvent(java.awt.event.KeyEvent)
	 */
	@Override
	public boolean dispatchKeyEvent(KeyEvent e) {

		if (e.getID() == KeyEvent.KEY_RELEASED && e.getKeyCode() == KeyEvent.VK_ENTER) {
			Biblioteca biblioteca = Biblioteca.getInstance();

			if (leUser().equals("") || lePass().equals("")) {

				lblMensagem.setText("Não inseriu dados nos campos.");
				return true;
			} else if (biblioteca.login(leUser(), lePass()) != null) {

				verificaTipoUtilizadorParaAvancarPainel(biblioteca.login(leUser(), lePass()));
				return true;
			} else {

				lblMensagem.setText("O username ou a password não estão correctos");
				return true;
			}
		}
		return false;
	}
}
