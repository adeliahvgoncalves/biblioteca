package pt.uc.dei.ar.ui;

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
import pt.uc.dei.ar.Leitor;
import pt.uc.dei.ar.Biblioteca;
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
	private LeitorPanel	leitor;
	private Utilizador utilizador;
	private RegistaUtilizadorPanel registaUtilizador;
	private PesquisarPublicacao pesquisaPublicacao;
	private EmprestimosForaPrazo emprestimosForaPrazo;
	private RegistaPublicacaoPanel registaPublicacao;
	private RelatorioPanel relatorioPanel;
	
	private Biblioteca biblioteca = Biblioteca.getInstance();

	public Janela() {

		setTitle("Biblioteca");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 500, 400);
		this.setResizable(false);
		this.layout = new CardLayout();
		getContentPane().setLayout(layout);

		login = new Login(this);
		getContentPane().add(login, "login");

		this.emprestimo = new EmprestimoPanel(this);
		getContentPane().add(emprestimo, "emprestimo");

		this.leitor = new LeitorPanel(this, null);
		getContentPane().add(leitor, "leitor");

		BibliotecarioChefePanel bibliotecarioChefe=new BibliotecarioChefePanel(this);
		getContentPane().add(bibliotecarioChefe, "bibliotecarioChefe");

		this.registaUtilizador= new RegistaUtilizadorPanel(this);
		getContentPane().add(registaUtilizador, "registaUtilizador");

		this.pesquisaPublicacao= new PesquisarPublicacao(this);
		getContentPane().add(pesquisaPublicacao, "pesquisaPublicacao");

		this.emprestimosForaPrazo= new EmprestimosForaPrazo(this);
		getContentPane().add(emprestimosForaPrazo, "emprestimosForaPrazo");
		
		this.registaPublicacao= new RegistaPublicacaoPanel(this);
		getContentPane().add(registaPublicacao, "registaPublicacao");
		
		this.relatorioPanel= new RelatorioPanel(this);
		getContentPane().add(relatorioPanel, "relatorioPanel");

	}

	public void loginOK(Utilizador utilizador) {

		leitor.setUtilizador(utilizador);
		layout.show(getContentPane(), "leitor");

	}

	public void colaboradorOK() {

		emprestimo.desativaVisibilidaBotaoVoltar();
		layout.show(getContentPane(), "emprestimo");

	}

	public void emprestimoPanelBibliotecarioChefeOK(){

		layout.show(getContentPane(), "emprestimo");
		emprestimo.activaVisibilidaBotaoVoltar();

	}

	public void bibliotecarioChefeOK(){

		layout.show(getContentPane(), "bibliotecarioChefe");

	}

	public void sairOK() {

		layout.show(getContentPane(), "login");

	}

	public void registaUtilizadorOK(){
		
		layout.show(getContentPane(), "registaUtilizador");

	}

	public void pesquisaPublicacaoOK(){

		layout.show(getContentPane(), "pesquisaPublicacao");

	}

	public void emprestimosForaPrazoOK(){

		layout.show(getContentPane(), "emprestimosForaPrazo");

	}
	
	public void registaPublicacaoOK(){
		
		layout.show(getContentPane(),"registaPublicacao");
		
	}
	
	public void relatorioPanelOK(){
		
		layout.show(getContentPane(),"relatorioPanel");
		
	}

}