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

public class Login extends JPanel {

	private JTextField txtUser;
	private JPasswordField pwdText;
	private JLabel lblMensagem;

	private Janela janela;
	private Utilizador utilizador;

	public Login(Janela j, Utilizador u) {

		this.janela = j;
		this.utilizador=u;
		
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

		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setBounds(191, 277, 117, 38);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			//	String user = "user";
			//	String colaborador = "colab";
			//	String biblio="biblio";
				
				/*if (leUser().equals(user) && lePass().equals("pass")) {
					verificaLogin();
				}
				if (leUser().equals(colaborador) && lePass().equals("colab")) {
					verificaColaborador();
				}
				if (leUser().equals(biblio) && lePass().equals("biblio")) {
					verificaBibliotecarioChefe();
				} else
					enviaMensagem();
			
					*/
				
				Biblioteca biblioteca= Biblioteca.getInstance();
				
				if(biblioteca.login(leUser(), lePass())!=null){
				
					verificaTipoUtilizadorParaAvancarPainel(biblioteca.login(leUser(), lePass()));
				
				}
				else{
					
					enviaMensagem();
					
				}
			}
				
		});
	
		add(btnLogin);
		
	}

	public String leUser() {

		return txtUser.getText();

	}

	@SuppressWarnings("deprecation")
	public String lePass() {

		return pwdText.getText();

	}

	public void enviaMensagem() {

		this.lblMensagem.setText("O user não está correcto");
		
	}

	// Pode-se retirar este método
	// BUG de mensagem de que o utilisador não está correcto, este método não
	// está implementado
	public void limpaLblMensagem() {
		
		lblMensagem.setText("");
		
	}
	
	public void limpaCampos(){
		
		lblMensagem.setText("");
		txtUser.setText("");
		pwdText.setText("");
		
	}
	
	
	public void verificaTipoUtilizadorParaAvancarPainel(Utilizador utilizador){
		
		if(utilizador instanceof Leitor){
			
			limpaCampos();
			janela.loginOK();
			
		}
		
		if(utilizador instanceof Colaborador){
			
			limpaCampos();
			janela.colaboradorOK();
	
		}
		
		if(utilizador instanceof BibliotecarioChefe){
			
			limpaCampos();
			janela.bibliotecarioChefeOK();
		}
		
	}
}
