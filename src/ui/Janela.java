package ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import pt.uc.dei.ar.Utilizador;

import java.awt.CardLayout;
import java.awt.Component;

public class Janela extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela frame = new Janela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private CardLayout layout;
	private Login login;
	private EmprestimoPanel emprestimo;

	private Utilizador utilizador;
	
	public Janela() {

		setTitle("Biblioteca");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 500, 400);
		this.setResizable(false);
		this.layout = new CardLayout();
		getContentPane().setLayout(layout);

		login = new Login(this, utilizador );
		getContentPane().add(login, "login");

		LeitorPanel leitor = new LeitorPanel(this);
		getContentPane().add(leitor, "leitor");

		this.emprestimo = new EmprestimoPanel(this);
		getContentPane().add(emprestimo, "emprestimo");
		
		BibliotecarioChefePanel bibliotecarioChefe=new BibliotecarioChefePanel(this);
		getContentPane().add(bibliotecarioChefe, "bibliotecarioChefe");

	}

	public void loginOK() {

		layout.show(getContentPane(), "leitor");
		
	}

	public void colaboradorOK() {

		emprestimo.desativaVisibilidadeBotaoVoltar();
		layout.show(getContentPane(), "emprestimo");
		
	}
	
	public void emprestimoPanelBibliotecarioChefeOK(){
		
		layout.show(getContentPane(), "emprestimo");
		emprestimo.activaVisibilidadeBotaoVoltar();
			
	}
	
	public void bibliotecarioChefeOK(){
		
		layout.show(getContentPane(), "bibliotecarioChefe");
		
	}

	public void sairOK() {
		
		layout.show(getContentPane(), "login");
		
	}

}